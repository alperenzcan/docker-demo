package com.alperen.server.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/files")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping
	public FileAttachment create(@RequestBody FileAttachment file) {
		return fileService.create(file);
	}

}
