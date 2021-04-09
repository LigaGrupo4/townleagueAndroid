package com.example.townleague.lstTeam.presenter;

import android.content.Context;

import com.example.townleague.beans.Team;
import com.example.townleague.lstTeam.contract.LstTeamContract;
import com.example.townleague.lstTeam.model.LstTeamModel;

import java.util.ArrayList;

public class LstTeamPresenter implements LstTeamContract.Presenter {

    private LstTeamModel lstTeamModel;
    private LstTeamContract.View vista;

    public LstTeamPresenter(LstTeamContract.View vista){
        this.vista = vista;
        this.lstTeamModel = new LstTeamModel();

    }

    @Override
    public void getTeams(Context context) {
        lstTeamModel.getTeamsWS(context, new LstTeamContract.Model.OnLstTeamsListener() {
            @Override
            public void resolve(ArrayList<Team> teams) {
                vista.success(teams);
            }

            @Override
            public void reject(String error) {
                vista.error("Problema al traer los datos");

            }
        });


    }
}
