package com.example.sixpack.repository;

import com.example.sixpack.domain.Member;
import com.example.sixpack.domain.Post;
import com.example.sixpack.domain.QMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);


}