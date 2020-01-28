package com.reno;

import com.reno.Position;
import java.util.LinkedList;

public class MazeSolver {

    //0 = wall
    //1 = path
    //2 = destination
    static int[][] maze = {
            {1,0,1,1,1,1,0,1,0,1,0},
            {1,1,1,1,0,1,1,0,1,0,1},
            {0,0,1,1,1,0,1,1,1,0,1},
            {1,1,1,1,0,1,1,0,1,0,1},
            {1,0,2,1,1,0,1,1,1,0,1}
    };

    //follow where the path is via stack
    static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] args) {

        Position p = new Position(2,8); //setting the starting position
        path.push(p); //we need to push it to the front of the stack



        while(true) {
            int y = path.peek().y;
            int x = path.peek().x;

            maze[y][x] = 0;

            //down movement
            if (isValid(y + 1, x)) {
                if (maze[y + 1][x] == 2) {
                    System.out.println("Moved down, You won");
                    return;
                } else if (maze[y + 1][x] == 1) {
                    path.push(new Position(y + 1, x));
                    System.out.println("Moved down");
                    continue;
                }
            }

            //left
            if (isValid(y, x - 1)) {
                if (maze[y][x - 1] == 2) {
                    System.out.println("Moved left, You won");
                    return;
                } else if (maze[y][x - 1] == 1) {
                    path.push(new Position(y, x - 1));
                    System.out.println("Moved left");
                    continue;
                }
            }

            //right
            if (isValid(y, x + 1)) {
                if (maze[y][x + 1] == 2) {
                    System.out.println("Moved right, You won");
                    return;
                } else if (maze[y][x + 1] == 1) {
                    path.push(new Position(y, x + 1));
                    System.out.println("Moved right");
                    continue;
                }
            }

            //up
            if (isValid(y - 1, x)) {
                if (maze[y - 1][x] == 2) {
                    System.out.println("Moved up, You won");
                    return;
                } else if (maze[y - 1][x] == 1) {
                    path.push(new Position(y - 1, x));
                    System.out.println("Moved up");
                    continue;
                }
            }

            path.pop();
            System.out.println("Moved back");
            if (path.size() <= 0) {
                System.out.println("No path");
                return;
            }
        }
    }

    public static boolean isValid(int y, int x) {
        if (y < 0 ||
            y >= maze.length ||
            x < 0 ||
            x >= maze[y].length) {
            return false;
        }
        return true;
    }
}