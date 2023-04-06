package testngpractise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericutilities.BaseClass;
import com.genericutilities.JavaUtility;
import com.jumia.pom.AddMenuPage;
import com.jumia.pom.AddRestaurantPage;
import com.jumia.pom.AdminpanelPage;
import com.jumia.pom.AllMenuPage;
import com.jumia.pom.AllRestaurantsPage;
import com.jumia.pom.UpdateMenuPage;
import com.jumia.pom.UpdateRestaurantPage;
@Listeners(com.genericutilities.ListenerImplementation.class)
public class RestaurantTest extends BaseClass {
	
	@Test(retryAnalyzer = com.genericutilities.RetryImpClass.class ,groups = "Smoke")
	public void addRestaurant() throws EncryptedDocumentException, IOException
	{
		JavaUtility ju = new JavaUtility();
		AdminpanelPage ap = new AdminpanelPage(driver);
		Assert.fail();
		AddRestaurantPage arp = new AddRestaurantPage(driver);
		ap.clickAddRestaurantmodule();
		arp.addRestaurant(wdu, eu, ju, driver);
		
	}
	/*@Test(groups = {"Smoke","Regression"})
	public void updateRestaurant() throws EncryptedDocumentException, IOException
	{
		JavaUtility ju = new JavaUtility();
		AdminpanelPage ap = new AdminpanelPage(driver);
		ap.clickAllRestaurantmodule();
		AllRestaurantsPage alp = new AllRestaurantsPage(driver);
		alp.updateRestaurant();
		UpdateRestaurantPage urp = new UpdateRestaurantPage(driver);
		urp.updateRestaurant(wdu, eu, ju, driver);
	}
	@Test(groups = "Regression")	
	public void addMenu() throws EncryptedDocumentException, IOException
	{
		AdminpanelPage ap = new AdminpanelPage(driver);
		ap.clickAddMenumodule();
		AddMenuPage amp = new AddMenuPage(driver);
		amp.AddMenuToRestaurant(eu, driver, wdu);
	}
	@Test(groups = "Smoke")
	public void editMenu() throws EncryptedDocumentException, IOException
	{
		AdminpanelPage ap = new AdminpanelPage(driver);
		Assert.fail();
		ap.clickAllMenuesmodule();
		AllMenuPage amp = new AllMenuPage(driver);
		amp.editmenu();
		UpdateMenuPage ump = new UpdateMenuPage(driver);
		ump.updateMenuToRestaurant(eu, driver, wdu);
	}
	
	/*@Test
	public void deleteOrder()
	{
		AdminpanelPage ap = new AdminpanelPage(driver);
		ap.clickOrders();
		AdminOrdersPage ao = new AdminOrdersPage();
		ao.deleteOrder(wdu,driver);
	}*/
}
