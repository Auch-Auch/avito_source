package ru.ok.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Currency;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
import ru.ok.android.sdk.util.OkAuthType;
import ru.ok.android.sdk.util.OkEncryptUtil;
import ru.ok.android.sdk.util.OkPayment;
import ru.ok.android.sdk.util.OkRequestUtil;
import ru.ok.android.sdk.util.OkThreadUtil;
import ru.ok.android.sdk.util.Utils;
public class Odnoklassniki {
    public static Odnoklassniki sOdnoklassniki;
    public Context a;
    public boolean allowDebugOkSso;
    public boolean allowWidgetRetry = true;
    public String b = Shared.REMOTE_API;
    public String c = Shared.REMOTE_WIDGETS;
    public String mAccessToken;
    public final String mAppId;
    public final String mAppKey;
    public String mSessionSecretKey;
    public final OkPayment okPayment;
    public String sdkToken;

    public class a implements Runnable {
        public final /* synthetic */ OkListener a;
        public final /* synthetic */ String b;

        public a(Odnoklassniki odnoklassniki, OkListener okListener, String str) {
            this.a = okListener;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onError(this.b);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ OkListener a;
        public final /* synthetic */ JSONObject b;

        public b(Odnoklassniki odnoklassniki, OkListener okListener, JSONObject jSONObject) {
            this.a = okListener;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onSuccess(this.b);
        }
    }

    public class c extends AsyncTask<Void, Void, Void> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ EnumSet c;
        public final /* synthetic */ OkListener d;

        public c(String str, Map map, EnumSet enumSet, OkListener okListener) {
            this.a = str;
            this.b = map;
            this.c = enumSet;
            this.d = okListener;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void[] voidArr) {
            Odnoklassniki.this.request(this.a, this.b, this.c, this.d);
            return null;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ OkListener a;

        public d(OkListener okListener) {
            this.a = okListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String request = Odnoklassniki.this.request("users.getLoggedInUser", null, null);
                if (request == null || request.length() <= 2 || !TextUtils.isDigitsOnly(request.substring(1, request.length() - 1))) {
                    try {
                        JSONObject jSONObject = new JSONObject(request);
                        if (jSONObject.has("error_msg")) {
                            Odnoklassniki.this.notifyFailed(this.a, jSONObject.getString("error_msg"));
                            return;
                        }
                    } catch (JSONException unused) {
                    }
                    Odnoklassniki.this.notifyFailed(this.a, request);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("access_token", Odnoklassniki.this.mAccessToken);
                    jSONObject2.put(Shared.PARAM_SESSION_SECRET_KEY, Odnoklassniki.this.mSessionSecretKey);
                    jSONObject2.put(Shared.PARAM_LOGGED_IN_USER, request);
                } catch (JSONException unused2) {
                }
                Odnoklassniki.this.okPayment.init();
                Odnoklassniki.this.notifySuccess(this.a, jSONObject2);
            } catch (IOException e) {
                Odnoklassniki.this.notifyFailed(this.a, e.getMessage());
            }
        }
    }

    public Odnoklassniki(Context context, String str, String str2) {
        this.a = context;
        this.mAppId = str;
        this.mAppKey = str2;
        this.okPayment = new OkPayment(context);
        this.mAccessToken = context.getSharedPreferences(Shared.PREFERENCES_FILE, 0).getString("acctkn", null);
        this.mSessionSecretKey = context.getSharedPreferences(Shared.PREFERENCES_FILE, 0).getString("ssk", null);
        this.sdkToken = context.getSharedPreferences(Shared.PREFERENCES_FILE, 0).getString("ok_sdk_tkn", null);
    }

