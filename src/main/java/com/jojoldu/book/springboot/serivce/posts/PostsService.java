package com.jojoldu.book.springboot.serivce.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsListResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
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
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }


    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 없습니다. id= "+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    //update 할때 쿼리를 날리는 부분이 없다.(JPA의 영속성 컨텍스트 때문)
    //영속성 컨텍스트란, 엔티티를 영구 저장하는 환경 이다.
    //JPA의 핵심은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐가 핵심.
    //JPA의 엔티티 메니저가 활성화된 상태로 트렌젝션 안에서 DB에서 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태이다.
    //이 상태에서 해당 데이터의 값을 변경하면 트렌젝션이 끝나는 시점에 해당 테이블에 변경분을 반영한다.
    //즉, entity 객체 값만 변경하면 별도로 update 쿼리를 날릴 필요가 없다. 이 개념을 더티 체킹이라고 한다.

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id= "+ id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    // 트랙잭션 범위는 유지하되, 조회기능만 남겨두어 조회속도가 개선됨. C,U,D 기능이 없는 메소드에 사용됨.
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                //map(Posts -> new PostsListResponseDto) 이거와 같음
                .collect(Collectors.toList());

        //postsRepository 결과로 넘어온 Posts의 stream을 map을 통해
        //PostsListResponseDto 변환 -> List 로 변환하는 메소드이다.
    }

}
