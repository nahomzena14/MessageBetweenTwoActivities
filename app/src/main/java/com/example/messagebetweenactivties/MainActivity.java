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

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 14;
    public static String READ_KEY = "READ";

    EditText editText;
    TextView textView;
    AppCompatButton send_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String message = getIntent().getStringExtra(READ_KEY);
        textView = findViewById(R.id.message_textView);
        if(message != null) textView.setText(message);
        editText = findViewById(R.id.message_editText);
        send_button = findViewById(R.id.send_message_button);
   }

    public void onClick(View view) {
        Intent intent = new Intent(this,Second_activity.class);
        intent.putExtra(READ_KEY,editText.getText().toString());
        startActivityForResult(intent,REQUEST_CODE);
    }

   @Override
   protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       super.onActivityResult(requestCode, resultCode, data);

       Log.d("TAG_X", "READ " + requestCode);
       Log.d("TAG_X", "REQUEST " + REQUEST_CODE);
       if(REQUEST_CODE == requestCode){
           textView.setText(data.getStringExtra(READ_KEY));
       }
   }
}