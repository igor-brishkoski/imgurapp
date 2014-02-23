package imgur.brishko.models;

/**
 * This model is used to represent the basic account information.
 * <p/>
 * You can request the account information about any user.
 * Example URL: https://api.imgur.com/3/account/{username}
 * <p/>
 * {
 * "data" : {
 * "id"         : 384077,
 * "url"        : "joshTest",
 * "bio"        : "A real hoopy frood who really knows where his towel is at."
 * "reputation" : 15303.84,
 * "created"    : 1376951504,
 * "pro_expiration": false,
 * },
 * "status"  : 200,
 * "success" : true
 * }
 * <p/>
 * https://api.imgur.com/models/account
 */
public class Account {

    /**
     * The account id for the username requested.
     */
    private int id;
    /**
     * The account username, will be the same as requested in the URL
     */
    private String url;
    /**
     * A basic description the user has filled out
     */
    private String bio;
    /**
     * The reputation for the account, in it's numerical format.
     */
    private float reputation;
    /**
     * The epoch time of account creation
     */
    private int created;
    /**
     * False if not a pro user, their expiration date if they are.
     */
    private int pro_expiration;

    /**
     * Empty constructor
     */
    public Account() {
    }

    /**
     * @param id             The account id for the username requested.
     * @param url            The account username, will be the same as requested in the URL
     * @param bio            A basic description the user has filled out
     * @param reputation     The reputation for the account, in it's numerical format.
     * @param created        The epoch time of account creation
     * @param pro_expiration False if not a pro user, their expiration date if they are.
     */
    public Account(int id, String url, String bio, float reputation, int created, int pro_expiration) {
        this.id = id;
        this.url = url;
        this.bio = bio;
        this.reputation = reputation;
        this.created = created;
        this.pro_expiration = pro_expiration;
    }

    /**
     * @param id             The account id for the username requested.
     * @param url            The account username, will be the same as requested in the URL
     * @param bio            A basic description the user has filled out
     * @param reputation     The reputation for the account, in it's numerical format.
     * @param created        The epoch time of account creation
     * @param pro_expiration False if not a pro user, their expiration date if they are.
     */
    public Account(int id, String url, String bio, float reputation, int created, boolean pro_expiration) {
        this.id = id;
        this.url = url;
        this.bio = bio;
        this.reputation = reputation;
        this.created = created;
        this.pro_expiration = -1;
    }

    /**
     * @return The account id for the username requested.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The account id for the username
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return The account username, will be the same as requested in the URL
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return A basic description the user has filled out
     */
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * @return The reputation for the account, in it's numerical format.
     */
    public float getReputation() {
        return reputation;
    }

    public void setReputation(float reputation) {
        this.reputation = reputation;
    }

    /**
     * @return The epoch time of account creation
     */
    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    /**
     * @return False if not a pro user, their expiration date if they are.
     */
    public int getPro_expiration() {
        return pro_expiration;
    }

    public void setPro_expiration(int pro_expiration) {
        this.pro_expiration = pro_expiration;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", bio='" + bio + '\'' +
                ", reputation=" + reputation +
                ", created=" + created +
                ", pro_expiration=" + pro_expiration +
                '}';
    }
}
