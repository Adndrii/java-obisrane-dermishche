package com.microservices.forum.post;

import com.microservices.forum.post.DTO.PostRequest;
import com.microservices.forum.post.DTO.PostResponse;
import jakarta.transaction.Transactional;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional

public class PostService {
    private final PostRepository postRepository;
    @Autowired
    private final ModelMapper _mapper;

    public List<PostResponse> getAllPosts() {
        var posts = postRepository.findAll();
        var result = posts
                .stream()
                .map(post -> _mapper.map(post, PostResponse.class))
                .collect(Collectors.toList());
        return result;
    }

    public PostResponse getPostById(int id) {
        var post =  postRepository.getById(id);
        return _mapper.map(post, PostResponse.class);
    }

    public void createPost(PostRequest postRequest) {
        var post = _mapper.map(postRequest, Post.class);
        post.setCreated_at(new Date());
        post.setUpdated_at(new Date());

        postRepository.save(post);
    }

    public void updatePost(int id, PostRequest postRequest) {
        var post = _mapper.map(postRequest, Post.class);
        postRepository.save(post);
    }

    public void deletePost(int id) {
        var post = postRepository.getById(id);
        postRepository.delete(post);
    }
}
