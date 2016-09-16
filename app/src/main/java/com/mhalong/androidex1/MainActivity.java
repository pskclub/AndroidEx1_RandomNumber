package com.mhalong.androidex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int countNumber;
    private int Number = 0;
    private int Num = 0;

    EditText edtNumber;
    TextView tvCount;
    TextView tvMin;
    TextView tvMax;
    TextView tvRandomNumber;
    Button btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMin = (TextView) findViewById(R.id.tvMin);
        tvRandomNumber = (TextView) findViewById(R.id.tvRandomNumber);
        tvMax = (TextView) findViewById(R.id.tvMax);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        tvCount = (TextView) findViewById(R.id.tvCount);
        btnRandom = (Button) findViewById(R.id.btnRandom);
        Number = randomNumber();
        tvCount.setText(Integer.toString(countNumber));


        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvCount.setText(countNumber + "");
                try {
                    Num = Integer.parseInt(edtNumber.getText().toString());

                    if (Number == Num) {
                        countNumber = 0;
                        randomNumber();
                        Toast.makeText(MainActivity.this, "GGWP", Toast.LENGTH_SHORT).show();
                        tvCount.setText(countNumber + "");
                        edtNumber.setText("");
                        tvMin.setText("0");
                        tvMax.setText(100 + "");
                    } else if (countNumber > 4) {
                        randomNumber();
                        countNumber = 0;
                        tvCount.setText(countNumber + "");
                        Toast.makeText(MainActivity.this, "KAK MAK MAK LEY WA", Toast.LENGTH_LONG).show();
                        edtNumber.setText("");
                        tvMin.setText("0");
                        tvMax.setText("100");
                    } else if (Number > Num) {
                        tvMin.setText(Num + "");
                        Toast.makeText(MainActivity.this, "Your Number less than", Toast.LENGTH_SHORT).show();
                        countNumber += 1;
                        tvCount.setText(countNumber + "");
                        edtNumber.setText("");
                    } else if (Number < Num) {
                        tvMax.setText(Num + "");
                        Toast.makeText(MainActivity.this, "Your Number more than", Toast.LENGTH_SHORT).show();
                        countNumber += 1;
                        tvCount.setText(countNumber + "");
                        edtNumber.setText("");
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "ใส่ตัวเลขก่อน", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


    private int randomNumber() {
        Random random = new Random();
        Number = random.nextInt(101);
        tvRandomNumber.setText(Number + "");
        return Number;
    }
}
