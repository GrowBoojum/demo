package com.example.demo.service;

import com.example.demo.api.FeignApi;
import com.example.demo.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeignService {
    @Autowired
    private FeignApi feignApi;

    public List<Post> getPosts() { return  feignApi.getPosts(); }

    public Post getPostById(Long postId){ return feignApi.getPostById(postId).get(0); }
}