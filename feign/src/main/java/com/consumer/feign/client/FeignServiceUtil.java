package com.consumer.feign.client;

import com.consumer.feign.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "feign", url = "http://localhost:8082/usuario") // porta da API usuario
public interface FeignServiceUtil {
    @GetMapping(value = "/listartodos")
    List<PostDTO> getAll();


}
