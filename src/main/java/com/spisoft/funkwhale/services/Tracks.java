package com.spisoft.funkwhale.services;

import com.spisoft.funkwhale.Credentials;
import com.spisoft.funkwhale.responses.Token;
import com.spisoft.funkwhale.responses.Track;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by phoenamandre on 24/04/18.
 */

public interface Tracks {

    String token_url="tracks/";
    @GET(token_url+"{track-id}")
    Call<Track> getTrack(@Path("track-id") int track);
}
