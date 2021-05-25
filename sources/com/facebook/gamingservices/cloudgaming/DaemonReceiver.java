package com.facebook.gamingservices.cloudgaming;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import java.net.HttpURLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
public class DaemonReceiver {
    @Nullable
    public static DaemonReceiver a;
    public static ConcurrentHashMap<String, CompletableFuture<GraphResponse>> b;
    public static SDKLogger c;

    public static class b extends BroadcastReceiver {
        public b(a aVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CompletableFuture<GraphResponse> remove;
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra(SDKConstants.RECEIVER_PAYLOAD));
                String string = jSONObject.getString(SDKConstants.REQUEST_ID);
                if (DaemonReceiver.b.containsKey(string) && (remove = DaemonReceiver.b.remove(string)) != null) {
                    remove.complete(DaemonReceiver.a(jSONObject, string));
                }
            } catch (JSONException unused) {
            }
        }
    }

    @SuppressLint({"BadDependencyInjection"})
    public DaemonReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter(SDKConstants.RECEIVER_INTENT);
        HandlerThread handlerThread = new HandlerThread(SDKConstants.RECEIVER_HANDLER);
        handlerThread.start();
        context.registerReceiver(new b(null), intentFilter, null, new Handler(handlerThread.getLooper()));
        b = new ConcurrentHashMap<>();
        c = SDKLogger.getInstance(context);
    }

    public static GraphResponse a(JSONObject jSONObject, String str) {
        GraphResponse graphResponse;
        if (!jSONObject.isNull("success")) {
            if (jSONObject.optJSONObject("success") != null) {
                c.logSendingSuccessResponse(str);
                return new GraphResponse((GraphRequest) null, (HttpURLConnection) null, (String) null, jSONObject.optJSONObject("success"));
            } else if (jSONObject.optJSONArray("success") == null) {
                return b(str);
            } else {
                c.logSendingSuccessResponse(str);
                return new GraphResponse((GraphRequest) null, (HttpURLConnection) null, (String) null, jSONObject.optJSONArray("success"));
            }
        } else if (jSONObject.isNull("error")) {
            return b(str);
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject != null) {
                graphResponse = c(new FacebookRequestError(optJSONObject.optInt("code"), optJSONObject.optString("type"), optJSONObject.optString("message")), str);
            } else {
                graphResponse = b(str);
            }
            return graphResponse;
        }
    }

    public static GraphResponse b(String str) {
        return c(new FacebookRequestError(20, "UNSUPPORTED_FORMAT", "The response format is invalid."), str);
    }

    public static GraphResponse c(FacebookRequestError facebookRequestError, @Nullable String str) {
        c.logSendingErrorResponse(facebookRequestError, str);
        return new GraphResponse(null, null, facebookRequestError);
    }
}
