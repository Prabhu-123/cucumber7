@All
Feature: SUEDU Feature

This feature contains the SUEDU scenarios

@Smoke
Scenario: Bottom form submission in homepage
Given User is on the Strayer Homepage
When User navigates to the bottom form
Then User enters "Certificates" in the "Degree" dropdown
Then User enters "Digital Entrepreneurship" in the "Program" dropdown
And User enters "Tony" in the "First Name" field
And User enters "Stark" in the "Last Name" field
And User enters "tony@cunet.com" in the "Email" field
And User enters "8967499395" in the "Phone" field
And User enters "18101" in the "ZIP Code" field
When User clicks on the Get program details button
Then User is navigated to thank you page

@Regression
Scenario: Header Links validation in homepage
Given User is on the Strayer Homepage
When User validates the SUEDU header logo
Then User should see "Academic Programs" in the header
Then User should see "Tuition & Aid" in the header
Then User should see "Admissions" in the header
Then User should see "Student Experience" in the header

