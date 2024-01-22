package me.sghong.posts_jpa.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void index() {
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertThat(body).contains("웹 페이지");
    }
    
    @Test
    public void postsSave() {
        //when
        String body = this.restTemplate.getForObject("/posts-save", String.class);
        
        //then
        assertThat(body).contains("등록");
    }

    @Test
    public void postsUpdate() {
        //given
        Long id = 20L;

        //when
        String body = this.restTemplate.getForObject("/posts/update/"+id, String.class);

        //then
        assertThat(body).contains("수정");
    }
}