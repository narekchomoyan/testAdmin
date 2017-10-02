package main.com.Server.security.sessions;

import main.com.Server.Utils.StringUtils;
import main.com.Server.dataModel.User.User;

/**
 * Created by narek on 4/6/17.
 */
public class Session {
    private String id;
    private String token;
    private long lastActionTs;
    private User user;

    public Session(String id, long lastActionTs) {
        this.id = id;
        this.lastActionTs = lastActionTs;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public long getLastActionTs() {
        return lastActionTs;
    }

    public void setLastActionTs(long lastActionTs) {
        this.lastActionTs = lastActionTs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
