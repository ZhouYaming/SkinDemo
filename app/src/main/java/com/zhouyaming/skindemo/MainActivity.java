package com.zhouyaming.skindemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhy.changeskin.SkinManager;
import com.zhy.changeskin.base.BaseSkinActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseSkinActivity {


    @Bind(R.id.btn_day)
    Button btnDay;
    @Bind(R.id.btn_night)
    Button btnNight;

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
}
