package com.example.playerssatchel;

import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Arrays;

public class Create extends AppCompatActivity {

    int c, d;
    private AlertDialog dialog;
    private NumberPicker stat_value;
    int[] stats = {10,10,10,10,10, 10};
    private AlertDialog.Builder statSheet;
    public static final String Player_name = "";
    public static final String Player_stats = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

    }
    public void fillStatSheet(View view){
        statSheet = new AlertDialog.Builder(this);
        final View statPopupView = getLayoutInflater().inflate(R.layout.statsheet, null);
        stat_value = (NumberPicker) statPopupView.findViewById(R.id.statPicker);
        stat_value.setMinValue(1);
        stat_value.setMaxValue(20);
        statSheet.setView(statPopupView);
        dialog = statSheet.create();
        dialog.show();
    }

    public void statSelect(View v){
        int s = v.getId();
        if (s == R.id.stat1 || s == R.id.strength){
            c = (R.id.strength);
            d = 0;
        }
        else if(s == R.id.stat2 || s == R.id.dexterity)
        {
            c = (R.id.dexterity);
            d = 1;
        }
        else if(s == R.id.stat3 || s == R.id.constitution)
        {
            c = (R.id.constitution);
            d = 2;
        }
        else if(s == R.id.stat4 || s == R.id.intelligence)
        {
            c = (R.id.intelligence);
            d = 3;
        }
        else if(s == R.id.stat5 || s == R.id.wisdom)
        {
            c = (R.id.wisdom);
            d = 4;
        }
        else
        {
            c = (R.id.charisma);
            d = 5;
        }
        fillStatSheet(v);
    }
    public void onSave(View view){
        final TextView stat = (TextView) findViewById(c);
        dialog.dismiss();
        stat.setText(String.valueOf(stat_value.getValue()));
        stats[d] = stat_value.getValue();
    }
    public void createCharacter(View view){
//       Character character = new Character("hello", stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
        Toast.makeText(this, "testing", Toast.LENGTH_LONG).show();
       //character.save_character(view);
//       TextView name =(TextView) findViewById(R.id.name);
//       name.setText(character.load_character(view));
       //character.character_sheet(view);
    }








}