package com.example.test1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 화면에 보이고 있는 동안에는 계속 유지된다.
    TextView output1;
    EditText input1;
    ImageView imageView;


    // 화면이 보이기 전에 한 번 실행됨
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // R은 res를 뜻한다. layout의 xml과 연결되어있다는것을 뜻한다.

        // 화면에 보이는 붕어빵들은 화면이 보이기 전에 이미 메모리에 만들어진다.
        // 붕어빵을 찾아서 변수상자에 넣어준다.
        output1 = findViewById(R.id.output1);
        this.input1 = findViewById(R.id.input1);
        imageView = findViewById(R.id.imageView);

        // 버튼을 눌렀을 때 동작할 기능을 예ㅇ약하기
        Button button = findViewById(R.id.button3);
        button.setOnClickListener(view -> {
            // 화면이 보인 이후에 사용자가 버튼을 누르면 이 중괄호 안에 코드가 실행됨
            String name = input1.getText().toString();
            //output1.setText(name);
            imageView.setImageResource(R.drawable.robout2);

            Dog dog1 = new Dog(name, 1);
            output1.setText("강아지 이름 : " + dog1.name);

        });
    }
}