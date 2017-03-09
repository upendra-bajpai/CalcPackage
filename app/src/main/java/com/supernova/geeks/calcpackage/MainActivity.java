package com.supernova.geeks.calcpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.value;
import static com.supernova.geeks.calcpackage.R.id.log;

public class MainActivity extends AppCompatActivity {
    Calculators mCalculator= new Calculators();
    private String currentDisplayedInput = "";
    private String inputToBeParsed = "";

    private String outputResult;


    private EditText displayResult;
    private EditText displayFormula;
    private EditText displayShift;
    private static String PREFS_NAME = "memory";
    Boolean isInverse = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sinInverse = (Button) findViewById(R.id.sin);
        assert sinInverse != null;
        sinInverse.setText(Html.fromHtml(Helper.inverseSin));
        Button logButton = (Button) findViewById(log);
        assert logButton != null;
        logButton.setText(Html.fromHtml(Helper.tenPowerX));
        Button cube = (Button) findViewById(R.id.cube);
        assert cube != null;
        cube.setText(Html.fromHtml(Helper.cubeRoot));
        Button square = (Button) findViewById(R.id.square);
        assert square != null;
        square.setText(Html.fromHtml(Helper.xSquare));
        Button power = (Button) findViewById(R.id.power);
        assert power != null;
        power.setText(Html.fromHtml(Helper.yPowerX));
        Button logBaseE = (Button) findViewById(R.id.ln);
        assert logBaseE != null;
        logBaseE.setText(Html.fromHtml(Helper.exponential));
        Button cosInverse = (Button) findViewById(R.id.cos);
        assert cosInverse != null;
        cosInverse.setText(Html.fromHtml(Helper.inverseCos));
        Button tanInverse = (Button) findViewById(R.id.tan);
        assert tanInverse != null;
        tanInverse.setText(Html.fromHtml(Helper.inverseTan));
        Button combination = (Button) findViewById(R.id.combination);
        assert combination != null;
        combination.setText(Html.fromHtml(Helper.combination));
        Button pi = (Button) findViewById(R.id.exponatial);
        assert pi != null;
        pi.setText(Html.fromHtml(Helper.pi));
        Button fact=(Button) findViewById(R.id.factorial);
        assert fact != null;
        fact.setText((Html.fromHtml(Helper.factorial)));
        Button point=(Button)findViewById(R.id.point);
        assert point != null;
        point.setText(Html.fromHtml(Helper.point));


