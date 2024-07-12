package com.example.timeget;

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
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;
    TextView timeOutput;
    TextView output2;
    EditText feeinput1;
    EditText feeinput2;
    TextView output1;

    int adultFee;
    int childFee;

    SimpleDateFormat format = new SimpleDateFormat("HH");
//    format.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    void init() {
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        timeOutput = findViewById(R.id.timeOutput);
        feeinput1 = findViewById(R.id.feeinput1);
        feeinput2 = findViewById(R.id.feeintput2);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);



        Button calcButton = findViewById(R.id.calcButton);
        calcButton.setOnClickListener(v -> {
            // 기본 입장료 계산하기
            calculateBasic();


        });



    }

    void nightSale() {
        // 입력상자 2개에서 값을 가져오기
        String nightAdultFeeStr = input1.getText().toString();
        String nightChildFeeStr = input2.getText().toString();

        // 숫자로 바꾸기
        int nightAdultFee = 0;
        int nightChildFee = 0;

        try {
            nightAdultFee = Integer.parseInt(nightAdultFeeStr);
            nightChildFee = Integer.parseInt(nightChildFeeStr);
        } catch(Exception e) {
            e.printStackTrace();
        }

        Date time = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);

//        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        calendar.add(Calendar.HOUR_OF_DAY, +9);

        String hour2 = format.format(calendar.getTime());
//        System.out.println(hour2);
        //        String hourStr = format.format(time);
//        int hour = Integer.parseInt(hourStr);
//
//        timeOutput.setText(hourStr);

        timeOutput.setText(hour2);


        adultFee = nightAdultFee;
        childFee = nightChildFee;



//        if (hour > 18) {
//            output2.setText("오후 6시가 넘었습니다.");
//            adultFee = nightAdultFee;
//            childFee = nightChildFee;
//        }else {
//            output2.setText("오후 6시가 아직 안됬습니다.");
//        }

    }

    void calculateBasic() {

        // 입력상자 2개에서 값을 가져오기
        String adultCountStr = feeinput1.getText().toString();
        String childCountStr = feeinput2.getText().toString();

        // 숫자로 바꾸기
        int adultCount = 0;
        int childCount = 0;

        try {
            adultCount = Integer.parseInt(adultCountStr);
            childCount = Integer.parseInt(childCountStr);
        } catch(Exception e) {
            e.printStackTrace();
        }

        // 입력상자에서 1인당 요금 가져오기
        adultFee = 20000;
        childFee = 9900;

        nightSale();

        // 기본 입장료 계산하기
        int basicFee = (adultCount * adultFee + childCount * childFee);

        // 기본 입장료 화면에 보여주기
        String basicFeeStr = String.valueOf(basicFee);
//        output1.setText(new Integer(basicFee).toString());


        output1.setText(basicFeeStr);
    }





}