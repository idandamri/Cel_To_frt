package com.example.idan.ctof;

import android.opengl.ETC1;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int c = 0, f=0;
    Button convert;
    RadioGroup rGroup;
    RadioButton F, C;
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
        initEvent();
    }

    private void initLayout() {
        convert = (Button) findViewById(R.id.button);
        rGroup = (RadioGroup) findViewById(R.id.radioGroup);
        C = (RadioButton) findViewById(R.id.CradioButton);
        F = (RadioButton) findViewById(R.id.FradioButton);
        et = (EditText) findViewById(R.id.editText);
        et.setInputType(InputType.TYPE_CLASS_NUMBER);
        tv = (TextView) findViewById(R.id.textView);
        F.setChecked(true);
    }

    private void initEvent() {
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(F.isChecked()){
                    try{
                        c = Integer.valueOf(String.valueOf(et.getText()));
                        f = c * 9 / 5 + 32;
                        tv.setText(String.valueOf(f));
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this,"What you entered is not a number!",Toast.LENGTH_SHORT).show();
                    }
                }
                if(C.isChecked()){
                    try{
                        f = Integer.valueOf(String.valueOf(et.getText()));
                        c = (f - 32) * 5 / 9;
                        tv.setText(String.valueOf(c));
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this,"What you entered is not a number!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
