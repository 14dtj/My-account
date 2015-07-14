package nju.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConfigReader {
	private static FrameConfig frameConfig;
	static{
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read("config/config.xml");
			Element root = doc.getRootElement();
			frameConfig = new FrameConfig(root.element("frame"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ConfigReader(){
		
	}
	public static FrameConfig getFrameConfig() {
		return frameConfig;
	}
	
}
