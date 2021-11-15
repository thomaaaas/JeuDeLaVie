package com.company;

public class Main {
    static int l = 20;
    public static void main(String[] args) throws InterruptedException {
	    boolean[][] map = new boolean[l][l];
        for (int i = 0; i < (l*l)/2; i++) {
            int x = (int)Math.floor(Math.random()*(l)+0);
            int y = (int)Math.floor(Math.random()*(l)+0);
            while (map[x][y]){
                x = (int)Math.floor(Math.random()*(l)+0);
                y = (int)Math.floor(Math.random()*(l)+0);
            }
            map[x][y] = true;
        }
        while(true){
            print(map);
            map = check(map);
            Thread.sleep(750);
        }
    }

    private static boolean[][] check(boolean[][] map) {
        boolean[][] mapBuffer = new boolean[l][l];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, mapBuffer[i], 0, map[i].length);
        }
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                if (nombreVoisin(map, x, y) == 3) {
                    mapBuffer[x][y] = true;
                }else if (nombreVoisin(map,x,y) == 2) {
                    mapBuffer[x][y] = map[x][y];
                }else if (nombreVoisin(map,x,y) < 2 || nombreVoisin(map,x,y) > 3){
                    mapBuffer[x][y] = false;
                }
            }
        }
        return mapBuffer;
    }

    private static int nombreVoisin(boolean[][] map, int x, int y){
        int nbVoisine = 0;
        if( x+1 < map.length && map[x+1][y]){
            nbVoisine++;
        }
        if(y+1 < map[0].length && map[x][y+1]){
            nbVoisine++;
        }
        if( x-1 >= 0 && map[x-1][y]){
            nbVoisine++;
        }
        if( y-1 >= 0 && map[x][y-1]){
            nbVoisine++;
        }
        if(y+1 < map[0].length && x+1 < map.length && map[x+1][y+1]){
            nbVoisine++;
        }
        if(y-1 >= 0 && x-1 >= 0 && map[x-1][y-1]){
            nbVoisine++;
        }
        if(y-1 >= 0 && x+1 < map.length && map[x+1][y-1]){
            nbVoisine++;
        }
        if(y+1 < map[0].length && x-1 >= 0 && map[x-1][y+1]){
            nbVoisine++;
        }
        return nbVoisine;
    }

    private static void print(boolean[][] map){
        System.out.println("---Nouvelle vague---");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j]){
                    System.out.print("o");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
