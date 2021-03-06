package com.example.dasha.backend;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class AppVersion {

    @Id
    private Long id;

    private String versionCode;

    public AppVersion() {
    }

    public AppVersion(Long pId, String pVersionCode) {
        id = pId;
        versionCode = pVersionCode;
    }

    public Long getId() {
        return id;
    }

    public String getVersionCode() {
        return versionCode;
    }

}
