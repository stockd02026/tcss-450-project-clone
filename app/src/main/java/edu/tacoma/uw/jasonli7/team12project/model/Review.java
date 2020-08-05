package edu.tacoma.uw.jasonli7.team12project.model;

import java.io.Serializable;
/**
 * Team 12 Group project.
 *
 * @author Daniel Stocksett.
 *
 * @version 2nd Aug 2020.
 *
 * A class for creating review objects.
 */
public class Review implements Serializable {


    private String mUserName;
    private String mReview;
    private double mRate;

    public Review(String name, String review, double rating) {
        mUserName = name;
        mReview = review;
        mRate = rating;
    }
    public String getmUserName() {
        return mUserName;
    }
    public double getRate() {
        return mRate;
    }
    public String getmReview() {
        return mReview;
    }
}
