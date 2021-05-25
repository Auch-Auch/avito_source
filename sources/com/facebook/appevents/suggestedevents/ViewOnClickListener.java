package com.facebook.appevents.suggestedevents;

import a2.g.k.a0.b;
import a2.g.k.a0.c;
import a2.g.k.a0.e;
import a2.g.k.a0.f;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY})
@AutoHandleExceptions
public final class ViewOnClickListener implements View.OnClickListener {
    public static final String OTHER_EVENT = "other";
    public static final Set<Integer> e = new HashSet();
    @Nullable
    public View.OnClickListener a;
    public WeakReference<View> b;
    public WeakReference<View> c;
    public String d;

    public ViewOnClickListener(View view, View view2, String str) {
        this.a = ViewHierarchy.getExistingOnClickListener(view);
        this.c = new WeakReference<>(view);
        this.b = new WeakReference<>(view2);
        this.d = str.toLowerCase().replace("activity", "");
    }

    public static void a(String str, String str2, float[] fArr) {
        if (SuggestedEventsManager.b.contains(str)) {
            new InternalAppEventsLogger(FacebookSdk.getApplicationContext()).logEventFromSE(str, str2);
        } else if (SuggestedEventsManager.c.contains(str)) {
            Bundle bundle = new Bundle();
            try {
                bundle.putString("event_name", str);
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb = new StringBuilder();
                for (float f : fArr) {
                    sb.append(f);
                    sb.append(",");
                }
                jSONObject.put("dense", sb.toString());
                jSONObject.put("button_text", str2);
                bundle.putString("metadata", jSONObject.toString());
                GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, "%s/suggested_events", FacebookSdk.getApplicationId()), null, null);
                newPostRequest.setParameters(bundle);
                newPostRequest.executeAndWait();
            } catch (JSONException unused) {
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        View.OnClickListener onClickListener = this.a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        View view2 = this.b.get();
        View view3 = this.c.get();
        if (view2 != null && view3 != null) {
            try {
                String d2 = c.d(view3);
                String b2 = b.b(view3, d2);
                if (b2 != null) {
                    Map<String, String> map = b.a;
                    String str = map.containsKey(b2) ? map.get(b2) : null;
                    if (str == null) {
                        z = false;
                    } else {
                        if (!str.equals("other")) {
                            Utility.runOnNonUiThread(new e(str, d2));
                        }
                        z = true;
                    }
                    if (!z) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("view", c.b(view2, view3));
                        jSONObject.put(ViewHierarchyConstants.SCREEN_NAME_KEY, this.d);
                        Utility.runOnNonUiThread(new f(this, jSONObject, d2, b2));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
