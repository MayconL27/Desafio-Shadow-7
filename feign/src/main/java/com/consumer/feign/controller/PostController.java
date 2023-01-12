package com.consumer.feign.controller;

import com.consumer.feign.client.PostClient;
import com.consumer.feign.dto.PostDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("posts")
public class PostController {

    private PostClient postClient;
    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postClient.getAllPosts();
    }

}
