package com.jojoldu.book.springboot.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    //JpaRepository - MyBatis에서 DAO와 같은 역할
    //인터페이스를 생성 후, JpaRepository<Entity 클래스, PK타입> 을 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
    //@Repository 어노테이션을 추가할 필요도 없다. 단, entity클래스와 EntityReository는 같은 패키지(위치)에 있어야 한다.
    //Entity클래스와 Repostory는 항상 같이 붙어다녀야함.
    //두개 다 도메인 패키지에서 관리한다.

    @Query(value = "SELECT * FROM posts p ORDER BY p.id DESC", nativeQuery = true)
    List<Posts> findAllDesc();

    //SpringDataJpa 에서 제공하지 않는 메소드는 위처럼 @query를 이용해 쿼리를 작성해도 됨.

    //DB 조회성 프레임워크란?
    //FK의 조인, 복잡한 조건 등으로 인해 이런 Entity 클래스 만으로 처리하기 어려울 때 사용
    // ==> 복잡한 쿼리 짤 때 쓴다. 조건 many, 조인 exist ex)queryDsl, jooq, MyBatis

    //queryDsl의 장점
    //타입 안정성이 보장된다.
    //==> 쿼리를 문자열이 아닌 메소드로 생성하기 때문에 오타나 존재하지 않는 컬럼 명을 명시할 경우 IDE에서 거름.

}
