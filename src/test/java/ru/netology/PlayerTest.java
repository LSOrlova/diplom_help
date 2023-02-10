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

        Assertions.assertThrows(RuntimeException.class, () -> {
            player.play(null, 8);
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
                //String.valueOf(player.sumGenre(game.getGenre()));
        assertEquals(expected, actual);

    }
}