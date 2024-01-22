package me.sghong.posts_jpa.web;

import lombok.RequiredArgsConstructor;
import me.sghong.posts_jpa.web.dto.PostsResponseDto;
import me.sghong.posts_jpa.web.dto.PostsSaveRequestDto;
import me.sghong.posts_jpa.web.dto.PostsUpdateRequestDto;
import me.sghong.posts_jpa.web.service.posts.PostsService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
