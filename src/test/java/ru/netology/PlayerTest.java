package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Igor");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Баттл Онлайн", "Аркады");

        Player player = new Player("Igor");
        player.installGame(game);
        player.play(game, 3);
        player.installGame(game1);
        player.play(game1, 4);

        int expected = 7;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGamesDifferentGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Баттл Онлайн", "PvP");

        Player player = new Player("Igor");
        player.installGame(game);
        player.play(game, 3);
        player.installGame(game1);
        player.play(game1, 4);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldInstallGame() {
        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Igor");

        Game expected = game;
        Game actual = player.installGame(game);
        assertEquals(expected, actual);
    }


    @Test
    public void shouldPlayReturnRunTimeException() {
        GameStore store = new GameStore();
        Player player = new Player("Igor");
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Assertions.assertThrows(RuntimeException.class, () -> {
            player.play(game, 0);
        });
    }

    @Test
    public void shouldPlay() {
        GameStore store = new GameStore();
        Player player = new Player("Igor");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        player.installGame(game1);

        int expected = 10;
        int actual = player.play(game1, 10);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        Game expected = game;
        Game actual = player.mostPlayerByGenre(game.getGenre());
        assertEquals(expected, actual);

    }
    @Test
    public void shouldShowMostPlayerByGenreNoPlay() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        Game expected = null;
        Game actual = player.mostPlayerByGenre(game.getGenre());
        assertEquals(expected, actual);

    }
    @Test
    public void shouldShowMostPlayerByGenreThreeGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 8);
        player.installGame(game1);
        player.play(game1, 3);
        player.installGame(game2);
        player.play(game2, 11);

        Game expected = game2;
        Game actual = player.mostPlayerByGenre(game.getGenre());
        assertEquals(expected, actual);

    }

    @Test
    public void shouldShowMostPlayerByGenreTwoDifferentGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Арк");
        Game game1 = store.publishGame("Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Баттл", "Аркады");


        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 8);
        player.installGame(game1);
        player.play(game1, 3);
        player.installGame(game2);
        player.play(game2, 1);


        Game expected = game1;
        Game actual = player.mostPlayerByGenre(game1.getGenre());
        assertEquals(expected, actual);

    }
}