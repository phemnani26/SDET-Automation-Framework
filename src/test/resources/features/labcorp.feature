
@ui
Feature: LabCorp Career Job Validation



  Scenario: Validate LabCorp job details and apply page information
   Given user launches LabCorp website
   When user clicks on Careers link 
   And user searches for "QA Test Automation Developer" job 
   And user selects the searched job 
   Then user validates job title 
   And user validates job location 
   And user validates job id 
   And user validates job description details 
   When user clicks Apply Now 
   Then user validates apply page information 
   And user clicks Return to Job Search
