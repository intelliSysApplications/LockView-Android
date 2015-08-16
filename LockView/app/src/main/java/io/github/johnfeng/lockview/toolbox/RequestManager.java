package io.github.johnfeng.lockview.toolbox;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Authenticator;
import com.android.volley.toolbox.HttpHeaderParser;
/**
 * Created by guangweifeng on 16/08/15.
 */
public class RequestManager {
    private static final String API_HOSTS = "http://cloudimagecomposition.azurewebsites.net/ImageComposition.svc/Compose";

    private static RequestManager Instance;
    private String mUserAgent;
    private Context mContext;
    private boolean mBlocked = false;

    public static RequestManager getInstance() {
        if (Instance == null) {
            Instance = new RequestManager();
        }
        return Instance;
    }

    public RequestManager init(Context context){
        this.mContext = context;

        //TODO: init Velloy

        return this;
    }

    public String getUserAgent() {
        return mUserAgent;
    }

    private boolean checkInit() {
        if (mContext != null) {
            return true;
        } else {
            throw new NullPointerException("please call init first");
        }
    }

    public void block() {
        mBlocked = true;
    }

    public void releaseBlock() {
        mBlocked = false;
    }

    public RequestQueue getRequestQueue() {
        checkInit();

    }

    public void addRequest(Request request) {

    }

    public void removeRequest(Object tag) {
        getRequestQueue().cancelAll(tag);
    }

    public void resendBlockedRequests() {

    }

    public String url(boolean https, String path) {
        StringBuilder urlBuilder = new StringBuilder(https ? "https://" : "http://");
        urlBuilder.append(API_HOSTS);
        urlBuilder.append("/api/v2");
        if (!path.startsWith("/")) {
            urlBuilder.append("/");
        }

        urlBuilder.append(path);
        return urlBuilder.toString();
    }


}
