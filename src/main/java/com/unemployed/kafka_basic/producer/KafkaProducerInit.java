package com.unemployed.kafka_basic.producer;

import java.time.Instant;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducerInit {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

		prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		Producer<String, String> producer = new KafkaProducer<>(prop);

//		Prepare record 

		String recordValue = "Current time is " + Instant.now().toString();
		System.out.println("Sending message: " + recordValue);
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("java_topic", recordValue);

//		produce and send the record 
		producer.send(record);
		producer.flush();
//		close the producer 
		producer.close();

	}

}
