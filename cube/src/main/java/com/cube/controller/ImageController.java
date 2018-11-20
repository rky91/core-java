package com.cube.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cube.domain.Image;
import com.cube.service.ImageService;

@Controller
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@RequestMapping("/image")
	public String uploadImage() {
		return "image";
	}
	
	@PostMapping("/saveImage")
	public String saveDefaultImage(@RequestParam("imagefile") MultipartFile file) throws IOException {
		imageService.saveImage(file);
		return "home";
	}
	
	public Image getDefaultImage(Long id) {
		return imageService.getImageById(id);
	}
	
	
	

}
