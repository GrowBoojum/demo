package com.example.demo;


import com.example.demo.entities.Post;
import com.example.demo.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


@RestController
public class HelloController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("/user")
    public String user(Principal principal) {
        return "Hello user";
    }

    @RequestMapping("/posts")
    public List<Post> foo() {
        return feignService.getPosts();
    }

    @RequestMapping("/posts/{postId}")
    public Post foo(Long postId) {
        return feignService.getPostById(postId);
    }

}