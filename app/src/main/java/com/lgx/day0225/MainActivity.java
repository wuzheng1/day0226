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
		
		int a = 20;
		int b = 20;
		int c = 20;
		int d = 10;
		int e = 10;

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
