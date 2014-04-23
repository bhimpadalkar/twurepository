package com.twu.biblioteca.domain;

import com.twu.biblioteca.menu.Displayable;

public class Movie extends LibraryItem implements Displayable{
    public static final Movie NULL_MOVIE = new Movie(-1,new String[]{"","","","0"}) {
        @Override
        public boolean isAvailableForCheckout(){
            return false;
        }

        @Override
        public boolean isCheckedOut(){
            return false;
        }
    };

    private String director;
    private int rating;
    private int year;

    public Movie(int id, String [] movieInfo){
        super(id,movieInfo[0]);
        int rating = Integer.parseInt(movieInfo[3]);
        if (rating<0||rating>10){
            throw new IllegalArgumentException("Rating out of 0-10 range not allowed");
        }
        this.year = Integer.parseInt(movieInfo[1]);
        this.director = movieInfo[2];
        this.rating = rating;
    }

    @Override
    public String getDisplayText() {
        return String.format("%s. %s\t%s\t%s\t%s", id, name, year, director, rating);
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Movie))
            return false;

        if(o == this)
            return true;

        Movie movieToCompare = (Movie) o;
        return (movieToCompare.id == id) &&
                (movieToCompare.name.equals(name)) &&
                (movieToCompare.year==year) &&
                (movieToCompare.director.equals(director)) &&
                (movieToCompare.rating==rating) &&
                (movieToCompare.isAvailable == isAvailable);
    }
}
