package com.blog.demo.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer>{
    Post findByTitle(String title);
    List<Post> findByTitleLike(String title);
}
