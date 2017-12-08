package com.potoyang.myandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.potoyang.common.annotation.InjectView;
import com.potoyang.common.annotation.MyAnnotation;
import com.potoyang.common.config.ActivityURL;
import com.potoyang.common.security.SecurityUtil;
import com.potoyang.myandroid.R;

@Route(path = ActivityURL.MainActivity)
public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.btn_decode)
    Button btn_decode;
    @InjectView(R.id.btn_bind_view)
    Button btn_bind_view;
    @InjectView(R.id.btn_bind_click)
    Button btn_bind_click;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAnnotation.injectView(this);

        // Example of a call to a native method
        final TextView tv = findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
        final String encodeText = SecurityUtil.encrypt("potoyang");
        tv.setText(encodeText);
//        btn_decode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String decondeText = SecurityUtil.decrypt(encodeText);
//                tv.setText(decondeText);
//            }
//        });
    }

}
