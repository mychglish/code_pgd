package com.example.a9476.myapplication;

import android.app.Activity;
import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static class spinner extends Activity {
        private Spinner spinner;
        private TextView textView;
        private ArrayAdapter<String> adapter;
        private static final String[] years = {"小于1年", "1年到3年", "3年到5年", "5年以上"};


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            spinner = (Spinner) findViewById(R.id.spin);
            textView = (TextView) findViewById(R.id.textView);
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,years);
            adapter.setDropDownViewResource(R.layout.dropdown);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String seleted = years[position];
                    textView.setText(seleted);
                    parent.setVisibility(View.VISIBLE);
                    
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    textView.setText("您还没有选择");
                }
            });
        }
    }
}
