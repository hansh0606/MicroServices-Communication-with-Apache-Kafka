package com.spkafproject2;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class TopicProducer {

      private static final Logger LOGGER = LoggerFactory.getLogger(TopicProducer.class);

//    @Value("${Spring.kafka.topic.name:wikimedia_recentChange}")
    String topic ="wikimedia_recentChange";
      private KafkaTemplate<String,String> kafkaTemplate;

        public TopicProducer(KafkaTemplate<String, String> kafkaTemplate) {
                this.kafkaTemplate = kafkaTemplate;
        }

        public void sendMessage() throws InterruptedException {


            EventHandler eventHandler= new ChangesHandler(kafkaTemplate,topic);
            String url ="https://stream.wikimedia.org/v2/stream/recentchange";
            EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
            EventSource eventSource= builder.build();
            eventSource.start();
            TimeUnit.MINUTES.sleep(10);
            //real time string data from wikimedia , we use event source
        }
}
