package my.practice.servicedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import my.practice.servicedemo.R;
import my.practice.servicedemo.service.ForegroundService;

public class ForegroundActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground);
        ButterKnife.bind(this);
        intent = new Intent(this, ForegroundService.class);

    }

    @OnClick(R.id.startForegroundService)
    void startForeground() {
        intent.putExtra("cmd",0);//0,开启前台服务,1,关闭前台服务
        startService(intent);
    }

    @OnClick(R.id.stopForegroundService)
    void stopForeground() {
        intent.putExtra("cmd",1);//0,开启前台服务,1,关闭前台服务
        stopService(intent);
    }
}
