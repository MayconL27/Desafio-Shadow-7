package com.consumer.feign.controller;

import com.consumer.feign.client.FeignServiceUtil;
import com.consumer.feign.dto.PostDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/demo")
public class PostController {

    private FeignServiceUtil feignServiceUtil;
    @GetMapping("/list")
    public List<PostDTO> getAllPosts() {
        return feignServiceUtil.getAll();
    }

}
