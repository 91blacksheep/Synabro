package com.example.user.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user.first.Loading.Client.CLoading;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(getApplicationContext(), CLoading.class);
        startActivity(intent);
        finish();
    }
}