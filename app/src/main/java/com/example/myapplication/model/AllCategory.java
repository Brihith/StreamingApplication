package com.example.myapplication.model;

import java.util.List;

public class AllCategory {

    String categoryTitle;
    Integer categoryId;
    private List<Categoryitem> categoryitemList = null;

    public AllCategory(Integer categoryId,  String categoryTitle,  List<Categoryitem> categoryitemList) {
        this.categoryTitle = categoryTitle;
        this.categoryId = categoryId;
        this.categoryitemList = categoryitemList;
    }

    public List<Categoryitem> getCategoryitemList() {
        return categoryitemList;
    }

    public void setCategoryitemList(List<Categoryitem> categoryitemList) {
        this.categoryitemList = categoryitemList;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
