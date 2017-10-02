package main.com.Server.httpEvents;

import main.com.Server.Utils.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by narek on 3/28/17.
 * This class is used to handle Rest API-s
 */
public abstract class HttpRestEventBase extends HttpEventBase{
    /** response data **/
    private JSONObject responseBody = new JSONObject();
    private int statusCode;
    private String errorMessage = "";

    protected final int RESULT_CODE_NORMAL = 1;
    protected final int RESULT_CODE_FAILED = 2;
    protected final int RESULT_CODE_NOT_AUTHORIZED = 3;
    protected final int RESULT_CODE_REDIRECT = 4;

    public HttpRestEventBase(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        statusCode = RESULT_CODE_NORMAL;
    }

    /** constructor method **/


    /**handling **/
    public final void handle(){
        prepareData();
        if(!requireAuthentication() || authenticate()){
            doHandle();
        }else {
            setErrorMessage("You Are not Authenticated");
            setStatusCode(RESULT_CODE_NOT_AUTHORIZED);
        }
        makeResponse();
    }



    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    protected abstract void doHandle();

    protected boolean handleAsynchrone(){
        return true;
    }

    private synchronized final void makeResponse(){
        if(statusCode == 4){
            String location = responseBody.optString("location");
            if(!StringUtils.isEmpty(location)){
                try {
                    response.sendRedirect(location);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return;
        }
        setResponseStatus();
        try {
            if(useEncodeing()) {
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
            }
            ServletOutputStream outputStream = response.getOutputStream();
//            response.setContentLength(responseBody.toString().getBytes().length);
            byte[] bytses;
            if(useEncodeing()) {
                bytses = responseBody.toString().getBytes("UTF-8");
            }else {
                bytses = responseBody.toString().getBytes();
            }
            outputStream.write(bytses,0, bytses.length);
            System.out.println(responseBody.toString());
            response.flushBuffer();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected boolean useEncodeing(){
        return true;
    }

    private void setResponseStatus(){
        JSONObject resultObject = new JSONObject();
        try {
            resultObject.putOpt("ResultCode", statusCode);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(statusCode == 1){
            try {
                resultObject.putOpt("Description", "OK");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }else {
            try {
                resultObject.putOpt("Description", errorMessage);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        addResponseParameter("Result", resultObject);
    }

    protected final void addResponseParameter(String key, Object value){
        try {
            responseBody.putOpt(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    protected final void setResponseBody(JSONObject responseBody){
        this.responseBody = responseBody;
    }

    protected final void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    protected final void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
