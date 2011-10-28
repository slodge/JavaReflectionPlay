package com.cirrious.play;

public class MoreLayerMethods {

	@LayerMethod(Name = "layerSelect")
	public void Select(int whichToSelect)
	{
		System.out.println("Selecting " + whichToSelect);
	}
	
	@LayerMethod(Name = "layerTransform")
	public Transform Transform(Transform whichTransform)
	{
		System.out.println("Transforming " + whichTransform.Field1 + "," + whichTransform.Field2);
		return whichTransform;
	}	
	
	public void IgnoreMePlease()
	{
		// just an empty test method for now
	}
}
