package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.ok.android.sdk.Shared;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class FetchedAppGateKeepersManager {
    public static final AtomicBoolean a = new AtomicBoolean(false);
    public static final ConcurrentLinkedQueue<Callback> b = new ConcurrentLinkedQueue<>();
    public static final Map<String, JSONObject> c = new ConcurrentHashMap();
    @Nullable
    public static Long d;

    public interface Callback {
        void onCompleted();
    }

    public static class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;

        public a(String str, Context context, String str2) {
            this.a = str;
            this.b = context;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject a3 = FetchedAppGateKeepersManager.a(this.a);
            if (a3 != null) {
                FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON(this.a, a3);
                this.b.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(this.c, a3.toString()).apply();
                FetchedAppGateKeepersManager.d = Long.valueOf(System.currentTimeMillis());
            }
            FetchedAppGateKeepersManager.c();
            FetchedAppGateKeepersManager.a.set(false);
        }
    }

    public static class b implements Runnable {
        public final /* synthetic */ Callback a;

        public b(Callback callback) {
            this.a = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onCompleted();
        }
    }

    @Nullable
    public static JSONObject a(String str) {
        Bundle y1 = a2.b.a.a.a.y1(Shared.PARAM_PLATFORM, "android");
        y1.putString("sdk_version", FacebookSdk.getSdkVersion());
        y1.putString("fields", "gatekeepers");
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, String.format("%s/%s", str, "mobile_sdk_gk"), null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(y1);
        return newGraphPathRequest.executeAndWait().getJSONObject();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void b(@androidx.annotation.Nullable com.facebook.internal.FetchedAppGateKeepersManager.Callback r8) {
        /*
            java.lang.Class<com.facebook.internal.FetchedAppGateKeepersManager> r0 = com.facebook.internal.FetchedAppGateKeepersManager.class
            monitor-enter(r0)
            if (r8 == 0) goto L_0x000a
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppGateKeepersManager$Callback> r1 = com.facebook.internal.FetchedAppGateKeepersManager.b     // Catch:{ all -> 0x0080 }
            r1.add(r8)     // Catch:{ all -> 0x0080 }
        L_0x000a:
            java.lang.Long r8 = com.facebook.internal.FetchedAppGateKeepersManager.d     // Catch:{ all -> 0x0080 }
            r1 = 0
            r2 = 1
            if (r8 != 0) goto L_0x0011
            goto L_0x0023
        L_0x0011:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0080 }
            long r5 = r8.longValue()     // Catch:{ all -> 0x0080 }
            long r3 = r3 - r5
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 >= 0) goto L_0x0023
            r8 = 1
            goto L_0x0024
        L_0x0023:
            r8 = 0
        L_0x0024:
            if (r8 == 0) goto L_0x002b
            c()     // Catch:{ all -> 0x0080 }
            monitor-exit(r0)
            return
        L_0x002b:
            android.content.Context r8 = com.facebook.FacebookSdk.getApplicationContext()
            java.lang.String r3 = com.facebook.FacebookSdk.getApplicationId()
            java.lang.String r4 = "com.facebook.internal.APP_GATEKEEPERS.%s"
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r1] = r3
            java.lang.String r4 = java.lang.String.format(r4, r5)
            if (r8 != 0) goto L_0x0041
            monitor-exit(r0)
            return
        L_0x0041:
            java.lang.String r5 = "com.facebook.internal.preferences.APP_GATEKEEPERS"
            android.content.SharedPreferences r5 = r8.getSharedPreferences(r5, r1)
            r6 = 0
            java.lang.String r5 = r5.getString(r4, r6)
            boolean r7 = com.facebook.internal.Utility.isNullOrEmpty(r5)
            if (r7 != 0) goto L_0x0064
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0059 }
            r7.<init>(r5)     // Catch:{ JSONException -> 0x0059 }
            r6 = r7
            goto L_0x005f
        L_0x0059:
            r5 = move-exception
            java.lang.String r7 = "FacebookSDK"
            com.facebook.internal.Utility.logd(r7, r5)
        L_0x005f:
            if (r6 == 0) goto L_0x0064
            parseAppGateKeepersFromJSON(r3, r6)
        L_0x0064:
            java.util.concurrent.Executor r5 = com.facebook.FacebookSdk.getExecutor()
            if (r5 != 0) goto L_0x006c
            monitor-exit(r0)
            return
        L_0x006c:
            java.util.concurrent.atomic.AtomicBoolean r6 = com.facebook.internal.FetchedAppGateKeepersManager.a
            boolean r1 = r6.compareAndSet(r1, r2)
            if (r1 != 0) goto L_0x0076
            monitor-exit(r0)
            return
        L_0x0076:
            com.facebook.internal.FetchedAppGateKeepersManager$a r1 = new com.facebook.internal.FetchedAppGateKeepersManager$a
            r1.<init>(r3, r8, r4)
            r5.execute(r1)
            monitor-exit(r0)
            return
        L_0x0080:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FetchedAppGateKeepersManager.b(com.facebook.internal.FetchedAppGateKeepersManager$Callback):void");
    }

    public static void c() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue<Callback> concurrentLinkedQueue = b;
            if (!concurrentLinkedQueue.isEmpty()) {
                Callback poll = concurrentLinkedQueue.poll();
                if (poll != null) {
                    handler.post(new b(poll));
                }
            } else {
                return;
            }
        }
    }

    public static boolean getGateKeeperForKey(String str, String str2, boolean z) {
        Boolean bool;
        Map<String, Boolean> gateKeepersForApplication = getGateKeepersForApplication(str2);
        if (gateKeepersForApplication.containsKey(str) && (bool = gateKeepersForApplication.get(str)) != null) {
            return bool.booleanValue();
        }
        return z;
    }

    public static Map<String, Boolean> getGateKeepersForApplication(String str) {
        b(null);
        if (str != null) {
            Map<String, JSONObject> map = c;
            if (map.containsKey(str)) {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = map.get(str);
                if (jSONObject == null) {
                    return new HashMap();
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, Boolean.valueOf(jSONObject.optBoolean(next)));
                }
                return hashMap;
            }
        }
        return new HashMap();
    }

    public static synchronized JSONObject parseAppGateKeepersFromJSON(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (FetchedAppGateKeepersManager.class) {
            Map<String, JSONObject> map = c;
            if (map.containsKey(str)) {
                jSONObject2 = map.get(str);
            } else {
                jSONObject2 = new JSONObject();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            JSONObject jSONObject3 = null;
            if (optJSONArray != null) {
                jSONObject3 = optJSONArray.optJSONObject(0);
            }
            if (!(jSONObject3 == null || jSONObject3.optJSONArray("gatekeepers") == null)) {
                JSONArray optJSONArray2 = jSONObject3.optJSONArray("gatekeepers");
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    try {
                        JSONObject jSONObject4 = optJSONArray2.getJSONObject(i);
                        jSONObject2.put(jSONObject4.getString("key"), jSONObject4.getBoolean("value"));
                    } catch (JSONException e) {
                        Utility.logd("FacebookSDK", e);
                    }
                }
            }
            c.put(str, jSONObject2);
        }
        return jSONObject2;
    }
}
