package com.example.shauryatrivedi.naamkaran.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NameInterface {

//    @GET("category_list")
//    Call<List<Categorylist>> get_Category(@Query("cat_name") String cat_name, @Query("cat_id ") String cat_id );

    @GET("post_list_by_cat_and_gender?")
    Call<List<GenderApi>> get_Gender(@Query("category_id") String categ_id,@Query("gender") String gender);
}
// id;
//         String category_id;
//         String name;
//         String meaning;
//         String gender;