package com.example.townleague.retrofit;

import com.example.townleague.beans.Team;
import com.example.townleague.beans.TeamsAPIResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TheLeagueApiInterface {

    @GET("teams")
    Call<List<Team>> getTeams();
}
