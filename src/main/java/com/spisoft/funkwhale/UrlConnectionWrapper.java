package com.spisoft.funkwhale;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by phoenamandre on 24/04/18.
 */

public class UrlConnectionWrapper {
    private HttpURLConnection http = null;
    private HttpsURLConnection https = null;
    public UrlConnectionWrapper(URLConnection connection){
        if(connection instanceof HttpURLConnection)
            http = (HttpURLConnection) connection;
        else
            https = (HttpsURLConnection) connection;
    }

    public void setRequestMethod(String method) throws ProtocolException {
        if(http!=null) http.setRequestMethod(method);
        else https.setRequestMethod(method);
    }

    public int getResponseCode() throws IOException {
        if(http!=null) return http.getResponseCode();
        else return https.getResponseCode();
    }

    public InputStream getInputStream() throws IOException {
        if(http!=null) return http.getInputStream();
        else return https.getInputStream();
    }
}
