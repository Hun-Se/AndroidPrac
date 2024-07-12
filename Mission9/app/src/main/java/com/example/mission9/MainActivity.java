package com.example.mission9;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText input1;

    TextView output1;
    TextView output2;
    TextView output3;
    TextView output4;
    TextView output5;
    TextView output6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
    }

    void init() {

        input1 = findViewById(R.id.input1);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);
        output4 = findViewById(R.id.output4);
        output5 = findViewById(R.id.output5);
        output6 = findViewById(R.id.output6);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {

            makeNumbers();


        });


    }

    void makeNumbers() {

        String People = input1.getText().toString();

        int input1 = 0;

        try {
            input1 = Integer.parseInt(People);

        } catch (Exception e) {
            e.printStackTrace();
        }

        int[] outputsNum = new int[6];

        for(int i = 0; i < 6; i++) {
            double ran = Math.floor(Math.random() * input1);
            outputsNum[i] = (int)(Math.random() * input1);
            for(int j = 0; j < i; j++) {
                if (outputsNum[j] == outputsNum[i]) {
                    i--;
                    break;
                }

            }
        }

        output1.setText(output1);
        ArrayList<TextView> outputlist = new ArrayList();


//        for (int i = 0; i < outputs.length; i ++) {
//            int randomNum = new Double(Math.floor(Math.random() * input1)).intValue();
//            System.out.println(Math.floor(Math.random() * input1));
//            System.out.println(randomNum);
//            if (outputs.equals(randomNum)) {
//               boolean duplicate = true;
//                while (duplicate) {
//                    System.out.println("증복 발생");
//                   int newRandom = new Double(Math.floor(Math.random() * input1)).intValue();
//                    duplicate = outputs.equals(newRandom);
//               }
//            } else {
//                outputs[i].setText(randomNum);
//            }
//            outputs[i].setText(String.valueOf(randomNum));
//        }




//        double ran1 = Math.floor(Math.random() * input1);
//        double ran2 = Math.floor(Math.random() * input1);
//        double ran3 = Math.floor(Math.random() * input1);
//        double ran4 = Math.floor(Math.random() * input1);
//        double ran5 = Math.floor(Math.random() * input1);
//        double ran6 = Math.floor(Math.random() * input1);

//        int no3 = new Double(ran1).intValue();
//        int no4 = new Double(ran2).intValue();
//        int no5 = new Double(ran3).intValue();
//        int no6 = new Double(ran4).intValue();
//        int no7 = new Double(ran5).intValue();
//        int no8 = new Double(ran6).intValue();


//        output1.setText("" + no3);
//        output2.setText("" + no4);
//        output3.setText("" + no5);
//        output4.setText("" + no6);
//        output5.setText("" + no7);
//        output6.setText("" + no8);

    }
}
