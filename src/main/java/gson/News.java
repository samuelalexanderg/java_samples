package gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * Author sam .
 */
public class News {
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    @SerializedName("Name")
    private String title;
    @SerializedName("URL__c")
    private String url;
    @SerializedName("published_date__c")
    private Date publishedDate;

    // For JSON
    public News() {}

    public News(String title, String url, Date publicationDate) {
    	this.title = title;
    	this.url = url;
    	this.publishedDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public static void main(String[] args) {
		News news = new News("title", "http://test", new Date());
        Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
//        System.out.println(gson.toJson(news));
        List<News> newsList = new ArrayList<>();
        newsList.add(new News("title", "http://test", new Date()));
        newsList.add(new News("title2", "http://test", new Date()));
        newsList.add(new News("title3", "http://test", new Date()));
        newsList.add(new News("title4", "http://test", new Date()));

        System.out.println(gson.toJson(newsList));
	}
}
