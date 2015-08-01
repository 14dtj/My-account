package nju.config;


import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class FrameConfig {
	/**
	 * 窗口宽度
	 */
	private int width;
	/**
	 * 窗口高度
	 */
	private int height;
	
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	List<ComponentsConfig> startComponentsConfig;
	public FrameConfig(Element frame) {
		this.width = Integer.parseInt(frame.attributeValue("width"));
		this.height = Integer.parseInt(frame.attributeValue("height"));
		Element panel = frame.element("startPanel");
		List<Element> components = panel.elements("component");
		startComponentsConfig =new ArrayList<ComponentsConfig>(components.size());
		for(Element layer:components){
			ComponentsConfig lc = new ComponentsConfig(
					layer.attributeValue("name"), 
					Integer.parseInt(layer.attributeValue("x")), 
					Integer.parseInt(layer.attributeValue("y")), 
					Integer.parseInt(layer.attributeValue("width")), 
					Integer.parseInt(layer.attributeValue("height")));
			startComponentsConfig.add(lc);
		}
		
	}
	public List<ComponentsConfig> getStartLayersConfig() {
		return startComponentsConfig;
	}
	
}
