package loginPage;
import org.junit.After; 
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import java.net.MalformedURLException;
import java.net.URL;

public class LambdaAssignment {
	
public String username = "ramanand.y";
  public String accesskey = "eQKWbGmbogrjYs9Iaq5HW5BomQHBH0FsG50Zd0CAOoXERE4Exp";
  public static RemoteWebDriver driver = null;
  public String gridURL = "@hub.lambdatest.com/wd/hub";
 boolean status = false;
	@Before
	 public void setUp() throws Exception {
	 DesiredCapabilities capabilities = new DesiredCapabilities();
  capabilities.setCapability("browserName", "chrome");
		 capabilities.setCapability("version", "70.0");
 capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
	 capabilities.setCapability("build", "LambdaTestSampleApp");
		capabilities.setCapability("name", "LambdaTestJavaSample");
		        
 try {
     driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
		        } catch (MalformedURLException e) {
		            System.out.println("Invalid grid URL");
		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    @Test
		    public void testSimple() throws Exception {
		       try {
		      
		      driver.manage().window().maximize();
		           String baseUrl = "https://www.lambdatest.com/automation-demos"; 

		           driver.get(baseUrl);
		           Thread.sleep(2000);
		    //login
   WebElement Usename =driver.findElement(By.id("username"));
		    Usename.sendKeys("lambda");  
		    Thread.sleep(2000);
		    WebElement Password =driver.findElement(By.id("password"));
		    Password.sendKeys("lambda123");
         WebElement LoginButton =driver.findElement(By.xpath("//button[@type='submit']"));           
		    LoginButton.click();
		    Thread.sleep(3000);
            //2nd screen
		    WebElement EmailTextbox =driver.findElement(By.xpath("//input[@type='email']"));
		    EmailTextbox.sendKeys("ramanand.y@hcl.com");
		    WebElement PopulateButton =driver.findElement(By.xpath("//input[@id='populate']"));
		    PopulateButton.click();
		    Thread.sleep(2000);
		    driver.switchTo().alert().accept();
		    Thread.sleep(2000);
              //1st ques radiobutton
		    WebElement Every3month = driver.findElement(By.xpath("//input[@type='radio'][@id='3months']"));
		    Every3month.click();
		    //2nd ques checkbox
		    Thread.sleep(2000);
		    WebElement CustomerService = driver.findElement(By.xpath("//input[@type='checkbox'][@id='customer-service']"));
		    CustomerService.click();                  
		       Thread.sleep(3000);
		         //3rd ques dropdown
		          Thread.sleep(2000);
		          WebElement dropdownField = driver.findElement(By.id("preferred-payment"));     

		          Select select = new Select(dropdownField);   // constructor needs object

		          select.selectByVisibleText("Cash on delivery");
              Thread.sleep(2000);
		   //Select Checkbox of tried attempts
		  WebElement TriedAttempt =driver.findElement(By.xpath("//input[@type='checkbox'][@id='tried-ecom']"));
		  TriedAttempt.click();
		  Thread.sleep(2000);
		  Actions action = new Actions(driver);
		  WebElement scroll = driver.findElement(By.xpath("//div[@role='slider'][@aria-valuenow='50']"));
		  action.dragAndDropBy(scroll, 150, 0).perform();
		  driver.findElement(By.id("comments")).sendKeys("Testing Comments");
		  Thread.sleep(2000);
		  WebElement UploadButton = driver.findElement(By.xpath("//label[@id='img']"));      
		  action.moveToElement(UploadButton).perform();
		  Thread.sleep(2000);
		  WebElement UploadInput = driver.findElement(By.xpath("//input[@type='file']"));
		  UploadInput.sendKeys("C:\\Users\\ramanand.y\\Desktop\\Screenshot_20210729-114220_OPTIK-V3001DV");
		  Thread.sleep(3000);
		  Alert alt= driver.switchTo().alert(); //current alert
		    String actualAlert = alt.getText();    
		    String expectedAlert ="your image upload sucessfully!!";
		    Assert.assertEquals(expectedAlert, actualAlert);
		          System.out.println(actualAlert);
		    if (expectedAlert.equals(actualAlert)){
		          System.out.println("Image Upload Test Passed");
		    }else {
		          System.out.println("Image Upload Test Failed");
		    }
		    driver.switchTo().alert().accept();
		  Thread.sleep(3000);
		  WebElement SubmitButton = driver.findElement(By.xpath("//button[@id='submit-button']"));
		  SubmitButton.click();
		  Thread.sleep(3000);
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,-850)");
		  Thread.sleep(3000);
		  String actualSubmitText = driver.findElement(By.xpath("//*[@class='success-message']//div/div/h1")).getText();           
		    String expectedSubmitText ="Thank you!";
		    Assert.assertEquals(expectedSubmitText, actualSubmitText);
		          System.out.println(actualSubmitText);
		    if (expectedSubmitText.equals(actualSubmitText)){

		          System.out.println("Form Submitted and Test Passed");

		    }else {

		          System.out.println("Form not Submitted and Test Failed");
}
		    Thread.sleep(8000);

		    driver.close();      
		    } 
		       catch (Exception e) {
		        System.out.println(e.getMessage());
		       }
		    }
		       @After
		       public void tearDown() throws Exception {
		          if (driver != null) {
		               ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
		               driver.quit();
		           }
		       }  
	}

