package watson.alchemy;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * Author sam .
 */
public class News {
    @SerializedName("Name")
    private String title;
    @SerializedName("URL__c")
    private String url;
    @SerializedName("published_date__c")
    private Date publishedDate;

    // For JSON
    public News() {}

    public News(String title, String url, Date publicationDate) {

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
}
