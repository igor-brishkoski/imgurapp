package com.example.uploadjpegs.datamodels;

/**
 * The base model for a vote.
 * <p/>
 * Example URL: https://api.imgur.com/3/gallery/image/{id}/votes
 * <p/>
 * https://api.imgur.com/models/vote
 */
public class Vote {

    private String ups;
    private String downs;

    public Vote() {
    }

    public String getUps() {
        return ups;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }

    public String getDowns() {
        return downs;
    }

    public void setDowns(String downs) {
        this.downs = downs;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "ups='" + ups + '\'' +
                ", downs='" + downs + '\'' +
                '}';
    }
}
