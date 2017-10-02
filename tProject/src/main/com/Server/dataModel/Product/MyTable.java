package main.com.Server.dataModel.Product;

import main.com.Server.core.Serialisable;
import main.com.Server.dataModel.User.User;
import org.apache.log4j.xml.SAXErrorHandler;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.persistence.*;

@Entity()
@Table(name = "myTable", catalog = "eBanking", schema = "DBO")
public class MyTable implements Serialisable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Column(name = "name",  columnDefinition = "ntext")
    private String name;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "waiterId")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        try {
            object.putOpt("name", name);
            object.putOpt("id", id);
            if(user != null) {
                object.putOpt("user", user.toJson());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {
        name = jsonObject.optString("name");
    }
}
