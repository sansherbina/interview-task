package com.blog.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Comment {

  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 4096)
  private String content;

  @Column(length = 512)
  private String author;

  @CreationTimestamp
  private LocalDateTime creationDate;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;

}
