package com.example.townleague.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.townleague.R;
import com.example.townleague.beans.Team;
import com.example.townleague.lstTeam.view.Activity_detail;

import java.io.Serializable;
import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder>{

    private ArrayList<Team> lstTeams;

    public static class TeamViewHolder extends RecyclerView.ViewHolder{

    public TextView name;
    public TextView points;
    public CardView cardView;

        public TeamViewHolder(View v) {
            super(v);
            name =  v.findViewById(R.id.TextLeague1);
            points =  v.findViewById(R.id.TextLeague2);
            cardView = v.findViewById(R.id.item_team_cardview);
        }
    }

    public TeamAdapter(ArrayList<Team> lstTeams){
        this.lstTeams = lstTeams;
    }


    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_league,
                        parent,false);
                return new TeamViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {

        final Team team = lstTeams.get(position);
        holder.name.setText(team.getName());
        holder.points.setText(String.valueOf(team.getPoints()));

        //detalle lista de equipos
        holder.cardView.setOnClickListener(v -> {
            Intent detalle = new Intent(holder.cardView.getContext(), Activity_detail.class);
            detalle.putExtra("team", team);
            holder.cardView.getContext().startActivity(detalle);
        });
    }

    @Override
    public int getItemCount() {
        return lstTeams.size();
    }
}
