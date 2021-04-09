package com.example.townleague.lstTeam.contract;

import android.content.Context;

import com.example.townleague.beans.Team;

import java.util.ArrayList;

public interface LstTeamContract {

    interface View{
        void success(ArrayList<Team> lstTeams);
        void error(String message);
    }
    interface Presenter{
        void getTeams(Context context);
    }
    interface Model{
        void getTeamsWS(Context context, OnLstTeamsListener onlstTeamsListener);

        interface OnLstTeamsListener{

            void resolve(ArrayList<Team> teams);
            void reject (String error);



        }

        }
    }



