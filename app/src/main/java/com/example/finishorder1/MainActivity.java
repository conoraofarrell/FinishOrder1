package com.example.finishorder1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void sayhi() {
        Toast toast=Toast.makeText(getApplicationContext(),"Hello Javapoint",Toast.LENGTH_SHORT);
        toast.setMargin(50,50);
        toast.show();
    }

    public void addrow(View view) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());


        // Toast PopUp
        Toast toast=Toast.makeText(getApplicationContext(),currentDateandTime,Toast.LENGTH_SHORT);
        toast.setMargin(50,50);
        toast.show();

        // Add Table Row
        TableLayout stk = (TableLayout) findViewById(R.id.tableLayout);
        int tableLength = stk.getChildCount();
        int rowCount = tableLength -1;
        String finishOrder = Integer.toString(rowCount);

        TableRow tbrow0 = new TableRow (this);
        // Finish Order
        TextView tv0 = new TextView(this);
        tv0.setText(finishOrder);
        tv0.setTextColor(Color.BLACK);
        tbrow0.addView(tv0);
        // Finish Time
        TextView tv1 = new TextView(this);
        tv1.setText((CharSequence) currentDateandTime);
        tv1.setTextColor(Color.BLACK);
        tbrow0.addView(tv1);
        // Race No. (Editable field)
        EditText tv2 = new EditText(this);
        tv2.setTextColor(Color.BLACK);
        tv2.setKeyListener((new DigitsKeyListener()));
        tv2.setHint("Number");
        tv2.requestFocus();
        InputFilter[] filterArray = new InputFilter[1];
        filterArray[0] = new InputFilter.LengthFilter(4);
        tv2.setFilters(filterArray);
        tv2.setImeOptions(EditorInfo.IME_ACTION_DONE);
        tbrow0.addView(tv2);

        stk.addView(tbrow0);


    }


}