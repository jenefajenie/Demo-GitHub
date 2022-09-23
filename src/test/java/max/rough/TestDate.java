package max.rough;

import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date d= new Date();
		String screenshotName= d.toString().replace(":", "_").replace(" ","_")+".jpg";
		System.out.println(screenshotName);
System.out.print(d);
	}

}
