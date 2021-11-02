package com.example.playerssatchel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.content.Context;

public class Manage extends AppCompatActivity {
    String filename = "thing.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
    }
    public void print (View view){
        Character carl = new Character("carl", 1, 2, 3, 4, 5 , 6);
        carl.print(this.getApplicationContext(), view);
        Toast.makeText(this, carl.getName()+ getFilesDir() + "/" + filename, Toast.LENGTH_LONG).show();
    }

}