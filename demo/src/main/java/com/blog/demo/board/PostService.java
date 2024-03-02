package com.blog.demo.board;
import com.blog.demo.exception.DataNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Post getPost(Integer id) {
        Optional<Post> post = this.postRepository.findById(id);
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new DataNotFoundException("post not found");
        }
    }

    public List<Post> getPostList() {
        return this.postRepository.findAll();
    }

    public Post getTitle(String title) {
        return this.postRepository.findByTitle(title);
    }

    public List<Post> getTitleLike(String title) {
        return this.postRepository.findByTitleLike(title);
    }

    public void create(String title, String content) {
        Post p = new Post();
        p.setTitle(title);
        p.setContent(content);
        p.setCreateDate(LocalDateTime.now());
        this.postRepository.save(p);
    }
}
