package fr.iut63.a2ddicegameupdate.models;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Resultat implements Serializable {
    private int score;
    private int level;
    private String dateRecord;

    public Resultat(int score, int level, String date) {
        this.score = score;
        this.level = level;
        this.dateRecord = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDate() {
        return dateRecord;
    }

    public void setDate(String date) {
        this.dateRecord = date;
    }
}

