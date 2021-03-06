package com.example.bookclub.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;

    @Column
    private String name;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private Integer page;

    //    https://stackoverflow.com/questions/54840769/how-to-persist-localdate-with-jpa
    @Column(columnDefinition = "DATE")
    private LocalDate date;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @JsonIgnore//IN THE JSON WILL NOT SHOW CATEGORY ID AS A COLUMN
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Post() {
    }

    //adding getters setters and constructor



    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Post(Long id, String name, String title, String body, Integer page, LocalDate date, LocalDateTime dateTime) {
        Id = id;
        this.name = name;
        this.title = title;
        this.body = body;
        this.page = page;
        this.date = date;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
