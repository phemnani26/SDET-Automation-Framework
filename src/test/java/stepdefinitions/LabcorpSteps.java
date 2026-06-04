package stepdefinitions;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CareersPage;
import pages.HomePage;
import pages.JobDetailsPage;
import util.ConfigReader;
import util.Log;

public class LabcorpSteps {

    HomePage homePage;
    CareersPage careersPage;
    JobDetailsPage jobDetailsPage;

    @Given("user launches LabCorp website")
    public void user_launches_labcorp_website() {

        homePage =
                new HomePage(
                        DriverFactory.getDriver());

        homePage.openLabCorpWebsite(
                ConfigReader.getProperty("url"));

        Log.logger.info(
                "LabCorp website launched successfully");
    }

    @When("user clicks on Careers link")
    public void user_clicks_on_careers_link() {

        homePage.clickCareersLink();

        Log.logger.info(
                "Clicked on Careers link");
    }

    @And("user searches for {string} job")
    public void user_searches_for_job(String jobName) {

        careersPage =
                new CareersPage(
                        DriverFactory.getDriver());

        careersPage.searchJob(jobName);

        Log.logger.info(
                "Searched for Job: " + jobName);
    }

    @And("user selects the searched job")
    public void user_selects_the_searched_job() {

        careersPage.selectJob();

        Log.logger.info(
                "Selected searched job");
    }

    @Then("user validates job title")
    public void user_validates_job_title() {

        jobDetailsPage =
                new JobDetailsPage(
                        DriverFactory.getDriver());

        String title =
                jobDetailsPage.getJobTitle();

        Log.logger.info(
                "JOB TITLE = " + title);

        Assert.assertEquals(
                title,
                ConfigReader.getProperty("jobTitle"),
                "Job Title validation failed");

        Log.logger.info(
                "Job title validated successfully");
    }

    @And("user validates job location")
    public void user_validates_job_location() {

        String location =
                jobDetailsPage.getJobLocation();

        Log.logger.info(
                "JOB LOCATION = " + location);

        Assert.assertTrue(
                location.contains("locations"),
                "Location information not displayed");

        Log.logger.info(
                "Job location validated successfully");
    }

    @And("user validates job id")
    public void user_validates_job_id() {

        String jobId =
                jobDetailsPage.getJobId();

        Log.logger.info(
                "JOB ID = " + jobId);

        Assert.assertEquals(
                jobId,
                "2615333",
                "Job ID validation failed");

        Log.logger.info(
                "Job ID validated successfully");
    }

    @And("user validates job description details")
    public void user_validates_job_description_details() {

        String pageSource =
                DriverFactory.getDriver()
                        .getPageSource()
                        .toLowerCase();

        Assert.assertTrue(
                pageSource.contains("automation"),
                "Automation keyword not found");

        Assert.assertTrue(
                pageSource.contains("quality"),
                "Quality keyword not found");

        Assert.assertTrue(
                pageSource.contains("software"),
                "Software keyword not found");

        Log.logger.info(
                "Job description validated successfully");
    }

    @When("user clicks Apply Now")
    public void user_clicks_apply_now() {

        jobDetailsPage.clickApplyNow();

        Log.logger.info(
                "Clicked Apply Now button");
    }

    @Then("user validates apply page information")
    public void user_validates_apply_page_information() {

        String currentUrl =
                DriverFactory.getDriver()
                        .getCurrentUrl();

        Log.logger.info(
                "APPLY PAGE URL = " + currentUrl);

        Assert.assertTrue(
                currentUrl.toLowerCase().contains("apply"),
                "Apply page was not opened");

        Log.logger.info(
                "Apply page validated successfully");
    }

    @And("user clicks Return to Job Search")
    public void user_clicks_return_to_job_search() {

        jobDetailsPage.clickReturnToJobSearch();

        Log.logger.info(
                "Returned to Job Search page");
    }
}