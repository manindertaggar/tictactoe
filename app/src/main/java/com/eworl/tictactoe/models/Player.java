package com.eworl.tictactoe.models;

import java.util.List;

/**
 * Created by Maninder Taggar on 26/1/17.
 */

public class Player {
    private String name, age, avatarUrl, token, emailId;
    private List<Acheivement> acheivements;
    private int numberOfGamesPlayed;
    private long rank;
    private double winPercentage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<Acheivement> getAcheivements() {
        return acheivements;
    }

    public void setAcheivements(List<Acheivement> acheivements) {
        this.acheivements = acheivements;
    }

    public int getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    public void setNumberOfGamesPlayed(int numberOfGamesPlayed) {
        this.numberOfGamesPlayed = numberOfGamesPlayed;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public double getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(double winPercentage) {
        this.winPercentage = winPercentage;
    }

    public long getRank() {
        return rank;
    }
}
