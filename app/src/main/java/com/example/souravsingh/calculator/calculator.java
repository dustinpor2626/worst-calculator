package com.example.souravsingh.calculator;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calculator extends AppCompatActivity implements View.OnClickListener {



    Button zero,one,two,three,four,five,six,seven,eight,nine,dot,equal,reset;
    Button add,sub,mul,div;
    TextView display;
    String num = "";
    float first_number;
    float initialise_first_number=0;
    String first_second_num = "";
    String operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        dot = (Button) findViewById(R.id.dot);
        equal = (Button) findViewById(R.id.equal);
        reset = (Button) findViewById(R.id.reset);

     display  = (TextView) findViewById(R.id.display);

        listner();
    }

    @Override
 public void onClick(View v)
    {
        String ButtonTypePressed;
        Button b= (Button)v;
        ButtonTypePressed = b.getText().toString();
        num = num + ButtonTypePressed;

            first_second_num = first_second_num + ButtonTypePressed;
            display.setText(num);


            if (ButtonTypePressed.equals("+") || ButtonTypePressed.equals("-") || ButtonTypePressed.equals("*") ||
                    ButtonTypePressed.equals("/") || ButtonTypePressed.equals("="))
            {

                String tempvar = "";

                tempvar = first_second_num.replace(ButtonTypePressed, "");
                float currentnumber = Float.parseFloat(tempvar);
                first_second_num = "";

                if (!ButtonTypePressed.equals("=")) {
                    operation = ButtonTypePressed;

                }


                if (initialise_first_number == 1) {
                    switch (operation) {
                        case "+":
                            first_number = first_number + currentnumber;
                            break;

                        case "-":
                            first_number = first_number - currentnumber;
                            break;

                        case "*":
                            first_number = first_number * currentnumber;
                            break;

                        case "/":
                            first_number = first_number / currentnumber;
                            break;
                    }
                } else {
                    first_number = currentnumber;
                    initialise_first_number++;
                }

                if (ButtonTypePressed.equals("=")) {
                    display.setText(String.valueOf(first_number));
                    num = String.valueOf(first_number);
                    first_second_num = String.valueOf(first_number);
                    initialise_first_number--;
                }

            }

            if (ButtonTypePressed.equals("Reset")) {
                num = "";
                first_second_num = "";
                first_number = 0;
                initialise_first_number = 0;
                operation = "";
                display.setText("0");

            }


            ButtonTypePressed = "";
        }
    

    public void listner()
    {
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        dot.setOnClickListener(this);
        equal.setOnClickListener(this);
        reset.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);


    }
}
