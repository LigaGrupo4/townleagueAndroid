package com.example.townleague.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Team implements Serializable {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String POINTS = "points";
    private static final String GOALS = "goals";
    private static final String PLAYERS = "players";

    @SerializedName(ID)
    private int id;
    @SerializedName(NAME)
    private String name;
    @SerializedName(POINTS)
    private int points;
    @SerializedName(GOALS)
    private int goals;
    @SerializedName(PLAYERS)
    private List<Player> players;

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
