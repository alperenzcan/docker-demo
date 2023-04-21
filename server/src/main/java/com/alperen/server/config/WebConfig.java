package com.alperen.server.config;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private AppConfig appConfig;
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file-storage/app/files/**")
                .addResourceLocations("file:" + appConfig.getUploadPath())
                .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
    }

//    @Bean
//    CommandLineRunner createStorageDirectories() {
//        return (args) -> {
//            File folder = new File(appConfig.getUploadPath());
//            boolean folderExist = folder.exists() && folder.isDirectory();
//            if (!folderExist) {
//                folder.mkdir();
//            }
//        };
//    }

}
