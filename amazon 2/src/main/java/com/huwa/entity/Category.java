package com.huwa.entity;

import lombok.Data;

/**
 * 分类
 */
@Data
public class Category {
    private Long id;
    private String name;
    private Long parent_id;
}
