package top.lbing.jacksonDemo;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLToJsonDemo {
	
	/**
	 * 将 XML 转换为 JSON
	 * 
	 * @param args
	 */
	public void XML2JSON() {
		String xml="<default><column><title>Title 1</title><id>id1</id><value>val1</value></column>"
		    +"<column><title>Title 2</title><id>id2</id><value>val2</value></column>"
		    +"<column><title>Title 3</title><id>id3</id><value>val3</value></column></default>";
		try {
			XmlMapper xmlMapper=new XmlMapper();
			Map<?,?> entries=xmlMapper.readValue(xml,Map.class);
			ObjectMapper jsonMapper=new ObjectMapper();
			String json=jsonMapper.writeValueAsString(entries);
			System.out.println(json);
		} catch(JsonParseException e) {
			e.printStackTrace();
		} catch(JsonMappingException e) {
			e.printStackTrace();
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new XMLToJsonDemo().XML2JSON();
	}
}
