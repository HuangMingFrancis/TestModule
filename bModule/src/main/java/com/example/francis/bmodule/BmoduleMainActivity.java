package com.example.francis.bmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.francis.commonmodule.User;

public class BmoduleMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmodule_main);
        getIntent().getData().getQueryParameter("cityName");
        User user = (User) getIntent().getExtras().getSerializable("user");
        user.getName();
    }
}
