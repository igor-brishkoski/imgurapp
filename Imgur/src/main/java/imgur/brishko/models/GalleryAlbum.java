package imgur.brishko.models;

import java.util.ArrayList;

/**
 * The data model formatted for gallery albums.
 * <p/>
 * Example URL: http://api.imgur.com/3/gallery/album/{id}
 * <p/>
 * https://api.imgur.com/models/gallery_album
 */
public class GalleryAlbum extends BaseGalleryImage {

    private String cover;
    private String privacy;
    private String layout;
    private String images_count;
    private ArrayList<Image> album_images; //TODO create custom Json Builder for the List of images

    public GalleryAlbum() {
    }

    /**
     * @return The ID of the album cover image
     */
    public String getCover() {
        return cover;
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


    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public void setImages_count(String images_count) {
        this.images_count = images_count;
    }

    @Override
    public String toString() {
        return "GalleryAlbum{" +
                "cover='" + cover + '\'' +
                ", privacy='" + privacy + '\'' +
                ", layout='" + layout + '\'' +
                ", images_count='" + images_count + '\'' +
                ", album_images=" + album_images +
                "} " + super.toString();
    }
}
