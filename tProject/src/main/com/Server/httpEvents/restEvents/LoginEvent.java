package main.com.Server.httpEvents.restEvents;

import main.com.Server.dataModel.User.User;
import main.com.Server.httpEvents.HttpRestEventBase;
import main.com.Server.managers.SessionManager;
import main.com.Server.managers.UserManager;
import main.com.Server.security.sessions.Session;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.SessionFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginEvent extends HttpRestEventBase{

    public LoginEvent(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected void doHandle() {
       JSONObject data = getJsonObject();
       if(data != null){
           String userName = getJsonObject().optString("username","");
           String password = getJsonObject().optString("password","");
           User user = UserManager.getInstance().authenticateUser(userName, password);
           if(user != null){
               Session session = SessionManager.getInstance().createSessionIfNotExists(
                       request.getSession().getId());
               session.setUser(user);
               addResponseParameter("location", "/home");
               setStatusCode(RESULT_CODE_REDIRECT);
//               addResponseParameter("user", user);
//               addResponseParameter("token", request.getSession().getId());
           }else {
               setErrorMessage("User not found");
               setStatusCode(RESULT_CODE_FAILED);
           }
       }else {
           setErrorMessage("Request Body can not be null.");
           setStatusCode(RESULT_CODE_FAILED);
       }
    }

    @Override
    protected boolean requireAuthentication() {
        return false;
    }
}
