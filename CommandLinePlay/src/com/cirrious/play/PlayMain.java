package com.cirrious.play;

public class PlayMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UsingSwitch();
		UsingDictionary();
	}
	
	private static void UsingDictionary() {
		System.out.println("Using dictionoo...");
		Diction	oo dictionoo = new Dictionoo();
		dictionoo.AddBindings(new LayerMethods());
		dictionoo.AddBindings(new MoreLayerMethods());
				
		// good calls
		dictionoo.Do(new Object[] { "layerStart" });
		dictionoo.Do(new Object[] { "layerSelect", 23 });
		Transform t = new Transform();
		t.Field1 = "Hello";
		t.Field2 = "World";
		dictionoo.Do(new Object[] { "layerTransform", t });
		
		// bad calls
		// unknown method
		dictionoo.Do(new Object[] { "layerMethodZ", t });
		// bad parameter
		dictionoo.Do(new Object[] { "layerTransform", 12 });
		// too many parameters
		dictionoo.Do(new Object[] { "layerTransform", t, 12 });
	}
	
	private static void UsingSwitch() {
		System.out.println("Using switch...");
		Switcheroo switcheroo = new Switcheroo();
		
		// good calls
		switcheroo.Do(new Object[] { "layerStart" });
		switcheroo.Do(new Object[] { "layerSelect", 23 });
		Transform t = new Transform();
		t.Field1 = "Hello";
		t.Field2 = "World";
		switcheroo.Do(new Object[] { "layerTransform", t });
		
		// bad calls
		// unknown method
		switcheroo.Do(new Object[] { "layerMethodZ", t });
		// bad parameter
		switcheroo.Do(new Object[] { "layerTransform", 12 });
		// too many parameters
		switcheroo.Do(new Object[] { "layerTransform", t, 12 });
	}
}
