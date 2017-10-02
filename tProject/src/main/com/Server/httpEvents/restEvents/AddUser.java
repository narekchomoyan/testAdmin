package main.com.Server.httpEvents.restEvents;

import main.com.Server.dataModel.User.User;
import main.com.Server.httpEvents.HttpRestEventBase;
import main.com.Server.managers.UserManager;
import org.codehaus.jettison.json.JSONObject;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUser extends HttpRestEventBase{
    public AddUser(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected void doHandle() {
        JSONObject object = getJsonObject();
        if(object != null){
            User user = new User();
            user.fromJson(object);
           boolean sucsess =  UserManager.getInstance().addUser(user);
           if(sucsess) {
               addResponseParameter("user", user.toJson());
           }else {
               setErrorMessage("Error to save a user");
               setStatusCode(RESULT_CODE_FAILED);
           }
        }else {
            setErrorMessage("Request body can not be empty.");
        }
    }
    @Override
    public int getAllowedRole() {
        return 2;
    }
}
