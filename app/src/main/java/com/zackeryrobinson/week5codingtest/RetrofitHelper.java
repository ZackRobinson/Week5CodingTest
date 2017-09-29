package com.zackeryrobinson.week5codingtest;

import com.zackeryrobinson.week5codingtest.model.FlickR;

import java.security.acl.Owner;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Zack on 9/29/2017.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "images\u2028http://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1";


    //create and initialize the retrofit instance
    public static Retrofit create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    //create a static method to use the interface verbs
    public static Call<List<FlickR>> createCall(String user) {
        Retrofit retrofit = create();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService.getFlickRItems(user);
    }

    public static Call<Owner> createCallUser(String user) {
        Retrofit retrofit = create();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService.getFlickRMedia(user);
    }



    //create an interface to have all the paths and verbs for the REST api to use
    interface ApiService {

        @GET("users/{user}/repos")
        Call<List<FlickR>> getFlickRItems(@Path("user") String user);

        @GET("users/{user}")
        Call<Owner> getFlickRMedia(@Path("user") String user);

    }

}
