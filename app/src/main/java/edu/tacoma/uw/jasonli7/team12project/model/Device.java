package edu.tacoma.uw.jasonli7.team12project.model;

import java.io.Serializable;
import java.util.List;
/**
 * Team 12 Group project.
 *
 * @author Daniel Stocksett.
 *
 * @version 2nd Aug 2020.
 *
 * A class for creating Device objects..
 */
public class Device implements Serializable {

    private String mDeviceName;
    private int mNumberOfReviews;
    private double mAvgRate;
    private List<Review> mReviews;



    public  Device(String name, List<Review> reviews) {
        mDeviceName = name;
        mNumberOfReviews = reviews.size();
        mReviews = reviews;
        mAvgRate = calcAvg(mReviews);
    }

    public int getmNumberOfReviews() {
        return mNumberOfReviews;
    }
    private double calcAvg(List<Review> reviews) {
    double toReturn = 0.0;
    for (Review r : reviews) {
        toReturn+=r.getRate();
    }
    return toReturn/mNumberOfReviews;
    }

    public String getDeviceName() {
        return mDeviceName;
    }

    public void setDeviceName(String mDeviceName) {
        this.mDeviceName = mDeviceName;
    }
    public List<Review> getReviews() {
        return mReviews;
    }

    public void addNewReview(Review review) {
        mReviews.add(review);
    }

    public double getAvgRate() {
        return mAvgRate;
    }

}
