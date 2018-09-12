package com.arka.shubhamsharma.webService;

import com.arka.shubhamsharma.model.CountryModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    /*@POST("/get/all")
    Call<User> createUser(@Body User user);*/

    @GET("get/all")
    Call<CountryModel> getCountryList( );

  /*  @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
}