package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity클래스들이 클래스를 상속할 경우 필드들도 칼럼으로 인식하게 함
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity에 Auditing기능을 포함함
public abstract class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장될때 시간이 자동 저장됨
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값을 변경할때 시간이 자동 저장됨
    private LocalDateTime modifiedDate;
}
