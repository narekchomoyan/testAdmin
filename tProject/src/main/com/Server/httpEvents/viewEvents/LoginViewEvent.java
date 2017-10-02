package main.com.Server.httpEvents.viewEvents;

import main.com.Server.httpEvents.HttpViewEventBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by narek on 4/19/17.
 */
public class LoginViewEvent extends HttpViewEventBase {


    public LoginViewEvent(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected String getViewName() {
        return "home";
    }

    @Override
    protected String getTemplateName() {
        if(authenticate()){
            return super.getTemplateName();
        }else {
            return "login";
        }
    }

    @Override
    protected void doHandle() {

    }

    @Override
    protected boolean requireAuthentication() {
        return false;
    }

}
