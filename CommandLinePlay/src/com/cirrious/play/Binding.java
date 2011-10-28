package com.cirrious.play;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Binding {

	public String Name;
	public Method Method;
	public Object TargetObject;
	
	public Object Invoke(String which, Object[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException 
	{
		return Method.invoke(TargetObject, args);
	}	
}
