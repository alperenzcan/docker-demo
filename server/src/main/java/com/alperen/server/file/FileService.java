package com.alperen.server.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.UUID;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperen.server.config.AppConfig;

@Service
public class FileService {

	@Autowired
	private FileRepository fileRepository;
	
	@Autowired
	private AppConfig appConfig;
	
	private Tika tika = new Tika();
	
    public String writeBase64EncodedStringToFile(String name) throws IOException {
        String fileName = generateRandomName() + "." + detectType(name).split("/")[1];
        File target = new File(appConfig.getUploadPath() + fileName);
        OutputStream outputStream = new FileOutputStream(target);

        byte[] base64Encoded = Base64.getDecoder().decode(name);
        outputStream.write(base64Encoded);
        outputStream.close();
        return fileName;
    }
    
    public String generateRandomName() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    public String detectType(String value) {
        byte[] base64Encoded = Base64.getDecoder().decode(value);
        return tika.detect(base64Encoded);
    }

	public FileAttachment create(FileAttachment file) {
		FileAttachment newFile = new FileAttachment();
		try {
			newFile.setFileType(detectType(file.getName()).split("/")[1]);
			newFile.setName(writeBase64EncodedStringToFile(file.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileRepository.save(newFile);
	}
}
