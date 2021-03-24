package com.example.myapplication.models;


import com.google.gson.annotations.SerializedName;

public class  Movie {

    @SerializedName("title")
    private String moviename;
    private String country;
    private String genre;
    private float kinopoisk, imdb;
    private int movieImg, year;

    public int getMovieImg() { return movieImg; }
    public void setMovieImg(int movieImg) { this.movieImg = movieImg; }

    public String getMoviename() { return moviename; }
    public void setMoviename(String moviename) {
        this.moviename = moviename;
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

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String country() {
        return country;
    }
    public void setCountry(String kinopoisk) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

}
