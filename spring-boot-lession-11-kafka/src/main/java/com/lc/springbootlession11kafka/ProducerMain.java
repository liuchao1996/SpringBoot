package com.lc.springbootlession11kafka;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
/**
 * 生产者测试
 * @author qq165
 *
 */
public class ProducerMain {

		@SuppressWarnings("resource")
		public static void main(String[] args) throws Exception {
			Properties properties = new Properties();
			
			properties.setProperty("bootstrap.servers", "192.168.1.108:9092");
			properties.put("key.serializer", StringSerializer.class);
			properties.put("value.serializer", StringSerializer.class);
			
			KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("lc",0,"message","大家好");
			
			Future<RecordMetadata> future = producer.send(producerRecord);
			
			RecordMetadata metadata = future.get();
			
			System.out.println(metadata);
		} 
}
