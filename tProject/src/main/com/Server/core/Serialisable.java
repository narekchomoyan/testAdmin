package main.com.Server.core;

import org.codehaus.jettison.json.JSONObject;

/**
 * Created by narek on 4/6/17.
 */
public interface Serialisable {
    JSONObject toJson();
    void fromJson(JSONObject jsonObject);
}
