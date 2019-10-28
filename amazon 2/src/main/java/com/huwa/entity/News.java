package com.huwa.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class News {
   private Long id;
   private String  title;
   private String  content;
   private Timestamp create_time ;
}
