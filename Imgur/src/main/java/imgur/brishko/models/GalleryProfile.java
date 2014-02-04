package com.example.uploadjpegs.datamodels;

import java.util.ArrayList;

/**
 * The totals for a users gallery information.
 * <p/>
 * Example URL: https://api.imgur.com/3/account/{username}/gallery_profile
 * <p/>
 * https://api.imgur.com/models/gallery_profile
 */
public class GalleryProfile {
    private String total_gallery_comments;
    private String total_gallery_likes;
    private String total_gallery_submissions;
    private ArrayList<Trophy> userTrophies; //TODO JSON Builder

    public GalleryProfile() {
    }

    /**
     * @return Total number of comments the user has made in the gallery
     */
    public String getTotal_gallery_comments() {
        return total_gallery_comments;
    }

    public void setTotal_gallery_comments(String total_gallery_comments) {
        this.total_gallery_comments = total_gallery_comments;
    }

    /**
     * @return Total number of images liked by the user in the gallery
     */
    public String getTotal_gallery_likes() {
        return total_gallery_likes;
    }

    public void setTotal_gallery_likes(String total_gallery_likes) {
        this.total_gallery_likes = total_gallery_likes;
    }

    /**
     * @return Total number of images submitted by the user.
     */
    public String getTotal_gallery_submissions() {
        return total_gallery_submissions;
    }

    public void setTotal_gallery_submissions(String total_gallery_submissions) {
        this.total_gallery_submissions = total_gallery_submissions;
    }

    /**
     * @return An array of trophies that the user has.
     */
    public ArrayList<Trophy> getUserTrophies() {
        return userTrophies;
    }

    public void setUserTrophies(ArrayList<Trophy> userTrophies) {
        this.userTrophies = userTrophies;
    }

    @Override
    public String toString() {
        return "GalleryProfile{" +
                "total_gallery_comments='" + total_gallery_comments + '\'' +
                ", total_gallery_likes='" + total_gallery_likes + '\'' +
                ", total_gallery_submissions='" + total_gallery_submissions + '\'' +
                ", userTrophies=" + userTrophies +
                '}';
    }
}
