package com.example.anna.recyclerviewanna;


public class Movie
{
    private String title, genre, year, description;
    public boolean isWatched = false;
    private int image;
    private float rating;
    private boolean mark;

    int[] imgs;
    String actors[];



    public Movie() {
    }

    public Movie(String title, String genre, String year, int image, String description,int imgs[], String actors[]) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.image = image;
        this.description = description;
        rating = 0;
        mark = false;
        this.actors=actors;
        this.imgs= imgs;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void watched()
    {
        isWatched = true;
    }

    public void notWatched() {isWatched = false;}

    public int getImage() {return image;}

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    public String getDescription() {return description;}

    public int[] getImgs() {
        return imgs;
    }

    public void setImgs(int[] imgs) {
        this.imgs = imgs;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

}
