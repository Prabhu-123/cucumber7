@All
Feature: CUEDU Feature

This feature contains the CUEDU scenarios

#Data table with lists
@Smoke
Scenario: RFI form submission in homepage as List
Given User is on the Capella Homepage
When User navigates to the RFI form
Then User enters the following dropdown
|Tony|Stark|tony@cunet.com|9589493938|18101|
|Steve|Rogers|steve@cunet.com|9589493948|18101|
|Wanda|Max|wanda@cunet.com|9589493368|18101|
When User clicks on the Get program details button
Then User is navigated to thank you page

#Data Table With Maps

Scenario: RFI form submission in homepage as List
Given User is on the Capella Homepage
When User navigates to the RFI form
Then User enters the following dropdown
|Tony|Stark|tony@cunet.com|9589493938|18101|
|Steve|Rogers|steve@cunet.com|9589493948|18101|
|Wanda|Max|wanda@cunet.com|9589493368|18101|
When User clicks on the Get program details button
Then User is navigated to thank you page

@Smoke
Scenario: Header Validation
Given User is on the Capella Homepage
When User verifies the CUEDU header logo
Then User should see "Degrees & Programs" in the top header
Then User should see "Capella Experience" in the top header
Then User should see "Financing" in the top header
Then User should see "Apply" in the top header

@Regression
Scenario: Navigation in Financing Menu
Given User is on the Capella Homepage
When User verifies the CUEDU header logo
Then User should see "Financing" in the top header
Then User navigates inside the Financing menu
When User clicks on the Grants menu
Then User is navigated to Grants page with title "Grants - Capella University"
