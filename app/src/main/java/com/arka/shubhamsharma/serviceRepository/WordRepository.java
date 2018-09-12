package com.arka.shubhamsharma.serviceRepository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import com.arka.shubhamsharma.model.CountryModel;
import com.arka.shubhamsharma.model.Result;
import com.arka.shubhamsharma.webService.ApiClient;
import com.arka.shubhamsharma.webService.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WordRepository {

   private MutableLiveData<List<Result>> listMutableLiveData = new MutableLiveData<>();

    public WordRepository(Application application) {
       getAllWords();
   }

    public MutableLiveData<List<Result>> getListMutableLiveData() {
        return listMutableLiveData;
    }

    private void getAllWords() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CountryModel> call = apiService.getCountryList();
        call.enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
                listMutableLiveData.postValue(response.body().getRestResponse().getResult());
            }

            @Override
            public void onFailure(Call<CountryModel> call, Throwable t) {

            }
        });
    }
}