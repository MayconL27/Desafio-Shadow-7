package com.consumer.feign.client;

import com.consumer.feign.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "post", url = "http://localhost:8082") // porta da API usuario
public interface PostClient {
    @GetMapping(value = "/posts")
    List<PostDTO> getAllPosts();

}
