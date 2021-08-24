package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
// JPA Enitity 클래스들이 해당 클래스를 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하게 해줌
@EntityListeners(AuditingEntityListener.class)//해당 클래스에 Auditing 기능을 포함시킵니다.
public abstract class BaseTimeEntity {

    @CreatedDate//Entity가 생성될 때 시간을 자동 저장함.
    private LocalDateTime createdDate;

    @LastModifiedDate//조회한 Entity의 값을 변경할 때 시간을 자동 저장함.
    private LocalDateTime modifiedDate;

    //BaseTimeEntity는 모든 Entity에 상속 받게 하여 하위 Entitye들의 createdDate, modifiedDate를 자동 관리할 것이다.

    //엔티티를 가지고 작업을 할 때 생성시간과 수정시간을 포함한다.
    //그러므로 DB에 삽입하기 전, update 하기 전에 날짜 데이터를 등록/수정하는 코드가 여기저기 들어간다.
    //이 문제를 해결하고자 JPA Auditing을 사용한다.

    //** LocalDate
    //Date와 Calendar 클래스가 가진 문제점을 해결한 클래스
    //1. 불변(변경이 불가능한) 객체가 아닙니다.(멀티스레드 환경에서 문제가 될 수 있음.)
    //2. Calendar는 월이 잘못 설계되어 있음.(ex) Calendar.OCTOBER == 9)

}
