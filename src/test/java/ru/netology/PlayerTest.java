package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

//    @Test
//    public void shouldSumGenreIfOneGame() {
//        GameStore store = new GameStore();
//        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//
//        Player player = new Player("Petya");
//        player.installGame(game);
//        player.play(game, 3);
//
//        int expected = 3;
//        int actual = player.sumGenre(game.getGenre());
//        assertEquals(expected, actual);
//    }

    @Test
    public void shouldInstallGame() {
        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player();

        Game expected = game;
        Game actual = player.installGame(game);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayReturnRunTimeException() {
        GameStore store = new GameStore();
        Player player = new Player();

        Assertions.assertThrows(RuntimeException.class, () -> {
            store.addPlayTime("Petya", 5);
        });
    }

//    @Test
//    public void shouldPlay() {
//        GameStore store = new GameStore();
//        Player player = new Player("Petya");
//        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//        game1.getStore().addPlayTime(game, 10);
//
//        int expected = 10;
//        int actual = playedTime.put(game1, playedTime.get(game1));
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldShowMostPlayerByGenre() {
//        GameStore store = new GameStore();
//        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//
//        Player player = new Player("Petya");
//        player.installGame(game);
//        player.play(game, 3);
//
//        String expected = "Petya";
//        String actual = String.valueOf(player.sumGenre(game.getGenre()));
//        assertEquals(expected, actual);
//
//    }
}