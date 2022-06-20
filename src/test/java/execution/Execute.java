package execution;

import org.testng.annotations.Test;

import funtionality.BaseClass;
import pageObjctClasses.LoginPage;
import pageObjctClasses.MainPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class Execute  extends BaseClass  {
	
	
  @SuppressWarnings({ "static-access" })
@Test(priority=0)
  public void launcgingApplication() {
	  
	  try {
		launchApplication();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
  }
  @SuppressWarnings({ "static-access", "unchecked" })
@Test(priority=1)
  public void userLoging() {
	  try {
		  LoginPage loginPage = new LoginPage(driver);
		  loginPage.login();
	  }catch(Exception e) {
		  System.out.println("Login Failed");
		  logStep("Login Failed");
	  }
	  
  }
  
  @SuppressWarnings({ "static-access", "unchecked" })
 @Test(priority=2)
public void CreateFolder() {
	  try {
	  MainPage mainPage = new MainPage(driver);
	  mainPage.checkUserOnHomePage();
	  mainPage.CheckFilesOption();
	  }catch(Exception e) {
		  System.out.println("Failed to create Folder and add files into that");
		  logStep("Failed to create Folder and add files into that");
	  }
  }
  
  
  @BeforeTest
  public void beforeTest() {
	 
	  System.out.println("Execution tsarted ========");
	  createFolderName();
  }

  @AfterTest
  public void afterTest() {
	 
	  System.out.println("Execution Ended ========");
  }

}
