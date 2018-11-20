package com.cube.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cube.domain.Image;
import com.cube.repository.ImageRepository;


@Service
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	public void saveImage(MultipartFile file) throws IOException {
		Image img = new Image();
		Byte[] byteObjects = new Byte[file.getBytes().length];
        int i = 0;
        
        for (byte b : file.getBytes()){
       	 byteObjects[i++] = b;
        }
        
        img.setImage(byteObjects);
        imageRepository.save(img);
		
	}
	
	public Image getImageById(Long id) {
		return imageRepository.findOne(id);
	}

}
