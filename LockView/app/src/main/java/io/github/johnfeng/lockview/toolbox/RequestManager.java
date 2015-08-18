package io.github.johnfeng.lockview.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.squareup.okhttp.Request;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import im.amomo.volley.OkRequest;
import im.amomo.volley.toolbox.OkVolley;
import io.github.johnfeng.lockview.LockViewApplication;
import io.github.johnfeng.lockview.model.OverlayContextContract;
import io.github.johnfeng.lockview.model.api.ImageCompositionRequest;
import io.github.johnfeng.lockview.model.api.ImageCompositionResponse;

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

    public RequestManager init(Context context) {
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
        return Volley.newRequestQueue(mContext);
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

    public OkRequest<ImageCompositionResponse> getResponseImage(
            ImageCompositionRequest imageCompositionRequest,
            Response.Listener<ImageCompositionResponse> listener,
            Response.ErrorListener errorListener) {
        String url = API_HOSTS;

        final Type type = new TypeToken<ImageCompositionResponse>() {
        }.getType();
        OkRequest<ImageCompositionResponse> request = new OkRequest<ImageCompositionResponse>(
                com.android.volley.Request.Method.POST, url, listener, errorListener) {
            @Override
            protected Response parseNetworkResponse(NetworkResponse networkResponse) {
                try {
                    byte[] data = networkResponse.data;
                    String json = new String(data,
                            HttpHeaderParser.parseCharset(networkResponse.headers));
                    if (VolleyLog.DEBUG) {
                        VolleyLog.d("response:%s", json);
                    }
                    if (type != null) {
                        return Response.success(
                                (ImageCompositionResponse) LockViewApplication.getApp()
                                        .getGsonInstance()
                                        .fromJson(new JsonReader(new StringReader(json)), type),
                                HttpHeaderParser.parseCacheHeaders(networkResponse)
                        );
                    } else {
                        return (Response) Response.success(json,
                                HttpHeaderParser.parseCacheHeaders(networkResponse));
                    }
                } catch (UnsupportedEncodingException e) {
                    Log.e("message", e.getMessage());
                    return Response.error(new ParseError(e));
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    return Response.error(new ParseError(e));
                }
            }
        };
        return request;
    }

}
