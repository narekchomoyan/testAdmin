package main.com.Server.httpEvents.restEvents;

import main.com.Server.dataModel.Product.ProductInOrder;
import main.com.Server.httpEvents.HttpRestEventBase;
import main.com.Server.managers.ProductManager;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AddProductsToOrder extends HttpRestEventBase {
    public AddProductsToOrder(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected void doHandle() {
        JSONObject object = getJsonObject();
        if(object != null && object.has("products")){
            JSONArray products = null;
            products = object.optJSONArray("products");
            if(products == null) {
                try {
                    products = new JSONArray(object.optString("products"));
                } catch (JSONException e) {
                    products = new JSONArray();
                    e.printStackTrace();
                }
            }
            List<ProductInOrder> productInOrders = new ArrayList<>();
            for(int i =0; i< products.length(); i++){
                JSONObject productObject = products.optJSONObject(i);
                ProductInOrder productInOrder = new ProductInOrder();
                productInOrder.fromJson(productObject);
                productInOrders.add(productInOrder);
            }
            if(productInOrders.size() > 0){
                boolean s = ProductManager.getInstance().addProducts(productInOrders);
                if(s){
                    JSONArray productsArray = new JSONArray();
                    for(ProductInOrder p : productInOrders){
                        productsArray.put(p.toJson());
                    }
                    addResponseParameter("products", productsArray);
                }else {
                    setErrorMessage("Insert Failed");
                    setStatusCode(RESULT_CODE_FAILED);
                }
            }
        }
    }

    @Override
    public int getAllowedRole() {
        return 1;
    }
}
