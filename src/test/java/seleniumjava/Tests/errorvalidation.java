package seleniumjava.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import seleniumjava.Testscomponent.Basetest;
import seleniumjava.pageobjects.productcatalogue;

public class errorvalidation extends Basetest{
		@Test
		public  void submitorder() throws InterruptedException, IOException {
		
	String productName="IPHONE 13 PRO";
	productcatalogue catalogue=landing.loginApplication("sundu123@gmail.com", "!011Sundu");
	//Assert.assertEquals("Incorrect email or password.",landing.geterrormessage());
	

}
}