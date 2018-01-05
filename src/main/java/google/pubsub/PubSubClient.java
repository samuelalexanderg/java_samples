package google.pubsub;

import com.google.cloud.pubsub.*;

import java.util.Iterator;
import java.util.concurrent.Future;

/**
 * Created by sam on 14/2/17.
 */
public class PubSubClient {
    public static void main(String... args) throws Exception {
        // Instantiates a client
        PubSub pubsub = PubSubOptions.getDefaultInstance().getService();

        // The name for the new topic
//        String topicName = "my-new-topic";

//        // Creates the new topic
//        Topic topic = pubsub.create(TopicInfo.of(topicName));

        Future<Iterator<ReceivedMessage>> future = pubsub.pullAsync("smlgdfsub", 1);
        while(!(future.isCancelled() || future.isDone())) {
            Iterator<ReceivedMessage> iter = future.get();
            int i = 1;
            while (iter.hasNext()) {
                System.out.println("Reading message - " + i);
                ReceivedMessage message = iter.next();
                System.out.println(message.getPayloadAsString());
                message.ack();
            }
        }
//        System.out.printf("Topic %s created.%n", topic.getName());
    }

}
