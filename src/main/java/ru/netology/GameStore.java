package ru.netology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//ГОТОВО
public class GameStore {

    private List<Game> games = new ArrayList<>();
    public List<Game> getGames() {
        return games;
    }

    /**
     * Информация о том, какой игрок сколько играл в игры этого каталога
     * Ключ - имя игрока
     * Значение - суммарное количество часов в игры этого каталога
     */
    private HashMap<String, Integer> playedTime = new HashMap<>();
    public HashMap<String, Integer> getPlayedTime() {
        return playedTime;
    }

    /**
     * Создание объекта игры с заданными заголовком и жанром
     * Каждый объект игры помнит объект каталога, которому она принадлежит
     */
    public Game publishGame(String title, String genre) {
        Game game = new Game(title, genre, this);
        if (!containsGame(game) == true) {
            games.add(game);
        } else {
            RuntimeException e = new RuntimeException("Игра была  установлена " + game);
            throw e;
        }
        return game;
    }

    /**
     * Проверяет наличие игры в каталоге и возврашает true
     * если игра есть и false иначе
     */
    public boolean containsGame(Game game) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).equals(game)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Регистрирует количество времени, которое проиграл игрок
     * за игрой этого каталога. Игрок задаётся по имени. Время должно
     * суммироваться с прошлым значением для этого игрока
     */
    public void addPlayTime(String playerName, int hours) {
        if (playedTime.containsKey(playerName)) {
            int currentTime = playedTime.get(playerName);
            int newTime = currentTime + hours;
            playedTime.put(playerName, newTime);
        } else {
            playedTime.put(playerName, hours);
        }
    }

    /**
     * Ищет имя игрока, который играл в игры этого каталога больше всего
     * времени. Если игроков нет, то возвращется null
     */
    public String getMostPlayer() {
        int mostTime = 0;
        String bestPlayer = null;
        for (String playerName : playedTime.keySet()) {
            int playerTime = playedTime.get(playerName);
            if (playerTime > mostTime) {
                mostTime = playerTime;
                bestPlayer = playerName;
            }
        }
        return bestPlayer;
    }

    /**
     * Суммирует общее количество времени всех игроков, проведённого
     * за играми этого каталога
     */
    public int getSumPlayedTime() {
        int sumPlayedTime = 0;
        for (String playerName : playedTime.keySet()) {
            int playerTime = playedTime.get(playerName);
            sumPlayedTime = sumPlayedTime + playerTime;
        }
        return sumPlayedTime;
    }
}