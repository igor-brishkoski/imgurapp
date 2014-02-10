package imgur.brishko.models;
import java.util.ArrayList;

/**
 * The data model formatted for gallery albums.
 * <p/>
 * Example URL: http://api.imgur.com/3/gallery/album/{id}
 * <p/>
 * https://api.imgur.com/models/gallery_album
 */
public class GalleryAlbum {

    private String id;
    private String title;
    private String description;
    private String datetime;
    private String cover;
    private String account_url;
    private String privacy;
    private String layout;
    private String views;
    private String link;
    private String ups;
    private String downs;
    private String score;
    private String is_album;
    private String vote;
    private String images_count;
    private ArrayList<Image> album_images; //TODO create custom Json Builder for the List of images

    public GalleryAlbum() {
    }

    /**
     * @return The ID for the album
     */
    public String getId() {
        return id;
    }

    /**
     * @return The title of the album in the gallery
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The description of the album in the gallery
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Time inserted into the gallery, epoch time
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     * @return The ID of the album cover image
     */
    public String getCover() {
        return cover;
    }

    /**
     * @return The account username or null if it's anonymous.
     */
    public String getAccount_url() {
        return account_url;
    }

    /**
     * @return The privacy level of the album, you can only view public if not logged in as album owner
     */
    public String getPrivacy() {
        return privacy;
    }

    /**
     * @return The view layout of the album.
     */
    public String getLayout() {
        return layout;
    }

    /**
     * @return The number of album views
     */
    public String getViews() {
        return views;
    }

    /**
     * @return The URL link to the album
     */
    public String getLink() {
        return link;
    }

    /**
     * @return Upvotes for the image
     */
    public String getUps() {
        return ups;
    }

    /**
     * @return Number of downvotes for the image
     */
    public String getDowns() {
        return downs;
    }

    /**
     * @return Imgur popularity score
     */
    public String getScore() {
        return score;
    }

    /**
     * @return f it's an album or not
     */
    public String getIs_album() {
        return is_album;
    }

    /**
     * @return The current user's vote on the album. null if not signed in or if the user hasn't voted on it.
     */
    public String getVote() {
        return vote;
    }

    /**
     * @return The total number of images in the album (only available when requesting the direct album)
     */
    public String getImages_count() {
        return images_count;
    }

    /**
     * @return An array of all the images in the album (only available when requesting the direct album)
     */
    public ArrayList<Image> getAlbum_images() {
        return album_images;
    }

    public void setAlbum_images(ArrayList<Image> album_images) {
        this.album_images = album_images;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setAccount_url(String account_url) {
        this.account_url = account_url;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }

    public void setDowns(String downs) {
        this.downs = downs;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setIs_album(String is_album) {
        this.is_album = is_album;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public void setImages_count(String images_count) {
        this.images_count = images_count;
    }

    @Override
    public String toString() {
        return "GalleryAlbum{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime='" + datetime + '\'' +
                ", cover='" + cover + '\'' +
                ", account_url='" + account_url + '\'' +
                ", privacy='" + privacy + '\'' +
                ", layout='" + layout + '\'' +
                ", views='" + views + '\'' +
                ", link='" + link + '\'' +
                ", ups='" + ups + '\'' +
                ", downs='" + downs + '\'' +
                ", score='" + score + '\'' +
                ", is_album='" + is_album + '\'' +
                ", vote='" + vote + '\'' +
                ", images_count='" + images_count + '\'' +
                ", album_images=" + album_images +
                '}';
    }
}
