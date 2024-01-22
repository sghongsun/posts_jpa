package me.sghong.posts_jpa.web.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PostsUpdateRequestDto {
    private String title;
    private String content;
}
