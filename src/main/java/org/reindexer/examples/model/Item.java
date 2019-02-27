package org.reindexer.examples.model;

import java.util.Set;

public class Item {
    private int id;
    private String name;
    private Set<Integer> articles;
    private int year;

    public Item(int id, String name, Set<Integer> articles, int year) {
        this.id = id;
        this.name = name;
        this.articles = articles;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getArticles() {
        return articles;
    }

    public void setArticles(Set<Integer> articles) {
        this.articles = articles;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
