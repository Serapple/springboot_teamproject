package com.example.intermediate.controller.response;

import java.time.LocalDateTime;

public class ReplyResponseDto {
    private Long id;
    private String author;
    private String content;
    private Long commentLikeCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
