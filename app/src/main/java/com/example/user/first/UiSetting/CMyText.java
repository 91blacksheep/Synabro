package com.example.user.first.UiSetting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.user.first.Home.CHomeClient;
import com.example.user.first.R;

/**
 * Created by USER on 2016-08-10.
 */
public class CMyText extends AppCompatActivity
{
    EditText editText;

    public final static String EXTRA_MESSAGE = "unikys.todo.MESSAGE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_text_dialog);
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, CHomeClient.class);
        editText = (EditText)findViewById(R.id.edtMyText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        finish();
    }
}
