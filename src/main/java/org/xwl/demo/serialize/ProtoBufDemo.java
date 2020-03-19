package org.xwl.demo.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.util.JsonFormat;

public class ProtoBufDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		UserProtoBuf.User user1 = createUser();

		System.out.println("-------------ProtoBuf--------------");
		System.out.println(user1.toByteArray().length);
		System.out.println(JsonFormat.printer().print(user1));

		
		User user2 = createJavaUser();
		System.out.println("\n-----------Jackson----------------");
		byte[] userOm = new ObjectMapper().writeValueAsBytes(user2);
		System.out.println(userOm.length);
		System.out.println(new String(userOm));
		
		System.out.println("\n-----------FastJson----------------");
		byte[] userFj = JSONObject.toJSONString(user2).getBytes();
		System.out.println(userFj.length);
		System.out.println(new String(userFj));		
		
		System.out.println("\n-----------Java----------------");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(user2);

		byte[] userJ = baos.toByteArray();
		System.out.println(userJ.length);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(userJ));
		User u2 = (User) ois.readObject();
		System.out.println(u2);

	}

	private static User createJavaUser() {
		User u = new User();
		u.setId(1000L);
		u.setUserId("xwl");
		u.setUserName("william");
		u.setPassword("pass");
		
		return u;
	}
	
	
	private static UserProtoBuf.User createUser(){
		// 使用builder创建
		UserProtoBuf.User.Builder builder = UserProtoBuf.User.newBuilder();
		builder.setId(1000L);
		builder.setUserId("xwl");
		builder.setUserName("william");
		builder.setPassword("pass");
		UserProtoBuf.User user = builder.build();
		return user;
	}
	
}
