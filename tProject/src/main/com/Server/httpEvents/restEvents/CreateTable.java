package main.com.Server.httpEvents.restEvents;

import main.com.Server.dataModel.Product.MyTable;
import main.com.Server.httpEvents.HttpRestEventBase;
import main.com.Server.managers.ProductManager;
import org.codehaus.jettison.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateTable  extends HttpRestEventBase{
    public CreateTable(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected void doHandle() {
        JSONObject object = getJsonObject();
        if(object != null){
            MyTable table = new MyTable();
            table.fromJson(object);
            boolean sucsess = ProductManager.getInstance().createProduct(table);
            if(sucsess){
                addResponseParameter("table", table.toJson());
            }else {
                setErrorMessage("Error to save table");
                setStatusCode(RESULT_CODE_FAILED);
            }
        }else {
            setErrorMessage("Request body can not be null.");
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
