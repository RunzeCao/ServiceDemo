package my.practice.servicedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import my.practice.servicedemo.R;
import my.practice.servicedemo.service.SimpleService;

public class SimpleServiceActivity extends AppCompatActivity {

    @OnClick(R.id.startService)
    public void start() {
        Intent intent = new Intent(this, SimpleService.class);
        startService(intent);
    }

    @OnClick(R.id.stopService)
    public void stop(){
        Intent intent = new Intent(this, SimpleService.class);
        stopService(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_service);
        ButterKnife.bind(this);
    }
}
