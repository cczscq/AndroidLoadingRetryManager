package cn.spade.android.manager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import cn.spade.android.loadingretry.manager.LoadingAndRetryManager;
import cn.spade.android.loadingretry.manager.OnLoadingAndRetryListener;
import cn.spade.android.manager.R;


public class MainActivity extends AppCompatActivity
{
    LoadingAndRetryManager mLoadingAndRetryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLoadingAndRetryManager = LoadingAndRetryManager.generate(this, new OnLoadingAndRetryListener()
        {
            @Override
            public void setRetryEvent(View retryView)
            {
                MainActivity.this.setRetryEvent(retryView);
            }
        });

        loadData();

    }

    private void loadData()
    {
        mLoadingAndRetryManager.showLoading();

        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                if (Math.random() > 0.6)
                {
                    mLoadingAndRetryManager.showContent();
                } else
                {
                    mLoadingAndRetryManager.showRetry();
                }
            }
        }.start();


    }


    public void setRetryEvent(View retryView)
    {
        View view = retryView.findViewById(R.id.id_btn_retry);
        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "retry event invoked", Toast.LENGTH_SHORT).show();
                loadData();
            }
        });
    }
}
