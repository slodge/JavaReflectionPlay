package com.cirrious.play;

public class Switcheroo {

	public Object Do(Object[] args)
	{
		try
		{
			return DoImpl(args);
		}
		catch (ClassCastException exc)
		{
			System.out.println("Cast exception seen");
			exc.printStackTrace();
			return null;
		}
	}
	
	private Object DoImpl(Object[] args)
	{
		String which = (String)args[0];
		
		if (which.equals("layerStart"))
		{
			System.out.println("Starting...");
		}
		else if (which.equals("layerSelect"))
		{
			int whichToSelect = (Integer)args[1];
			System.out.println("Selecting " + whichToSelect);
		}
		else if (which.equals("layerTransform"))
		{
			Transform whichTransform = (Transform)args[1];
			System.out.println("Transforming " + whichTransform.Field1 + "," + whichTransform.Field2);
			return whichTransform;
		}
		else
		{
			System.out.println("Error " + which);
		}
		return null;		
	}
}
