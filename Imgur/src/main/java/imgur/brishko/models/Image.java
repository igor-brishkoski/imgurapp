package imgur.brishko.models;
/**
 * The base model for an image.
 * <p/>
 * Example URL: https://api.imgur.com/3/image/{id}
 * <p/>
 * Image thumbnails
 * There are 6 total thumbnails that an image can be resized to. Each one is accessable by appending a single character suffix to the end of the image id, and before the file extension. The thumbnails are:
 * For example, the image located at http://i.imgur.com/12345.jpg has the Medium Thumbnail located at http://i.imgur.com/12345m.jpg
 * <p/>
 * https://api.imgur.com/models/image
 */
public class Image {

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

    public Image() {
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getType() {
        return type;
    }

    public String getAnimated() {
        return animated;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getSize() {
        return size;
    }

    public String getViews() {
        return views;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public String getDeletehash() {
        return deletehash;
    }

    public String getSection() {
        return section;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "Image{" +
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
                '}';
    }
}
