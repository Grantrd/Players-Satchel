package com.example.playerssatchel;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import android.content.Context;

public class Character extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_character);
//    }
    private AlertDialog dialog;
    private AlertDialog.Builder charactersheet;
    //EditText stats;
    String filename = "thing.txt";
    String name;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
//    public Character() {
//    }
    public Character(String name, int strength, int dexterity, int constitution, int intelligence,
                     int wisdom, int charisma) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public String getName() {
        return name;
    }

    public void character_sheet(View view) {
        charactersheet = new AlertDialog.Builder(this);
        final View statPopupView = getLayoutInflater().inflate(R.layout.statsheet, null);
        charactersheet.setView(statPopupView);
        dialog = charactersheet.create();
        dialog.show();
    }

//    public void save_character(View view) {
//        FileOutputStream fos;
//        try {
//            fos = openFileOutput(filename, MODE_PRIVATE);
//            fos.write("this is a test".getBytes());
//            Toast.makeText(this, "saved to " + getFilesDir() + "/" + filename, Toast.LENGTH_LONG).show();
//            fos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void print(Context co, View view) {
        FileOutputStream fos = null;
        try {
            fos = co.openFileOutput(filename, 0);
            //Toast.makeText(getBaseContext(), "Saved to "+ getFilesDir() + "/" + filename, Toast.LENGTH_LONG).show();
            //Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
            fos.write(this.name.getBytes());

            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String load_character(String filename) {
        FileInputStream fis = null;
        String stats = "open";
        try {
            fis = openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((stats = br.readLine()) != null){
                sb.append(stats).append("\n");
            }
            //stats.setText(sb.toString());
            stats = sb.toString();
            if (fis != null){
                fis.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stats;
    }
//    public void print(View view){
//
//
//    }
    //EditText simpleEditText = (EditText) findViewById(R.id.simpleEditText);
    //String editTextValue = simpleEditText.getText().toString();
}

