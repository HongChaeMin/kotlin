package com.example.kotlinserver.domain.test;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Test> getMembers() {
        return members;
    }

    public void setMembers(List<Test> members) {
        this.members = members;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team") // 관계 테이블에 어떤 필드로 저장이 되어 있는지?
    private List<Test> members = new ArrayList<>();

}
