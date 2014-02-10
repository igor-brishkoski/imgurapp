package imgur.brishko.models;
/**
 * Example URL: https://api.imgur.com/3/account/{username}/gallery_profile
 * <p/>
 * https://api.imgur.com/models/gallery_profile
 */
public class Trophy {

    private String id;
    private String name;
    private String name_clean;
    private String description;
    private String data;
    private String data_link;
    private String datetime;
    private String image;

    public Trophy() {
    }

    /**
     * @return The ID of the trophy, this is unique to each trophy
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The name of the trophy
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Can be thought of as the ID of a trophy type
     */
    public String getName_clean() {
        return name_clean;
    }

    public void setName_clean(String name_clean) {
        this.name_clean = name_clean;
    }

    /**
     * @return A description of the trophy and how it was earned.
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The ID of the image or the ID of the comment where the trophy was earned
     */
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return A link to where the trophy was earned
     */
    public String getData_link() {
        return data_link;
    }

    public void setData_link(String data_link) {
        this.data_link = data_link;
    }

    /**
     * @return Date the trophy was earned, epoch time
     */
    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * @return URL of the image representing the trophy
     */
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Trophy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", name_clean='" + name_clean + '\'' +
                ", description='" + description + '\'' +
                ", data='" + data + '\'' +
                ", data_link='" + data_link + '\'' +
                ", datetime='" + datetime + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
