package com.eviro.assessment.grad001.lelonantshiba.grad001.lelonantshiba.Controller;

import com.eviro.assessment.grad001.lelonantshiba.grad001.lelonantshiba.FileParser.parseFile;
import com.eviro.assessment.grad001.lelonantshiba.grad001.lelonantshiba.Repository.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Arrays;

@RestController
@RequestMapping("/v1.api/image")
public class ImageController {

    @Autowired
    AccountService accountService;
    public parseFile parseFile = new parseFile();

    @PostMapping(value = "/upload")
    public String uploadFile() {
        /**
         * This request posts the information in the account holder list into the account profile database.
         */
        accountService.saveUser();
        return "infomation saved into database";
    }



    @GetMapping(value = "/{name}/{surname}",produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    /**
     * This method retrieves the httpImageLink and displays the physical image file converted from the flat file.
     */
    public FileSystemResource gethttpImageLink(@PathVariable("name") String name, @PathVariable("surname") String surname){
       String path = accountService.getHttpImageLink(name, surname);
       return new FileSystemResource(path);
    }
}
