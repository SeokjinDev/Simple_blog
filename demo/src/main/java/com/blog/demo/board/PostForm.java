package com.blog.demo.board;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostForm {
    @NotEmpty(message="제목이 비었습니다.")
    @Size(max=100)
    private String title;

    @NotEmpty(message="내용이 비었습니다.")
    private String content;
}
