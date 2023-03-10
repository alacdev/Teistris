/*
 * Copyright (C) 2019 Antonio de Andrés Lema
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package model;

/**
 * Clase que implementa a peza cadrada do xogo do Tetris
 *
 * @author Profe de Programación
 */
public abstract class Piece {

    /**
     * Referenza ao obxecto xogo
     */
    protected Game game;
    /**
     * Referenzas aos catro cadrados que forman a peza
     */
    protected Square[] squares = new Square [4];

    public Square[] getSquares() {
        return squares;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    

    /**
     * Move a ficha á dereita se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveRight() {
        boolean canMove=true;
        for (Square s : squares) {
            if(!game.isValidPosition(s.getX()+Game.SQUARE_SIDE, s.getY())){
                canMove=false;
            }
        }
        if (canMove) {
            for (Square square : squares) {
                square.setX(square.getX() + Game.SQUARE_SIDE);
            }
            return true;
        }
        return false;
    }

    /**
     * Move a ficha á esquerda se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveLeft() {
        boolean canMove=true;
        for (Square s : squares) {
            if(!game.isValidPosition(s.getX()-Game.SQUARE_SIDE, s.getY())){
                canMove=false;
            }
        }
        if (canMove) {
            for (Square square : squares) {
                square.setX(square.getX() - Game.SQUARE_SIDE);
            }
            return true;
        }
        return false;
    }

    /**
     * Move a ficha a abaixo se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveDown() {
        boolean canMove=true;
        for (Square s : squares) {
            if(!game.isValidPosition(s.getX(), s.getY()+ Game.SQUARE_SIDE)){
                canMove=false;
            }
        }
        if (canMove) {
            for (Square square : squares) {
                square.setY(square.getY() + Game.SQUARE_SIDE);
            }
            return true;
        }
        return false;
    }

    /**
     * Rota a ficha se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean rotate() {
        // A rotación da ficha cadrada non supón ningunha variación na ficha,
        // por iso simplemente devolvemos true
        return true;
    }

}
