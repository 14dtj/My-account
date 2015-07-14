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
	List<ComponentsConfig> componentsConfig;
	public FrameConfig(Element frame) {
		this.width = Integer.parseInt(frame.attributeValue("width"));
		this.height = Integer.parseInt(frame.attributeValue("height"));
		List<Element> components = frame.elements("component");
		componentsConfig =new ArrayList<ComponentsConfig>(components.size());
		for(Element layer:components){
			ComponentsConfig lc = new ComponentsConfig(
					layer.attributeValue("name"), 
					Integer.parseInt(layer.attributeValue("x")), 
					Integer.parseInt(layer.attributeValue("y")), 
					Integer.parseInt(layer.attributeValue("width")), 
					Integer.parseInt(layer.attributeValue("height")));
			componentsConfig.add(lc);
		}
		
	}
	public List<ComponentsConfig> getLayersConfig() {
		return componentsConfig;
	}
	
}
