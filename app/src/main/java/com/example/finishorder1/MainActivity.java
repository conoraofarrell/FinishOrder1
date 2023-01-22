package com.example.finishorder1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
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

    public void buttonPress(View view) {
        TableLayout stk = (TableLayout) findViewById(R.id.tableLayout);
        int tableLength = stk.getChildCount();
        int rowCount = tableLength -1;
        addrow(tableLength);
    }

    public void popupToast (int msg) {
//         Toast PopUp
        String message = Integer.toString(msg);
        Toast toast=Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT);
        toast.setMargin(50,50);
        toast.show();
    }

    public void addrow(int rowIndex) {

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//        String currentDateandTime = sdf.format(new Date());

        // Toast PopUp
//        Toast toast=Toast.makeText(getApplicationContext(),currentDateandTime,Toast.LENGTH_SHORT);
//        toast.setMargin(50,50);
//        toast.show();

        // Add Table Row
        TableLayout stk = (TableLayout) findViewById(R.id.tableLayout);
        String finishOrder = "";
        String currentDateandTime ="";

        int rowCount = stk.getChildCount();
        if ( rowIndex == rowCount ) {
            finishOrder = Integer.toString(rowCount);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
            currentDateandTime = sdf.format(new Date());
        } else {
            finishOrder = Integer.toString(rowIndex);
            currentDateandTime = "NOTIME";
//            addrow(rowIndex + 1);
            appendrow_new(rowIndex);
        }


        TableRow tbrow0 = new TableRow (this);
        Button btn0 = new Button(this);
        btn0.setText("+");
        btn0.setTextColor(Color.BLACK);
        btn0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addrow(stk.indexOfChild(tbrow0));
//                v.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                // get table row index android.
//                int nIndex = stk.indexOfChild(tbrow0);
//                String fOrder = Integer.toString(nIndex);
            }
        });
        tbrow0.addView(btn0);
        // Finish Order
        TextView tv0 = new TextView(this);
        tv0.setText(finishOrder);
        tv0.setTextColor(Color.BLACK);
        tv0.setOnClickListener(v -> {
                popupToast(stk.indexOfChild(tbrow0));
////            addrow(view);
//            v.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
//            // get table row index android.
//            int nIndex = stk.indexOfChild(tbrow0);
//            String fOrder = Integer.toString(nIndex);
//            // Toast PopUp for table row
//            Toast toast1 =Toast.makeText(getApplicationContext(),fOrder,Toast.LENGTH_SHORT);
//            toast1.setMargin(50,50);
//            toast1.show();
        });
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

        stk.addView(tbrow0,rowIndex);

    }

    public void appendrow_new (int rowIndex) {
        TableLayout stk = (TableLayout) findViewById(R.id.tableLayout);
        TableRow t = (TableRow) stk.getChildAt(rowIndex);
//        TextView firstTextView = (TextView) t.getChildAt(0);
        TextView secondTextView = (TextView) t.getChildAt(1);
        String oldnumber = (String) secondTextView.getText();
        int oldnumberint = Integer.parseInt(oldnumber);
        String numberstr = String.valueOf(oldnumberint + 1);
        secondTextView.setText(numberstr);
        // do a foreach number between rowindex and table length
    }



}