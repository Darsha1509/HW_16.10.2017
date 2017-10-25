package com.github.darsha1509.sample3;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class MyBuildConfig {

    Context mContext;

    public MyBuildConfig() {
    }

    public MyBuildConfig(Context pContext) {
        mContext = pContext;
    }

    public int getVersionCode(){
        try{
            PackageInfo pInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            return pInfo.versionCode;
        }catch(PackageManager.NameNotFoundException e){
            e.printStackTrace();
            return 0;
        }
    }
}
