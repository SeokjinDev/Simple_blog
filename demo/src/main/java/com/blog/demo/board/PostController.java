package com.blog.demo.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;

    @PostMapping("/post/create")
    public String createPost(@RequestParam("title") String title, @RequestParam("content") String content) {
        this.postService.create(title, content);
        return "redirect:/post/list";
    }

    @GetMapping("/post/list")
    public String list(Model model) {
        List<Post> postList = this.postService.getPostList();
        model.addAttribute("postList", postList);
        return "post_list";
    }
    
    @GetMapping("/post/detail/{id}")
    public String list(Model model, @PathVariable("id") Integer id) {
        Post post = this.postService.getPost(id);
        model.addAttribute("post", post);
        return "post_detail";
    }
    
}
