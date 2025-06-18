package org.example.springboot.domain.posts;


import org.example.springboot.domain.posts.Posts;
import org.example.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

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
    public void CallingUp_PostSave(){
        //given
        String title="title1";
        String content="content1 in title1";

        postsRepository.save(Posts.builder().
                title(title).content(content).author("kiridodo").build());

        //when
        List<Posts> list = postsRepository.findAll();


        //then
        Posts posts=list.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);


    }

    @Test
    public void BaseTimeEntity_등록(){
        //given

        LocalDateTime now=LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder().
                title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> list = postsRepository.findAll();

        //then
        Posts posts=list.get(0);
        System.out.println(">>>>>>CreateDate="+posts.getCreatedDate()+",modifiedDate ="+posts.getLastModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getLastModifiedDate()).isAfter(now);

    }





}
