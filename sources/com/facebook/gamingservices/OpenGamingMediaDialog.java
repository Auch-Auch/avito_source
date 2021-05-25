package com.facebook.gamingservices;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;
public class OpenGamingMediaDialog implements GraphRequest.OnProgressCallback {
    public Context a;
    public GraphRequest.Callback b;

    public OpenGamingMediaDialog(Context context) {
        this(context, null);
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        GraphRequest.Callback callback = this.b;
        if (callback != null) {
            callback.onCompleted(graphResponse);
        }
        if (graphResponse != null && graphResponse.getError() == null) {
            String optString = graphResponse.getJSONObject().optString("id", null);
            String optString2 = graphResponse.getJSONObject().optString("video_id", null);
            if (optString != null || optString2 != null) {
                if (optString == null) {
                    optString = optString2;
                }
                if (CloudGameLoginHandler.isRunningInCloud()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", optString);
                        jSONObject.put("deepLink", "MEDIA_ASSET");
                        DaemonRequest.executeAsync(this.a, jSONObject, null, SDKMessageEnum.OPEN_GAMING_SERVICES_DEEP_LINK);
                    } catch (JSONException unused) {
                    }
                } else {
                    this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(a.c3("https://fb.gg/me/media_asset/", optString))));
                }
            }
        }
    }

    @Override // com.facebook.GraphRequest.OnProgressCallback
    public void onProgress(long j, long j2) {
        GraphRequest.Callback callback = this.b;
        if (callback != null && (callback instanceof GraphRequest.OnProgressCallback)) {
            ((GraphRequest.OnProgressCallback) callback).onProgress(j, j2);
        }
    }

    public OpenGamingMediaDialog(Context context, GraphRequest.Callback callback) {
        this.a = context;
        this.b = callback;
    }
}
