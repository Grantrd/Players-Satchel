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

public class Character extends AppCompatActivity {
    private AlertDialog dialog;
    private AlertDialog.Builder charactersheet;
    EditText stats;
    String name;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_create);
//
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

    public void save_character(View view) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(name+".txt", MODE_PRIVATE);
            fos.write(name.getBytes(StandardCharsets.UTF_8));
            Toast.makeText(this, "saved to " + getFilesDir() + "/" + name, Toast.LENGTH_LONG);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load_character(View view) {
        FileInputStream fis = null;
        try {
            fis = openFileInput(name+".txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null){
                //sb.append(text).append("\n");
            }
            stats.setText(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //EditText simpleEditText = (EditText) findViewById(R.id.simpleEditText);
    //String editTextValue = simpleEditText.getText().toString();
}

