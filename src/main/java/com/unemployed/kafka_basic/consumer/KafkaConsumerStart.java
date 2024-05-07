package com.unemployed.kafka_basic.consumer;

import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerStart {

	public static void main(String[] args) {

		Properties prop = new Properties();
		prop.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		prop.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer-group-init");
		prop.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		prop.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

		Consumer<String, String> consumer = new KafkaConsumer<>(prop);

//		subscribe to topic 
		consumer.subscribe(Collections.singleton("java_topic"));
//		pool the record from the topic

		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
			for (ConsumerRecord<String, String> record : records) {
				System.out.println("Message received: " + record.value());

			}

			consumer.commitAsync();
			consumer.close();
		}

	}

}
