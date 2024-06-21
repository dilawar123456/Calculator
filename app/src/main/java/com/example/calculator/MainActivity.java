package com.example.calculator;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button_c;
    Button button_sqr;
    Button button_sqr_root;
    Button button_div;
    Button button_mul;
    Button button_min;
    Button button_add;
    Button button_equal;
    Button button_dot;
    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;
    Button button_6;
    Button button_7;
    Button button_8;
    Button button_9;
    Button button_0;
    Button button_addition_info;
    Button button_subtraction_info;
    Button button_multiplication_info;
    Button button_division_info;
    Button button_delete_addition;
    Button button_delete_subtraction;
    Button button_delete_multiplication;
    Button button_delete_division;

    TextView input;
    TextView result;
    int c=0;
    database g = new database(MainActivity.this);







    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        button_c=findViewById(R.id.button_c);
        button_sqr=findViewById(R.id.button_sqr);
        button_sqr_root=findViewById(R.id.button_sqr_root);
        button_div=findViewById(R.id.button_div);
        button_mul=findViewById(R.id.button_mul);
        button_min=findViewById(R.id.button_min);
        button_add=findViewById(R.id.button_add);
        button_equal=findViewById(R.id.button_equal);
        button_dot=findViewById(R.id.button_dot);
        button_0=findViewById(R.id.button_0);
        button_1=findViewById(R.id.button_1);
        button_2=findViewById(R.id.button_2);
        button_3=findViewById(R.id.button_3);
        button_4=findViewById(R.id.button_4);
        button_5=findViewById(R.id.button_5);
        button_6=findViewById(R.id.button_6);
        button_7=findViewById(R.id.button_7);
        button_8=findViewById(R.id.button_8);
        button_9=findViewById(R.id.button_9);
        button_addition_info=findViewById(R.id.btn_add_info);
        button_subtraction_info=findViewById(R.id.btn_sub_info);
        button_multiplication_info=findViewById(R.id.btn_mul_info);
        button_division_info=findViewById(R.id.btn_div_info);
        button_delete_addition=findViewById(R.id.btn_dlt_add);
        button_delete_subtraction=findViewById(R.id.btn_dlt_sub);
        button_delete_multiplication=findViewById(R.id.btn_dlt_mul);
        button_delete_division=findViewById(R.id.btn_dlt_div);
        input=findViewById(R.id.input);
        result=findViewById(R.id.result);


        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "0");
            }
        });
        button_1.setOnClickListener(new View.OnClickListener() {
              @Override
           public void onClick(View v) {
            input.setText(input.getText() + "1");
           }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "2");
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "3");
            }
        });
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "4");
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "5");
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "6");
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "7");
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "8");
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "9");
            }
        });
        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + ".");
            }
        });
        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=check(c);
                if(c==0)
                {
                    Calculation();
                    c++;
                }
                input.setText(input.getText() + "*");
            }
        });
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=check(c);
                if(c==0)
                {
                    Calculation();
                    c++;
                }
                input.setText(input.getText() + "/");

            }
        });
        button_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=check(c);
                if(c==0)
                {
                    Calculation();
                    c++;
                }
                input.setText(input.getText() + "-");

            }
        });

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    c=check(c);
                    if(c==0)
                    {
                        Calculation();
                        c++;
                    }
                    input.setText(input.getText() + "+");
            }

        });
        button_sqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                input.setText(input.getText() + "²");
            }

        });
        button_sqr_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                input.setText(input.getText() + "√");
            }

        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=0;
                Calculation();

            }
        });
        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=0;
                input.setText("");
                result.setText("0");
            }
        });
        button_addition_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor t=g.getAddition();
                if(t.getCount()==0)
                {
                    Toast.makeText(MainActivity.this, "No rows in Addition Table", Toast.LENGTH_SHORT).show();

                }
                StringBuffer buffer= new StringBuffer();
                while(t.moveToNext())
                {
                    buffer.append(t.getString(0)+".\t\t\t");
                    buffer.append(t.getString(1)+"\t");
                    buffer.append(t.getString(2)+"\t");
                    buffer.append(t.getString(3)+"\t =\t\t");
                    buffer.append(t.getString(4)+"\n\n");

                }
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("\t\t\t\t\t\t\tADDITION TABLE");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        button_subtraction_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor t=g.getSubtraction();
                if(t.getCount()==0)
                {
                    Toast.makeText(MainActivity.this, "No rows in Subtraction Table", Toast.LENGTH_SHORT).show();

                }
                StringBuffer buffer= new StringBuffer();
                while(t.moveToNext())
                {
                    buffer.append(t.getString(0)+".\t\t\t");
                    buffer.append(t.getString(1)+"\t");
                    buffer.append(t.getString(2)+"\t");
                    buffer.append(t.getString(3)+"\t =\t\t");
                    buffer.append(t.getString(4)+"\n\n");

                }
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("\t\t\t\t\t\t\tSUBTRACTION TABLE");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        button_multiplication_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor t=g.getMultiplication();
                if(t.getCount()==0)
                {
                    Toast.makeText(MainActivity.this, "No rows in Multiplication Table", Toast.LENGTH_SHORT).show();

                }
                StringBuffer buffer= new StringBuffer();
                while(t.moveToNext())
                {
                    buffer.append(t.getString(0)+".\t\t\t");
                    buffer.append(t.getString(1)+"\t");
                    buffer.append(t.getString(2)+"\t");
                    buffer.append(t.getString(3)+"\t =\t\t");
                    buffer.append(t.getString(4)+"\n\n");

                }
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("\t\t\t\t\t\t\tMULTIPLICATION TABLE");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        button_division_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor t=g.getDivision();
                if(t.getCount()==0)
                {
                    Toast.makeText(MainActivity.this, "No rows in Division Table", Toast.LENGTH_SHORT).show();

                }
                StringBuffer buffer= new StringBuffer();
                while(t.moveToNext())
                {
                    buffer.append(t.getString(0)+".\t\t\t");
                    buffer.append(t.getString(1)+"\t");
                    buffer.append(t.getString(2)+"\t");
                    buffer.append(t.getString(3)+"\t =\t\t");
                    buffer.append(t.getString(4)+"\n\n");

                }
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("\t\t\t\t\t\t\tDIVISION TABLE");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        button_delete_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.DeleteAddition();
                Toast.makeText(MainActivity.this, "All rows of Addition table deleted", Toast.LENGTH_LONG).show();

            }
        });
        button_delete_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.DeleteSubtraction();
                Toast.makeText(MainActivity.this, "All rows of Subtraction table deleted", Toast.LENGTH_LONG).show();
            }
        });
        button_delete_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.DeleteMultiplication();
                Toast.makeText(MainActivity.this, "All rows of Multiplication table deleted", Toast.LENGTH_LONG).show();
            }
        });
        button_delete_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.DeleteDivision();
                Toast.makeText(MainActivity.this, "All rows of Division table deleted", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void Calculation()
    {
        String s=input.getText().toString();
        String s1="";
        String s2="";
        char operation=' ';
        int len=s.length();
        int i=0;
        while(i<len)
        {
            if(s.charAt(i )=='+' || s.charAt(i )=='-' || s.charAt(i )=='*'|| s.charAt(i )=='/' || s.charAt(i)=='²'|| s.charAt(i)=='√')
            {
                operation=s.charAt(i);
                i++;
                break;
            }
            else
            {
                s1= s1 + s.charAt(i);
                i++;
            }

        }
        while(i<len)
        {
            s2=s2+s.charAt(i);
            i++;
        }
        double num1=Double.parseDouble(s1);
        double res = 0;
        if(operation!='²' && operation!='√') {
            double num2 = Double.parseDouble(s2);


            if (operation == '+') {
                res = num1 + num2;
                boolean check= g.Insert_to_addition(num1,num2,res);
                if (check==true)
                {
                    Toast.makeText(MainActivity.this, "Row Added to Addition table", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                }

            }
            else if (operation == '-') {
                res = num1 - num2;
                boolean check= g.Insert_to_Subtraction(num1,num2,res);
                if (check==true)
                {
                    Toast.makeText(MainActivity.this, "Row Added to Subtraction table", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                }
            }
            else if (operation == '*') {
                res = num1 * num2;
                boolean check= g.Insert_to_Multiplication(num1,num2,res);
                if (check==true)
                {
                    Toast.makeText(MainActivity.this, "Row Added to Multiplication table", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                }
            }
            else if (operation == '/') {
                res = num1 / num2;
                boolean check= g.Insert_to_Division(num1,num2,res);
                if (check==true)
                {
                    Toast.makeText(MainActivity.this, "Row Added to Division table", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(operation=='²')
        {
            res=num1*num1;
        }
        else if (operation=='√')
        {
            res=Math.sqrt(num1);
        }

        result.setText(String.valueOf(res));
        input.setText(String.valueOf(res));

    }
    int check(int c)
    {
        c++;
        if (c>1)
        {
           c=0;
        }

            return c;

    }

}