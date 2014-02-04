package com.example.uploadjpegs.datamodels;

/**
 * The data model formatted for gallery images.
 * <p/>
 * Example URL: https://api.imgur.com/3/gallery/image/{id}
 * <p/>
 * https://api.imgur.com/models/gallery_image
 * <p/>
 * Image thumbnails
 * There are 6 total thumbnails that an image can be resized to. Each one is accessable by appending a single character suffix to the end of the image id, and before the file extension. The thumbnails are:
 * <p/>
 * For example, the image located at http://i.imgur.com/12345.jpg has the Medium Thumbnail located at http://i.imgur.com/12345m.jpg
 */
public class GalleryImage {

    private String id;
    private String title;
    private String description;
    private String datetime;
    private String type;
    private String animated;
    private String width;
    private String height;
    private String size;
    private String views;
    private String bandwidth;
    private String deletehash;
    private String section;
    private String link;
    private String vote;
    private String account_url;
    private String ups;
    private String downs;
    private String score;
    private String is_album;

    public GalleryImage() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnimated() {
        return animated;
    }

    public void setAnimated(String animated) {
        this.animated = animated;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getDeletehash() {
        return deletehash;
    }

    public void setDeletehash(String deletehash) {
        this.deletehash = deletehash;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getAccount_url() {
        return account_url;
    }

    public void setAccount_url(String account_url) {
        this.account_url = account_url;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getIs_album() {
        return is_album;
    }

    public void setIs_album(String is_album) {
        this.is_album = is_album;
    }

    @Override
    public String toString() {
        return "GalleryImage{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime='" + datetime + '\'' +
                ", type='" + type + '\'' +
                ", animated='" + animated + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", size='" + size + '\'' +
                ", views='" + views + '\'' +
                ", bandwidth='" + bandwidth + '\'' +
                ", deletehash='" + deletehash + '\'' +
                ", section='" + section + '\'' +
                ", link='" + link + '\'' +
                ", vote='" + vote + '\'' +
                ", account_url='" + account_url + '\'' +
                ", ups='" + ups + '\'' +
                ", downs='" + downs + '\'' +
                ", score='" + score + '\'' +
                ", is_album='" + is_album + '\'' +
                '}';
    }
}
