package com.blog.demo.board;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getList() {
        return this.postRepository.findAll();
    }

    public Post getTitle(String title) {
        return this.postRepository.findByTitle(title);
    }

    public List<Post> getTitleLike(String title) {
        return this.postRepository.findByTitleLike(title);
    }
}
