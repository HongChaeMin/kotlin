package com.example.kotlinserver.domain.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMain {

    public static void main(String[] args) {
// 하나만 생성해서 애플리케이션 전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 쓰레드간에 공유 X (사용하고 버려야 한다)
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        // JPA 의 모든 데이터 변경은 트랜잭션 안에서 실행행
        tx.begin();

        try {
            // 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Test member = new Test();
            member.setUserName("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Test findMember = em.find(Test.class, member.getId());

            Team findTeam = findMember.getTeam();
            System.out.println("findTime = " + findTeam.getName());

            Team findTeam2 = em.find(Team.class, team.getId());
            findTeam2.getMembers().isEmpty(); // 역방향 조회

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

}
