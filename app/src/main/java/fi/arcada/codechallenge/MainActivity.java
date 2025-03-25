package fi.arcada.codechallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    TextView myText;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = findViewById(R.id.text);
        myText.setText("Hej");


        ArrayList<Double> nummer = new ArrayList<Double>();
        nummer.add(5.5);
        nummer.add(5.6);
        nummer.add(5.7);
        nummer.add(5.8);

        myButton = findViewById(R.id.button);

       myButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               calculate(nummer);
           }
       });
    }

    private void calculate(ArrayList<Double> num) {
        double mean = Statistics.calcMean(num);
        myText.setText(Double.toString(mean));

    }
}