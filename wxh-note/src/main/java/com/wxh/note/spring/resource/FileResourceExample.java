package com.wxh.note.spring.resource;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

public class FileResourceExample {
	
	public static void main(String[] args) throws Exception {
		
		String filePath = "ddddd";
		
		// 使用系统文件路径方式加载文件
		WritableResource res1 = new PathResource(filePath);
		
		// 使用类路径方式加载文件
		Resource res2 = new ClassPathResource("conf/file.txt");
		
		// 使用WritableResource接口写资源文件
		OutputStream stream1 = res1.getOutputStream();
		stream1.write("hello world!".getBytes());
		stream1.close();
		
		// 使用Resource接口读资源文件
		InputStream ins1 = res1.getInputStream();
		InputStream ins2 = res2.getInputStream();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i;
		while((i=ins2.read()) != -1) {
			baos.write(i);
		}
		
		System.out.println(baos.toString());
		
		System.out.println("res1:"+res1.getFilename());
		System.out.println("res2:"+res2.getFilename());
		
	}

}
