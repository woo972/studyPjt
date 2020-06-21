package com.woo.study.springboot.service.posts;

import com.woo.study.springboot.domain.posts.Posts;
import com.woo.study.springboot.domain.posts.PostsRepository;
import com.woo.study.springboot.web.dto.PostsListResponseDto;
import com.woo.study.springboot.web.dto.PostsResponseDto;
import com.woo.study.springboot.web.dto.PostsSaveRequestDto;
import com.woo.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto){
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto postsUpdateRequestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("ID에 해당하는 글 없음")
        );
        posts.update(postsUpdateRequestDto.getTitle(), postsUpdateRequestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("ID에 해당하는 글 없음")
        );
        return new PostsResponseDto(posts);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                                .map(PostsListResponseDto::new)
                                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("ID에 해당하는 글 없음")
        );
        postsRepository.delete(posts);
    }
}
