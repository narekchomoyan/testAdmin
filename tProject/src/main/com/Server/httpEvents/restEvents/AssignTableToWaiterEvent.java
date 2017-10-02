package main.com.Server.httpEvents.restEvents;

import main.com.Server.httpEvents.HttpRestEventBase;
import main.com.Server.managers.ProductManager;
import org.codehaus.jettison.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AssignTableToWaiterEvent extends HttpRestEventBase {
    public AssignTableToWaiterEvent(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected void doHandle() {
        JSONObject object = getJsonObject();
        if(object != null){
            if(object.has("tableId") && object.has("waiterId")){
                long tableId = object.optLong("tableId");
                long waiterId = object.optLong("waiterId");
                boolean s = ProductManager.getInstance().
                        assignTableToWaiter(tableId, waiterId);
                if(!s){
                    setErrorMessage("Error to execute an operation.");
                    setStatusCode(RESULT_CODE_FAILED);
                }

            }else {
                setErrorMessage("table Id and WaiterId required.");
            }
        }else {
            setErrorMessage("Request body can not be empty");
            setStatusCode(RESULT_CODE_FAILED);
        }
    }
    @Override
    public int getAllowedRole() {
        return 2;
    }
}
