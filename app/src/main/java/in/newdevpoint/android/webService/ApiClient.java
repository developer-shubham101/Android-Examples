package in.newdevpoint.android.webService;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://newdevpoint.in/demo/data/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getPaytm() {

        return new Retrofit.Builder()
        .baseUrl("http://mystar11.com/PAYTMChecksum/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    }

}