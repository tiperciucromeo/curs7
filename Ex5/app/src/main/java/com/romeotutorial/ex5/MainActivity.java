package com.romeotutorial.ex5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText text;
    public static final String FILE_NAME = "mytext.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText);
    }

    public void createFile(View view)  {
        String txt = text.getText().toString();
        FileOutputStream outputStream = null;

        File file = new File(FILE_NAME);
        try {
            outputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
            outputStream.write(txt.getBytes());
            Toast.makeText(getApplicationContext(),"Fisier creat cu succes!",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
               try {
                   outputStream.close();
               }catch (IOException e){
                   e.printStackTrace();
               }
            }
        }
}
