package com.company;

import com.company.entities.Player;
import com.company.entities.Race;

import java.util.PropertyResourceBundle;

public class Game {
    private final String name = "Ďuránova cesta ze dobrodružstvím ";
    private final double version = 0.1;
    private final String author = "Karla_Kubalová";
    private GameDialog gameDialog;
    private Player player;

    public Game() {
        player = new Player();
        gameDialog = new GameDialog();
    }

    public void start() {
        gameDialog.intro(name, version, author);
        introMenu();
    }

    private void introMenu() {
        gameDialog.say("Vitej v poklidnem mestecku. V mestecku bydli tisice lidi. Je cas na vyber tvoji postavy. ");
        gameDialog.say("Zvol si svoji rasu:", "white");
        for (Race value : Race.values()) {
            gameDialog.say(value.toString(), "purple");
        }
        selectRace();
        storyIntro();
    }

    private void selectRace() {
        String userInput = gameDialog.userInput();
        boolean check = false;
        for (Race value : Race.values()) {
            if (userInput.trim().equalsIgnoreCase(value.toString())) {
                check = true;
                player.setRace(value);
                break;
            }
        }
        if (!check) {
            selectRace();
            return;
        }

        System.out.println(player.getRace());
        ;
    }

    private void storyIntro() {
        gameDialog.say("Zvolil jsi si rasu " + player.getRace(), "red");
        gameDialog.say("-------------------------------------------------");
        gameDialog.say("Hra zacina.", "white");
        gameDialog.say("-------------------------------------------------");
        gameDialog.say("Vitej Tomasi v nasem poklidnem mestecku, kde tisice lidi prezivaji tvoji existenci.");
    }

}
