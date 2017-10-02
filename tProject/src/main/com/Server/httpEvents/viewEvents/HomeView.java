package main.com.Server.httpEvents.viewEvents;

import main.com.Server.httpEvents.HttpViewEventBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeView extends HttpViewEventBase{
    public HomeView(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected String getViewName() {
        if(getSession().getUser().getRole() == 1) {
            return "waiterHom";
        }else {
            return "adminHome";
        }
    }

    @Override
    protected void doHandle() {
    }
}
