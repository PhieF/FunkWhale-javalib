package com.spisoft.funkwhale;

import com.spisoft.funkwhale.responses.Token;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by phoenamandre on 24/04/18.
 */

public interface Authentificator {
    String token_url="token/";
    @POST(token_url)
    @Headers({"Content-Type: application/json", "Cache-Control: max-age=640000"})
    Call<Token> getToken(@Body Credentials cred);
}
