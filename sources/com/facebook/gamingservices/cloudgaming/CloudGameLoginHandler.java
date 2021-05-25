package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class CloudGameLoginHandler {
    public static boolean a = false;
    public static SDKLogger b;

    public static List<String> a(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (!str.isEmpty()) {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.get(i).toString());
            }
        }
        return arrayList;
    }

    @Nullable
    public static AccessToken b(JSONObject jSONObject) throws JSONException {
        String optString = jSONObject.optString(SDKConstants.PARAM_ACCESS_TOKEN);
        String optString2 = jSONObject.optString(SDKConstants.PARAM_ACCESS_TOKEN_SOURCE);
        String optString3 = jSONObject.optString(SDKConstants.PARAM_APP_ID);
        String optString4 = jSONObject.optString(SDKConstants.PARAM_DECLINED_PERMISSIONS);
        String optString5 = jSONObject.optString(SDKConstants.PARAM_EXPIRED_PERMISSIONS);
        String optString6 = jSONObject.optString(SDKConstants.PARAM_EXPIRATION_TIME);
        String optString7 = jSONObject.optString(SDKConstants.PARAM_DATA_ACCESS_EXPIRATION_TIME);
        String optString8 = jSONObject.optString(SDKConstants.PARAM_GRAPH_DOMAIN);
        String optString9 = jSONObject.optString(SDKConstants.PARAM_LAST_REFRESH_TIME);
        String optString10 = jSONObject.optString("permissions");
        String optString11 = jSONObject.optString(SDKConstants.PARAM_USER_ID);
        String optString12 = jSONObject.optString(SDKConstants.PARAM_SESSION_ID);
        String str = null;
        if (optString.isEmpty() || optString3.isEmpty() || optString11.isEmpty()) {
            return null;
        }
        SDKLogger sDKLogger = b;
        if (sDKLogger != null) {
            sDKLogger.setAppID(optString3);
            b.setUserID(optString11);
            b.setSessionID(optString12);
        }
        List<String> a3 = a(optString10);
        List<String> a4 = a(optString4);
        List<String> a5 = a(optString5);
        AccessTokenSource valueOf = !optString2.isEmpty() ? AccessTokenSource.valueOf(optString2) : null;
        Date date = !optString6.isEmpty() ? new Date(((long) Integer.parseInt(optString6)) * 1000) : null;
        Date date2 = !optString9.isEmpty() ? new Date(((long) Integer.parseInt(optString9)) * 1000) : null;
        Date date3 = !optString7.isEmpty() ? new Date(((long) Integer.parseInt(optString7)) * 1000) : null;
        if (!optString8.isEmpty()) {
            str = optString8;
        }
        AccessToken accessToken = new AccessToken(optString, optString3, optString11, a3, a4, a5, valueOf, date, date2, date3, str);
        AccessToken.setCurrentAccessToken(accessToken);
        return accessToken;
    }

    @Nullable
    public static synchronized AccessToken init(Context context) throws FacebookException {
        AccessToken init;
        synchronized (CloudGameLoginHandler.class) {
            init = init(context, 5);
        }
        return init;
    }

    public static boolean isRunningInCloud() {
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009a  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.facebook.AccessToken init(android.content.Context r6, int r7) throws com.facebook.FacebookException {
        /*
            java.lang.Class<com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler> r0 = com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler.class
            monitor-enter(r0)
            if (r7 > 0) goto L_0x0006
            r7 = 5
        L_0x0006:
            com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum r1 = com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum.IS_ENV_READY     // Catch:{ all -> 0x0098 }
            r2 = 0
            com.facebook.GraphResponse r1 = com.facebook.gamingservices.cloudgaming.DaemonRequest.executeAndWait(r6, r2, r1, r7)     // Catch:{ all -> 0x0098 }
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0020
            org.json.JSONObject r5 = r1.getJSONObject()     // Catch:{ all -> 0x0098 }
            if (r5 != 0) goto L_0x0018
            goto L_0x0020
        L_0x0018:
            com.facebook.FacebookRequestError r1 = r1.getError()     // Catch:{ all -> 0x0098 }
            if (r1 != 0) goto L_0x0020
            r1 = 1
            goto L_0x0021
        L_0x0020:
            r1 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x009a
            com.facebook.gamingservices.cloudgaming.internal.SDKLogger r1 = com.facebook.gamingservices.cloudgaming.internal.SDKLogger.getInstance(r6)     // Catch:{ all -> 0x0098 }
            com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler.b = r1     // Catch:{ all -> 0x0098 }
            com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum r1 = com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum.GET_ACCESS_TOKEN     // Catch:{ all -> 0x0098 }
            com.facebook.GraphResponse r7 = com.facebook.gamingservices.cloudgaming.DaemonRequest.executeAndWait(r6, r2, r1, r7)     // Catch:{ all -> 0x0098 }
            if (r7 == 0) goto L_0x0090
            org.json.JSONObject r1 = r7.getJSONObject()     // Catch:{ all -> 0x0098 }
            if (r1 == 0) goto L_0x0090
            com.facebook.FacebookRequestError r1 = r7.getError()     // Catch:{ all -> 0x0098 }
            if (r1 != 0) goto L_0x0082
            org.json.JSONObject r1 = r7.getJSONObject()     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = "daemonPackageName"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ all -> 0x0098 }
            boolean r5 = r1.isEmpty()     // Catch:{ all -> 0x0098 }
            if (r5 != 0) goto L_0x007a
            java.lang.String r5 = "com.facebook.gamingservices.cloudgaming:preferences"
            android.content.SharedPreferences r6 = r6.getSharedPreferences(r5, r4)     // Catch:{ all -> 0x0098 }
            android.content.SharedPreferences$Editor r6 = r6.edit()     // Catch:{ all -> 0x0098 }
            r6.putString(r2, r1)     // Catch:{ all -> 0x0098 }
            r6.commit()     // Catch:{ all -> 0x0098 }
            org.json.JSONObject r6 = r7.getJSONObject()     // Catch:{ JSONException -> 0x0071 }
            com.facebook.AccessToken r6 = b(r6)     // Catch:{ JSONException -> 0x0071 }
            com.facebook.Profile.fetchProfileForCurrentAccessToken()     // Catch:{ JSONException -> 0x0071 }
            com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler.a = r3     // Catch:{ JSONException -> 0x0071 }
            com.facebook.gamingservices.cloudgaming.internal.SDKLogger r7 = com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler.b     // Catch:{ JSONException -> 0x0071 }
            r7.logLoginSuccess()     // Catch:{ JSONException -> 0x0071 }
            monitor-exit(r0)
            return r6
        L_0x0071:
            r6 = move-exception
            com.facebook.FacebookException r7 = new com.facebook.FacebookException
            java.lang.String r1 = "Cannot properly handle response."
            r7.<init>(r1, r6)
            throw r7
        L_0x007a:
            com.facebook.FacebookException r6 = new com.facebook.FacebookException
            java.lang.String r7 = "Could not establish a secure connection."
            r6.<init>(r7)
            throw r6
        L_0x0082:
            com.facebook.FacebookException r6 = new com.facebook.FacebookException
            com.facebook.FacebookRequestError r7 = r7.getError()
            java.lang.String r7 = r7.getErrorMessage()
            r6.<init>(r7)
            throw r6
        L_0x0090:
            com.facebook.FacebookException r6 = new com.facebook.FacebookException
            java.lang.String r7 = "Cannot receive response."
            r6.<init>(r7)
            throw r6
        L_0x0098:
            r6 = move-exception
            goto L_0x00a2
        L_0x009a:
            com.facebook.FacebookException r6 = new com.facebook.FacebookException
            java.lang.String r7 = "Not running in Cloud environment."
            r6.<init>(r7)
            throw r6
        L_0x00a2:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler.init(android.content.Context, int):com.facebook.AccessToken");
    }
}
