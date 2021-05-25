package ru.ok.android.sdk;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;
import ru.ok.android.sdk.AbstractWidgetActivity;
public class OkPostingActivity extends AbstractWidgetActivity {
    @Override // ru.ok.android.sdk.AbstractWidgetActivity
    public int getCancelledMessageId() {
        return R.string.posting_canceled;
    }

    @Override // ru.ok.android.sdk.AbstractWidgetActivity
    public String getWidgetId() {
        return "WidgetMediatopicPost";
    }

    @Override // ru.ok.android.sdk.AbstractWidgetActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ok_posting_activity);
        int i = R.id.web_view;
        WebView webView = (WebView) findViewById(i);
        webView.setWebViewClient(new AbstractWidgetActivity.OkWidgetViewClient(this));
        webView.getSettings().setJavaScriptEnabled(true);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.args.put("st.attachment", extras.getString("attachment"));
            this.args.put("st.utext", extras.getBoolean(Shared.PARAM_USER_TEXT_ENABLE, false) ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        }
        ((WebView) findViewById(i)).loadUrl(prepareUrl(null));
    }

    @Override // ru.ok.android.sdk.AbstractWidgetActivity
    public void processResult(String str) {
        Odnoklassniki instance = Odnoklassniki.getInstance();
        Intent intent = new Intent();
        if (instance != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if ("error".equals(jSONObject.getString("type"))) {
                    intent.putExtra("error", jSONObject.getString("message"));
                } else {
                    intent.putExtra("result", jSONObject.toString());
                }
            } catch (JSONException unused) {
                intent.putExtra("error", str);
            }
        }
        setResult(-1, intent);
        finish();
    }
}
