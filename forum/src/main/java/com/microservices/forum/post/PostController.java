package com.microservices.forum.post;

import com.microservices.forum.post.DTO.PostRequest;
import com.microservices.forum.post.DTO.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")

public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostResponse> getAllPosts() {
        List<PostResponse> posts = postService.getAllPosts();
        return posts;
    }

    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostRequest newPost) {
        postService.createPost(newPost);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable int id, @RequestBody PostRequest updatedPost) {
        postService.updatePost(id, updatedPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }
}