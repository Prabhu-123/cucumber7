package stepDefinitions;

import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.CueduHomePage;
import com.utils.DriverFactory;

import io.cucumber.datatable.DataTable;

public class CuedustepDefinitions {
	
	CueduHomePage cuhomepage = new CueduHomePage(DriverFactory.getDriver());
	
	@When("User navigates to the RFI form")
	public void user_navigates_to_the_rfi_form() {
		System.out.println("User navigates to the RFI form");
	}

	@Then("User enters the following dropdown")
	public void user_enters_the_following_dropdown(DataTable dataTable) {
		List<List<String>> userlist=dataTable.asLists(String.class);
		for(List<String>data:userlist)
		{
			for(String datavalue:data)
			{
			System.out.println(datavalue);
			}
			
		}
	   
	}
	
	@Then("User enters the following dropdown as column values")
	public void user_enters_the_following_dropdown_as_column_values(DataTable dataTable) {
		List<Map<String,String>> userlist=dataTable.asMaps(String.class, String.class);
		System.out.println(userlist);
		for(Map<String,String> userlistdata:userlist)
		{			
			System.out.println(userlistdata.get("FirstName"));
			System.out.println(userlistdata.get("LastName"));
			
		}
	   
	}
	
	@Given("User is on the Capella Homepage")
	public void user_is_on_the_homepage() {
		cuhomepage.navigateTocapella();
	}

	@Then("User should see {string} in the top header")
	public void user_should_see_in_the_top_header(String header) {
		boolean flag = cuhomepage.VerifyHeaderMenu(header);
		Assert.assertTrue("The headermenus are not displayed", flag);
	}
	
	@Then("User navigates inside the Financing menu")
	public void user_navigates_inside_the_financing_menu() {
		cuhomepage.clickOnFinancingLink();	
	}

	@When("User clicks on the Grants menu")
	public void user_clicks_on_the_grants_menu() {
		cuhomepage.clickOnGrantsLink();
	}

	@When("User verifies the CUEDU header logo")
	public void user_verifies_the_cuedu_header_logo() {
		boolean flag = cuhomepage.VerifyHeadrLogo();
		Assert.assertTrue("The headerlogo is not displayed", flag);
	}


	@Then("User is navigated to Grants page with title {string}")
	public void user_is_navigated_to_grants_page_with_title(String pagetitle) {
		String Page_title = cuhomepage.validatePagetitle();
		Assert.assertEquals("The Page title does not match", Page_title, pagetitle);
	}
}
