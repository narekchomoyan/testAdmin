package main.com.Server.Utils;


import org.apache.commons.io.IOUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by narek on 3/14/17.
 */
public class StringUtils {
    private static final String dateFormat = "yyyy-MM-dd";
    private static final char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890_ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final Random random = new Random();

    public static boolean isEmpty(String text){
        if(text == null || text.length() == 0){
            return true;
        }
        return false;
    }

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static JSONObject getJsonFromFile(File file){
        JSONObject jsonObject = null;
        InputStream stream = null;
        try {
           stream = new FileInputStream(file);
            String jsonTxt = IOUtils.toString( stream );
            try {
                jsonObject = new JSONObject(jsonTxt);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static Date getDateFromString(String s){
        if(isEmpty(s)){
            return null;
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static Date getDateFromString(String s, String Format){
        if(isEmpty(s)){
            return null;
        }
        DateFormat format = new SimpleDateFormat(Format);
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getDateFromString2(String s){
        if(isEmpty(s)){
            return null;
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getFullDateStringFromDate(Date date){
        if(date == null){
            return "";
        }
        DateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }
}
