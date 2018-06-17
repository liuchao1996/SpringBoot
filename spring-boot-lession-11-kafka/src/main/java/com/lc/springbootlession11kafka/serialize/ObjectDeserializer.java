package com.lc.springbootlession11kafka.serialize;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

/**
 * Object反序列化
 * @author qq165
 *
 */
public class ObjectDeserializer implements Deserializer<Object> {



    @Override
    public Object deserialize(String topic, byte[] data) {

        Object object = null;

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);

        try {
            ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);

            object = inputStream.readObject();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(" topic : " + topic + " , deserialized object :" + object);

        return object;
    }

    @Override
    public void close() {

    }

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

}
