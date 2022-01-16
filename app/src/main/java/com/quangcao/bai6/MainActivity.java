package com.quangcao.bai6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt_id, edt_name , edt_price, edt_Description;
    Button btn_insert, btn_update, btn_delete;
    TextView tv_kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_id = findViewById(R.id.edt_id);
        edt_name = findViewById(R.id.edt_name);
        edt_price = findViewById(R.id.edt_price);
        edt_Description = findViewById(R.id.edt_Description);
        tv_kq = findViewById(R.id.tv_result);
        btn_insert = findViewById(R.id.btn_insert);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FunctionVolley functionVolley = new FunctionVolley();
                functionVolley.insertVolley(MainActivity.this , tv_kq,
                        edt_name.getText().toString(),
                        edt_price.getText().toString(),
                        edt_Description.getText().toString()
                        );
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FunctionVolley functionVolley = new FunctionVolley();
                functionVolley.updateVolley(MainActivity.this , tv_kq,
                        edt_id.getText().toString(),
                        edt_name.getText().toString(),
                        edt_price.getText().toString(),
                        edt_Description.getText().toString()
                );
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FunctionVolley functionVolley = new FunctionVolley();
                functionVolley.deleteVolley(MainActivity.this , tv_kq, edt_id.getText().toString() );
            }
        });
    }
}