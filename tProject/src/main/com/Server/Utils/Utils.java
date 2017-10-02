package main.com.Server.Utils;

import java.util.Date;

/**
 * Created by narek on 4/12/17.
 */
public class Utils {
    public static long getTimeInMiliseconds(){
        return new Date().getTime();
    }
}
