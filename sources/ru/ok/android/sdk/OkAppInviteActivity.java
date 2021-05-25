package ru.ok.android.sdk;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;
import ru.ok.android.sdk.AbstractWidgetActivity;
public class OkAppInviteActivity extends AbstractWidgetActivity {
    public int getActivityView() {
        return R.layout.ok_app_invite_activity;
    }

    @Override // ru.ok.android.sdk.AbstractWidgetActivity
    public int getCancelledMessageId() {
        return R.string.invite_canceled;
    }

    @Override // ru.ok.android.sdk.AbstractWidgetActivity
    public String getWidgetId() {
        return "WidgetInvite";
    }

    @Override // ru.ok.android.sdk.AbstractWidgetActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getActivityView());
        int i = R.id.web_view;
        WebView webView = (WebView) findViewById(i);
        webView.setWebViewClient(new AbstractWidgetActivity.OkWidgetViewClient(this));
        webView.getSettings().setJavaScriptEnabled(true);
        ((WebView) findViewById(i)).loadUrl(prepareUrl(null));
    }

    @Override // ru.ok.android.sdk.AbstractWidgetActivity
    public void processResult(String str) {
        Odnoklassniki instance = Odnoklassniki.getInstance();
        Intent intent = new Intent();
        if (instance != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if ("ok".equalsIgnoreCase(jSONObject.optString("code"))) {
                    intent.putExtra("result", jSONObject.toString());
                } else {
                    intent.putExtra("error", jSONObject.getString("message"));
                }
            } catch (JSONException unused) {
                intent.putExtra("error", str);
            }
        }
        setResult(-1, intent);
        finish();
    }
}
