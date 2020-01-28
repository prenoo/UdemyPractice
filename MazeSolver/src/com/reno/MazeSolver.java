package com.reno;

import java.util.LinkedList;

public class MazeSolver {

    static Maze m = new Maze();
    //0 = wall
    //1 = path
    //2 = destination

    public static void main(String[] args) {

        int[][] maze = {
                {1,0,1,1,1,1,0,1,0,1,0},
                {1,1,1,1,0,1,1,0,1,0,1},
                {0,0,1,1,1,0,1,1,1,0,1},
                {1,1,1,1,0,1,1,0,1,0,1},
                {1,0,2,1,1,0,1,1,1,0,1}
        };

        m.maze = maze;
        m.start = new Position(2, 8);
        m.path = new LinkedList<Position>();
        m.path.push(m.start); //we need to push it to the front of the stack

        while(true) {
            int y = m.path.peek().y;
            int x = m.path.peek().x;

            m.maze[y][x] = 0;

            //down movement
            if (isValid(y + 1, x)) {
                if (m.maze[y + 1][x] == 2) {
                    System.out.println("Moved down, You won");
                    return;
                } else if (m.maze[y + 1][x] == 1) {
                    m.path.push(new Position(y + 1, x));
                    System.out.println("Moved down");
                    continue;
                }
            }

            //left
            if (isValid(y, x - 1)) {
                if (m.maze[y][x - 1] == 2) {
                    System.out.println("Moved left, You won");
                    return;
                } else if (m.maze[y][x - 1] == 1) {
                    m.path.push(new Position(y, x - 1));
                    System.out.println("Moved left");
                    continue;
                }
            }

            //right
            if (isValid(y, x + 1)) {
                if (m.maze[y][x + 1] == 2) {
                    System.out.println("Moved right, You won");
                    return;
                } else if (m.maze[y][x + 1] == 1) {
                    m.path.push(new Position(y, x + 1));
                    System.out.println("Moved right");
                    continue;
                }
            }

            //up
            if (isValid(y - 1, x)) {
                if (m.maze[y - 1][x] == 2) {
                    System.out.println("Moved up, You won");
                    return;
                } else if (m.maze[y - 1][x] == 1) {
                    m.path.push(new Position(y - 1, x));
                    System.out.println("Moved up");
                    continue;
                }
            }

            m.path.pop();
            System.out.println("Moved back");
            if (m.path.size() <= 0) {
                System.out.println("No path");
                return;
            }
        }
    }

    public static boolean isValid(int y, int x) {
        if (y < 0 ||
            y >= m.maze.length ||
            x < 0 ||
            x >= m.maze[y].length) {
            return false;
        }
        return true;
    }
}