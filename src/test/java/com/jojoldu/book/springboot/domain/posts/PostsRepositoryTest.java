package com.jojoldu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    //After은 JUnit에서 단위 테스트가 끝날때 마다 수행되는 메소드를 지정한다.
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title="테스트 게시글";
        String content = "테스트 본문";
        postsRepository.save(Posts.builder()
                            .title(title)
                            .content(content)
                            .author("jojoldu@gmail.com")
                            .build()); // 테이블 posts에 insert/update쿼리를 실행함 . id가 있다면 update를, 없으면 insert함
        //when
        List<Posts> postsList = postsRepository.findAll(); // findAll()은 모든 데이터를 조회해오는 메소드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);


    }
}
