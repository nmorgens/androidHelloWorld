package com.example.nathanmorgenstern.teenagemutantninjaturtles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private String selected_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDropdownItems();
    }



    public void setDropdownItems() {
        spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.turtle_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // @override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //TextView result = (TextView) findViewById(R.id.turtleText);
                selected_item = spinner.getSelectedItem().toString();
                setImage(selected_item);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ImageView imageview= (ImageView)findViewById(R.id.ninjaTurtle);
                imageview.setImageResource(R.drawable.ninjaturtles);
                //TextView textview = (TextView)findViewById(R.id.turtleText);
                //textview.setText(R.string.NinjaTurtle_Description);
            }
        });

    }
    public void setImage(String selected){

        ImageView imageview  = (ImageView)findViewById(R.id.ninjaTurtle);
        TextView   result    = (TextView)findViewById(R.id.turtleText);

        if(selected.equals("Leonardo")){
            imageview.setImageResource(R.drawable.leonardo);
            result.setText(R.string.Leonardo_Description);
        }
        else if(selected.equals("Donatello")){
            imageview.setImageResource(R.drawable.donatello);
            result.setText(R.string.Dontatello_Description);
        }
        else if(selected.equals("Michelangelo")){
            imageview.setImageResource(R.drawable.michelangelo);
            result.setText(R.string.Michelangelo_Description);
        }
        else if(selected.equals("Raphael")){
            imageview.setImageResource(R.drawable.raphael);
            result.setText(R.string.Raphael_Description);
        }
    }

}