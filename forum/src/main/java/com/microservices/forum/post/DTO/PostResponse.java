package com.microservices.forum.post.DTO;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private int id;
    private String title;
    private String content;
    private Date created_at;
    private Date updated_at;
}
