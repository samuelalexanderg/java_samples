package watson.alchemy;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Article;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Document;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Documents;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentsResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Author sam .
 */
public class AlchemySample {
    private static final Logger LOG = LoggerFactory.getLogger(AlchemySample.class);

    public static final String RESP_ENRICHED_URL_URL = "enriched.url.url";
    public static final String RESP_ENRICHED_URL_TITLE = "enriched.url.title";
    public static final String RESP_ENRICHED_URL_PUBLICATION_DATE = "enriched.url.publicationDate";

    public static void main(String args[]) throws Exception {
        LOG.info("Reading news");
        AlchemyDataNews service = new AlchemyDataNews();
        service.setApiKey("b4cb64d514da25b1e4599770b87d3457a88de4e3");
        Map<String, Object> params = new HashMap<String, Object>();

        String[] fields =
                new String[] {RESP_ENRICHED_URL_TITLE, RESP_ENRICHED_URL_URL,
                        RESP_ENRICHED_URL_PUBLICATION_DATE};

        params.put(AlchemyDataNews.RETURN, StringUtils.join(fields, ","));

        // TODO : Make the days as configurable
        params.put(AlchemyDataNews.START, "now-1d");
        params.put(AlchemyDataNews.END, "now");
        // TODO : Make the count as configurable
        params.put(AlchemyDataNews.COUNT, 7);
        params.put("q.enriched.url.enrichedTitle.relations.relation", "|action.verb.text=O[raise^acquire],subject.entities.entity.type=Company,object.entities.entity.type=quantity|");
        // TODO : Make publisher configurable
        // TODO : Handle multiple publishers
        params.put("q.enriched.url.url", "techcrunch");

        DocumentsResult result = service.getNewsDocuments(params).execute();

        System.out.println("result : " + result);

        Documents documents = result.getDocuments();
        System.out.println("docList : " + documents);

        List<Document> docList = documents.getDocuments();
        List<News> newsList = null;
        System.out.println("docList : " + docList);
        if (docList != null && !docList.isEmpty()) {
            for (Document doc: docList) {
                Article article = doc.getSource().getEnriched().getArticle();
                News news = new News(article.getTitle(), article.getUrl(), article.getPublicationDate().getDate());
                newsList.add(news);
            }
        }

        System.out.println("News : " + newsList);
    }
}
