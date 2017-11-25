package com.example.nishantsikri.microdoctor;

import com.example.nishantsikri.microdoctor.POJO.Example;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by nishantsikri on 12/11/17.
 */

public interface RetrofitMaps {
    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
     */
    @GET("api/place/nearbysearch/json?sensor=true&key=AIzaSyCQ3VDME_d8V5ndsfWh8m_ZoInhBHMfYRY")
    Call<Example> getNearbyPlaces(@Query("type") String type, @Query("location") String location, @Query("radius") int radius);

}
