package main.com.Server.frontEnd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by narek on 3/8/17.
 */
public class ViewModel {
    public List<String> headerJS = new ArrayList<>();
    public List<String> css = new ArrayList<String>();
    public List<String> jss = new ArrayList<String>();
    public List<String> outerJS = new ArrayList<>();
    public String font;
    public String page;
    public String title;
    public String slug;

    public void setCss(List<String> localCss) {
        this.css = localCss;
    }

    public List<String> getCss() {
        return css;
    }

    public List<String> getJss() {
        return jss;
    }

    public String getFont() {
        return font;
    }

    public String getPage() {
        return page;
    }

    public String getTitle() {
        return title;
    }


    public String getSlug() {
        return slug;
    }

    public List<String> getOuterJS() {
        return outerJS;
    }


    public List<String> getHeaderJS() {
        return headerJS;
    }

    public void setHeaderJS(List<String> headerJS) {
        this.headerJS = headerJS;
    }
}
