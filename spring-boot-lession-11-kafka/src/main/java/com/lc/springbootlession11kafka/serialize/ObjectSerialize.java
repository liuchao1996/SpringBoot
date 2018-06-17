package com.lc.springbootlession11kafka.serialize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

/**
 * Object序列化
 * @author qq165
 *
 */
public class ObjectSerialize implements Serializer<Object> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		 
	}

	@Override
	public byte[] serialize(String topic, Object data) {
		System.out.println("topic："+topic+" , object："+data);
		byte[] dataArray = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			
			objectOutputStream.writeObject(data);
			
			dataArray = outputStream.toByteArray();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dataArray;
	}

	@Override
	public void close() {
		
	}

	
	
}
