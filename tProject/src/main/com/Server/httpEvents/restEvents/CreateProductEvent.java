package main.com.Server.httpEvents.restEvents;

import com.sun.org.apache.regexp.internal.RE;
import main.com.Server.dataModel.Product.Product;
import main.com.Server.httpEvents.HttpRestEventBase;
import main.com.Server.managers.ProductManager;
import org.codehaus.jettison.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateProductEvent extends HttpRestEventBase{
    public CreateProductEvent(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected void doHandle() {
        JSONObject object = getJsonObject();
        if(object != null){
            Product product = new Product();
            product.fromJson(object);
            boolean sucsess = ProductManager.getInstance().createProduct(product);
            if(sucsess){
                addResponseParameter("product", product.toJson());
            }else {
                setErrorMessage("can not save Product");
                setStatusCode(RESULT_CODE_FAILED);
            }
        }else {
            setErrorMessage("Request body can not be null");
            setStatusCode(RESULT_CODE_FAILED);
        }

    }

    @Override
    public int getAllowedRole() {
        return 2;
    }

    @Override
    protected boolean requireAuthentication() {
        return false;
    }
}
