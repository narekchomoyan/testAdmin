package main.com.Server.managers;

import main.com.Server.Utils.Utils;
import main.com.Server.security.sessions.Session;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by narek on 4/6/17.
 */
public class SessionManager {
    private static SessionManager instance = new SessionManager();

    public static SessionManager getInstance() {
        return instance;
    }

    private SessionManager() {
    }
    /** implementation **/
    private Map<String, Session> sessionMap = new HashMap<>();

    public Session createSessionIfNotExists(String sessionId){
        Session session = sessionMap.get(sessionId);
        if(session != null){
            return session;
        }
        else {
            session = new Session(sessionId, Utils.getTimeInMiliseconds());
            sessionMap.put(sessionId, session);
        }
        return session;
    }

    public void removeSessionwithId(String sessionId){
        sessionMap.remove(sessionId);
    }

    public Session getSessionWithId(String sessionId){
        return sessionMap.get(sessionId);
    }
}
