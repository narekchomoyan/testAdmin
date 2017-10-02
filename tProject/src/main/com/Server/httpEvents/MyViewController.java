package main.com.Server.httpEvents;

import main.com.Server.httpEvents.viewEvents.HomeView;
import main.com.Server.httpEvents.viewEvents.LoginViewEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyViewController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request,
                       HttpServletResponse response){
        LoginViewEvent event = new LoginViewEvent(request, response);
        return event.handle();
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request,
                              HttpServletResponse response){
        HomeView event = new HomeView(request, response);
        return event.handle();
    }
}
