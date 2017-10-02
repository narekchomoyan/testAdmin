package main.com.Server.dataModel.Product;

import com.sun.org.apache.xpath.internal.operations.Or;
import main.com.Server.core.Serialisable;
import main.com.Server.dataModel.User.User;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.persistence.*;

@Entity()
@Table(name = "productInOrder", catalog = "eBanking", schema = "DBO")
public class ProductInOrder implements Serialisable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "orderId")
    private Order order;
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "productId")
    private Product product;
    @JoinColumn(name = "count")
    private int count;
    @JoinColumn(name = "status")
    private int status;

    public ProductInOrder() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
            object.putOpt("count", count);
            object.putOpt("status", status);
            if(product != null){
                object.putOpt("product",product.toString());
            }
            if(order != null){
                object.putOpt("order",order.toJson());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {
        long orderId = jsonObject.optLong("orderId");
        order = new Order();
        order.setId(orderId);
        product = new Product();
        product.setId(jsonObject.optLong("productId"));
        count = jsonObject.optInt("count", 1);
    }
}
