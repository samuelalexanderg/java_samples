package rss.reader;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;


/**
 * Author sam .
 */
public class RSSReader {
    private String commaSeparatedReedUrl = "http://blogs.workday.com/feed/";
    private List<String> feedUrls;

    public static void main(String[] args) throws Exception {
    	RSSReader rssReader = new RSSReader();
    	rssReader.init();
    	List<Blog> blogs = rssReader.read();
    	for (Blog blog : blogs) {
            Gson gson = new GsonBuilder().setDateFormat(Blog.DATE_FORMAT).create();
            System.out.println(gson.toJson(blog));
		}
	}

    public void init() {
        feedUrls = Arrays.asList(commaSeparatedReedUrl.split(","));
    }

    public List<Blog> read() throws Exception {
        List<Blog> blogs = new ArrayList<>();

        for (String feedUrl: feedUrls) {
            blogs.addAll(getFeeds(feedUrl));
        }

        return blogs;
    }

    private List<Blog> getFeeds(String feedUrl) throws Exception {
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(new URL(feedUrl)));

        List<Blog> blogs = new ArrayList<>();
        List<SyndEntry> entries = feed.getEntries();
        for (SyndEntry entry: entries) {
            if (doesContainKeywords(entry.getContents())) {
                blogs.add(new Blog(entry.getTitle(), entry.getLink(), entry.getPublishedDate()));
            }
        }

        return blogs;
    }

    private boolean doesContainKeywords(List<SyndContent> contents) {
        for (SyndContent syndContent : contents) {
            String content = syndContent.getValue();
            System.out.println("Content : " + content);

            // TODO : Check whether it has the required keywords
        }

        return true;
    }


}
