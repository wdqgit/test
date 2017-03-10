package test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Convert {
	
	public static Map<String, Object> classToMap(Object entity){
		Map<String, Object> map = new HashMap<String, Object>();
		if(entity != null){
			Field[] fs = entity.getClass().getDeclaredFields();
			for(Field f : fs){
				f.setAccessible(true);
				try {
					Object o = f.get(entity);
					if(o != null){
						map.put(f.getName(), o);
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
		return map;
	}
	
	public static Map<String, Object> parseJSON2Map(String jsonString){
		Map<String, Object> map = new HashMap<String, Object>();
		if(jsonString != null && !"".equals(jsonString) ){
			JSONObject json = JSONObject.parseObject(jsonString);
			for(Object o : json.keySet()){
				Object v = json.get(o);
				if(v instanceof JSONArray){
					List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
					Iterator<Object> i = ((JSONArray) v).iterator();
					while(i.hasNext()){
						JSONObject j = (JSONObject) i.next();
						list.add(parseJSON2Map(j.toString()));
					}
					map.put(o.toString(), list);
				}else{
					map.put(o.toString(), v);
				}
			}
			
		}
		return map;
	}
	
	public static String toXML(List<?> list){
		StringBuffer sb = new StringBuffer();
		if(list != null && list.size() > 0){
			sb.append("<root>");
			for(Object o : list){
				if(o instanceof Map){
					System.out.println(o);
					sb.append(toXML((Map<Object, Object>) o));
				}else{
					sb.append(toXML(o));
				}
			}
			sb.append("</root>");
		}
		return sb.toString();
	}
	

	private static String toXML(Object o) {
		StringBuffer sb = new StringBuffer();
		if(o != null){
			sb.append("<node>");
			Field[] fs = o.getClass().getDeclaredFields();
			for(Field f : fs){
				f.setAccessible(true);
				try {
					Object v = f.get(o);
					sb.append("<" + f.getName() + ">");
					sb.append(v == null ? "" : v);
					sb.append("</" + f.getName() + ">");
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			sb.append("</node>");
		}
		return sb.toString();
	}

	private static Object toXML(Map<Object, Object> o) {
		StringBuffer sb = new StringBuffer();
		if(o != null && !o.isEmpty()){
			sb.append("<node>");
			for(Map.Entry<Object, Object> entry : o.entrySet()){
				sb.append("<" + entry.getKey() + ">");
				sb.append(entry.getValue() == null ? "" : entry.getValue());
				sb.append("</" + entry.getKey() + ">");
			}
			sb.append("</node>");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Map<String, Object> map = classToMap(new Entity(1, "wang"));
		System.out.println(map);
		
		String json = "{\"1\":\"wang\",\"2\":{\"2_1\":\"wang2_1\",\"2_2\":\"wang2_2\"}}";
		Map<String, Object> map2 = parseJSON2Map(json);
		System.out.println(map2);
		
		List list = new ArrayList();
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("3", "33");
		map3.put("4", "44");
		list.add(map3);
		list.add(new Entity(5, "feng"));
		String xml = toXML(list);
		System.out.println(xml);
		
	}

}


class Entity{
	private int id;
	private String name;
	
	
	
	public Entity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
