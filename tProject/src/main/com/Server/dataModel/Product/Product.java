package main.com.Server.dataModel.Product;

import main.com.Server.core.Serialisable;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.persistence.*;

@Entity()
@Table(name = "product", catalog = "eBanking", schema = "DBO")
public class Product implements Serialisable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Column(name = "name",  columnDefinition = "ntext")
    private String name;
    @Column(name = "description",  columnDefinition = "ntext")
    private String description;
    @Column(name = "price")
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        try {
            object.putOpt("name", name);
            object.putOpt("price", price);
            object.putOpt("description", description);
            object.putOpt("id", id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {
        name = jsonObject.optString("name");
        price = jsonObject.optDouble("price");
        description = jsonObject.optString("description");
    }
}
