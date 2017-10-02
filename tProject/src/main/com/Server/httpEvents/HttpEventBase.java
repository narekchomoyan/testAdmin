package main.com.Server.httpEvents;


import main.com.Server.Utils.Utils;
import main.com.Server.dataModel.User.User;
import main.com.Server.managers.SessionManager;
import main.com.Server.security.sessions.Session;
import org.apache.commons.io.IOUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

/**
 * Created by Narek on 5/23/2017.
 * HttpEvent base Is Base Class for HttpRestEventBAse
 * and HttpViewEventBAse
 * This class handles Http Request parameters and Authentication
 */
public abstract class HttpEventBase {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    private JSONObject cacheObject;
    private JSONArray cacheArray;
    private String data;

    public HttpEventBase(HttpServletRequest request,
                         HttpServletResponse response) {
        this.request = request;
        this.response = response;
        prepareData();
    }

    protected final void prepareData() {
        if (handleAsForm()) {
            if (request.getCharacterEncoding() == null) {
                try {
                    request.setCharacterEncoding("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            Enumeration<String> keys = request.getParameterNames();
            JSONObject dataObject = new JSONObject();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();
                try {
                    String value = request.getParameter(key);
                    value = new String(value.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
                    dataObject.putOpt(key, request.getParameter(key));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            data = dataObject.toString();
        } else {
            if (request != null) {
                try {
                    InputStream stream = null;
                    stream = request.getInputStream();
                    StringWriter writer = new StringWriter();
                    IOUtils.copy(stream, writer);
                    String data = writer.toString();
                    data = data.trim();
                    setData(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//
            }

        }
    }

    /** getter and setter methods **/
    protected final JSONObject getJsonObject(){
        if(cacheObject != null){
            return cacheObject;
        }else {
            try {
                cacheObject = new JSONObject(getData());
                return cacheObject;
            } catch (JSONException e) {
                if(main.com.Server.Utils.StringUtils.isEmpty(getData())){
                    String[] parts = getData().split("&");
                    if(parts.length > 0){
                        cacheObject = new JSONObject();
                        for(String string:parts){
                            String[] kv = string.split("=");
                            if(kv.length > 1){
                                try {
                                    cacheObject.putOpt(kv[0], kv[1]);
                                } catch (JSONException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }
                        return cacheObject;
                    }
                }
                e.printStackTrace();
                return null;
            }
        }
    }

    protected final JSONArray getJsonArray(){
        if(cacheArray != null){
            return cacheArray;
        }else {
            try {
                cacheArray = new JSONArray(getData());
                return cacheArray;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    protected boolean handleAsForm(){
        return true;
    }

    protected final boolean authenticate() {
        long current = Utils.getTimeInMiliseconds();
        Session session = getSession();
        if(session != null){
            if((current - session.getLastActionTs()) > (15 * 60 * 1000)){
                SessionManager.getInstance().removeSessionwithId(getSessionId());
                return false;
            }
            session.setLastActionTs(current);
           User user =  session.getUser();
           if(getAllowedRole() == 0 || getAllowedRole() == user.getRole()){
               return true;
           }else {
               return false;
           }
        }
        return false;
    }

    protected boolean requireAuthentication(){
        return true;
    }

    /**
     * Abstract method which must be overridden by every APi
     * This method will contain business logic for API-s
     */
    protected abstract void doHandle();

    protected final String getSessionId(){
        return request.getSession().getId();
    }

    protected final Session getSession(){
        Session session = SessionManager.getInstance().getSessionWithId(getSessionId());
        if(session == null){
            session = SessionManager.getInstance().getSessionWithId(request.getHeader("token"));
        }
        return session;
    }

    public void setData(String data){
        this.data = data;
    }

    protected String getData(){
        return data;
    }


    protected final void addSessionParameter(String key, Object value){
        request.getSession().setAttribute(key, value);
    }

    protected final Object getSessionAttribute(String key){
        return request.getSession().getAttribute(key);
    }

    public JSONObject getCacheObject() {
        return cacheObject;
    }

    public void setCacheObject(JSONObject cacheObject) {
        this.cacheObject = cacheObject;
    }

    public JSONArray getCacheArray() {
        return cacheArray;
    }

    public void setCacheArray(JSONArray cacheArray) {
        this.cacheArray = cacheArray;
    }

    /**
     * This method returns sufficient role for Api Use
     * default value is 0 which means that Api does not require
     * any role to be specified
     * @return
     */
    public int getAllowedRole(){
        return 0;
    }
}
