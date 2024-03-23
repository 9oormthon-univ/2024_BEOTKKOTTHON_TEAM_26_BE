package com.example.sixpack.repository;

import com.example.sixpack.domain.Linked_image;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Linked_imageRepository extends JpaRepository<Linked_image, Long> {
    List<Linked_image> findByPostId(Long postId);
}
