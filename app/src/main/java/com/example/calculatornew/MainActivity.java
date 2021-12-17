package com.example.calculatornew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.itis.libs.parserng.android.expressParser.MathExpression;

public class MainActivity extends AppCompatActivity {

    Button zero, one, two, three, four, five,
            six, seven, eight, nine, clear, res,
            division, multi, minus, plus;
    EditText operand;
    TextView result;
    String resNumExp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        if (savedInstanceState != null && savedInstanceState.containsKey("str")){
            resNumExp = savedInstanceState.getString("str");
            result.setText(resNumExp);
        }
    }

    public void onClickNum(View v){
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        clear = findViewById(R.id.clear);
        operand = findViewById(R.id.operand);
        if (v.getId() == zero.getId()){
            operand.setText(operand.getText().toString() + "0");
        }
        else if(v.getId() == one.getId()){
            operand.setText(operand.getText().toString() + "1");
        }
        else if(v.getId() == two.getId()){
            operand.setText(operand.getText().toString() + "2");
        }
        else if(v.getId() == three.getId()){
            operand.setText(operand.getText().toString() + "3");
        }
        else if(v.getId() == four.getId()){
            operand.setText(operand.getText().toString() + "4");
        }
        else if(v.getId() == five.getId()){
            operand.setText(operand.getText().toString() + "5");
        }
        else if(v.getId() == six.getId()){
            operand.setText(operand.getText().toString() + "6");
        }
        else if(v.getId() == seven.getId()){
            operand.setText(operand.getText().toString() + "7");
        }
        else if(v.getId() == eight.getId()){
            operand.setText(operand.getText().toString() + "8");
        }
        else if(v.getId() == nine.getId()){
            operand.setText(operand.getText().toString() + "9");
        }
        else if(v.getId() == clear.getId()){
            operand.setText("");
        }
    }

    public void onClickMath(View v){
        res = findViewById(R.id.res);
        division = findViewById(R.id.division);
        multi = findViewById(R.id.multi);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        operand = findViewById(R.id.operand);
        result = findViewById(R.id.result);
        if(v.getId() == division.getId()){
            operand.setText(operand.getText().toString() + "/");
        }
        else if(v.getId() == multi.getId()){
            operand.setText(operand.getText().toString() + "*");
        }
        else if(v.getId() == minus.getId()){
            operand.setText(operand.getText().toString() + "-");
        }
        else if(v.getId() == plus.getId()){
            operand.setText(operand.getText().toString() + "+");
        }
    }

    public void onClickRes(View v){
        res = findViewById(R.id.res);
        operand = findViewById(R.id.operand);
        result = findViewById(R.id.result);
        String resNum;
        resNum = operand.getText().toString();
        MathExpression exprNum = new MathExpression(resNum);
        resNumExp = exprNum.solve();
        result.setText(resNumExp);
    }

    @Override
    public void onSaveInstanceState(Bundle bundle){
        bundle.putString("str", resNumExp);
        super.onSaveInstanceState(bundle);
    }
}