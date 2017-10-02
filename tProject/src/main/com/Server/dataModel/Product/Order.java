package main.com.Server.dataModel.Product;

import main.com.Server.Utils.StringUtils;
import main.com.Server.core.Serialisable;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity()
@Table(name = "myOrder", catalog = "eBanking", schema = "DBO")
public class Order implements Serialisable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Column(name = "orderTime")
    private Timestamp orderTime;
    @Column(name = "status")
    private int status;
    @Column(name = "tableId")
    private long tableId;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true)
    private List<ProductInOrder> products;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public List<ProductInOrder> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInOrder> products) {
        this.products = products;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        try {
            object.putOpt("id", id);
            object.putOpt("tableId", tableId);
            object.putOpt("status", status);
            if(orderTime != null) {
                object.putOpt("offerTime", orderTime.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {
        Date date =  StringUtils.getDateFromString(jsonObject.optString("offerDate"));
        if(date != null){
            orderTime = new Timestamp(date.getTime());
        }
        tableId = jsonObject.optInt("tableId");
    }
}
