package my.practice.servicedemo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import my.practice.servicedemo.R;

public class MainActivity extends AppCompatActivity {
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";

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
    void goForegroundService() {
        startActivity(new Intent(MainActivity.this, ForegroundActivity.class));
    }

    @OnClick(R.id.NotificationService)
    void goNotificationService() {
        if (!isEnabled()) {
            Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            startActivity(intent);
        } else {
            Toast.makeText(this, "已开启服务权限", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, NotificationActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private boolean isEnabled() {
        String pkgName = getPackageName();
        final String flat = Settings.Secure.getString(getContentResolver(),
                ENABLED_NOTIFICATION_LISTENERS);
        if (!TextUtils.isEmpty(flat)) {
            final String[] names = flat.split(":");
            for (int i = 0; i < names.length; i++) {
                final ComponentName cn = ComponentName.unflattenFromString(names[i]);
                if (cn != null) {
                    if (TextUtils.equals(pkgName, cn.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
