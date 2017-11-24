/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maze1;

import acm.graphics.*;
import acm.program.*;
import java.awt.Color;
import java.util.ArrayList;
import svu.csc213.Dialog;

/**
 *
 * @author wyatt
 */
// (Tile goalTile, ArrayList<Tile> path, ArrayList<Tile> visited) 
// Tile nextTile;
// Tile currentTile = path.get(path.size() - 1);
public class MazeRunner extends GraphicsProgram {

    private Maze maze;
    private int pause;
    public Tile startTile;
    public Tile goalTile;
    boolean solved = false;
    private ArrayList<Tile> path1 = new ArrayList<Tile>();
    private ArrayList<Tile> visited1 = new ArrayList<Tile>();

    @Override
    public void init() {
        pause = Dialog.getInteger(this, "Enter delay between steps in milliseconds.");
        int rows = 22;
        int cols = 35;
        maze = new Maze(rows, cols);
        add(maze, 10, 10);
//        pause(2000);
    }

    @Override
    public void run() {
        String rowRange = String.format("(%d-%d):", 0, maze.getRows() - 1);
        String colRange = String.format("(%d-%d):", 0, maze.getCols() - 1);
        int r0 = Dialog.getInteger(this, "Enter row for starting tile" + rowRange);
        int c0 = Dialog.getInteger(this, "Enter column for starting tile" + colRange);
        int r1 = Dialog.getInteger(this, "Enter Column for ending tile" + rowRange);
        int c1 = Dialog.getInteger(this, "Enter Column for ending tile" + colRange);      
        startTile = maze.getTile(r0, c0);
        startTile.fillColor(Color.BLUE);
        goalTile = maze.getTile(r1, c1);
        goalTile.fillColor(Color.GREEN);
        Solve(startTile, path1, visited1);
    }



    public void Solve(Tile startTile, ArrayList<Tile> path, ArrayList<Tile> visited) {
//        startTile.fillColor(Color.yellow);
        if (visited.contains(goalTile)) {
            Dialog.showMessage(this, "I found the exit!");
            System.exit(0);
        }else{
        path.add(0, startTile);
        visited.add(0, startTile);
            if (!startTile.hasWall(0) && !visited.contains(startTile.getNeighbor(0))) {
                startTile.fillColor(Color.RED);
                Solve(startTile.getNeighbor(0), (ArrayList<Tile>) path.clone(), visited);
                startTile.fillColor(Color.WHITE);
                pause (pause);
            }
            if (!startTile.hasWall(1) && !visited.contains(startTile.getNeighbor(1))) {
                startTile.fillColor(Color.RED);
                Solve(startTile.getNeighbor(1), (ArrayList<Tile>) path.clone(), visited);
                startTile.fillColor(Color.WHITE);
                 pause (pause);
            }

            if (!startTile.hasWall(2) && !visited.contains(startTile.getNeighbor(2))) {
                startTile.fillColor(Color.RED);
                Solve(startTile.getNeighbor(2), (ArrayList<Tile>) path.clone(), visited);
                startTile.fillColor(Color.WHITE);
                 pause (pause);
            }

            if (!startTile.hasWall(3) && !visited.contains(startTile.getNeighbor(3))) {
                startTile.fillColor(Color.RED);
                Solve(startTile.getNeighbor(3), (ArrayList<Tile>) path.clone(), visited);
                startTile.fillColor(Color.WHITE);
                 pause (pause);
                }
            }
    }
    public static void main(String[] args) {
        new MazeRunner().start();
    }
}
