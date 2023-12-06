package models;

import lombok.*;

//Create an Album POJO (Plain Old Java Object) in your models package. It must have the following fields, as well as getters, setters, an all-argument constructor, a no-argument constructor, and a toString(). Hint: your IDE can do most of this work for you!
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Album {

    private long id;
    private String artist;
    private String name;
    private int releaseDate;
    private double sales;
    private String genre;

}
