package com.github.darsha1509.sample3.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageInfo;

import com.github.darsha1509.sample3.MyBuildConfig;
import com.github.darsha1509.sample3.http.HttpClient;
import com.github.darsha1509.sample3.parse.VersionListener;

public class Utils {

    Context mContext;

    public Utils() {
    }

    public Utils(Context pContext) {
        mContext = pContext;
    }

    public static String getVersion(){
        VersionListener listener = new VersionListener();
        new HttpClient().request(Constants.URL, listener);
        return listener.getResult().getVersionCode();
    }

    public boolean compereVersions(String versionCode){
        int appVersionCode = new MyBuildConfig(mContext).getVersionCode();

        boolean result = true;
        if(Integer.parseInt(versionCode) > appVersionCode){
            result = true;
        } else if (Integer.parseInt(versionCode) == appVersionCode){
            result = false;
        }
        return result;
    }

}
