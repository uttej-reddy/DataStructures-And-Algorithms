package com.javaconcepts;

 enum Days{
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY;	
}

public class EnumTest {
	
	Days day;
	
	/*public EnumTest(Days d) {
		this.day = d;
	}*/
	

	public void dayIsLike(String s) {
		
		Days d = Days.valueOf(s);
		//EnumTest t1 = new EnumTest(d);
		
		switch (d) {
		case SATURDAY:
			System.out.println("This is Saturday !!");
			break;
		case SUNDAY:
			System.out.println("This is Sunday");
			break;

		default:
			System.out.println("This is weekday :(");
			break;
		}
		
	}
	
	public static void main(String[] args) {
		
		for(Days d :  Days.values()) {
			System.out.println(d);
		}
		
		
		//String s = "SUNDAY";
		//EnumTest t1 = new EnumTest();
		//t1.dayIsLike(s);

	}

}


