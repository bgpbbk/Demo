package general_Classes;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GettngMethodName_DP {

	@DataProvider(name="DP")
	public Object[][] getMethodName(Method m){
		Object[][] data=new Object[3][2];
		System.out.println(m.getName());
		
		data[0][0]="user1";
		data[0][1]="pass1";
		data[1][0]="user2";
		data[1][1]="pass2";
		data[2][0]="user3";
		data[2][1]="pass3";
		return data;
	}
	
	@Test(dataProvider="DP")
	public void method1(String uid,String pwd){
		System.out.println("In Method1");
		System.out.println("uid is --"+uid+"\n"+"pwd is --"+pwd);
	}
	
	@Test(dataProvider="DP")
	public void method2(String uid,String pwd){
		System.out.println("In Method2");
		System.out.println("uid is --"+uid+"\n"+"pwd is --"+pwd ); 
	}
}
