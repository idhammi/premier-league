package id.idham.premierleague.data.api;

import java.util.concurrent.TimeUnit;

import id.idham.premierleague.BuildConfig;
import id.idham.premierleague.data.model.TeamResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    private APIInterface apiInterface;

    public APIService() {
        OkHttpClient.Builder okhttpBuilder = new OkHttpClient().newBuilder();
        okhttpBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okhttpBuilder.writeTimeout(30, TimeUnit.SECONDS);
        okhttpBuilder.readTimeout(30, TimeUnit.SECONDS);
        okhttpBuilder.retryOnConnectionFailure(true);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okhttpBuilder.addInterceptor(interceptor);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okhttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(APIInterface.class);
    }

    public void getListTeams(String id, Callback<TeamResponse> callback) {
        apiInterface.getListTeams(id).enqueue(callback);
    }
}
