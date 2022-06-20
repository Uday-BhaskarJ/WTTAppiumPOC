package pageObjctClasses;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.ReusabaleFunctions;

public class MainPage extends ReusabaleFunctions{

	@SuppressWarnings("unused")
	private static  AndroidDriver<AndroidElement> driver;


	public MainPage() {
	}

	@SuppressWarnings("static-access")
	public MainPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	//	//MainOption filed using Id
	//	@AndroidFindBy(className = "android.widget.ImageButton")
	//	public static AndroidElement MainOption;

	//MainOption filed using Id
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
	public static AndroidElement MainOption;



	//EmailDetails filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/nav_displayname")
	public static AndroidElement EmailDetails;

	//SizeDetails Button using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/nav_diskusage_text")
	public static AndroidElement SizeDetails;


	//Files in MainMenu
	@AndroidFindBy(xpath = "(//*[@class = 'android.support.v7.widget.LinearLayoutCompat'])[1]")
	public static AndroidElement FilesMenu;

	//Vault in MainMenu
	@AndroidFindBy(xpath = "(//*[@class = 'android.support.v7.widget.LinearLayoutCompat'])[2]")
	public static AndroidElement VaultMenu;

	//LinksMenu in MainMenu
	@AndroidFindBy(xpath = "(//*[@class = 'android.support.v7.widget.LinearLayoutCompat'])[3]")
	public static AndroidElement LinksMenu;

	//Recents in MainMenu
	@AndroidFindBy(xpath = "(//*[@class = 'android.support.v7.widget.LinearLayoutCompat'])[4]")
	public static AndroidElement RecentsMenu;

	//Rewards in MainMenu
	@AndroidFindBy(xpath = "(//*[@class = 'android.support.v7.widget.LinearLayoutCompat'])[5]")
	public static AndroidElement RewardsMenu;

	//Settings in MainMenu
	@AndroidFindBy(xpath = "(//*[@class = 'android.support.v7.widget.LinearLayoutCompat'])[7]")
	public static AndroidElement SettingsMenu;

	//EmptyFolder filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/filelist_empty_title")
	public static AndroidElement EmptyFolder;

	//AddFolder filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/fab")
	public static AndroidElement AddFolder;

	//UpLoad File filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/bottomsheetActionUpload")
	public static AndroidElement UploadFiles;

	//NewFolderCreation filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/bottomsheetActionMkdir")
	public static AndroidElement NewFolderCreation;


	//CeateFolderName filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/foldername")
	public static AndroidElement CeateFolderName;


	//CreateButton filed using Id
	@AndroidFindBy(id = "android:id/button1")
	public static AndroidElement CreateButton;


	//CancelButton filed using Id
	@AndroidFindBy(id = "android:id/button2")
	public static AndroidElement CancelButton;

	//FileDetails in the list filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/filename")
	public static AndroidElement FileDetails;


	//AllowButton in the popup using Id
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	public static AndroidElement AllowButton;

	//SelectFile in the popup using Id
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout")
	public static AndroidElement SelectFile;


	//AllowButton in the popup using Id
	@AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout")
	public static AndroidElement ValidateFile;


	//FileDetails in the list filed using Id
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public static AndroidElement NavigateBack;



	public static void checkUserOnHomePage() {
		try {
			waitForVisible(EmailDetails);
			logStep("Validate Loged in Email details");
			if(EmailDetails.getText().trim().equalsIgnoreCase(getDatafromprop("Email").trim())) {
				System.out.println("Logged in User is :: "+EmailDetails.getText());
				System.out.println("--and Allocated Size is  : "+SizeDetails.getText());
				logStep("Logged in User is :: "+EmailDetails.getText());
				logStep("--and Allocated Size is  : "+SizeDetails.getText());
			}else {
				System.err.println("Logged in User is not matching :: "+EmailDetails.getText());
				logStep("Logged in User is not matching :: "+EmailDetails.getText());
			}

		}catch(Exception e) {
			try {
				waitForVisible(MainOption);
				MainOption.isDisplayed();
				System.out.println("User on Main Page .. need to click on menu option");
				logStep("User on Main Page .. need to click on menu option");
			}catch(Exception loggedinIssue) {
				System.err.println("User not able to logged in properly");
				logStep("User not able to logged in properly");
			}
		}
	}

