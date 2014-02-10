package imgur.brishko.models;
import java.util.ArrayList;

/**
 * This model represents the data for the users statistics.
 * <p/>
 * Example URL: https://api.imgur.com/3/account/{username}/stats
 * <p/>
 * https://api.imgur.com/models/account_statistics
 */
public class AccountStatistics {
    private String total_images;
    private String total_albums;
    private String disk_used;
    private String bandwidth_used;
    private ArrayList<Image> album_images;
    private ArrayList<Album> topAlbums;
    private ArrayList<Comment> comments; //TODO you know, JSON builder

    public AccountStatistics() {
    }

    /**
     * @return The amount of images associated with the account
     */
    public String getTotal_images() {
        return total_images;
    }

    public void setTotal_images(String total_images) {
        this.total_images = total_images;
    }

    /**
     * @return The amount of albums associated with the account
     */
    public String getTotal_albums() {
        return total_albums;
    }

    public void setTotal_albums(String total_albums) {
        this.total_albums = total_albums;
    }

    /**
     * @return The amount of disk space used by the images
     */
    public String getDisk_used() {
        return disk_used;
    }

    public void setDisk_used(String disk_used) {
        this.disk_used = disk_used;
    }

    /**
     * @return The amount of bandwidth used by the account
     */
    public String getBandwidth_used() {
        return bandwidth_used;
    }

    public void setBandwidth_used(String bandwidth_used) {
        this.bandwidth_used = bandwidth_used;
    }

    /**
     * @return The most popular Images in the account
     */
    public ArrayList<Image> getAlbum_images() {
        return album_images;
    }

    public void setAlbum_images(ArrayList<Image> album_images) {
        this.album_images = album_images;
    }

    /**
     * @return The most popular albums in the account
     */
    public ArrayList<Album> getTopAlbums() {
        return topAlbums;
    }

    public void setTopAlbums(ArrayList<Album> topAlbums) {
        this.topAlbums = topAlbums;
    }

    /**
     * @return The most popular gallery comments created by the user
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "AccountStatistics{" +
                "total_images='" + total_images + '\'' +
                ", total_albums='" + total_albums + '\'' +
                ", disk_used='" + disk_used + '\'' +
                ", bandwidth_used='" + bandwidth_used + '\'' +
                ", album_images=" + album_images +
                ", topAlbums=" + topAlbums +
                ", comments=" + comments +
                '}';
    }
}
