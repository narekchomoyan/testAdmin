package main.com.Server.httpEvents.restEvents;

import com.sun.org.apache.regexp.internal.RE;
import main.com.Server.dataModel.Product.Order;
import main.com.Server.httpEvents.HttpRestEventBase;
import main.com.Server.managers.ProductManager;
import org.codehaus.jettison.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class CreateOrderEvent extends HttpRestEventBase{
    public CreateOrderEvent(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected void doHandle() {
        JSONObject object = getJsonObject();
        if(object != null && object.has("tableId") && object.has("offerDate")){
            long tableId = object.optLong("table");
            List<Order> orders = ProductManager.getInstance().getOpenOrdersForTable(tableId);
            if(orders.size() > 0){
                setErrorMessage("Table has open Orders");
                setStatusCode(RESULT_CODE_FAILED);
            }else {
                Order order = new Order();
                order.fromJson(object);
                order.setStatus(3);
                boolean sucsess = ProductManager.getInstance().createProduct(order);
                if(sucsess){
                   addResponseParameter("order",  order.toJson());
                }else {
                    setErrorMessage("Error to save an Order.");
                    setStatusCode(RESULT_CODE_FAILED);
                }
            }

        }else {
            setErrorMessage("TableId and OrderTime required");
            setStatusCode(RESULT_CODE_FAILED);
        }
    }
    @Override
    public int getAllowedRole() {
        return 1;
    }
}
