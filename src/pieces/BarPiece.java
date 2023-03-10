/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pieces;

import model.Piece;
import model.Game;
import model.Square;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author haleacu
 */
public class BarPiece extends Piece {
    
    private int position;

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     *
     * @param game
     */
    public BarPiece(Game game) {
        this.position = 0;
        this.game = game;
        //para que la pieza salga de un color random
        Random rand = new Random();
	    float red = rand.nextFloat();
	    float green = rand.nextFloat();
	    float blue = rand.nextFloat();
	    Color randomColor = new Color(red, green, blue);

        squares[0] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, randomColor, game);
        squares[1] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE, randomColor, game);
        squares[2] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 2 * Game.SQUARE_SIDE,
                randomColor, game);
        squares[3] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 3 * Game.SQUARE_SIDE, randomColor, game);

    }

    @Override
    public boolean rotate() {
        boolean canRotate = false;
        switch (position) {
            case 0:
                //creamos un if para ver que se pueda mover la pieza
                if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY() + Game.SQUARE_SIDE)
                        && game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE, squares[2].getY() - Game.SQUARE_SIDE)
                        && game.isValidPosition(squares[3].getX() + 2 * Game.SQUARE_SIDE, squares[3].getY() - 2 * Game.SQUARE_SIDE)) {
                    //movemos el cuadrado 0
                    squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                    squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
                    //movemos el cuadrado 2
                    squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                    squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
                    //movemos el cuadrado 3
                    squares[3].setX(squares[3].getX() + 2 * Game.SQUARE_SIDE);
                    squares[3].setY(squares[3].getY() - 2 * Game.SQUARE_SIDE);
                    position++;
                    canRotate = true;
                }
                break;            
            case 1 :
                //creamos un if para ver que se pueda mover la pieza
                if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY() - Game.SQUARE_SIDE)
                        && game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE, squares[2].getY() + Game.SQUARE_SIDE)
                        && game.isValidPosition(squares[3].getX() + 2*Game.SQUARE_SIDE, squares[3].getY())) {
                    //movemos el cuadrado 0
                    squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                    squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
                    //movemos el cuadrado 2
                    squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                    squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
                    //movemos el cuadrado 3
                    squares[3].setX(squares[3].getX() + 2*Game.SQUARE_SIDE);
                    position=0;
                    canRotate = true;
                }
                break;            
        }
        return canRotate;
    }
    
}
