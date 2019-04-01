package com.blog.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
  List<Comment> findByPostIdOrderByCreationDateDesc(Long postId);
}
