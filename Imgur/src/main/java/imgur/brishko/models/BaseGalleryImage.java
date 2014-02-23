package imgur.brishko.models;

/**
 * Parent class for the public gallery of imgur
 */
public class BaseGalleryImage extends BaseImage {

    protected String ups;
    protected String downs;
    protected String is_album;
    protected String vote;
    protected String account_url;
    protected String score;

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
     * @return The account username or null if it's anonymous.
     */
    public String getAccount_url() {
        return account_url;
    }

    /**
     * @return Imgur popularity score
     */
    public String getScore() {
        return score;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }

    public void setDowns(String downs) {
        this.downs = downs;
    }

    public void setIs_album(String is_album) {
        this.is_album = is_album;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public void setAccount_url(String account_url) {
        this.account_url = account_url;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "BaseGalleryImage{" +
                "ups='" + ups + '\'' +
                ", downs='" + downs + '\'' +
                ", is_album='" + is_album + '\'' +
                ", vote='" + vote + '\'' +
                ", account_url='" + account_url + '\'' +
                ", score='" + score + '\'' +
                "} " + super.toString();
    }
}
