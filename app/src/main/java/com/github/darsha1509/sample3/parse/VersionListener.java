package com.github.darsha1509.sample3.parse;

import com.github.darsha1509.sample3.http.HttpClient;

import java.io.InputStream;

public class VersionListener implements HttpClient.ResponseListener {

    @Override
    public void onResponse(InputStream pInputStream) throws Exception {

    }

    @Override
    public void onError(Throwable pThrowable) {

    }
}
