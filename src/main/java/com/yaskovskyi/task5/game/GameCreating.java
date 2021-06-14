package com.yaskovskyi.task5.game;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.yaskovskyi.task5.model.*;

import static com.yaskovskyi.task5.model.GameStatus.*;

@Service
@AllArgsConstructor
public class GameCreating {

    public GameInfo createGame(Player player, String id) {
        GameInfo game = new GameInfo();
        game.setBoard(new int[3][3]);
        game.setGameId(id);
        game.setPlayer1(player);
        game.setStatus(NEW);
        GameStorage.getInstance().setGame(game);
        return game;
    }

    public GameInfo connectToGame(Player player2, String gameId) {
        if (!GameStorage.getInstance().getGames().containsKey(gameId)) {
            System.out.println("Game with provided id doesn't exist");
        }
        GameInfo game = GameStorage.getInstance().getGames().get(gameId);

        if (game.getPlayer2() != null) {
            System.out.println("Game is not valid anymore");
        }

        game.setPlayer2(player2);
        game.setStatus(IN_PROGRESS);
        GameStorage.getInstance().setGame(game);
        return game;
    }

    public GameInfo gamePlay(GameTech gameT) {
        if (!GameStorage.getInstance().getGames().containsKey(gameT.getGameId())) {
            System.out.println("Game not found");
        }

        GameInfo game = GameStorage.getInstance().getGames().get(gameT.getGameId());
        if (game.getStatus().equals(FINISHED)) {
            System.out.println("Game is already finished");
        }

        int[][] board = game.getBoard();
        board[gameT.getCoordinateX()][gameT.getCoordinateY()] = gameT.getType().getValue();

        Boolean xWinner = checkWinner(game.getBoard(), Tic.X);
        Boolean oWinner = checkWinner(game.getBoard(), Tic.O);

        if (xWinner) {
            game.setWinner(Tic.X);
        } else if (oWinner) {
            game.setWinner(Tic.O);
        }

        GameStorage.getInstance().setGame(game);
        return game;
    }

    private Boolean checkWinner(int[][] board, Tic tic) {
        int[] boardArray = new int[9];
        int counterIndex = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boardArray[counterIndex] = board[i][j];
                counterIndex++;
            }
        }

        int[][] winCombinations = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for (int i = 0; i < winCombinations.length; i++) {
            int counter = 0;
            for (int j = 0; j < winCombinations[i].length; j++) {
                if (boardArray[winCombinations[i][j]] == tic.getValue()) {
                    counter++;
                    if (counter == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
}
