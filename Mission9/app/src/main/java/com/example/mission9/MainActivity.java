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

    TextView textView10;


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

        textView10 = findViewById(R.id.textView10);

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


        String[] textList = new String[6];
        // 6 이하일때는 무한루프 발생
        if (input1 > 6) {

            for (int i = 0; i < textList.length; i++) {
                System.out.println(i);
                textList[i] = Integer.toString((int)(Math.random() * input1 + 1));
                for (int j = 0; j < i; j++) {
                    if (textList[i].equals(textList[j])) {
                        System.out.println("중복발생");
                        i--;
                        break;
                    }
                }
            }


        } else {
            for (int i = 0; i < textList.length-(textList.length-input1); i++) {
                System.out.println(i);
                textList[i] = Integer.toString((int)(Math.random() * input1 + 1));
                for (int j = 0; j < i; j++) {
                    if (textList[i].equals(textList[j])) {
                        System.out.println("중복발생");
                        i--;
                        break;
                    }
                }
            }

            // 나머지 "" 넣기
            for (int i = 6; (i-input1) < 0; i--) {
                textList[i-1] = "";
            }
        }

        TextView[] outputList = {output1, output2, output3, output4, output5, output6};

        for(int i = 0; i < outputList.length; i++) {
            outputList[i].setText(textList[i]);
        }

//        ArrayList<String> textList = new ArrayList<String>();
//
//        if (input1 > 6) {
//            for (int i = 0; i < 6; i++) {
//                String numStr = ("" + (int) ((Math.random() * input1) + 1));
//                if (textList.contains(numStr)) {
//                    i--; // 중복 발생 시 재반복을 위해 i를 1 감소
//                    continue; // 아래 로직을 수행하지 않고 다음 순환 으로 넘어감(다음 i로 넘어간다)
//                }
//                textList.add(numStr);
//            }
//        } else {
//            for (int i = 0; i < input1; i++) {
//                String numStr = ("" + (int) ((Math.random() * input1) + 1));
//                if (textList.contains(numStr)) {
//                    i--; // 중복 발생 시 재반복을 위해 i를 1 감소
//                    continue; // 아래 로직을 수행하지 않고 다음 순환 으로 넘어감(다음 i로 넘어간다)
//                }
//                textList.add(numStr);
//            }
//            // 남은 자리를 null로 채우기
//            while (textList.size() < 6) {
//                textList.add(null);
//            }
//        }
//
//        TextView[] outputList = {output1, output2, output3, output4, output5, output6};
//
//        for(int i = 0; i < outputList.length; i++) {
                // 삼항 연산자 -> 조건 ? true 일때 : false 일때
//            outputList[i].setText(textList.get(i) != null ? textList.get(i): "");
//        }5
    }
}
