package com.example.nathanmorgenstern.rockpaperscissors;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageSwitcher;
import android.widget.Toast;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;
import java.lang.*;




public class MainActivity extends AppCompatActivity {

    private String randMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomMove();
    }

    public void randomMove(){
        Random rand = new Random();
        int num = rand.nextInt(3);

        if(num == 0)
            randMove = "Rock";
        else if(num == 1)
            randMove = "Paper";
        else if(num == 2)
            randMove = "Scissors";
    }

    public void roundResult(String playerChoice, String randomMove) {
        if (playerChoice == "Rock") {
            if (randomMove == "Rock")
                Toast.makeText(this, "It's a Tie!", Toast.LENGTH_SHORT).show();

            else if (randomMove == "Paper")
                Toast.makeText(this, "Sorry, Paper covers Rock!", Toast.LENGTH_SHORT).show();

            else if(randomMove == "Scissors")
                Toast.makeText(this, "You win! Rock smashes Scissors!", Toast.LENGTH_SHORT).show();
        }
        else if (playerChoice == "Paper") {

            if(randomMove == "Paper")
                Toast.makeText(this, "It's a Tie!", Toast.LENGTH_SHORT).show();

            else if(randomMove == "Rock" )
                Toast.makeText(this, "You win! Paper covers Rock!", Toast.LENGTH_SHORT).show();

            else if(randomMove == "Scissors")
                Toast.makeText(this, "Sorry, you lose. Scissors cut Paper!", Toast.LENGTH_SHORT).show();
        }

        else if (playerChoice == "Scissors") {

            if(randomMove == "Scissors")
                Toast.makeText(this, "It's a Tie!", Toast.LENGTH_SHORT).show();

            else if(randomMove == "Rock")
                Toast.makeText(this, "Sorry, you lose. Rock smashes Scissors!", Toast.LENGTH_SHORT).show();

            else if(randomMove == "Paper")
                Toast.makeText(this, "You win! Scissors Cut Paper!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRockClick(View view){
        String choice = "Rock";
        roundResult(choice, randMove);
        setImage("Player", choice);
        setImage("CPU", randMove);
        randomMove();
    }
    public void onPaperClick(View view){
        String choice = "Paper";
        roundResult(choice, randMove);
        setImage("Player", choice);
        setImage("CPU", randMove);
        randomMove();
    }
    public void onScissorsClick(View view){
        String choice = "Scissors";
        roundResult(choice, randMove);
        setImage("Player", choice);
        setImage("CPU", randMove);
        randomMove();
    }



    public void setImage(String player, String move) {

        ImageView imageview = null;
        if(player == "Player"){
            imageview= (ImageView)findViewById(R.id.imageView_player);
        }
        else if(player == "CPU"){
            imageview= (ImageView)findViewById(R.id.imageView_cpu);
        }



        if(move == "Rock"){
            imageview.setImageResource(R.drawable.rock);
        }
        else if(move == "Paper"){
            imageview.setImageResource(R.drawable.paper);
        }
        else if(move == "Scissors"){
            imageview.setImageResource(R.drawable.scissors);
        }
    }
}
