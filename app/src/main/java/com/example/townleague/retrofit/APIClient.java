package com.example.townleague.retrofit;

import android.content.Context;

import com.example.townleague.beans.Team;
import com.example.townleague.beans.TeamsAPIResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

private Retrofit retrofit;
private Context context;

private static final String BASE_URL = "http://192.168.1.40:8080/";


    public APIClient(Context context) {

        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

public Call<List<Team>> getTeams(){
        TheLeagueApiInterface service = retrofit.create(TheLeagueApiInterface.class);
 return service.getTeams();
}


}
