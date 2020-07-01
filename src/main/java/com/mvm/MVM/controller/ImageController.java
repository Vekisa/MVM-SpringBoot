package com.mvm.MVM.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mvm.MVM.cofiguration.UploadFileResponse;
import com.mvm.MVM.dto.ImageDto;
import com.mvm.MVM.model.Category;
import com.mvm.MVM.model.Image;
import com.mvm.MVM.service.ImageService;
import com.mvm.MVM.service.UserService;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;
    
    @Autowired
    private UserService userService;

    @RequestMapping(value ="remove", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id) throws IOException {
        imageService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*@RequestMapping(value ="/all", method = RequestMethod.GET)
    public ResponseEntity<List<Image>> getAllProductImages(@RequestParam(value = "id") Long id){
        return new ResponseEntity<>(imageService.getAllProductImages(id), HttpStatus.OK);
    }*/

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("productId") Long productId) {
        return imageService.uploadImage(file,productId);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("productId") Long productId) {
        return imageService.uploadMultipleFiles(files,productId);
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<org.springframework.core.io.Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        System.out.println(fileName);
        return imageService.downloadFile(fileName,request);
    }
    
    @PostMapping("/save")
    public ResponseEntity<Image> saveProfileImage(@RequestBody ImageDto dto) {
    	Image image = imageService.dto2Image(dto);
    	Image existedImage = null;
    	if(dto.getUserId() != null) {
    		existedImage = imageService.findByUserId(Long.parseLong(dto.getUserId()));
    	}
    	if(existedImage != null) {
    		existedImage.setPath(image.getPath());
        	imageService.save(existedImage);
    	}
    	else {
    		imageService.save(image);
    	}
    	return new ResponseEntity<Image>(image, HttpStatus.OK);
    }
    
    @PostMapping("/getImage")
    public ResponseEntity<ImageDto> obtainImage(@RequestBody ImageDto dto){
    	Image image = null;
    	Category category;
    	if(dto.getCategoryId() != null) {
    		image = imageService.findByCategoryId((long)Double.parseDouble(dto.getCategoryId()));
    	}
    	else if(dto.getUserId() != null) {
    		image = imageService.findByUserId(Long.parseLong(dto.getUserId()));
    	}
    	if(image != null) {
    		dto.setContent(imageService.bitmap2String(image.getPath()));
    	}
    	return new ResponseEntity<ImageDto>(dto, HttpStatus.OK);
    }
}
