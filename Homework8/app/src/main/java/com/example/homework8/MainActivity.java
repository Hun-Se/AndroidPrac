package com.example.homework8;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// 1. 강아지 클래스 만들고 만들기 할때마다 생성하기
// * 첫 이미지 뷰에는 이미지들이 없어야 한다.
// 2. 강아지 개수 출력하는 TextView, 선택된 강아지 이미지 생성하는 이미지 뷰 3개
// 3. 강이지 선택하면 보여주는 큰 이미지뷰 1개 + 이름 번호 출력하는 textView
// 4. 강버튼 누를때마다 생성
// 5. selcted 변수 -> index 번호 -> 이미지를 선택할때 셀렉트 번호를 알 수 있나? -> 강아지 생성시 id에 + selected 번호 부여

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}