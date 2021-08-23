package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor//기본 생성자 자동추가 public Posts(){} 와 같은 효과
@Entity//엔티티 클래스 어노테이션
public class Posts {

    @Id//1.PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK 생성 전략(방법)
    // GenerationType.IDENTITY를 붙여야 자동 시퀀스됨.(부트 2.0에서)
    private Long id;

    @Column(length = 500, nullable = false)//column어노테이션 안붙여도 다 컬럼됨. 변경하거나 추가할 옵션이 있을 때 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder//빌더 패던 클래스 생성 | 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }
    //개발 초기에 엔티티는 자주 바뀌니까 롬복 어노테이션을 최대한 활용해서 엔티티 클래스 변경을 막는다.
    //Entity 클래스에는 절대 setter 메소드를 만들지 않는다.(해당 클래스의 객체들이 언제 어디서 변해야하는지 명확하지 않기 때문.)
    //대신, 필드의 값 변경이 필요하면, 명확히 목적과 의도를 나타낼 수 잇는 메소드를 추가해야 함.
    //Entity에 값을 채울 때는 생성자를 통해 값을 채운 후 DB작업 하면됨.(값의 변경이 필요한 경우 public 메소드를 호출하여 해결)
    //Builder를 통해 제공되는 빌더클래스를 사용해도 됨.
    /**
     * Example.builder()
     * .a(a)
     * .b(b)
     * .build();
     * **/


}
