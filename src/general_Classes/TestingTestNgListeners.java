package general_Classes;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;

	@Listeners({general_Classes.TestNG_Listener.class})
	public class TestingTestNgListeners extends TestBase{		
		
			
						
		@Test
		public void method1(){
			System.out.println("Method1");
		}
		
		@Test
		public void method2(){
			System.out.println("Method2");
		}
		
		@Test
		public void method3() throws Exception{	
			
		
			driverinit();
			//System.out.println("Method3");				
			driver.get("http://gmail.com"); 
			driver.findElement(By.id("Email")).sendKeys("baigaddakarthik@gmail.com");
			driver.findElement(By.id("next")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("abc");
			driver.findElement(By.id("signIn")).click(); 
			Thread.sleep(2000);
			String act=driver.findElement(By.xpath(".//*[@id=':it']/div/div")).getText();
			System.out.println(act);
			Assert.assertTrue(act.equals("COMPOSE"));
		}
		
		@Test
		public void method4(){
			System.out.println("Method4");
			Assert.fail();
		}

	}

