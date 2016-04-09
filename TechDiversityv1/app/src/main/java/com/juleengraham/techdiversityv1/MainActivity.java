package com.juleengraham.techdiversityv1;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method opens a website
     *
     * @param url of the website
     */
    public void openWebsite(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    /**
     * This method opens the website for Diamond Hacks
     */
    public void openTapiaWeb(View view) {
        openWebsite("http://tapiaconference.org/");
    }

    /**
     * This method opens the online registration for Diamond Hacks
     */
    public void openTapiaApp(View view) {
        openWebsite("http://tapiaconference.org/registration/");
    }

    /**
     * This method opens the website for Diamond Hacks
     */
    public void openDiamondWeb(View view) {
        openWebsite("http://www.ncsudiamondhacks.com/");
    }

    /**
     * This method opens the online registration for Diamond Hacks
     */
    public void openDiamondApp(View view) {
        openWebsite("https://docs.google.com/forms/d/12wJYUQPzS6QyTQ-PWe_AqUBEP3Hu-VW02u7RQ37EVcM/viewform?c=0&w=1");
    }

    /**
     * This method opens the website for Code2040
     */
    public void openCode2040Web(View view) {
        openWebsite("http://www.code2040.org/students/");
    }

    /**
     * This method opens the website for Microsoft DS3
     */
    public void openDS3Web(View view) {
        openWebsite("https://ds3.research.microsoft.com/");
    }

    /**
     * This method opens the online application for Microsoft DS3
     */
    public void openDS3App(View view) {
        openWebsite("https://ds3.research.microsoft.com/apply");
    }

    /**
     * This method opens the website for Buildium Women in Tech Scholarship
     */
    public void openBuildiumWeb(View view) {
        openWebsite("https://www.buildium.com/women-in-technology-scholarship/");
    }

    /**
     * This method sets the app view back to the homepage
     */
    public void setLayoutMain (View view) {
        setContentView(R.layout.activity_main);
    }

    /**
     * This method sets the app view to code2040_layout
     */
    public void setLayoutCode2040 (View view) {
        setContentView(R.layout.code2040_layout);
    }

    /**
     * This method sets the app view to Microsoft DS3 layout
     */
    public void setLayoutDS3 (View view) {
        setContentView(R.layout.ds3_layout);
    }

    /**
     * This method sets the app view to Tapia Conference layout
     */
    public void setLayoutTapia (View view) {
        setContentView(R.layout.tapia_layout);
    }

    /**
     * This method sets the app view to Diamond Hacks layout
     */
    public void setLayoutDiamondHacks (View view) {
        setContentView(R.layout.diamond_hacks_layout);
    }

    /**
     * This method sets the app view to Buildium Scholarship layout
     */
    public void setLayoutBuildiumScholarship (View view) {
        setContentView(R.layout.buildium_scholarship_layout);
    }
}
