package com.github.darsha1509.sample3.parse;

import com.github.darsha1509.sample3.api.AppVersion;
import com.github.darsha1509.sample3.http.HttpClient;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

public class VersionListener implements HttpClient.ResponseListener {

    private AppVersion result;
    private Throwable mThrowable;

    @Override
    public void onResponse(InputStream pInputStream) throws Exception {
        InputStreamReader inputStreamReader = null;
        try{
            inputStreamReader = new InputStreamReader(pInputStream);
            result = new GsonBuilder()
                    .setLenient()
                    .create().fromJson(inputStreamReader, AppVersion.class);
        }finally {
            if (inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch(final Exception ignored){}
            }
        }
    }

    @Override
    public void onError(Throwable pThrowable) {
        mThrowable = pThrowable;
    }

    public AppVersion getResult() {
        return result;
    }

    public Throwable getThrowable() {
        return mThrowable;
    }
}
