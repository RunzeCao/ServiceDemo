package my.practice.servicedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import my.practice.servicedemo.R;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.simpleService)
    public void goSimpleService() {
        Intent intent = new Intent(MainActivity.this, SimpleServiceActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.localService)
    public void goLocalService() {
        Intent intent = new Intent(MainActivity.this, BindActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.messengerService)
    void goMessengerService() {
        startActivity(new Intent(MainActivity.this, MessengerActivity.class));
    }
    @OnClick(R.id.foregroundService)
    void goForegroundService(){
        startActivity(new Intent(MainActivity.this,ForegroundActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
