package com.example.nouman.mhtours;

public class ModelClass {
    private String mSiteName;
    private int mSiteImage;
    private String mSiteInfoUrl;

    public ModelClass(String site, int image, String infoUrl){
        mSiteName = site;
        mSiteImage = image;
        mSiteInfoUrl = infoUrl;
    }

    public String getmSiteName() {
        return mSiteName;
    }

    public int getmSiteImage() {
        return mSiteImage;
    }

    public String getmSiteInfoUrl() {
        return mSiteInfoUrl;
    }
}
