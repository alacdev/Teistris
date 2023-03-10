/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pieces;

import model.Piece;
import model.Game;
import model.Square;
import java.awt.Color;

/**
 *
 * @author haleacu
 */
public class SquarePiece extends Piece{
    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     * @param game
     */
    public SquarePiece(Game game) {       
        this.game = game;    
            
            squares[0] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.BLUE, game);
            squares[1] = new Square(Game.MAX_X / 2, 0, Color.BLUE, game);
            squares[2] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE,
                    Color.BLUE, game);
            squares[3] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.BLUE, game);  
     
    }
}
