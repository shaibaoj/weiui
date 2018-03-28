package vip.kuaifan.weiui.ui.component.icon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.MotionEvent;

import com.alibaba.fastjson.JSONObject;

import com.alibaba.weex.plugin.annotation.WeexComponent;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.dom.WXDomObject;
import com.taobao.weex.dom.flex.CSSAlign;
import com.taobao.weex.dom.flex.CSSJustify;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;

import java.util.Map;


import vip.kuaifan.weiui.extend.module.weiuiJson;
import vip.kuaifan.weiui.extend.module.weiuiParse;
import vip.kuaifan.weiui.extend.module.weiuiScreenUtils;

/**
 * Created by WDM on 2018/3/13.
 */
@SuppressLint("SetTextI18n")
@WeexComponent(names = {"weiui_icon", "wi_icon"})
public class Icon extends WXComponent<IconView> {

    private static final String TAG = "Icon";

    private IconView mIconView;

    private int mIconColor;

    private int mIconClickColor;

    public Icon(WXSDKInstance instance, WXDomObject dom, WXVContainer parent) {
        super(instance, dom, parent);
        initDom(dom);
    }

    public Icon(WXSDKInstance instance, WXDomObject dom, WXVContainer parent, int type) {
        super(instance, dom, parent, type);
        initDom(dom);
    }

    private void initDom(WXDomObject dom) {
        dom.setJustifyContent(CSSJustify.CENTER);
        dom.setAlignItems(CSSAlign.CENTER);
        if (Float.isNaN(dom.getStyleWidth())) {
            dom.setStyleWidth(weiuiScreenUtils.weexPx2dp(getInstance(), 50));
        }
        if (Float.isNaN(dom.getStyleHeight())) {
            dom.setStyleHeight(weiuiScreenUtils.weexPx2dp(getInstance(), 50));
        }
    }

    @Override
    protected IconView initComponentHostView(@NonNull Context context) {
        mIconView = new IconView(context);
        appleStyleAfterCreated();
        return mIconView;
    }

    @Override
    protected boolean setProperty(String key, Object param) {
        return initProperty(key, param) || super.setProperty(key, param);
    }

    private boolean initProperty(String key, Object val) {
        switch (key) {
            case "weiui":
                JSONObject json = weiuiJson.parseObject(weiuiParse.parseStr(val, ""));
                if (json.size() > 0) {
                    for (Map.Entry<String, Object> entry : json.entrySet()) {
                        initProperty(entry.getKey(), entry.getValue());
                    }
                }
                return true;

            case "icon":
            case "text":
                setIcon(weiuiParse.parseStr(val, null));
                return true;

            case "iconSize":
            case "textSize":
            case "fontSize":
            case "font-size":
                setIconSize(weiuiParse.parseInt(val, 0));
                return true;

            case "color":
            case "iconColor":
            case "textColor":
                setIconColor(weiuiParse.parseStr(val, null));
                return true;

            case "iconClickColor":
            case "textClickColor":
                setIconClickColor(weiuiParse.parseStr(val, null));
                return true;

            default:
                return false;
        }
    }

    private void appleStyleAfterCreated() {
        mIconView.setGravity(Gravity.CENTER);
        setIcon("home");
        setIconSize(20);
        setIconColor("#242424");
    }

    /***************************************************************************************************/
    /***************************************************************************************************/
    /***************************************************************************************************/

    /**
     * 设置图标
     * @param var
     */
    @JSMethod
    public void setIcon(String var) {
        if (var == null) {
            return;
        }
        if (var.isEmpty()) {
            mIconView.setText("");
            return;
        }
        if (!var.startsWith("ion-") && !var.startsWith("tb-")) {
            var = "ion-" + var;
        }
        mIconView.setText("{" + var + "}");
    }

    /**
     * 设置图标大小
     * @param var
     */
    @JSMethod
    public void setIconSize(Object var) {
        mIconView.setTextSize(weiuiParse.parseInt(var, 0));
    }

    /**
     * 设置图标颜色
     * @param var
     */
    @JSMethod
    public void setIconColor(String var) {
        if (var == null) {
            return;
        }
        mIconColor = Color.parseColor(var);
        mIconView.setTextColor(mIconColor);
    }

    /**
     * 设置图标点击颜色
     * @param var
     */
    @JSMethod
    public void setIconClickColor(String var) {
        if (var == null) {
            return;
        }
        int color = Color.parseColor(var);
        if (mIconClickColor == 0) {
            mIconView.setClickable(true);
            mIconView.setFocusable(true);
            mIconView.setOnTouchListener((view, event) -> {
                switch (event.getAction()) {
                    //离开
                    case MotionEvent.ACTION_UP:
                        mIconView.setTextColor(mIconColor);
                        break;

                    //按下
                    case MotionEvent.ACTION_DOWN:
                        mIconView.setTextColor(mIconClickColor);
                        break;
                }
                return false;
            });
        }
        mIconClickColor = color;
    }

}