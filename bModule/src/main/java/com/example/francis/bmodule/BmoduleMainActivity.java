package com.example.francis.bmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.francis.commonmodule.User;
import com.example.francis.commonmodule.inject.ParameterInjector;
import com.example.ioc_annotation.BindParameter;

public class BmoduleMainActivity extends AppCompatActivity {

    @BindParameter("user")
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmodule_main);
        getIntent().getData().getQueryParameter("cityName");
        ParameterInjector.injectParameter(this);

        Toast.makeText(this, "user: " + user.getName() + " age: " + user.getAge(), Toast.LENGTH_LONG).show();


    }
}