        displayResult = (EditText) findViewById(R.id.displayResult);
        displayFormula = (EditText) findViewById(R.id.displayFormula);
        displayShift = (EditText) findViewById(R.id.displayShift);


    }

    public void onButtonClick(View v) {

        // Button button = (Button) v;

        switch (v.getId()) {
            case R.id.ac:
                displayFormula.setText("");
                currentDisplayedInput = "";
                inputToBeParsed = "";
                clearMemoryStorage(MainActivity.this);
                //Log.d("tony","ac");

                break;
            case R.id.del:

                String enteredString = displayFormula.getText().toString();
                if (enteredString.length() > 0) {
                    enteredString = enteredString.substring(0, enteredString.length() - 1);
                    currentDisplayedInput = enteredString;

                }
                break;
            case R.id.equal:

                String enteredInput = displayFormula.getText().toString();
                // call a function that will return the result of the calculate.
                String resultObject = mCalculator.getResult(currentDisplayedInput, inputToBeParsed);
                Log.d("tony",resultObject);
                displayResult.setText(removeTrailingZero(resultObject));
                Log.d("tony", "eql");

                break;


            case R.id.zero:
                currentDisplayedInput += "0";
                inputToBeParsed += "0";
                break;

            case R.id.one:
                currentDisplayedInput += "1";
                inputToBeParsed += "1";
                break;
            case R.id.two:

                currentDisplayedInput += "2";
                inputToBeParsed += "2";

                //toggleInverse();
                //toggleShiftButton();
                break;
            case R.id.three:
                currentDisplayedInput += "3";
                inputToBeParsed += "3";
                break;


            case R.id.four:
                currentDisplayedInput += "4";
                inputToBeParsed += "4";
                break;


            case R.id.five:
                currentDisplayedInput += "5";
                inputToBeParsed += "5";
                break;

            case R.id.six:
                currentDisplayedInput += "6";
                inputToBeParsed += "6";
                break;


            case R.id.seven:
                currentDisplayedInput += "7";
                inputToBeParsed += "7";
                break;


            case R.id.eight:
                currentDisplayedInput += "8";
                inputToBeParsed += "8";
                break;

            case R.id.nine:
                currentDisplayedInput += "9";
                inputToBeParsed += "9";
                break;


            case R.id.sin:
                if (isInverse) {
                    currentDisplayedInput += "asin(";
                    inputToBeParsed += "asin(";
                } else {
                    currentDisplayedInput += "sin(";
                    inputToBeParsed += "sin(";

                }
                toggleInverse();
                toggleShiftButton();
                break;


            case R.id.cos:
                if (isInverse) {
                    currentDisplayedInput += "acos(";
                    inputToBeParsed += "acos(";
                } else {
                    currentDisplayedInput += "cos(";
                    inputToBeParsed += "cos(";
                }
                toggleInverse();
                toggleShiftButton();
                break;

            case R.id.tan:
                if (isInverse) {
                    currentDisplayedInput += "atan(";
                    inputToBeParsed += "tan(";
                } else {
                    currentDisplayedInput += "tan(";
                    inputToBeParsed += "tan(";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case R.id.combination:
                if (isInverse) {
                    currentDisplayedInput += "permu(";
                    inputToBeParsed += "permu(";

                } else {
                    currentDisplayedInput += "comb(";
                    inputToBeParsed += "comb(";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case R.id.factorial:
                if (isInverse) {
                    currentDisplayedInput += "x";
                    inputToBeParsed += "1/x";

                } else {
                    currentDisplayedInput += "!";
                    inputToBeParsed += "!";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case R.id.square:
                if (!isInverse) {
                    currentDisplayedInput += "^2";
                    inputToBeParsed += "^2";

                } else {
                    currentDisplayedInput += "√(";
                    inputToBeParsed += "sqrt(";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case R.id.log:
                if (!isInverse) {
                    currentDisplayedInput += "log(";
                    inputToBeParsed += "log(";

                } else {
                    currentDisplayedInput += "10^";
                    inputToBeParsed += "10^";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case R.id.cube:
                if (!isInverse) {
                    currentDisplayedInput += "^3";
                    inputToBeParsed += "^3";

                } else {
                    currentDisplayedInput += "3√(";
                    inputToBeParsed += "crt(";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case R.id.power:
                if (!isInverse) {
                    currentDisplayedInput += "^";
                    inputToBeParsed += "^";

                } else {
                    currentDisplayedInput += "√(";
                    inputToBeParsed += "power(";
                }
                toggleInverse();
                toggleShiftButton();
                break;
            case R.id.ln:
                if (!isInverse) {
                    currentDisplayedInput += "ln(";
                    inputToBeParsed += "ln(";

                } else {
                    currentDisplayedInput += "e^";
                    inputToBeParsed += "e^";
                }
                toggleInverse();
                toggleShiftButton();
                break;

            case R.id.rbracket:
                currentDisplayedInput += "(";
                inputToBeParsed += "(";
                break;
            case R.id.lbarket:
                currentDisplayedInput += ")";
                inputToBeParsed += ")";
                break;
            case R.id.plus:
                currentDisplayedInput += "+";
                inputToBeParsed += "+";
                break;
            case R.id.minus:
                currentDisplayedInput += "-";
                inputToBeParsed += "-";
                break;
            case R.id.multiply:
                currentDisplayedInput += "*";
                inputToBeParsed += "*";
                break;
            case R.id.devide:
                currentDisplayedInput += "/";
                inputToBeParsed += "/";
                break;
            case R.id.percentage:
                currentDisplayedInput += "%";
                inputToBeParsed += "%";
                break;

//BUTTON LIKE TOGGLE HANDLING
            case R.id.shift:
                if (!isInverse) {
                    isInverse = true;
                } else {
                    isInverse = false;
                }
                toggleShiftButton();
                break;

            case R.id.sett:
                displayShift.setText("underdev");
                break;
            case R.id.checkup:
                displayShift.setText("soon");
                break;

            case R.id.checkdn:
                displayShift.setText("available");
                break;

        }
        displayFormula.setText(currentDisplayedInput);
    }

    private void clearMemoryStorage(Context context) {
        setPreference(context, 0);
    }

    private boolean setPreference(Context c, float value) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, 0);
        settings = c.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat("key", value);
        return editor.commit();
    }
    private String getStoredPreferenceValue(Context context){
        float returnedValue = getPreference(context);
        return String.valueOf(returnedValue);
    }
    static public float getPreference(Context c) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, 0);
        settings = c.getSharedPreferences(PREFS_NAME, 0);
        float value = settings.getFloat("key", 0);
        return value;
    }

    private void toggleInverse() {
        if (isInverse)
            isInverse = false;
    }

    private void toggleShiftButton() {
        if (isInverse) {
            displayShift.setText("SHIFT");


        } else {
            displayShift.setText("");
        }
    }


    private String removeTrailingZero(String formattingInput) {
        if (!formattingInput.contains(".")) {
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue = formattingInput.substring(dotPosition, formattingInput.length());
        if (newValue.equals(".0")) {
            return formattingInput.substring(0, dotPosition);
        }
        return formattingInput;

    }
}