package fi.arcada.codechallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    TextView myText;
    TextView currentNums;
    EditText inputText;
    Button calcButton;
    Button addButton;

    ArrayList<Double> nummer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = findViewById(R.id.text);
        inputText = findViewById(R.id.inputText);
        currentNums = findViewById(R.id.currentNums);
        calcButton = findViewById(R.id.Calculate);
        addButton = findViewById(R.id.Add);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = inputText.getText().toString();

                if (!input.isEmpty()) {
                    try {
                        double number = Double.parseDouble(input);
                        nummer.add(number);
                        inputText.setText("");

                        StringBuilder currentNumsString = new StringBuilder();
                        for (double num : nummer) {
                            currentNumsString.append(num).append("\n");
                        }
                        currentNums.setText(currentNumsString.toString());

                    } catch (NumberFormatException e) {
                        myText.setText("Please input a valid number!");
                    }
                }
            }
        });

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(nummer);
            }
        });
    }


    private void calculate(ArrayList<Double> num) {
        double calcAverage = Statistics.calcMean(num);
        double calcMax = Statistics.calcMax(num);
        double calcMin = Statistics.calcMin(num);
        double calcMedian = Statistics.calcMedian(num);
        double calcMode = Statistics.calcMode(num);
        double calcStdev = Statistics.calcQR(num);
        double calcLQ = Statistics.calcLQ(num);
        double calcUQ = Statistics.calcUQ(num);
        double calcQR = Statistics.calcQR(num);



        myText.setText("Average: " + Double.toString(calcAverage) + "\n" +
                        "Max: " + Double.toString(calcMax) + "\n" +
                        "Min: " + Double.toString(calcMin) + "\n" +
                        "Median: " + Double.toString(calcMedian) + "\n" +
                        "Mode: " + Double.toString(calcMode) + "\n" +
                        "Standard Dev: " + Double.toString(calcStdev) + "\n" +
                        "LQ: " + Double.toString(calcLQ) + "\n" +
                        "UQ: " + Double.toString(calcUQ) + "\n" +
                        "QR: " + Double.toString(calcQR));

    }
}