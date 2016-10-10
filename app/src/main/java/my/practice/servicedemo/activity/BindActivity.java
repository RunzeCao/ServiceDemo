package my.practice.servicedemo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;
import my.practice.servicedemo.R;
import my.practice.servicedemo.service.BindService;

public class BindActivity extends AppCompatActivity {
    protected static final String TAG = BindActivity.class.getSimpleName();
    private BindService mService;
    private Intent intent;

    ServiceConnection connection = new ServiceConnection() {
        /**
         * 与服务器端交互的接口方法 绑定服务的时候被回调，在这个方法获取绑定Service传递过来的IBinder对象，
         * 通过这个IBinder对象，实现宿主和Service的交互。
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "绑定成功调用：onServiceConnected");
            // 获取Binder
            BindService.LocalBinder binder = (BindService.LocalBinder) service;
            mService = binder.getService();
        }

        /**
         * 当取消绑定的时候被回调。但正常情况下是不被调用的，它的调用时机是当Service服务被意外销毁时，
         * 例如内存的资源不足时这个方法才被自动调用。
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind);
        ButterKnife.bind(this);
        intent = new Intent(BindActivity.this, BindService.class);
    }

    @OnClick(R.id.bindService)
    public void bind() {
        Log.i(TAG, "绑定调用：bindService");
        //flags则是指定绑定时是否自动创建Service。0代表不自动创建、BIND_AUTO_CREATE则代表自动创建
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    @OnClick(R.id.unBindService)
    public void unBind() {
        Log.i(TAG, "解除绑定调用：unbindService");
        // 解除绑定
        if (mService != null) {
            mService = null;
            unbindService(connection);
        }
    }

    @OnClick(R.id.getData)
    public void getData() {
        if (mService != null) {
            // 通过绑定服务传递的Binder对象，获取Service暴露出来的数据

            Log.d(TAG, "从服务端获取数据：" + mService.getCount());
        } else {

            Log.d(TAG, "还没绑定呢，先绑定,无法从服务端获取数据");
        }
    }

}
