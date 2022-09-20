package stepDefinitions;

import org.junit.Assert;
import com.pages.SueduHomePage;
import com.utils.DriverFactory;
import io.cucumber.java.en.*;


public class Suedustepdefinition {

	private SueduHomePage homepage = new SueduHomePage(DriverFactory.getDriver());
		
	@Given("User is on the Strayer Homepage")
	public void user_is_on_the_homepage() {
		homepage.navigateToStrayer();
	}

	@When("User navigates to the bottom form")
	public void user_navigates_to_the_bottom_form() {
		boolean flag= homepage.VerifybtmRFIForm();
		Assert.assertTrue("The RFI form is not displayed", flag);
	}
	

	@Then("User enters {string} in the {string} dropdown")
	public void user_enters_in_the_dropdown(String desireddegree, String degree) {
		homepage.selectDegree(desireddegree,degree);
	}

	@When("User clicks on the Get program details button")
	public void user_clicks_on_the_get_programdetails_button() {
		System.out.println("clicks the button");
	}

	@Then("User is navigated to thank you page")
	public void user_is_navigated_to_thank_you_page() {
		System.out.println("gets thank you page");
	}
	
	@Then("User enters {string} in the {string} field")
	public void user_enters_in_the_field(String fieldvalue, String fieldname) {
		homepage.FillFields(fieldvalue,fieldname);
	}

	@When("User validates the SUEDU header logo")
	public void user_validates_the_suedu_header_logo() {
		boolean flag = homepage.VerifyHeadrLogo();
		Assert.assertTrue("The headerlogo is not displayed", flag);
	}


	@Then("User should see {string} in the header")
	public void user_should_see_in_the_header(String headervalue) {
		homepage.VerifyHeaderMenu(headervalue);
	}

	
	
}
