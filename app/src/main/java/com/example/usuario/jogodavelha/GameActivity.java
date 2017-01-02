package com.example.usuario.jogodavelha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by USUARIO on 04/05/2016.
 */
public class GameActivity extends AppCompatActivity{

    String jogador = ""; // recebe o valor selecionado na primeira view com o nome do jogador que fará o primeiro movimento
    Board board = new Board(); //controla o jogo
    boolean jogoComecou = false; //controla o inicio/fim do jogo
    boolean vezJogador = false; // controla se é a vez do jogador ou não

    // Cria a tela do jogo e o array de botões
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        board.buttons[0][0] = (Button) findViewById(R.id.button_00);
        board.buttons[0][1] = (Button) findViewById(R.id.button_01);
        board.buttons[0][2] = (Button) findViewById(R.id.button_02);
        board.buttons[1][0] = (Button) findViewById(R.id.button_10);
        board.buttons[1][1] = (Button) findViewById(R.id.button_11);
        board.buttons[1][2] = (Button) findViewById(R.id.button_12);
        board.buttons[2][0] = (Button) findViewById(R.id.button_20);
        board.buttons[2][1] = (Button) findViewById(R.id.button_21);
        board.buttons[2][2] = (Button) findViewById(R.id.button_22);

        Intent intent = getIntent();
        jogador = intent.getStringExtra("jogador");

        for(int i = 0; i < board.buttons.length;i++)
        {
            for(int j = 0; j < board.buttons[0].length;j++)
            {
                board.buttons[i][j].setText("");
            }
        }
    }

    public void jogada_00(View view) {

        if(jogoComecou)
        {
            if (vezJogador)
            {
                if(!board.isGameOver())
                {
                    int x = 0;
                    int y = 0;
                    if (board.buttons[x][y].getText().toString().equals(""))
                    {
                        jogar(x, y);
                    }
                }
            }
        }
    }

    public void jogada_01(View view) {

        if(jogoComecou)
        {
            if (vezJogador)
            {
                if(!board.isGameOver())
                {
                    int x = 0;
                    int y = 1;
                    if (board.buttons[x][y].getText().toString().equals(""))
                    {
                        jogar(x, y);
                    }
                }
            }
        }
    }

    public void jogada_02(View view) {

        if(jogoComecou)
        {
            if (vezJogador)
            {
                if(!board.isGameOver())
                {
                    int x = 0;
                    int y = 2;
                    if (board.buttons[x][y].getText().toString().equals(""))
                    {
                        jogar(x, y);
                    }
                }
            }
        }
    }

    public void jogada_10(View view) {

        if(jogoComecou)
        {
            if (vezJogador)
            {
                if(!board.isGameOver())
                {
                    int x = 1;
                    int y = 0;
                    if (board.buttons[x][y].getText().toString().equals(""))
                    {
                        jogar(x, y);
                    }
                }
            }
        }
    }

    public void jogada_11(View view) {

        if(jogoComecou)
        {
            if (vezJogador)
            {
                if(!board.isGameOver())
                {
                    int x = 1;
                    int y = 1;
                    if (board.buttons[x][y].getText().toString().equals(""))
                    {
                        jogar(x, y);
                    }
                }
            }
        }
    }

    public void jogada_12(View view) {

        if(jogoComecou)
        {
            if (vezJogador)
            {
                if(!board.isGameOver())
                {
                    int x = 1;
                    int y = 2;
                    if (board.buttons[x][y].getText().toString().equals(""))
                    {
                        jogar(x, y);
                    }
                }
            }
        }
    }

    public void jogada_20(View view) {

        if(jogoComecou)
        {
            if (vezJogador)
            {
                if(!board.isGameOver())
                {
                    int x = 2;
                    int y = 0;
                    if (board.buttons[x][y].getText().toString().equals(""))
                    {
                        jogar(x, y);
                    }
                }
            }
        }
    }

    public void jogada_21(View view) {

        if(jogoComecou)
        {
            if (vezJogador)
            {
                if(!board.isGameOver())
                {
                    int x = 2;
                    int y = 1;
                    if (board.buttons[x][y].getText().toString().equals(""))
                    {
                        jogar(x, y);
                    }
                }
            }
        }
    }

    public void jogada_22(View view) {

        if(jogoComecou)
        {
            if (vezJogador)
            {
                if(!board.isGameOver())
                {
                    int x = 2;
                    int y = 2;
                    if (board.buttons[x][y].getText().toString().equals(""))
                    {
                        jogar(x, y);
                    }
                }
            }
        }
    }

    public void comecaJogo(View view) {

        if (!jogoComecou){

            if(!board.isGameOver()) {
                if (jogador.equalsIgnoreCase("x")) {
                    Random rand = new Random();
                    Ponto p = new Ponto(rand.nextInt(3), rand.nextInt(3));
                    board.placeAMove(p, 1);
                    replicarBoard();
                }
                jogoComecou = true;
                vezJogador = true;
            }
        }
    }

    private void jogar(int x, int y) {
        Ponto p = new Ponto(x,y);
        board.placeAMove(p, 2);
        vezJogador=false;
        if(!board.isGameOver())
        {
            board.minimax(0,1);
            board.placeAMove(board.computersMove,1);
            if(!board.isGameOver())
            {
                vezJogador = true;
            }
            else
            {
                jogoComecou=false;
                if(board.hasOWon()){
                    TextView txtView = (TextView) findViewById(R.id.text_placar_jogador);
                    int placar = Integer.parseInt(txtView.getText().toString());
                    txtView.setText(String.valueOf(placar + 1));

                }
                if(board.hasXWon()){
                    TextView txtView = (TextView) findViewById(R.id.text_placar_pc);
                    int placar = Integer.parseInt(txtView.getText().toString());
                    txtView.setText(String.valueOf(placar + 1));

                }
            }
        }
        else
        {
            jogoComecou=false;
            if(board.hasOWon()){
                TextView txtView = (TextView) findViewById(R.id.text_placar_jogador);
                int placar = Integer.parseInt(txtView.getText().toString());
                txtView.setText(String.valueOf(placar + 1));

            }
            if(board.hasXWon()){
                TextView txtView = (TextView) findViewById(R.id.text_placar_pc);
                int placar = Integer.parseInt(txtView.getText().toString());
                txtView.setText(String.valueOf(placar + 1));

            }

        }

        replicarBoard();

    }

    public void resetaJogo(View view)  {
        for(int i = 0; i < board.buttons.length;i++)
        {
            for(int j = 0; j < board.buttons[0].length;j++)
            {
                board.buttons[i][j].setText("");
                board.board[i][j] = 0;
            }
        }
        vezJogador = false;
        jogoComecou = false;
    }


    private void replicarBoard(){
        for(int i = 0; i < board.board.length;i++)
        {
            for(int j = 0; j < board.board[0].length;j++)
            {

                if(board.board[i][j] == 1)
                    board.buttons[i][j].setText("x");
                if(board.board[i][j] == 2)
                    board.buttons[i][j].setText("o");
            }
        }


    }
}




