package com.example.playerssatchel;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Character extends AppCompatActivity {
    private AlertDialog dialog;
    private AlertDialog.Builder charactersheet;
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
                     int wisdom, int charisma){
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
//    public void character_sheet(View view){
//        charactersheet = new AlertDialog.Builder(this);
//        final View statPopupView = getLayoutInflater().inflate(R.layout.statsheet, null);
//        charactersheet.setView(statPopupView);
//        dialog = charactersheet.create();
//        dialog.show();
//    }

    //EditText simpleEditText = (EditText) findViewById(R.id.simpleEditText);
    //String editTextValue = simpleEditText.getText().toString();
}
