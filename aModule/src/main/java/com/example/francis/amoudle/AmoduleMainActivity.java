package com.example.francis.amoudle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.francis.commonmodule.User;
import com.example.francis.commonmodule.route.Router;

public class AmoduleMainActivity extends AppCompatActivity {

    private TextView tvGoAModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amodule_main);

        tvGoAModule = (TextView) findViewById(R.id.tv_go_bmodule);
        tvGoAModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterService service = new Router(AmoduleMainActivity.this).create(RouterService.class);
                service.startUserActivity("厦门", new User("francis", 24));
//                startActivity(new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("router://com.example.francis.bmodule")));
            }
        });
    }
}
