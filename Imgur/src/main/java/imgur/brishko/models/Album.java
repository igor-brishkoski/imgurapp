package imgur.brishko.models;
import java.util.ArrayList;

/**
 * This model represents the data for albums
 * <p/>
 * Example URL: https://api.imgur.com/3/album/{id}
 * <p/>
 * https://api.imgur.com/models/album
 */
public class Album {

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
    private String deletehash;
    private String images_count;
    private ArrayList<Image> album_images; //TODO create custom Json Builder for the List of images

    public Album() {
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
     * @return OPTIONAL, the deletehash, if you're logged in as the album owner
     */
    public String getDeletehash() {
        return deletehash;
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

    @Override
    public String toString() {
        return "Album{" +
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
                ", deletehash='" + deletehash + '\'' +
                ", images_count='" + images_count + '\'' +
                ", album_images=" + album_images +
                '}';
    }
}
