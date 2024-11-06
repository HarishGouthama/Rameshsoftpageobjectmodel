package com.rameshsoft.automation.supporters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.rameshsoft.automation.customisedexceptions.FrameworkException;

public class JsonReader {

		private String filePath;
		private JSONParser jsonParser;
		private JSONObject jsonObject;
		private String value;
		private Set setKeys;
		
		public JsonReader(String filePath) throws FileNotFoundException, IOException, ParseException 
		{
			this.filePath = filePath;
			JSONParser jsonParser = new JSONParser();
			Object object = jsonParser.parse(new FileReader(filePath));
			jsonObject = (JSONObject) object;
		}
		
		public String getJsonValue(String key , String defaultValue) {
			try
			{
				if(jsonObject != null) {
					value = (String) jsonObject.get(key);
					if(value == null)
					{
						value = defaultValue;
					}
				}
				else
				{
					
				}
			}
			catch(Exception exception)
			{
				
			}
			return value;
		}
		
		public Set getAllkeys() throws FrameworkException {
			if(jsonObject != null)
			{
				setKeys = jsonObject.keySet();
				
			}
			else
			{
				FrameworkException exception = new FrameworkException("JSONOBJECT is pointing to null");
				throw exception;
			}
			return  setKeys;
		}
		
		public List<String> getAllValues() throws FrameworkException {
			List<String> values = new ArrayList<>();
			if(jsonObject != null)
			{
				setKeys = jsonObject.keySet();
				for(Object obj : setKeys)
				{
					value = (String) jsonObject.get(obj);
					values.add(value);
				}
				
			}
			else
			{
				FrameworkException exception = new FrameworkException("JSONOBJECT is pointing to null");
				throw exception;
			}
			return values;
		}
		
		public Map<String ,String> getAllKeysValues() throws FrameworkException {
			Map<String, String> map = new HashMap<String, String>();
			if(jsonObject != null)
			{
				setKeys = jsonObject.keySet();
				for(Object obj : setKeys)
				{
					String key = (String) obj;
					value = (String) jsonObject.get(obj);
					map.put(key, value);
				}
			}
			else
			{
				FrameworkException exception = new FrameworkException("JSONOBJECT is pointing to null");
				throw exception;
			}
			return  map;
		}
		
	}
