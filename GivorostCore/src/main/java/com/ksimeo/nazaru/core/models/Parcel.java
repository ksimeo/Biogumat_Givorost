package com.ksimeo.nazaru.core.models;

import java.util.List;

/**
 * @author Ksimeo on 18.03.2015
 * @version 1.2
 * @since 2.5
 */
public class Parcel<E> {

    public final static int MAX_ROWS_NUMBERS = 8;

    private int count;
    private List<E> page;
    private boolean isLast;


    public Parcel() {
    }

    public Parcel(int count, List<E> page, boolean isLast) {
//        if (page.size() < MAX_ROWS_NUMBERS) {
            this.page = page;
            this.count = count;
            this.isLast = isLast;
//        } else throw new IllegalArgumentException("The arrays length is too large!");
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {

        this.count = count;
    }

    public List<E> getPage() {

        return page;
    }

    public void setPage(List<E> page) {

//        if (page.size() < MAX_ROWS_NUMBERS) {
            this.page = page;
//        } else throw new IllegalArgumentException("The arrays length is too large!");
    }

    public boolean isLast() {

        return isLast;
    }

    public void setIsLast(boolean isLast) {

        this.isLast = isLast;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "count=" + count +
                ", page='" + page + '\'' +
                ", isLast='" + isLast + '\'' +
                '}';
    }

    /*public void addOne(E item) {

        if (page.size() < MAX_ROWS_NUMBERS) page.add(item);
        else throw new IllegalStateException("The arrays length is too large!");
    }*/
}