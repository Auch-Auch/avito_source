package a2.g.k;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public class p {
    public static final String b = "p";
    public Context a;

    public p(Context context) {
        this.a = context;
    }

    @JavascriptInterface
    public String getProtocol() {
        return "fbmq-0.1";
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        Bundle bundle;
        if (str == null) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, b, "Can't bridge an event without a referral Pixel ID. Check your webview Pixel configuration");
            return;
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(this.a);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.getString(next));
            }
        } catch (JSONException unused) {
            bundle = new Bundle();
        }
        bundle.putString("_fb_pixel_referral_id", str);
        internalAppEventsLogger.logEvent(str2, bundle);
    }
}
