package com.arka.shubhamsharma.webService;

import com.arka.shubhamsharma.model.Checksum;
import com.arka.shubhamsharma.model.CountryModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    //this is the URL of the paytm folder that we added in the server
    //make sure you are using your ip else it will not work
    String BASE_URL = "http://mystar11.com/PAYTMChecksum/";
    /*@POST("/get/all")
    Call<User> createUser(@Body User user);*/

    @GET("get/all")
    Call<CountryModel> getCountryList( );


    @FormUrlEncoded
    @POST("GenerateChecksum.aspx")
    Call<Checksum> getChecksum(
            @Field("MID") String mId,
            @Field("ORDER_ID") String orderId,
            @Field("CUST_ID") String custId,
            @Field("CHANNEL_ID") String channelId,
            @Field("TXN_AMOUNT") String txnAmount,
            @Field("WEBSITE") String website,
            @Field("CALLBACK_URL") String callbackUrl,
            @Field("INDUSTRY_TYPE_ID") String industryTypeId,
            @Field("EMAIL") String email,
            @Field("MOBILE_NO") String mobile


    );

  /*  @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
}