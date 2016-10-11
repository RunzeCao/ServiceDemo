package my.practice.servicedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import my.practice.servicedemo.R;
import my.practice.servicedemo.service.NotificationService;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start)
    void startNotificationService(){
        startService(new Intent(NotificationActivity.this, NotificationService.class));
    }


    @OnClick(R.id.stop)
    void stopNotificationService(){
        stopService(new Intent(NotificationActivity.this, NotificationService.class));
    }
}
