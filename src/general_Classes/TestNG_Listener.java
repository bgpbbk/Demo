package general_Classes;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.TestBase;

public class TestNG_Listener implements ITestListener{

@SuppressWarnings("unused")
private WebDriver driver;


@Override
public void onFinish(ITestContext arg0) {
	
	
}

@Override
public void onStart(ITestContext arg0) {
	
	
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	
	
}

@Override
public void onTestFailure(ITestResult result) {
	
	
	System.out.println("Test Failed due to ::"+result.getName());
	
	try { 
		//if(ITestResult.FAILURE==result.getStatus())
		
		TestBase.printScreenshot(result.getName());
						              
		System.out.println("Screenshot taken");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

@Override
public void onTestSkipped(ITestResult arg0) {
	
	
}

@Override
public void onTestStart(ITestResult result) {
	
	System.out.println("Test "+result.getName()+" has started");
}

@Override
public void onTestSuccess(ITestResult result) {
	
	System.out.println("Hurray Test "+result.getName()+" is passed"); 
}

}