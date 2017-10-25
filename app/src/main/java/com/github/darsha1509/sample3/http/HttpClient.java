package com.github.darsha1509.sample3.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    private HttpURLConnection mConnection;

    public void request(final String pUrl, final ResponseListener pListener){
        try{
            final InputStream is = openStream(pUrl);
            pListener.onResponse(is);
            mConnection.disconnect();
        }catch(final Throwable t){
            pListener.onError(t);
        }finally {
            if (mConnection !=null){
                mConnection.disconnect();
            }
        }
    }

    InputStream openStream (final String url) throws IOException {
        mConnection = (HttpURLConnection) (new URL(url)).openConnection();
        return  mConnection.getInputStream();
    }

    public interface ResponseListener {
        void onResponse (InputStream pInputStream) throws Exception;
        void onError (Throwable pThrowable);
    }
}
