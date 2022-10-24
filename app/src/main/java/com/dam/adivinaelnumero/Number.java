package com.dam.adivinaelnumero;

import java.util.Random;

public class Number {
    public static int MAX = 100;
    public static int MIN = 1;

    public int intentos = 5;
    public int randnum = getRandnum();

    public int getRandnum() {
        Random rd = new Random();
        int randnum = rd.nextInt(MAX - MIN + 1) + MIN;
        return randnum;
    }

    public boolean checkNumber(int num) {
        if (num == randnum) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIntentos() {
        if (intentos > 0) {
            return true;
        } else {
            return false;
        }
    }
}


