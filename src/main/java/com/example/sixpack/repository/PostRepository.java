package com.example.sixpack.repository;

import com.example.sixpack.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepository extends JpaRepository<Post,Long> {

    Page<Post> findAll(Pageable pageable);

    Page<Post> findAllByTitleContaining(String keyword, Pageable pageable);

    Page<Post> findAllByCategoryId(Long categoryId, Pageable pageable);

}