package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;
    EditText inputAdultFee;
    EditText inputChildFee;
    EditText nightInput1;
    EditText nightInput2;

    TextView output1;

    TextView timeOutput;

    SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    void init() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(cal.HOUR_OF_DAY);
        System.out.println(cal.getTime());
        System.out.println(hour);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        inputAdultFee = findViewById(R.id.inputAdult);
        inputChildFee = findViewById(R.id.inputChild);
        nightInput1 = findViewById(R.id.nightInput1);
        nightInput2 = findViewById(R.id.nightInput2);

        output1 = findViewById(R.id.output1);

        timeOutput = findViewById(R.id.timeOutput);

        Button calcButton = findViewById(R.id.calcButton);
        calcButton.setOnClickListener(v-> {
            //기본 입장료 계산하기
            calculateBasic();
        });

        // 시작 버튼
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(v -> {

            startTime();
        });
    }

    void startTime() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                // 계속 반복하기
                boolean running = true;
                while(running) {
                    
                    // 현재 시간을 계산해서 화면에 보여주기
                    Date date = new Date();
                    String now = format.format(date);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // 화면에 접근할때
                            timeOutput.setText(now);
                        }
                    });



                    // 1초 동안 쉬기
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }


    void calculateBasic() {
        // 입력상자 2개에서 값을 가져온다.
        String adultCountStr = input1.getText().toString();
        String childCountStr = input2.getText().toString();

        // 숫자로 바꾸기
        int adultCount = 0;
        int childCount = 0;

        try {
            adultCount = Integer.parseInt(adultCountStr);
            childCount = Integer.parseInt(childCountStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 입력상자에서 1인당 요금 가져오기
        int adultFee = 0;
        int childFee = 0;

        adultFee = Integer.parseInt(inputAdultFee.getText().toString());
        childFee = Integer.parseInt(inputChildFee.getText().toString());

        // 기본 입장료 계산하기



        // 할인들
        Date time = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);

        calendar.add(Calendar.HOUR_OF_DAY, +14);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // 계산 + 할인
        int basicFee =  (adultCount * adultFee) + (childCount * childFee);

        if (hour >= 18 && adultCount + childCount >= 5) {
            String nightAdultFeeStr = nightInput1.getText().toString();
            String nightChildFeeStr = nightInput2.getText().toString();

            try {
                adultFee = Integer.parseInt(nightAdultFeeStr);
                childFee = Integer.parseInt(nightChildFeeStr);
            } catch(Exception e) {
                e.printStackTrace();
            }
            basicFee =  ((adultCount * adultFee) + (childCount * childFee)) * 8 /10;

        } else if (adultCount + childCount >= 5) {
            basicFee =  basicFee * 8 / 10;
        } else if (hour >= 18) {
            String nightAdultFeeStr = nightInput1.getText().toString();
            String nightChildFeeStr = nightInput2.getText().toString();

            try {
                adultFee = Integer.parseInt(nightAdultFeeStr);
                childFee = Integer.parseInt(nightChildFeeStr);
            } catch(Exception e) {
                e.printStackTrace();
            }

            basicFee =  ((adultCount * adultFee) + (childCount * childFee));
        }
        
        // 기본 입장료 화면에 보여주기
        String basicFeeStr = String.valueOf(basicFee);

        //숫자에 콤마 붙여주기
        String basicFeeFormatted = formatComma(basicFeeStr);

        output1.setText(basicFeeFormatted);
    }

    String formatComma(String value) {
        String reversedStr = new StringBuilder(value).reverse().toString();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < reversedStr.length(); i++) {
            char out = reversedStr.charAt(i);
            builder.append(out);

            if ((i+1) % 3 == 0 && (i+1) != reversedStr.length()) {
                builder.append(",");
            }
        }

        String basicFeeFormatted = builder.reverse().toString();

        return basicFeeFormatted;
    }
}