package com.example.townleague.lstTeam.model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.townleague.beans.Team;
import com.example.townleague.lstTeam.contract.LstTeamContract;
import com.example.townleague.retrofit.APIClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstTeamModel implements LstTeamContract.Model{



    @Override
    public void getTeamsWS(Context context,final OnLstTeamsListener onlstTeamsListener) {
        APIClient apiClient = new APIClient(context);
    final Call<List<Team>> peticion = apiClient.getTeams();

    peticion.enqueue(new Callback<List<Team>>() {

        @Override
        public void onResponse(@Nullable Call<List<Team>> call,@Nullable Response<List<Team>> response) {

            if (response != null && response.body() !=null){
                onlstTeamsListener.resolve(new ArrayList<>(response.body()));

            }
        }

        @Override
        public void onFailure(@Nullable Call<List<Team>> call,@Nullable Throwable t) {

            t.printStackTrace();
            onlstTeamsListener.reject(t.getLocalizedMessage());

        }
    });


    }
}
