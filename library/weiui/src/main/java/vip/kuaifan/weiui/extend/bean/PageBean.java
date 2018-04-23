package vip.kuaifan.weiui.extend.bean;

import android.app.Activity;
import android.content.Context;

import com.taobao.weex.bridge.JSCallback;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by WDM on 2018/3/7.
 */

public class PageBean {


    public Map<String, Object> toMap() {
        Map<String, Object> temp = new HashMap<>();
        temp.put("url", getUrl());
        temp.put("pageName", getPageName());
        temp.put("pageType", getPageType());
        temp.put("cache", getUrl());
        temp.put("loading", isLoading());
        temp.put("swipeBack", isSwipeBack());
        temp.put("statusBarType", getStatusBarType());
        temp.put("statusBarColor", getStatusBarColor());
        temp.put("statusBarAlpha", getStatusBarAlpha());
        temp.put("backgroundColor", getBackgroundColor());
        temp.put("backPressedClose", isBackPressedClose());
        return temp;
    }

    /**
     * url :                网址
     * pageName :           页面标识（可选）
     * pageType :           类型（可选，如：web|weex，默认：weex）
     * cache :              缓存（可选，单位：毫秒，仅weex有效，默认：0不启用）
     * data :               传递参数（可选）
     * loading : true       是否显示等待（可选，默认：true）
     * swipeBack : true     是否支持滑动返回（可选，默认：true）
     * statusBarType :      状态栏样式（可选，等于fullscreen|immersion时statusBarType、statusBarAlpha无效）
     * statusBarColor :     状态栏颜色值（可选，默认：#3EB4FF）
     * statusBarAlpha : 0   状态栏透明度（可选，默认：0）
     * backgroundColor :    页面背景颜色（可选，默认：#f4f8f9）
     * backPressedClose :   返回键关闭（可选，默认：true）
     * callback :           JS回调事件（可选）
     *
     * context :            上下文
     */

    private String url;
    private String pageName;
    private String pageType = "weex";
    private long cache = 0;
    private Object data = null;
    private boolean loading = true;
    private boolean swipeBack = true;
    private String statusBarType = "default";
    private String statusBarColor = "#3EB4FF";
    private int statusBarAlpha = 0;
    private String backgroundColor = "#f4f8f9";
    private boolean backPressedClose = true;
    private JSCallback callback;
    private Context context;
    private JSONObject otherObject;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public long getCache() {
        return cache;
    }

    public void setCache(long cache) {
        this.cache = cache;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public boolean isSwipeBack() {
        return swipeBack;
    }

    public void setSwipeBack(boolean swipeBack) {
        this.swipeBack = swipeBack;
    }

    public String getStatusBarType() {
        return statusBarType;
    }

    public void setStatusBarType(String statusBarType) {
        this.statusBarType = statusBarType;
    }

    public String getStatusBarColor() {
        return statusBarColor;
    }

    public void setStatusBarColor(String statusBarColor) {
        this.statusBarColor = statusBarColor;
    }

    public int getStatusBarAlpha() {
        return statusBarAlpha;
    }

    public void setStatusBarAlpha(int statusBarAlpha) {
        this.statusBarAlpha = statusBarAlpha;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public boolean isBackPressedClose() {
        return backPressedClose;
    }

    public void setBackPressedClose(boolean backPressedClose) {
        this.backPressedClose = backPressedClose;
    }

    public JSCallback getCallback() {
        return callback;
    }

    public void setCallback(JSCallback callback) {
        this.callback = callback;
    }

    public Activity getActivity() {
        return (Activity) context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public JSONObject getOtherObject() {
        return otherObject;
    }

    public void setOtherObject(JSONObject otherObject) {
        this.otherObject = otherObject;
    }

}
