package engine;

import model.world.Champion;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    private String name;
    private Champion leader;
    private ArrayList<Champion> team;
    private Listener listener;
    private String color;

    public Player(String name) {
        this.name = name;
        this.team = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Champion getLeader() {
        return leader;
    }

    public void setLeader(Champion leader) {
        this.leader = leader;
        listener.onPlayerTeamChanged();
    }

    public ArrayList<Champion> getTeam() {
        return team;
    }

    public void addChampion(Champion champion) {
        team.add(champion);
        listener.onPlayerTeamChanged();
    }

    public void removeChampion(Champion champion) {
        team.remove(champion);
        listener.onPlayerTeamChanged();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public boolean hasChampion(Champion champion) {
        return this.team.contains(champion);
    }

    public boolean isLeader(Champion champion) {
        return champion.equals(leader);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public interface Listener {
        void onPlayerTeamChanged();
    }
}
