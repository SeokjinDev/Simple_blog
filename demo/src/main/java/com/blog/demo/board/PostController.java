package com.blog.demo.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequestMapping("/post")
@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;

    @GetMapping("/create")
    public String postCreate(PostForm postForm) {
        return "post_create";
    }

    @PostMapping("/create")
    public String postCreate(@Valid PostForm postForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "post_create";
        }
        this.postService.create(postForm.getTitle(), postForm.getContent());
        return "redirect:/post/list";
    }


    @GetMapping("/list")
    public String list(Model model) {
        List<Post> postList = this.postService.getPostList();
        model.addAttribute("postList", postList);
        return "post_list";
    }
    
    @GetMapping("/detail/{id}")
    public String list(Model model, @PathVariable("id") Integer id) {
        Post post = this.postService.getPost(id);
        model.addAttribute("post", post);
        return "post_detail";
    }
    
}
