package com.blog.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Post {

  @Id
  @GeneratedValue
  private Long id;

  private String title;

  @Column(length = 4096)
  private String content;

  private LocalDateTime creationDate;

}
