package cn.spade.android.loadingretry.manager;

import android.view.View;

public abstract class OnLoadingAndRetryListener
{
    public abstract void setRetryEvent(View retryView);

    public int generateLoadingLayoutId()
    {
        return LoadingAndRetryManager.NO_LAYOUT_ID;
    }

    public int generateRetryLayoutId()
    {
        return LoadingAndRetryManager.NO_LAYOUT_ID;
    }

    public View generateLoadingLayout()
    {
        return null;
    }

    public View generateRetryLayout()
    {
        return null;
    }

    public boolean isSetLoadingLayout()
    {
        if (generateLoadingLayoutId() != LoadingAndRetryManager.NO_LAYOUT_ID || generateLoadingLayout() != null)
            return true;
        return false;
    }

    public boolean isSetRetryLayout()
    {
        if (generateRetryLayoutId() != LoadingAndRetryManager.NO_LAYOUT_ID || generateRetryLayout() != null)
            return true;
        return false;
    }


}