package models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String img;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @DateTimeFormat
    private Date dateTime;
