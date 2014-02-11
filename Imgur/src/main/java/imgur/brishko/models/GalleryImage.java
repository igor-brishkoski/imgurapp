package imgur.brishko.models;
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
public class GalleryImage extends BaseGalleryImage {

    private String type;
    private String animated;
    private String width;
    private String height;
    private String size;
    private String bandwidth;
    private String deletehash;
    private String section;

    public GalleryImage() {
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

    @Override
    public String toString() {
        return "GalleryImage{" +
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
