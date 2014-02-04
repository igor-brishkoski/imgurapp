package com.example.uploadjpegs.datamodels;

import java.util.ArrayList;

/**
 * This data model represents an images comment.
 * <p/>
 * Example URL: https://api.imgur.com/3/comment/{id}
 * <p/>
 * https://api.imgur.com/models/comment
 */
public class Comment {

    private String id;
    private String image_id;
    private String caption;
    private String author;
    private String author_id;
    private String on_album;
    private String album_cover;
    private String ups;
    private String downs;
    private String points;
    private String datetime;
    private String parent_id;
    private String deleted;
    private ArrayList<Comment> comments; //TODO create custom Json Builder for the List of comments

    public Comment() {
    }

    /**
     * @return The ID for the comment
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The ID of the image that the comment is for
     */
    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    /**
     * @return The comment itself.
     */
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * @return Username of the author of the comment
     */
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return The account ID for the author
     */
    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    /**
     * @return If this comment was done to an album
     */
    public String getOn_album() {
        return on_album;
    }

    public void setOn_album(String on_album) {
        this.on_album = on_album;
    }

    /**
     * @return The ID of the album cover image, this is what should be displayed for album comments
     */
    public String getAlbum_cover() {
        return album_cover;
    }

    public void setAlbum_cover(String album_cover) {
        this.album_cover = album_cover;
    }

    /**
     * @return Number of upvotes for the comment
     */
    public String getUps() {
        return ups;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }

    /**
     * @return The number of downvotes for the comment
     */
    public String getDowns() {
        return downs;
    }

    public void setDowns(String downs) {
        this.downs = downs;
    }

    /**
     * @return the number of upvotes - downvotes
     */
    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    /**
     * @return Timestamp of creation, epoch time
     */
    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * @return If this is a reply, this will be the value of the comment_id for the caption this a reply for.
     */
    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    /**
     * @return Marked true if this caption has been deleted
     */
    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    /**
     * @return All of the replies for this comment. If there are no replies to the comment then this is an empty set.
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", image_id='" + image_id + '\'' +
                ", caption='" + caption + '\'' +
                ", author='" + author + '\'' +
                ", author_id='" + author_id + '\'' +
                ", on_album='" + on_album + '\'' +
                ", album_cover='" + album_cover + '\'' +
                ", ups='" + ups + '\'' +
                ", downs='" + downs + '\'' +
                ", points='" + points + '\'' +
                ", datetime='" + datetime + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", deleted='" + deleted + '\'' +
                ", comments=" + comments +
                '}';
    }
}
