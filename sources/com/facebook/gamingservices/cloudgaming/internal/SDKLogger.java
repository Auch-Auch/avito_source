package com.facebook.gamingservices.cloudgaming.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.FacebookRequestError;
import com.facebook.appevents.InternalAppEventsLogger;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
public class SDKLogger {
    public static SDKLogger e;
    public final InternalAppEventsLogger a;
    public String b = null;
    public String c = null;
    public ConcurrentHashMap<String, String> d;

    public SDKLogger(Context context) {
        this.a = new InternalAppEventsLogger(context);
        this.d = new ConcurrentHashMap<>();
    }

    public static synchronized SDKLogger getInstance(Context context) {
        SDKLogger sDKLogger;
        synchronized (SDKLogger.class) {
            if (e == null) {
                e = new SDKLogger(context);
            }
            sDKLogger = e;
        }
        return sDKLogger;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.b;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = this.c;
        if (str2 != null) {
            bundle.putString(SDKAnalyticsEvents.PARAMETER_SESSION_ID, str2);
        }
        return bundle;
    }

    public final Bundle b(@Nullable String str) {
        Bundle a3 = a();
        if (str != null) {
            String orDefault = this.d.getOrDefault(str, null);
            a3.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str);
            if (orDefault != null) {
                a3.putString(SDKAnalyticsEvents.PARAMETER_FUNCTION_TYPE, orDefault);
                this.d.remove(str);
            }
        }
        return a3;
    }

    public void logLoginSuccess() {
        this.a.logEventImplicitly(SDKAnalyticsEvents.EVENT_LOGIN_SUCCESS, a());
    }

    public void logPreparingRequest(String str, String str2, JSONObject jSONObject) {
        Bundle a3 = a();
        a3.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str2);
        a3.putString(SDKAnalyticsEvents.PARAMETER_FUNCTION_TYPE, str);
        a3.putString("payload", jSONObject.toString());
        this.a.logEventImplicitly(SDKAnalyticsEvents.EVENT_PREPARING_REQUEST, a3);
    }

    public void logSendingErrorResponse(FacebookRequestError facebookRequestError, @Nullable String str) {
        Bundle b2 = b(str);
        b2.putString("error_code", Integer.toString(facebookRequestError.getErrorCode()));
        b2.putString("error_type", facebookRequestError.getErrorType());
        b2.putString("error_message", facebookRequestError.getErrorMessage());
        this.a.logEventImplicitly(SDKAnalyticsEvents.EVENT_SENDING_ERROR_RESPONSE, b2);
    }

    public void logSendingSuccessResponse(String str) {
        this.a.logEventImplicitly(SDKAnalyticsEvents.EVENT_SENDING_SUCCESS_RESPONSE, b(str));
    }

    public void logSentRequest(String str, String str2, JSONObject jSONObject) {
        Bundle a3 = a();
        a3.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str2);
        a3.putString(SDKAnalyticsEvents.PARAMETER_FUNCTION_TYPE, str);
        this.d.put(str2, str);
        a3.putString("payload", jSONObject.toString());
        this.a.logEventImplicitly(SDKAnalyticsEvents.EVENT_SENT_REQUEST, a3);
    }

    public void setAppID(String str) {
        this.b = str;
    }

    public void setSessionID(String str) {
        this.c = str;
    }

    public void setUserID(String str) {
    }
}
