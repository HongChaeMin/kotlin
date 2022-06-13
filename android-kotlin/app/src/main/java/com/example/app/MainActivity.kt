package com.example.app

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 5. 내부 익명 함수
        val button = findViewById<Button>(R.id.button);

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0 : View?) {
                // TODO...
            }
        });

        // 내부 익명 함수를 사용하기 위한 조건
        // 1. kotlin.interface 가 아닌 java interface 여야 한다
        // 2. 그 interface 는 딱 하나이 메소드만 가져야 한다

        button.setOnClickListener {
            // TODO...
        };
    }

}