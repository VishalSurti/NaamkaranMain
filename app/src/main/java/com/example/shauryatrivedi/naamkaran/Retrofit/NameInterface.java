package com.example.shauryatrivedi.naamkaran.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NameInterface {

    @GET("category_list")
    Call<List<Categorylist>> get_Category(@Query("cat_name") String cat_name, @Query("id ") String id );


}
