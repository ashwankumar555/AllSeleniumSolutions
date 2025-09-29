package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlaceSerialization;
import pojo.LocationClass;

public class TestDataBuild {

	public AddPlaceSerialization addPlacePayLoad(String name, String language, String address)
	{
		AddPlaceSerialization p = new AddPlaceSerialization();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 9949778355");
		p.setWebsite("https://ashwinakhiraworld.com");
		p.setName(name);
		
		//Creating ArrayList to accept types items
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);
		
		//Creating LocationClass object to accept lat and lng
		LocationClass l = new LocationClass();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		return p;

	}
	
	public String deletePlacePayLoad(String placeId)
	{
		return "{\r\n"
				+ "    \"place_id\": \""+placeId+"\"\r\n"
				+ "}";
	}
}
