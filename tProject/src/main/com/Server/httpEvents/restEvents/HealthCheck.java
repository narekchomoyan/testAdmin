package main.com.Server.httpEvents.restEvents;

import main.com.Server.httpEvents.HttpRestEventBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HealthCheck extends HttpRestEventBase {
    public HealthCheck(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected void doHandle() {
        String name = "User";
        if(getJsonObject() != null){
            name = getJsonObject().optString("name",name);
        }
        addResponseParameter("hello", "hello Dear " + name);
    }

    @Override
    protected boolean requireAuthentication() {
        return false;
    }
}
