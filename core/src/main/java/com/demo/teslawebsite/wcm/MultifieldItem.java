package com.demo.teslawebsite.wcm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.Resource;

import com.adobe.cq.sightly.WCMUsePojo;
import com.demo.teslawebsite.beans.Items;

public class MultifieldItem extends WCMUsePojo {
	private List<Items> multiitems = new ArrayList<Items>();
	@Override
	public void activate() throws Exception 
	{
		populateArrayList();
		
		
	}
	private void populateArrayList() {
		Resource multifield = getResource().getChild("multifield");
		Iterator<Resource> resource = multifield.listChildren();
		String title, description,imagepath;
		while (resource.hasNext()) {
			Resource childNode =resource.next();
			
			title = childNode.getValueMap().get("textfield",String.class).toUpperCase().toString();
			description = childNode.getValueMap().get("description",String.class);
			imagepath = childNode.getValueMap().get("imagepath",String.class);
			
			Items item = new Items();
			item.setTextfield(title);
			item.setDescription(description);
			item.setImagepath(imagepath);
			multiitems.add(item);
			
			
			
			
		}
		
	}
	
	
	public List<Items> getMultiitems() {
		return multiitems;
	}
	public void setMultiitems(List<Items> multiitems) {
		this.multiitems = multiitems;
	}

}
