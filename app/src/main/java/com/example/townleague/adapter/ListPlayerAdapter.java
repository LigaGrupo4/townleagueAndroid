package com.example.townleague.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.townleague.R;
import com.example.townleague.beans.Player;
import com.example.townleague.lstTeam.contract.LstTeamContract;

import java.util.ArrayList;
import java.util.List;

public class ListPlayerAdapter extends RecyclerView.Adapter<ListPlayerAdapter.PlayerViewHolder> {

    private List<Player> listPlayers;

    public static class PlayerViewHolder extends RecyclerView.ViewHolder {

        public TextView playerName;

        public TextView playerLastName;

        public PlayerViewHolder(View v){
            super(v);
            playerName = v.findViewById(R.id.txtPlayerName);
            playerLastName = v.findViewById(R.id.txtPlayerLastName);
        }

    }
    public ListPlayerAdapter(List<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_player, parent, false);
        return new PlayerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {

        Player player = listPlayers.get(position);
        holder.playerName.setText(player.getName());
        holder.playerLastName.setText(player.getLastName());
    }

    @Override
    public int getItemCount() {
        return listPlayers.size();
    }

}
