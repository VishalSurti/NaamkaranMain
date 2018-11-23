package com.example.shauryatrivedi.naamkaran.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NameInterface {

    @GET("v1/naamkaran/post_list_by_cat_and_gender")
    Call<List<GenderApi>> get_Gender(@Query("category_id") String catgry_id, @Query("gender") String gender);
}
