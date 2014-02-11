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
public class Image extends BaseImage {

    private String type;
    private String animated;
    private String width;
    private String height;
    private String size;
    private String bandwidth;
    private String deletehash;
    private String section;


    public Image() {
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

    public String getBandwidth() {
        return bandwidth;
    }

    public String getDeletehash() {
        return deletehash;
    }

    public String getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "Image{" +
                "type='" + type + '\'' +
                ", animated='" + animated + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", size='" + size + '\'' +
                ", bandwidth='" + bandwidth + '\'' +
                ", deletehash='" + deletehash + '\'' +
                ", section='" + section + '\'' +
                "} " + super.toString();
    }
}
