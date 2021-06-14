package com.yaskovskyi.task5.model;

import java.util.HashMap;
import java.util.Map;

public class GameStorage {
    private static Map<String, GameInfo> games;
    private static GameStorage instance;

    private GameStorage() {
        games = new HashMap<>();
    }

    public static synchronized GameStorage getInstance() {
        if (instance == null) {
            instance = new GameStorage();
        }
        return instance;
    }

    public Map<String, GameInfo> getGames() {
        return games;
    }

    public void setGame(GameInfo game) {
        games.put(game.getGameId(), game);
    }
}
