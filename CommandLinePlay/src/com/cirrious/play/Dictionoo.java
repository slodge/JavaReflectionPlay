package com.cirrious.play;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeMap;

public class Dictionoo {
	private TreeMap<String, Binding> _bindings;
	
	public Dictionoo()
	{
		_bindings = new TreeMap<String, Binding>();
	}

	public void AddBindings(Object targetObject)
	{
		Method[] methods = targetObject.getClass().getDeclaredMethods();
		for (Method method:methods)
		{
			LayerMethod annotation = method.getAnnotation(LayerMethod.class);
			if (annotation == null)
				continue;
			
			Binding binding = new Binding();
			binding.Name = annotation.Name();
			binding.Method = method;	
			binding.TargetObject = targetObject;
			_bindings.put(binding.Name, binding);
		}
	}
	
	public Object Do(Object[] args)
	{
	    String which = (String)args[0]; 
	    	
		Object[] localArgs = new Object[args.length - 1];
	    System.arraycopy(args, 1, localArgs, 0, args.length - 1);
 
	    Binding binding = _bindings.get(which);
	    if (binding != null)
	    {	    
	    	try {
				return binding.Invoke(which, localArgs);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    else
	    {
			System.out.println("Error " + which);
	    }
	    return null;
	}
}
