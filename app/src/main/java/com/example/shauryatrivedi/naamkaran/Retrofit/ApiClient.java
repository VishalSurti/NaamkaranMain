package com.example.shauryatrivedi.naamkaran.Retrofit;

//http://mapi.trycatchtech.com/v1/naamkaran/category_list

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL="http://mapi.trycatchtech.com/v1/naamkaran/";
    private static Retrofit retrofit =null;

    public static Retrofit getClient()
    {
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
    }
