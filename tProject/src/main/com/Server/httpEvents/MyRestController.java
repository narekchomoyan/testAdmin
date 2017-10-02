package main.com.Server.httpEvents;

import main.com.Server.httpEvents.restEvents.*;
import main.com.Server.managers.HibernateSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/api")
public class MyRestController {
    @Autowired
    private ApplicationContext appContext;

    @PostConstruct
    public void initServer(){
        HibernateSessionManager.getInstance().init(appContext);
    }

    @RequestMapping(path = "/healthCheck", method = RequestMethod.POST)
    public void healthCheck(HttpServletRequest request,
                            HttpServletResponse response){
        HealthCheck event = new HealthCheck(request, response);
        event.handle();
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request,
                            HttpServletResponse response){
        LoginEvent event = new LoginEvent(request, response);
        event.handle();
    }

    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    public void addUserEvent(HttpServletRequest request,
                      HttpServletResponse response){
        AddUser event = new AddUser(request, response);
        event.handle();
    }

    @RequestMapping(path = "/createTable", method = RequestMethod.POST)
    public void createTable(HttpServletRequest request,
                             HttpServletResponse response){
        CreateTable event = new CreateTable(request, response);
        event.handle();
    }

    @RequestMapping(path = "/createProduct", method = RequestMethod.POST)
    public void createProduct(HttpServletRequest request,
                            HttpServletResponse response){
        CreateProductEvent event = new CreateProductEvent(request, response);
        event.handle();
    }
    @RequestMapping(path = "/assignTableToWaiter", method = RequestMethod.POST)
    public void asignTableToWaiter(HttpServletRequest request,
                              HttpServletResponse response){
        AssignTableToWaiterEvent event = new AssignTableToWaiterEvent(request, response);
        event.handle();
    }
    @RequestMapping(path = "/createOrderEvent", method = RequestMethod.POST)
    public void createOrder(HttpServletRequest request,
                                   HttpServletResponse response){
        CreateOrderEvent event = new CreateOrderEvent(request, response);
        event.handle();
    }
    @RequestMapping(path = "/GetMyAssignedTables", method = RequestMethod.POST)
    public void getMyAssignedTables(HttpServletRequest request,
                            HttpServletResponse response){
        GetMyAssignedTables event = new GetMyAssignedTables(request, response);
        event.handle();
    }
    @RequestMapping(path = "/AddProductsToOrder", method = RequestMethod.POST)
    public void addProductsToOrder(HttpServletRequest request,
                                   HttpServletResponse response){
        AddProductsToOrder event = new AddProductsToOrder(request, response);
        event.handle();
    }
    @RequestMapping(path = "/UpdateOrderProductEvent", method = RequestMethod.POST)
    public void updateOrderProductEvent(HttpServletRequest request,
                                   HttpServletResponse response){
        UpdateOrderProductEvent event = new UpdateOrderProductEvent(request, response);
        event.handle();
    }
    @RequestMapping(path = "/UpdateOrderEvent", method = RequestMethod.POST)
    public void updateOrderEvent(HttpServletRequest request,
                                        HttpServletResponse response){
        UpdateOrderEvent event = new UpdateOrderEvent(request, response);
        event.handle();
    }
}
