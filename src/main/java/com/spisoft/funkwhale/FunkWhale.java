package com.spisoft.funkwhale;

import com.spisoft.funkwhale.exceptions.AuthentificationException;
import com.spisoft.funkwhale.responses.Token;
import com.spisoft.funkwhale.services.Tracks;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FunkWhale {
    private final String mUrl;
    private static final String api="/api/v1/";
    private final Retrofit mRetrofit;
    private String token = null;

    public FunkWhale(String url){
        mUrl = url;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request newRequest;
                newRequest = request.newBuilder()
                        .addHeader("Authorization", "JWT" + " " + token)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(mUrl+api)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void setToken(String token){

    }

    public void asyncRetrieveAccessToken(final AsyncResultCallback callback, final String username, final String password){
        new Thread(){
            public void run(){
                try {
                    callback.onResult(AsyncResultCallback.RESULT_OK, retrieveAccessToken(username, password));
                } catch (AuthentificationException e) {
                    callback.onResult(AsyncResultCallback.RESULT_AUTHENTIFICATION_ERROR, null);
                }
            }
        }.start();
    }
    public String retrieveAccessToken(String username, String password) throws AuthentificationException {
        Authentificator service = mRetrofit.create(Authentificator.class);
        try {
            Credentials credentials = new Credentials();
            credentials.username = username;
            credentials.password = password;
            Response<Token> response = service.getToken(credentials).execute();
            if(response.isSuccessful()){
                this.token = response.body().token;
                return response.body().token;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Tracks getTracksService(){
        return mRetrofit.create(Tracks.class);
    }
}
