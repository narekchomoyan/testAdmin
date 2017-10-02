package main.com.Server.httpEvents;

import main.com.Server.NetworkConstants;
import main.com.Server.dataModel.User.User;
import main.com.Server.frontEnd.ViewModel;
import main.com.Server.httpEvents.HttpEventBase;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by narek on 4/11/17.
 */
@Controller
public abstract class HttpViewEventBase extends HttpEventBase{
    private ViewModel model;
    private ModelAndView modelAndView;
    protected String pageName;

    public HttpViewEventBase(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }


    public int getSelectedTab(){
        return -1;
    }

    protected final void addViewParameter(String name, Object value){
        modelAndView.addObject(name, value);
    }

    public ModelAndView handle() {
        this.request = request;
        this.response = response;
        prepareData();
        if(!requireAuthentication() || authenticate()){
            modelAndView = new ModelAndView(getTemplateName());
            addViewParameter("server_URL",NetworkConstants.SERVER_URL );
            addViewParameter("innerPrefix",NetworkConstants.INNER_PREFIX);
            doHandle();
            response.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            prepareIncludes();
            if(getSession() != null) {
                User user = getSession().getUser();
                addViewParameter("user", user);
            }
            addViewParameter("viewModel", model);
            return modelAndView;
        }
        try {
            response.sendRedirect(NetworkConstants.INNER_PREFIX + "/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ViewModel getModel() {
        return model;
    }

    public void setModel(ViewModel model) {
        this.model = model;
    }

    public ModelAndView getModelAndView() {
        return modelAndView;
    }

    public void setModelAndView(ModelAndView modelAndView) {
        this.modelAndView = modelAndView;
    }

    protected String getTemplateName(){
        return "template";
    }

    /**
     * Prepare Css and JS includes
     */
    public void prepareIncludes(){
        this.model = new ViewModel();
        model.slug = "page-" + getViewName();
        model.page = getViewName() + ".jsp";
        model.title = StringUtils.capitalize(getViewName());

    }


    /**
     * Prepare CSS includes **/



    protected abstract String getViewName();

}
