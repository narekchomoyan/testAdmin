package main.com.Server.httpEvents.restEvents;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xpath.internal.operations.Or;
import main.com.Server.dataModel.Product.Order;
import main.com.Server.httpEvents.HttpRestEventBase;
import main.com.Server.managers.ProductManager;
import org.codehaus.jettison.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateOrderEvent extends HttpRestEventBase{
    public UpdateOrderEvent(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected void doHandle() {
        JSONObject object = getJsonObject();
        if(object != null){
            long id = object.optLong("id");
            Order order = ProductManager.getInstance().getOrderWithId(id);
            if(order != null){
                int status = object.optInt("status", -1);
                if(status >= 0) {
                    order.setStatus(status);
                }
                boolean s = ProductManager.getInstance().updateProduct(order);
                if(!s){
                    setErrorMessage("Update Failed");
                    setStatusCode(RESULT_CODE_FAILED);
                }

            }else {
                setErrorMessage("Order not found");
                setStatusCode(RESULT_CODE_FAILED);
            }
        }
    }
    @Override
    public int getAllowedRole() {
        return 1;
    }
}
