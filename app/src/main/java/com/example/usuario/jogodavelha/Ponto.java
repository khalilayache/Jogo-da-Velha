package com.example.usuario.jogodavelha;

/**
 * Created by USUARIO on 04/05/2016.
 */
public class Ponto {

    int x, y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}