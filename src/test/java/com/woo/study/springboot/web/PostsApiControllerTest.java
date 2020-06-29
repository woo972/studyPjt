package com.woo.study.springboot.web;

import com.woo.study.springboot.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import com.woo.study.springboot.domain.posts.Posts;
import com.woo.study.springboot.domain.posts.PostsRepository;
import com.woo.study.springboot.web.dto.PostsSaveRequestDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void test(){

    }

//    @Test
//    public void save_등록성공() {
//        // given
//        String title = "success test title";
//        String content = "success test content";
//        String author = "success test author";
//
//        PostsSaveRequestDto postsSaveRequestDto = PostsSaveRequestDto.builder()
//                .title(title)
//                .content(content)
//                .author(author)
//                .build();
//
//        String url = "http://localhost:"+port+"/api/v1/posts";
//
//        // when
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, postsSaveRequestDto, Long.class);
//
//        // then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Posts> allPosts = postsRepository.findAll();
//        assertThat(allPosts.get(0).getTitle()).isEqualTo(title);
//        assertThat(allPosts.get(0).getContent()).isEqualTo(content);
//    }
//
//    @Test
//    public void update_수정성공(){
//        // given
//        Posts savedPost = postsRepository.save(PostsSaveRequestDto
//                .builder().title("old").content("old").author("old").build().toEntity());
//
//
//        Long id = savedPost.getId();
//        String newTitle = "newTitle";
//        String newContent = "newContent";
//
//        PostsUpdateRequestDto postsUpdateRequestDto = PostsUpdateRequestDto.builder()
//                .title(newTitle).content(newContent).build();
//
//        String url = "http://localhost:"+port+"/api/v1/posts/"+id;
//
//        HttpEntity<PostsUpdateRequestDto> httpEntity = new HttpEntity<>(postsUpdateRequestDto);
//
//        // when
//        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Long.class);
//
//        // then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//        List<Posts> allPosts = postsRepository.findAll();
//        assertThat(allPosts.get(0).getTitle()).isEqualTo(newTitle);
//        assertThat(allPosts.get(0).getContent()).isEqualTo(newContent);
//    }

//    @Test
//    public void delete_삭제성공(){
//        // given
//        Posts savedPost = postsRepository.save(PostsSaveRequestDto.builder()
//                                                                    .title("test")
//                                                                    .content("content")
//                                                                    .author("author")
//                                                                    .build()
//                                                                    .toEntity());
//        Long id = savedPost.getId();
//        String url = "http://localhost:"+port+"/api/v1/posts/"+id;
//
//        // when
//        restTemplate.delete(url);
//
//        // then
//        List<Posts> allPosts = postsRepository.findAll();
//        assertThat(allPosts.size()).isEqualTo(0);
//    }
}