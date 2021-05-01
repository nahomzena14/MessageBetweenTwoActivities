package com.example.messagebetweenactivties;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.messagebetweenactivties.MainActivity.READ_KEY;
import static com.example.messagebetweenactivties.MainActivity.REQUEST_CODE;


public class Second_activity extends AppCompatActivity {

    EditText editText2;
    TextView textView2;
    AppCompatButton send_button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String message = getIntent().getStringExtra(READ_KEY);

        if(message == null)
            Log.d("TAG_X", "null message");
        else
            Log.d("TAG_X", message);
        setContentView(R.layout.second_activity);
        textView2 = findViewById(R.id.message_textView2);
        textView2.setText(message);
        editText2 = findViewById(R.id.message_editText2);
        send_button2 = findViewById(R.id.send_message_button2);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(READ_KEY, editText2.getText().toString());
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Log.d("TAG_X", "READ " + requestCode);
        Log.d("TAG_X", "REQUEST " + REQUEST_CODE);
        if(REQUEST_CODE == requestCode){
            //textView2.setText(data.getStringExtra(READ_KEY));
            textView2.setText("YO 2222");
        }
    }


}