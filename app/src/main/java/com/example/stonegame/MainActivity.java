package com.example.stonegame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView[] tv= new TextView[5];
    Button[][]  buttons= new Button[5][5];
    String[] colors= {"#42c5f5","#4272f5","#bc42f5","#f542dd","#f54266"};
    Button[] moveButtons= new Button[5];
    Button saveButton;
    boolean activePlayer=true;
    TextView tvTurn;
    TextView tvWinner;


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<5;i++)
        {
            String btnid= "btn"+i;
            int resourceId= getResources().getIdentifier(btnid,"id",getPackageName());
            tv[i]=(TextView) findViewById(resourceId);

        }


        for(int i=0;i<5;i++)
        {
            final int index=i;
            String btnid= "btnClick"+i;
            int resourceId= getResources().getIdentifier(btnid,"id",getPackageName());
            moveButtons[i]=(Button) findViewById(resourceId);
            moveButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int temp = Integer.parseInt(tv[index].getText().toString());
                    if(temp !=0) {
                        tv[index].setText(String.valueOf(temp - 1));

                        for (int j = 0; j < 5; j++) {
                            buttons[index][j].setBackgroundColor(Color.parseColor("#fafafa"));
                        }
                        generateColors();
                    }
                }
            });
        }

        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                String btnid= "btn"+i+j;
                int resourceId= getResources().getIdentifier(btnid,"id",getPackageName());
                buttons[i][j]=(Button) findViewById(resourceId);
            }

        }
        saveButton=findViewById(R.id.btnSave);
        tvTurn=findViewById(R.id.tvTurnActual);
        tvWinner=findViewById(R.id.tvWinnerActual);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean winner = checkWinner();
                if (winner==true) {
                    if (activePlayer) {
                        tvWinner.setText("Player 1");
                    } else {
                        tvWinner.setText("Player 2");
                    }
                }

                else {
                    activePlayer = !activePlayer;
                    if (!activePlayer) {
                        tvTurn.setText("Player 2");
                    } else {
                        tvTurn.setText("Player 1");
                    }
                }
            }
        });




    }

    private boolean checkWinner() {
        int sum=0;
        for(int i=0;i<5;i++)
        {
            sum+= Integer.parseInt(tv[i].getText().toString());
        }
        if(sum==0)
        {
            return true;
        }
        return false;


    }


    private void startGame() {
        Random random= new Random();
        for(int i=0;i<5;i++)
        {
            int c= random.nextInt(6);
            if(c==0)c+=1;

            tv[i].setText(String.valueOf(c));
        }
        generateColors();



    }

    private void generateColors() {

        for(int i=0;i<5;i++)
        {
            int c=Integer.parseInt(tv[i].getText().toString());
            for(int j=0;j<c;j++)
            {
                buttons[i][j].setBackgroundColor(Color.parseColor(colors[i]));
            }


        }
    }

    public void resetGame0(View view) {
        resetGame();
    }
    public void resetGame() {
        clearEverything();
        startGame();
    }

    private void clearEverything() {
        for(int i=0;i<5;i++)
        {
            int c=0;
            tv[i].setText(String.valueOf(c));
        }

        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                buttons[i][j].setBackgroundColor(Color.parseColor("#fafafa"));
            }
        }


    }


    public void startGame0(View view) {
        startGame();
    }
}