package testTopic;

import Pages.topicPages;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.security.PublicKey;

import static extentreports.ExtentTestManager.getTest;
import static extentreports.ExtentTestManager.startTest;


public class addTopic extends BaseTest {

   topicPages topicPages;

   @Test
   public void login(){
       startTest("Login ", "login as owner");
       topicPages = new topicPages(driver, wait);
       topicPages.login_page("suciyanayan@gmail.com", "PetugasPartaiInspeksiJaringan2024");
       getTest().log(Status.INFO, "login into ada");
   }

   @Test(priority = 1)
   public void add_topic() throws InterruptedException {
       startTest("add topic", "add topic true");
       topicPages = new topicPages(driver, wait);
       topicPages.add_topic("test automation");
       Thread.sleep(3000);
       getTest().log(Status.INFO, "add topic");
   }

    @Test(priority = 2)
    public void search_topic() throws InterruptedException {
       startTest("search", "search topic name");
       topicPages = new topicPages(driver,wait);
       topicPages.search_topic("test automation");
    }

    @Test(priority = 3)
    public void delete_topic() throws InterruptedException {
       startTest("delete topic", "topic deleted");
       topicPages = new topicPages(driver, wait);
       Thread.sleep(5000);
       topicPages.delete_topic();

       getTest().log(Status.INFO,"topic selected deleted");
    }


}
