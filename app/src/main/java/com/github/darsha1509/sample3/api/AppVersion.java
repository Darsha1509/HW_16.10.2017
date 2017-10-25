package com.github.darsha1509.sample3.api;

import com.google.gson.annotations.SerializedName;

public class AppVersion {

    @SerializedName("id")
    private Long id;

    @SerializedName("versionCode")
    private String versionCode;

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String pVersionCode) {
        versionCode = pVersionCode;
    }
}