	public static void CheckFilesOption() {
		try {
			clickOnelement(FilesMenu);
			logStep("Select File Menu");
			checkFolderEmpty();

		}catch(Exception e) {
			System.err.println("User Not of File menu ===============");
		}

	}

	public static void checkFolderEmpty() {
		try {
			waitForVisible(EmptyFolder);
			EmptyFolder.isDisplayed();
			System.err.println("Folder is Empty Need to add New Folder");
			logStep("Folder is Empty Need to add New Folder");
			AddNewFolder(); //Add New Folder
			SelectFolder();
			AddfilesinExistFolder();

		}catch(Exception emptyFolder) {
			System.out.println("Folder is not Empty, need to Select perticuler Folder");
			AddNewFolder();
			SelectFolder();
			AddfilesinExistFolder();
		}



	}

	public static void AddNewFolder() {
		try {
			waitForVisible(AddFolder);
			clickOnelement(AddFolder);
			clickOnelement(NewFolderCreation);
			EnterText(CeateFolderName, FolderName);
			logStep("Create New Folder with the Name of  :: "+FolderName);
			clickOnelement(CreateButton);
			System.out.println("User Successfully Created New Folder");
			logStep("User Successfully Created New Folder");
			attachScreen(FolderName+" was Created Successfully");
		}catch(Exception AddFolder) {
			try {
				clickOnelement(CancelButton);
				logStep("Click on Cancel button to cancel create screen");
			}catch(Exception cancelButton) {
				System.err.println("Not abel to Create new Folder");
				logStep("Not abel to Create new Folder");
				attachScreen("Not abel to Create new Folder");
			}
		}
	}

	public static void SelectFolder() {
		try {
			waitForVisible(FileDetails);
			Thread.sleep(2000);
			List<AndroidElement> ListOfFolders = driver.findElements(By.id("com.sync.mobileapp:id/filename"));
			for(AndroidElement Folder:ListOfFolders) {
				if(Folder.getText().equalsIgnoreCase(FolderName)) {
					System.out.println("Successfully Selected Folder");
					logStep("Successfully Selected Folder" );
					Folder.click();
					attachScreen("Successfully Selected Folder");
					break;
				}

			}

		}catch(Exception e) {

			System.err.println("Folder was not selected");
			logStep("Folder was not selected");
			attachScreen("Folder was not selected");
		}
	}
	public static void AddfilesinExistFolder() {
		try {

			waitForVisible(EmptyFolder);
			EmptyFolder.isDisplayed();
			System.err.println("Folder is Empty Need to add Upload Files");
			logStep("Folder is Empty Need to add Upload Files");
			clickOnelement(AddFolder);
			logStep("Click on AddFolder button");
			clickOnelement(UploadFiles);
			logStep("Click on Upload Files button");
			System.out.println("User Ready to Upload Files into Selected Folder :: "+FolderName);
			logStep("User Ready to Upload Files into Selected Folder :: "+FolderName);
			try {
				clickOnelement(AllowButton);
				logStep("Click on Allow buton to give permissions");
				clickOnelement(UploadFiles);
			}catch(Exception e) {
				System.out.println("Allow button not present on the screen");
			}

			waitForVisible(SelectFile);
			clickOnelement(SelectFile);
			logStep("Select First File to Upload");
			Thread.sleep(5000);
			attachScreen("File Uploaded Successfully");

			clickOnelement(NavigateBack);
			SelectFolder();
			attachScreen("File Uploaded Successfully");
			clickOnelement(NavigateBack);
			clickOnelement(MainOption);
			clickOnelement(SettingsMenu);
			

			//			waitForVisible(ValidateFile);
			//			System.out.println("ValidateFile name is :: "+ValidateFile.getText());
		}catch(Exception AddNewFiles) {

			System.err.println("Upload Page not present on the screen");
		}

	}

}
