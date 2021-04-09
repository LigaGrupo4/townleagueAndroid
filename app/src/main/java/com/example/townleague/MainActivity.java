package com.example.townleague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.townleague.adapter.TeamAdapter;
import com.example.townleague.beans.Team;
import com.example.townleague.lstTeam.contract.LstTeamContract;
import com.example.townleague.lstTeam.presenter.LstTeamPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LstTeamContract.View {

    private RecyclerView recyclerView;
    private LstTeamPresenter lstTeamPresenter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstTeamPresenter = new LstTeamPresenter(this);
        lstTeamPresenter.getTeams(this);

    }


    @Override
    public void success(ArrayList<Team> lstTeams) {

        recyclerView = findViewById(R.id.reciclador);
        lManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lManager);
        TeamAdapter adapter = new TeamAdapter(lstTeams);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void error(String message) {


    }



}