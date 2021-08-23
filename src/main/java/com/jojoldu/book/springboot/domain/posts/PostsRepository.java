package com.jojoldu.book.springboot.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    //JpaRepository - MyBatis에서 DAO와 같은 역할
    //인터페이스를 생성 후, JpaRepository<Entity 클래스, PK타입> 을 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
    //@Repository 어노테이션을 추가할 필요도 없다. 단, entity클래스와 EntityReository는 같은 패키지(위치)에 있어야 한다.
    //Entity클래스와 Repostory는 항상 같이 붙어다녀야함.
    //두개 다 도메인 패키지에서 관리한다.
}
