package com.example.kotlinserver.domain.test;

import javax.persistence.*;

@Entity
public class Test {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @ManyToOne // member 입장에서는 1이고 team 입장에서는 여러개
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}
