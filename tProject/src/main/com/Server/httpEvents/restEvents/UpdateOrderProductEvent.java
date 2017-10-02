package main.com.Server.httpEvents.restEvents;

import main.com.Server.dataModel.Product.ProductInOrder;
import main.com.Server.httpEvents.HttpRestEventBase;
import main.com.Server.managers.ProductManager;
import org.codehaus.jettison.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateOrderProductEvent extends HttpRestEventBase{
    public UpdateOrderProductEvent(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected void doHandle() {
        JSONObject object = getJsonObject();
        if(object != null){
            long pId = object.optLong("id");
            ProductInOrder productInOrder = ProductManager.getInstance().getProductInOrderWithId(pId);
            if(productInOrder != null){
                int status = object.optInt("status",-1);
                int count = object.optInt("count", -1);
                if(status > -1){
                    productInOrder.setStatus(status);
                }
                if(count > -1){
                    productInOrder.setCount(count);
                }
                ProductManager.getInstance().updateProduct(productInOrder);
            }else {
                setErrorMessage("product not found.");
                setStatusCode(RESULT_CODE_FAILED);
            }
        }
    }

    @Override
    public int getAllowedRole() {
        return 1;
    }
}
