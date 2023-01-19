package com.example.navdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.navdemo.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityLoginBinding binding;
    SharedPreferences userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnStudent.setOnClickListener(this);
        binding.btnTeacher.setOnClickListener(this);
        binding.btnError.setOnClickListener(this);
        userInfo = getSharedPreferences("userInfo",MODE_PRIVATE);
    }


    @Override
    public void onClick(View v) {
        String utype="";
        switch (v.getId()) {
            case R.id.btnStudent:
                utype = "student";
                break;
            case R.id.btnTeacher:
                utype = "teacher";
                break;
            case R.id.btnError:
                utype = "!!!!";
                break;
        }
        userInfo.edit().putString("cate", utype).apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}