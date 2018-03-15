package com.example.francis.testmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.francis.amoudle.AmoduleMainActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvGoCommonModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvGoCommonModule = (TextView) findViewById(R.id.tv_goto_commonmodule);

        tvGoCommonModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AmoduleMainActivity.class));
            }
        });
    }
}
