package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // mappedBy는 연관관계 주인을 정해주는 조건임(Order Entity의 member 필드에 의해서 맵핑이 되었다.
    // 읽기 전용(수정 X)
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


}