package com.example.uploadjpegs.datamodels;

import java.util.ArrayList;
import java.util.List;

/**
 * The account settings, only accessible if you're logged in as the user.
 * <p/>
 * Example URL: https://api.imgur.com/3/account/{username}/settings
 * <p/>
 * <p/>
 * https://api.imgur.com/models/account_settings
 */
public class AccountSettings {

    private String email;
    private String high_quality;
    private String public_images;
    private String album_privacy;
    private String pro_expiration;
    private String accepted_gallery_terms;
    ArrayList<String> active_emails;
    private String messaging_enabled;
    List<BlockedUsers> blockedUserses;


    public AccountSettings() {
    }

    public String getEmail() {
        return email;
    }

    public String getHigh_quality() {
        return high_quality;
    }

    public String getPublic_images() {
        return public_images;
    }


    public String getAlbum_privacy() {
        return album_privacy;
    }

    public String getPro_expiration() {
        return pro_expiration;
    }

    public String getAccepted_gallery_terms() {
        return accepted_gallery_terms;
    }

    public ArrayList<String> getActive_emails() {
        return active_emails;
    }

    public String getMessaging_enabled() {
        return messaging_enabled;
    }

    public List<BlockedUsers> getBlockedUserses() {
        return blockedUserses;
    }

    public void setBlockedUserses(List<BlockedUsers> blockedUserses) {
        this.blockedUserses = blockedUserses;
    }

    @Override
    public String toString() {
        return "AccountSettings{" +
                "email='" + email + '\'' +
                ", high_quality='" + high_quality + '\'' +
                ", public_images='" + public_images + '\'' +
                ", album_privacy='" + album_privacy + '\'' +
                ", pro_expiration='" + pro_expiration + '\'' +
                ", accepted_gallery_terms='" + accepted_gallery_terms + '\'' +
                ", active_emails=" + active_emails.toString() +
                ", messaging_enabled='" + messaging_enabled + '\'' +
                ", blockedUserses=" + blockedUserses.toString() +
                '}';
    }
}
