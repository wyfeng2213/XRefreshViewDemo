package com.cmcc.healthlibrary.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;

import com.cmcc.heallibrary.R;
import com.tamic.jswebview.browse.CallBackFunction;
import com.tamic.jswebview.browse.JsWeb.CustomWebViewClient;
import com.tamic.jswebview.view.ProgressBarWebView;

import java.util.ArrayList;
import java.util.Map;


public class WebViewFragment extends Fragment {
    private View view;// 缓存页面

    public static final String KEY_URL = "URL";
    private String value_url;

    // UI references.
    private ProgressBarWebView mProgressBarWebView;
    private ArrayList<String> mHandlers = new ArrayList<>();

    ValueCallback<Uri> mUploadMessage;
    private static CallBackFunction mfunction;
    int RESULT_CODE = 0;
    private Context mcontext;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        value_url = getArguments().getString(KEY_URL);
    }


    //添加webview的Url参数
    public void addWebViewURL(WebViewFragment webViewFragment, String url) {
        Bundle args = new Bundle();
        args.putString(WebViewFragment.KEY_URL, url);
        webViewFragment.setArguments(args);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != view) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (null != parent) {
                parent.removeView(view);
            }
        } else {
            view = inflater.inflate(R.layout.activity_webview, container, false);
        }
        mProgressBarWebView = (ProgressBarWebView) view.findViewById(R.id.login_progress_webview);
        initWebView();
        return view;
    }

    private void initWebView() {

        mProgressBarWebView.setWebViewClient(new CustomWebViewClient(mProgressBarWebView.getWebView()) {


            @Override
            public String onPageError(String url) {
                //指定网络加载失败时的错误页面
                return "file:///android_asset/error.html";
            }

            @Override
            public Map<String, String> onPageHeaders(String url) {

                // 可以加入header

                return null;
            }

            @SuppressWarnings("unused")
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String AcceptType, String capture) {
                this.openFileChooser(uploadMsg);
            }

            @SuppressWarnings("unused")
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String AcceptType) {
                this.openFileChooser(uploadMsg);
            }

            public void openFileChooser(ValueCallback<Uri> uploadMsg) {
                mUploadMessage = uploadMsg;
                pickFile();
            }
        });

        // =====================打开页面 支持本地============
//        mProgressBarWebView.loadUrl("file:///android_asset/demo.html");
        mProgressBarWebView.loadUrl(value_url);


        //====================示例  添加回调方法========================
//        mHandlers.add("login");
//        mHandlers.add("callNative");
//        mHandlers.add("callJs");
//        mHandlers.add("open");
//

        //===========================示例   回调js的方法======================
//        mProgressBarWebView.registerHandlers(mHandlers, new JsHandler() {
//            @Override
//            public void OnHandler(String handlerName, String responseData, CallBackFunction function) {
//
//                if (handlerName.equals("login")) {
//
//                    Toast.makeText(MainActivity.this, responseData, Toast.LENGTH_SHORT).show();
//
//
//                } else if (handlerName.equals("callNative")) {
//
//                    Toast.makeText(MainActivity.this, responseData, Toast.LENGTH_SHORT).show();
//
//                    function.onCallBack("我在上海");
//
//                } else if (handlerName.equals("callJs")) {
//
//                    Toast.makeText(MainActivity.this, responseData, Toast.LENGTH_SHORT).show();
//
//                    // 想调用你的方法：
//
//                    function.onCallBack("好的 这是图片地址 ：xxxxxxx");
//
//
//                }
//                if (handlerName.equals("open")) {
//
//                    mfunction = function;
//
//                    pickFile();
//
//                }
//
//            }
//        });

        // ======================================示例  调用js=========================================
//        mProgressBarWebView.callHandler("callNative", "hello H5, 我是java", new JavaCallHandler() {
//            @Override
//            public void OnHandler(String handlerName, String jsResponseData) {
//                Toast.makeText(mcontext, "h5返回的数据：" + jsResponseData, Toast.LENGTH_SHORT).show();
//            }
//        });
        //=====================================示例   发送消息给js===========================================
//        mProgressBarWebView.send("哈喽", new CallBackFunction() {
//            @Override
//            public void onCallBack(String data) {
//
//                Toast.makeText(mcontext, data, Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }

    public void pickFile() {
        Intent chooserIntent = new Intent(Intent.ACTION_GET_CONTENT);
        chooserIntent.setType("image/*");
        startActivityForResult(chooserIntent, RESULT_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == RESULT_CODE) {
            if (null == mUploadMessage) {
                return;
            }
            Uri result = intent == null || resultCode != Activity.RESULT_OK ? null : intent.getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;

            mfunction.onCallBack(intent.getData().toString());

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mProgressBarWebView.getWebView() != null) {
            mProgressBarWebView.getWebView().destroy();
        }
    }
}
