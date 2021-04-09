package com.example.townleague.lstTeam.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;


import com.example.townleague.R;
import com.example.townleague.adapter.ListPlayerAdapter;
import com.example.townleague.beans.Team;


public class Activity_detail extends AppCompatActivity {

    public TextView teamName;

    private Team team;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initComponents();

        Bundle bundle = getIntent().getExtras();
        team = (Team) bundle.getSerializable("team");

        addDetails();
    }

    private void addDetails() {

        teamName.setText(team.getName());
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);
        ListPlayerAdapter adapter = new ListPlayerAdapter(team.getPlayers());
        recycler.setAdapter(adapter);

    }

    private void initComponents(){
        teamName = findViewById(R.id.txtTeamName);
        recycler = findViewById(R.id.playerRecycler);
    }
}