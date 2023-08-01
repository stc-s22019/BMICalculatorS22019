package jp.suntech.s22019.bmicalculators22019;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight;
    private EditText editTextHeight;

    private EditText editTextAge;
    private Button buttonCalculate;
    private Button buttonclear;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextAge = findViewById(R.id.editTextAge);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
        buttonclear = findViewById(R.id.clearName);
        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            textViewResult.setText("体重と身長を入力してください。");
            return;
        }

        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr) / 100; // cmからmに変換

        float bmi = weight / (height * height);

        String resultText = "あなたのBMIは " + String.format("%.2f", bmi);
        textViewResult.setText(resultText);
    }
    private void clearFields() {
        editTextWeight.setText("");
        editTextHeight.setText("");
        editTextAge.setText("");
        textViewResult.setText("");
    }
}