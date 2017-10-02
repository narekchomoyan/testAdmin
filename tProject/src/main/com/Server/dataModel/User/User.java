package main.com.Server.dataModel.User;

import main.com.Server.core.Serialisable;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.persistence.*;

@Entity()
@Table(name = "cafeUser", catalog = "eBanking", schema = "DBO")
public class User implements Serialisable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Column(name = "username",  columnDefinition = "ntext")
    private String userName;
    @Column(name = "password",  columnDefinition = "ntext")
    private String password;
    @Column(name = "role")
    private int role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        try {
            object.putOpt("username", userName);
            object.putOpt("id", id);
            object.putOpt("password", password);
            object.putOpt("role", role);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {
       userName = jsonObject.optString("username");
       password = jsonObject.optString("password");
       role = jsonObject.optInt("role");
    }
}
