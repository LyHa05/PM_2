package Tutorium.Termin12;

import java.lang.reflect.Field;

public abstract class AutoToString {
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		Class<?> obj = this.getClass();
		ToString annotations = obj.getAnnotation(ToString.class);
		Field[] fields = obj.getDeclaredFields();
		
		sb.append("Ein ");
		sb.append(annotations.value());
		sb.append(" Objekt mit ");
		
		for(Field element : fields){
			if(element.getAnnotation(ToString.class) != null){
				if(element.getAnnotation(ToString.class).value() != ""){
					sb.append(element.getAnnotation(ToString.class).value());
					element.setAccessible(true);
					sb.append(el)
				} else {
					sb.append(element.getName().toString());
				}
			}
		}
		
		
		
		return sb.toString();
	}
	
}