    public static Odnoklassniki createInstance(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException(context.getString(R.string.no_application_data));
        }
        if (sOdnoklassniki == null) {
            sOdnoklassniki = new Odnoklassniki(context.getApplicationContext(), str, str2);
        }
        return sOdnoklassniki;
    }

    public static Odnoklassniki getInstance() {
        Odnoklassniki odnoklassniki = sOdnoklassniki;
        if (odnoklassniki != null) {
            return odnoklassniki;
        }
        throw new IllegalStateException("No instance available. Odnoklassniki.createInstance() needs to be called before Odnoklassniki.getInstance()");
    }

    public static boolean hasInstance() {
        return sOdnoklassniki != null;
    }

    public final void a(Activity activity, Class<? extends AbstractWidgetActivity> cls, HashMap<String, String> hashMap, int i) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra(Shared.PARAM_APP_ID, this.mAppId);
        intent.putExtra("access_token", this.mAccessToken);
        intent.putExtra(Shared.PARAM_WIDGET_RETRY_ALLOWED, this.allowWidgetRetry);
        intent.putExtra(Shared.PARAM_SESSION_SECRET_KEY, this.mSessionSecretKey);
        intent.putExtra(Shared.PARAM_WIDGET_ARGS, hashMap);
        activity.startActivityForResult(intent, i);
    }

    public final void checkValidTokens(OkListener okListener) {
        if (this.mAccessToken == null || this.mSessionSecretKey == null) {
            notifyFailed(okListener, this.a.getString(R.string.no_valid_token));
        } else {
            new Thread(new d(okListener)).start();
        }
    }

    public final void clearTokens() {
        this.mAccessToken = null;
        this.mSessionSecretKey = null;
        this.sdkToken = null;
        SharedPreferences.Editor edit = this.a.getSharedPreferences(Shared.PREFERENCES_FILE, 0).edit();
        edit.remove("acctkn");
        edit.remove("ssk");
        edit.remove("ok_sdk_tkn");
        edit.apply();
        CookieManager.getInstance().removeAllCookies(null);
    }

    public String getApiBaseUrl() {
        return this.b;
    }

    public String getConnectBaseUrl() {
        return this.c;
    }

    public boolean isActivityRequestInvite(int i) {
        return i == 22892;
    }

    public boolean isActivityRequestOAuth(int i) {
        return i == 22890;
    }

    public boolean isActivityRequestPost(int i) {
        return i == 22891;
    }

    public boolean isActivityRequestSuggest(int i) {
        return i == 22893;
    }

    public boolean isActivityRequestViral(int i) {
        return isActivityRequestPost(i) || isActivityRequestInvite(i) || isActivityRequestSuggest(i);
    }

    public final void notifyFailed(OkListener okListener, String str) {
        if (okListener != null) {
            OkThreadUtil.executeOnMain(new a(this, okListener, str));
        }
    }

    public final void notifySuccess(OkListener okListener, JSONObject jSONObject) {
        if (okListener != null) {
            OkThreadUtil.executeOnMain(new b(this, okListener, jSONObject));
        }
    }

    public boolean onActivityResultResult(int i, int i2, @Nullable Intent intent, OkListener okListener) {
        if (!isActivityRequestViral(i)) {
            return false;
        }
        if (intent == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Shared.PARAM_ACTIVITY_RESULT, i2);
            } catch (JSONException unused) {
            }
            okListener.onError(jSONObject.toString());
            return true;
        } else if (intent.hasExtra("error")) {
            okListener.onError(intent.getStringExtra("error"));
            return true;
        } else {
            try {
                okListener.onSuccess(new JSONObject(intent.getStringExtra("result")));
                return true;
            } catch (JSONException unused2) {
                okListener.onError(intent.getStringExtra("result"));
                return true;
            }
        }
    }

    public boolean onAuthActivityResult(int i, int i2, @Nullable Intent intent, OkListener okListener) {
        if (!isActivityRequestOAuth(i)) {
            return false;
        }
        if (intent == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Shared.PARAM_ACTIVITY_RESULT, i2);
            } catch (JSONException unused) {
            }
            okListener.onError(jSONObject.toString());
            return true;
        }
        String stringExtra = intent.getStringExtra("access_token");
        if (stringExtra == null) {
            String stringExtra2 = intent.getStringExtra("error");
            if (i2 != 3 || !(okListener instanceof OkAuthListener)) {
                okListener.onError(stringExtra2);
                return true;
            }
            ((OkAuthListener) okListener).onCancel(stringExtra2);
            return true;
        }
        String stringExtra3 = intent.getStringExtra(Shared.PARAM_SESSION_SECRET_KEY);
        String stringExtra4 = intent.getStringExtra("refresh_token");
        long longExtra = intent.getLongExtra("expires_in", 0);
        this.mAccessToken = stringExtra;
        if (stringExtra3 == null) {
            stringExtra3 = stringExtra4;
        }
        this.mSessionSecretKey = stringExtra3;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("access_token", this.mAccessToken);
            jSONObject2.put(Shared.PARAM_SESSION_SECRET_KEY, this.mSessionSecretKey);
            if (longExtra > 0) {
                jSONObject2.put("expires_in", longExtra);
            }
        } catch (JSONException unused2) {
        }
        this.okPayment.init();
        okListener.onSuccess(jSONObject2);
        return true;
    }

    public void performAppInvite(Activity activity, HashMap<String, String> hashMap) {
        a(activity, OkAppInviteActivity.class, hashMap, Shared.OK_INVITING_REQUEST_CODE);
    }

    public void performAppSuggest(Activity activity, HashMap<String, String> hashMap) {
        a(activity, OkAppSuggestActivity.class, hashMap, Shared.OK_SUGGESTING_REQUEST_CODE);
    }

    public void performPosting(Activity activity, String str, boolean z, @Nullable HashMap<String, String> hashMap) {
        Intent intent = new Intent(activity, OkPostingActivity.class);
        intent.putExtra(Shared.PARAM_APP_ID, this.mAppId);
        intent.putExtra("attachment", str);
        intent.putExtra("access_token", this.mAccessToken);
        intent.putExtra(Shared.PARAM_WIDGET_ARGS, hashMap);
        intent.putExtra(Shared.PARAM_WIDGET_RETRY_ALLOWED, this.allowWidgetRetry);
        intent.putExtra(Shared.PARAM_SESSION_SECRET_KEY, this.mSessionSecretKey);
        intent.putExtra(Shared.PARAM_USER_TEXT_ENABLE, z);
        activity.startActivityForResult(intent, Shared.OK_POSTING_REQUEST_CODE);
    }

    public void reportPayment(String str, String str2, Currency currency) {
        this.okPayment.report(str, str2, currency);
    }

    public final String request(String str, @Nullable Map<String, String> map, @Nullable EnumSet<OkRequestMode> enumSet) throws IOException {
        if (!TextUtils.isEmpty(str)) {
            if (enumSet == null) {
                enumSet = OkRequestMode.DEFAULT;
            }
            TreeMap treeMap = new TreeMap();
            if (map != null && !map.isEmpty()) {
                treeMap.putAll(map);
            }
            treeMap.put(Shared.PARAM_APP_KEY, this.mAppKey);
            treeMap.put("method", str);
            if (!enumSet.contains(OkRequestMode.NO_PLATFORM_REPORTING)) {
                treeMap.put(Shared.PARAM_PLATFORM, "ANDROID");
            }
            if (enumSet.contains(OkRequestMode.SDK_SESSION)) {
                if (!TextUtils.isEmpty(this.sdkToken)) {
                    treeMap.put(Shared.PARAM_SDK_TOKEN, this.sdkToken);
                } else {
                    throw new IllegalArgumentException("SDK token is required for method call, have not forget to call sdkInit?");
                }
            }
            if (enumSet.contains(OkRequestMode.SIGNED)) {
                StringBuilder sb = new StringBuilder(100);
                for (Map.Entry entry : treeMap.entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                }
                StringBuilder L = a2.b.a.a.a.L(sb.toString());
                L.append(this.mSessionSecretKey);
                treeMap.put("sig", OkEncryptUtil.toMD5(L.toString()));
                treeMap.put("access_token", this.mAccessToken);
            }
            return OkRequestUtil.executeRequest(treeMap);
        }
        throw new IllegalArgumentException(this.a.getString(R.string.api_method_cant_be_empty));
    }

    public final AsyncTask<Void, Void, Void> requestAsync(String str, @Nullable Map<String, String> map, @Nullable EnumSet<OkRequestMode> enumSet, @NonNull OkListener okListener) {
        return new c(str, map, enumSet, okListener).execute(new Void[0]);
    }

    public final void requestAuthorization(Activity activity, @Nullable String str, OkAuthType okAuthType, String... strArr) {
        Intent intent = new Intent(activity, OkAuthActivity.class);
        intent.putExtra("client_id", this.mAppId);
        intent.putExtra(Shared.PARAM_APP_KEY, this.mAppKey);
        intent.putExtra("redirect_uri", str);
        intent.putExtra("auth_type", okAuthType);
        intent.putExtra(Shared.PARAM_SCOPES, strArr);
        intent.putExtra(Shared.PARAM_ALLOW_DEBUG_OK_SSO, this.allowDebugOkSso);
        activity.startActivityForResult(intent, Shared.OK_AUTH_REQUEST_CODE);
    }

    public void setBasePlatformUrls(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public final boolean request(String str, @Nullable Map<String, String> map, @Nullable EnumSet<OkRequestMode> enumSet, OkListener okListener) {
        try {
            String request = request(str, map, enumSet);
            try {
                JSONObject jSONObject = new JSONObject(request);
                if (jSONObject.has("error_msg")) {
                    notifyFailed(okListener, jSONObject.optString("error_msg"));
                    return false;
                }
                notifySuccess(okListener, jSONObject);
                return true;
            } catch (JSONException unused) {
                notifySuccess(okListener, Utils.toJson("result", request));
                return true;
            }
        } catch (IOException e) {
            notifyFailed(okListener, Utils.toJson(OkListener.KEY_EXCEPTION, e.getMessage()).toString());
            return false;
        }
    }
}
