package cn.spade.android.manager.activity;

import android.app.Application;

import cn.spade.android.loadingretry.manager.LoadingAndRetryManager;
import cn.spade.android.manager.R;

/**
 * Created by zhy on 15/8/27.
 */
public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        LoadingAndRetryManager.BASE_RETRY_LAYOUT_ID = R.layout.base_retry;
        LoadingAndRetryManager.BASE_LOADING_LAYOUT_ID = R.layout.base_loading;
    }
}
