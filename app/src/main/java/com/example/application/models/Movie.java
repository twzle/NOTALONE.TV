package com.example.application.models;


import com.google.gson.annotations.SerializedName;

public class  Movie {

    private int id;
    private String category;
    private int year;
    private String genres;
    @SerializedName("title_rus")
    private String title;
    private float kinopoisk;
    private float imdb;
    private String poster;
    private String date_update;
    private String link;
    private String type;
    private int MovieImg;

    public int getMovieImg() {
        return MovieImg;
    }

    public void setMovieImg(int movieImg) {
        MovieImg = movieImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getKinopoisk() {
        return kinopoisk;
    }

    public void setKinopoisk(float kinopoisk) {
        this.kinopoisk = kinopoisk;
    }

    public float getImdb() {
        return imdb;
    }

    public void setImdb(float imdb) {
        this.imdb = imdb;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDate_update() {
        return date_update;
    }

    public void setDate_update(String date_update) {
        this.date_update = date_update;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Movie(int id, String category, int year, String genres, String title, float kinopoisk, float imdb, String poster, String date_update, String link, String type, int movieImg) {
        this.id = id;
        this.category = category;
        this.year = year;
        this.genres = genres;
        this.title = title;
        this.kinopoisk = kinopoisk;
        this.imdb = imdb;
        this.poster = poster;
        this.date_update = date_update;
        this.link = link;
        this.type = type;
        MovieImg = movieImg;
    }
}
