package com.zhouyaming.skindemo;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhy.changeskin.SkinManager;
import com.zhy.changeskin.base.BaseSkinActivity;
import com.zhy.changeskin.callback.ISkinChangingCallback;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseSkinActivity {


    @Bind(R.id.btn_day)
    Button btnDay;
    @Bind(R.id.btn_night)
    Button btnNight;
    @Bind(R.id.btn_plugin)
    Button btnPlugin;

    private String mSkinPkgPath = Environment.getExternalStorageDirectory() + File.separator + "night.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_day, R.id.btn_night})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_day:
                SkinManager.getInstance().removeAnySkin();
                break;
            case R.id.btn_night:
                SkinManager.getInstance().changeSkin("night");
                break;
        }
    }

    @OnClick(R.id.btn_plugin)
    public void onClick() {
        SkinManager.getInstance().changeSkin(mSkinPkgPath, "com.zhouyaming.myapplication","night", new com.zhy.changeskin.callback.ISkinChangingCallback()
        {
            @Override
            public void onStart()
            {
            }

            @Override
            public void onError(Exception e)
            {
                Toast.makeText(MainActivity.this, "换肤失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete()
            {
                Toast.makeText(MainActivity.this, "换肤成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
