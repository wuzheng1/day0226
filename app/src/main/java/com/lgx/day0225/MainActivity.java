package com.lgx.day0225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.lgx.myanno.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.liguixiao)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Class<?> aClass = Class.forName(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName() + "_ViewBinding");
            IBinder iBinder = (IBinder) aClass.newInstance();
            iBinder.bind(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        tv.setText("123");
    }
}