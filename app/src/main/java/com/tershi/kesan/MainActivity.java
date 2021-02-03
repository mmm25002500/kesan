package com.tershi.kesan;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.util.Set;

public class MainActivity extends Activity implements OnClickListener {

    private String url = null;
    private WebView webView;
    private EditText EditTextAddress;
    private Button btnSearch;
    private Button btnSetting;  //尚未完成
    WebSettings settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 進度條
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);

        setProgressBarIndeterminate(true);

        webView = (WebView) findViewById(R.id.webView);
        EditTextAddress = (EditText) findViewById(R.id.EditTextAddress);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSetting = (Button) findViewById(R.id.btnSetting );
        webView.loadUrl("https://mail.tershi.ml");
        btnSearch.setOnClickListener(this);         // 監聽Event/
        btnSetting.setOnClickListener(this);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        settings = webView.getSettings();  //設定
        loadSetting();
    }

    protected void startReadURL(String url) {
        webView.loadUrl(url);

        //打開頁面顯示進度條
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                setTitle("已經載入" + newProgress + "%");
                if (newProgress == 100) {
                    closeProgressBar();
                } else {
                    openProgressBar(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }
    protected void openProgressBar(int x) {
        // TODO Auto-generated method stub
        setProgressBarIndeterminateVisibility(true);
        setProgress(x);
    }
    protected void closeProgressBar() {
        // TODO Auto-generated method stub
        setProgressBarIndeterminateVisibility(false);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                // 返回上一页面
                webView.goBack();
                return true;
            } else {
                // 退出程序
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onClick(View v) {       //按鈕
        switch (v.getId()) {
            case R.id.btnSearch:
                url = "http://" + EditTextAddress.getText().toString();
                url = url.replace(" ", "");
                startReadURL(url);
                break;
            case R.id.btnSetting:
                Intent settingIntent = new Intent(this, Setting.class);
                startActivity(settingIntent);
                break;
        }
    }

    public void loadSetting(){
        settings.setJavaScriptEnabled(Setting.codeB[0]); //是否啟用載入JavaScript
        settings.setDomStorageEnabled(Setting.codeB[1]); //是否啟用HTML5資料儲存
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(Setting.codeB[2]); //是否自動調整螢幕大小
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(Setting.codeB[3]); //是否啟用自適應螢幕
        settings.setSupportZoom(Setting.codeB[4]); //是否啟用縮放
        settings.setDefaultTextEncodingName("utf-8");
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // 優先使用cache載入
        EditTextAddress.setText(Setting.codeB[0]+ "");
    }
}
