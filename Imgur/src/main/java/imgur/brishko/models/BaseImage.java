package imgur.brishko.models;

/**
 * Parent class for BaseGalleryImage which extends to GalleryImage, GalleryAlbum, Image and Album.
 */
public class BaseImage {
    /**
     * Small Square	 90x90	No
     */
    public static final String SMALL_SQUARE_THUMBNAIL = "s";
    /**
     * Big Square	160x160	No
     */
    public static final String BIG_SQUARE_THUMBNAIL = "b";
    /**
     * Small Thumbnail	160x160	Yes
     */
    public static final String SMALL_THUMBNAIL = "t";
    /**
     * Medium Thumbnail	320x320	Yes
     */
    public static final String MEDIUM_THUMBNAIL = "m";
    /**
     * Large Thumbnail	640x640	Yes
     */
    public static final String LARGE_THUMBNAIL = "l";
    /**
     * Huge Thumbnail	1024x1024	Yes
     */
    public static final String HUGE_THUMBNAIL = "h";


    protected String id;
    protected String title;
    protected String description;
    protected String datetime;
    protected String link;
    protected String views;

    public BaseImage() {
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
     * @return The URL link to the album
     */
    public String getLink() {
        return link;
    }

    /**
     * @return The number of album views
     */
    public String getViews() {
        return views;
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

    public void setLink(String link) {
        this.link = link;
    }

    public void setViews(String views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "BaseImage{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime='" + datetime + '\'' +
                ", link='" + link + '\'' +
                ", views='" + views + '\'' +
                '}';
    }
}
