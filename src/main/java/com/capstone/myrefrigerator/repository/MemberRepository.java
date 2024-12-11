package com.capstone.myrefrigerator.repository;

import com.capstone.myrefrigerator.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
