package runTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.TestUtil;
import base.TestBase;

public class GmailTest extends TestBase{

		
	@BeforeMethod
	public void launchApp() throws IOException{
		
		initialize();
	}
	
	@Test(dataProvider="Data_GmailLogin")
	public void GmailLoginTest(String Num,String Userid,String Password,String Result) throws Exception{
				
		Assert.assertEquals(loginSuccess(Num,Userid,Password,Result), true);
	}

	@DataProvider(name="Data_GmailLogin")
	public Object[][] dataSupplier(){
	System.out.println("Collecting Data");
	Object[][] data=TestUtil.gettingData("GmailLogin");
	return data;
	
	
}	
	@AfterMethod
	public void teardown(){
		tearDown();
	}
	
public boolean loginSuccess(String Num,String Userid,String Password,String Result) throws Exception{
	int num = Integer.parseInt(Num);
	boolean GmailSuccess= false;
	
	try {
		System.out.println("Userid is :"+Userid);
		System.out.println("Row number"+num);
		
		testURL();
		
		setValue(getObjectByid("Userid_Input"), Userid);
		Thread.sleep(2000);
		Click(getObjectByid("Btn_next"));
		Thread.sleep(2000);
		setValue(getObjectByXpath("Password_Input"), Password);
		Click(getObjectByid("Btn_signin"));
		Thread.sleep(3000);
		
		String strCompose=getObjectByXpath("btn_Compose").getText();
		System.out.println(strCompose);
		
		if (strCompose.equals("COMPOSE")) {
			TestUtil.settingCellValue("GmailLogin", "Result", num + 1, "Pass");
			System.out.println("Login Successful");
			
		}else{
			
			TestUtil.settingCellValue("GmailLogin", "Result", num + 1, "Fail");
			System.out.println("Login Failed");
		}
		
		return GmailSuccess;
		
	} catch (Exception e) {
		
		TestUtil.settingCellValue("GmailLogin", "Result", num+1, "Fail");
		printScreenshot("GmailScreenShot");
		return GmailSuccess;
	}
	
}

}
