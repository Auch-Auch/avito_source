package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
public final class AccessTokenManager {
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    public static final String TAG = "AccessTokenManager";
    public static volatile AccessTokenManager f;
    public final LocalBroadcastManager a;
    public final a2.g.a b;
    public AccessToken c;
    public AtomicBoolean d = new AtomicBoolean(false);
    public Date e = new Date(0);

    public class a implements Runnable {
        public final /* synthetic */ AccessToken.AccessTokenRefreshCallback a;

        public a(AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
            this.a = accessTokenRefreshCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            AccessTokenManager.this.c(this.a);
        }
    }

    public class b implements GraphRequest.Callback {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ Set b;
        public final /* synthetic */ Set c;
        public final /* synthetic */ Set d;

        public b(AccessTokenManager accessTokenManager, AtomicBoolean atomicBoolean, Set set, Set set2, Set set3) {
            this.a = atomicBoolean;
            this.b = set;
            this.c = set2;
            this.d = set3;
        }

        @Override // com.facebook.GraphRequest.Callback
        public void onCompleted(GraphResponse graphResponse) {
            JSONArray optJSONArray;
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("data")) == null)) {
                this.a.set(true);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("permission");
                        String optString2 = optJSONObject.optString("status");
                        if (!Utility.isNullOrEmpty(optString) && !Utility.isNullOrEmpty(optString2)) {
                            String lowerCase = optString2.toLowerCase(Locale.US);
                            if (lowerCase.equals("granted")) {
                                this.b.add(optString);
                            } else if (lowerCase.equals("declined")) {
                                this.c.add(optString);
                            } else if (lowerCase.equals("expired")) {
                                this.d.add(optString);
                            }
                        }
                    }
                }
            }
        }
    }

    public class c implements GraphRequest.Callback {
        public final /* synthetic */ e a;

        public c(AccessTokenManager accessTokenManager, e eVar) {
            this.a = eVar;
        }

        @Override // com.facebook.GraphRequest.Callback
        public void onCompleted(GraphResponse graphResponse) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject != null) {
                this.a.a = jSONObject.optString("access_token");
                this.a.b = jSONObject.optInt("expires_at");
                this.a.c = Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME));
                this.a.d = jSONObject.optString(NativeProtocol.RESULT_ARGS_GRAPH_DOMAIN, null);
            }
        }
    }

    public class d implements GraphRequestBatch.Callback {
        public final /* synthetic */ AccessToken a;
        public final /* synthetic */ AccessToken.AccessTokenRefreshCallback b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ e d;
        public final /* synthetic */ Set e;
        public final /* synthetic */ Set f;
        public final /* synthetic */ Set g;

        public d(AccessToken accessToken, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback, AtomicBoolean atomicBoolean, e eVar, Set set, Set set2, Set set3) {
            this.a = accessToken;
            this.b = accessTokenRefreshCallback;
            this.c = atomicBoolean;
            this.d = eVar;
            this.e = set;
            this.f = set2;
            this.g = set3;
        }

        @Override // com.facebook.GraphRequestBatch.Callback
        public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
            AccessToken accessToken;
            Throwable th;
            AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback;
            Set<String> set;
            Set<String> set2;
            Date date;
            Date date2;
            try {
                if (AccessTokenManager.a().c != null) {
                    if (AccessTokenManager.a().c.getUserId() == this.a.getUserId()) {
                        if (!this.c.get()) {
                            e eVar = this.d;
                            if (eVar.a == null && eVar.b == 0) {
                                AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback2 = this.b;
                                if (accessTokenRefreshCallback2 != null) {
                                    accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                                }
                                AccessTokenManager.this.d.set(false);
                            }
                        }
                        String str = this.d.a;
                        if (str == null) {
                            str = this.a.getToken();
                        }
                        String applicationId = this.a.getApplicationId();
                        String userId = this.a.getUserId();
                        Set<String> permissions2 = this.c.get() ? this.e : this.a.getPermissions();
                        if (this.c.get()) {
                            set = this.f;
                        } else {
                            set = this.a.getDeclinedPermissions();
                        }
                        if (this.c.get()) {
                            set2 = this.g;
                        } else {
                            set2 = this.a.getExpiredPermissions();
                        }
                        AccessTokenSource source = this.a.getSource();
                        if (this.d.b != 0) {
                            date = new Date(((long) this.d.b) * 1000);
                        } else {
                            date = this.a.getExpires();
                        }
                        Date date3 = new Date();
                        if (this.d.c != null) {
                            date2 = new Date(1000 * this.d.c.longValue());
                        } else {
                            date2 = this.a.getDataAccessExpirationTime();
                        }
                        accessToken = new AccessToken(str, applicationId, userId, permissions2, set, set2, source, date, date3, date2, this.d.d);
                        try {
                            AccessTokenManager.a().e(accessToken, true);
                            AccessTokenManager.this.d.set(false);
                            AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback3 = this.b;
                            if (accessTokenRefreshCallback3 != null) {
                                accessTokenRefreshCallback3.OnTokenRefreshed(accessToken);
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            AccessTokenManager.this.d.set(false);
                            accessTokenRefreshCallback = this.b;
                            if (!(accessTokenRefreshCallback == null || accessToken == null)) {
                                accessTokenRefreshCallback.OnTokenRefreshed(accessToken);
                            }
                            throw th;
                        }
                    }
                }
                AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback4 = this.b;
                if (accessTokenRefreshCallback4 != null) {
                    accessTokenRefreshCallback4.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
                }
                AccessTokenManager.this.d.set(false);
            } catch (Throwable th3) {
                th = th3;
                accessToken = null;
                AccessTokenManager.this.d.set(false);
                accessTokenRefreshCallback = this.b;
                accessTokenRefreshCallback.OnTokenRefreshed(accessToken);
                throw th;
            }
        }
    }

    public static class e {
        public String a;
        public int b;
        public Long c;
        public String d;

        public e(a aVar) {
        }
    }

    public AccessTokenManager(LocalBroadcastManager localBroadcastManager, a2.g.a aVar) {
        Validate.notNull(localBroadcastManager, "localBroadcastManager");
        Validate.notNull(aVar, "accessTokenCache");
        this.a = localBroadcastManager;
        this.b = aVar;
    }

    public static AccessTokenManager a() {
        if (f == null) {
            synchronized (AccessTokenManager.class) {
                if (f == null) {
                    f = new AccessTokenManager(LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()), new a2.g.a());
                }
            }
        }
        return f;
    }

    public void b(AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            c(accessTokenRefreshCallback);
        } else {
            new Handler(Looper.getMainLooper()).post(new a(accessTokenRefreshCallback));
        }
    }

    public final void c(AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AccessToken accessToken = this.c;
        if (accessToken == null) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
        } else if (this.d.compareAndSet(false, true)) {
            this.e = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            e eVar = new e(null);
            b bVar = new b(this, atomicBoolean, hashSet, hashSet2, hashSet3);
            Bundle bundle = new Bundle();
            HttpMethod httpMethod = HttpMethod.GET;
            c cVar = new c(this, eVar);
            Bundle y1 = a2.b.a.a.a.y1("grant_type", "fb_extend_sso_token");
            y1.putString("client_id", accessToken.getApplicationId());
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(new GraphRequest(accessToken, "me/permissions", bundle, httpMethod, bVar), new GraphRequest(accessToken, "oauth/access_token", y1, httpMethod, cVar));
            graphRequestBatch.addCallback(new d(accessToken, accessTokenRefreshCallback, atomicBoolean, eVar, hashSet, hashSet2, hashSet3));
            graphRequestBatch.executeAsync();
        } else if (accessTokenRefreshCallback != null) {
            accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
        }
    }

    public final void d(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.a.sendBroadcast(intent);
    }

    public final void e(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.c;
        this.c = accessToken;
        this.d.set(false);
        this.e = new Date(0);
        if (z) {
            if (accessToken != null) {
                this.b.b(accessToken);
            } else {
                a2.g.a aVar = this.b;
                aVar.a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
                if (FacebookSdk.isLegacyTokenUpgradeSupported()) {
                    aVar.a().b.edit().clear().apply();
                }
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            d(accessToken2, accessToken);
            Context applicationContext = FacebookSdk.getApplicationContext();
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (AccessToken.isCurrentAccessTokenActive() && currentAccessToken.getExpires() != null && alarmManager != null) {
                Intent intent = new Intent(applicationContext, CurrentAccessTokenExpirationBroadcastReceiver.class);
                intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
                try {
                    alarmManager.set(1, currentAccessToken.getExpires().getTime(), PendingIntent.getBroadcast(applicationContext, 0, intent, 0));
                } catch (Exception unused) {
                }
            }
        }
    }
}
