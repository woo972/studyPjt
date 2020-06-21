package com.woo.study.springboot.domain.posts;

import com.woo.study.springboot.web.dto.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void save_게시글(){
        //given
        String title = "new title";
        String content = "new content";

        Posts posts = Posts.builder().title(title).content(content).build();

        postsRepository.save(posts);

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts resultPosts = postsList.get(0);
        assertThat(resultPosts.getTitle()).isEqualTo(title);
        assertThat(resultPosts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){
        // given
        LocalDateTime now = LocalDateTime.of(2020,6,7,0,0,0);
        postsRepository.save(Posts.builder().author("aa").title("bb").content("cc").build());

        // when
        List<Posts> allPosts = postsRepository.findAll();

        // then
        System.out.println(allPosts.get(0).getCreatedDate());
        assertThat(allPosts.get(0).getCreatedDate()).isAfter(now);  
        assertThat(allPosts.get(0).getModifiedDate()).isAfter(now);
    }
}