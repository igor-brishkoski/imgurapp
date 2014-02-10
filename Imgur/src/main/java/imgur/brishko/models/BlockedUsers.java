package imgur.brishko.models;

/**
 * Blocked users used in AccountSettings class
 */
public class BlockedUsers {

    private String blocked_id;
    private String blocked_url;

    public BlockedUsers() {
    }

    public BlockedUsers(String blocked_id, String blocked_url) {
        this.blocked_id = blocked_id;
        this.blocked_url = blocked_url;
    }

    public String getBlocked_id() {
        return blocked_id;
    }

    public void setBlocked_id(String blocked_id) {
        this.blocked_id = blocked_id;
    }

    public String getBlocked_url() {
        return blocked_url;
    }

    public void setBlocked_url(String blocked_url) {
        this.blocked_url = blocked_url;
    }

    @Override
    public String toString() {
        return "BlockedUsers{" +
                "blocked_id=" + blocked_id +
                ", blocked_url=" + blocked_url +
                '}';
    }
}
