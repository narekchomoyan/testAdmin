package main.com.Server.httpEvents.restEvents;

import main.com.Server.dataModel.Product.MyTable;
import main.com.Server.dataModel.User.User;
import main.com.Server.httpEvents.HttpRestEventBase;
import main.com.Server.managers.ProductManager;
import org.codehaus.jettison.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetMyAssignedTables extends HttpRestEventBase{
    public GetMyAssignedTables(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    protected void doHandle() {
        User user = getSession().getUser();
        List<MyTable> tables = ProductManager.getInstance()
                .getTablesAssignedToUSer(user.getId());
        JSONArray tablesArray = new JSONArray();
        for(MyTable t: tables){
            tablesArray.put(t.toJson());
        }
        addResponseParameter("tables", tablesArray);
    }
    @Override
    public int getAllowedRole() {
        return 1;
    }
}
