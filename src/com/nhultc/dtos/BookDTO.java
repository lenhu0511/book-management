/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhultc.dtos;

/**
 *
 * @author Dell
 */
public class BookDTO {
    private String id;
    private String name;
    private String author;
    private String publisher;
    private int publishedYear;
    private boolean forRent;

    public BookDTO() {
    }

    public BookDTO(String id, String name, String author, String publisher, int publisherYear, boolean forRent) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publishedYear = publisherYear;
        this.forRent = forRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publisherYear) {
        this.publishedYear = publisherYear;
    }

    public boolean isForRent() {
        return forRent;
    }

    public void setForRent(boolean forRent) {
        this.forRent = forRent;
    }
    
    
}
