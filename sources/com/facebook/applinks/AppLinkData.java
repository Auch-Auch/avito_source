package com.facebook.applinks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.share.internal.ShareConstants;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class AppLinkData {
    public static final String ARGUMENTS_EXTRAS_KEY = "extras";
    public static final String ARGUMENTS_NATIVE_CLASS_KEY = "com.facebook.platform.APPLINK_NATIVE_CLASS";
    public static final String ARGUMENTS_NATIVE_URL = "com.facebook.platform.APPLINK_NATIVE_URL";
    public static final String ARGUMENTS_REFERER_DATA_KEY = "referer_data";
    public static final String ARGUMENTS_TAPTIME_KEY = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
    @Nullable
    public String a;
    @Nullable
    public Uri b;
    @Nullable
    public JSONObject c;
    @Nullable
    public Bundle d;
    @Nullable
    public String e;
    @Nullable
    public JSONObject f;

    public interface CompletionHandler {
        void onDeferredAppLinkDataFetched(@Nullable AppLinkData appLinkData);
    }

    public static class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CompletionHandler c;

        public a(Context context, String str, CompletionHandler completionHandler) {
            this.a = context;
            this.b = str;
            this.c = completionHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.a;
            String str = this.b;
            CompletionHandler completionHandler = this.c;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "DEFERRED_APP_LINK");
                Utility.setAppEventAttributionParameters(jSONObject, AttributionIdentifiers.getAttributionIdentifiers(context), AppEventsLogger.getAnonymousAppDeviceGUID(context), FacebookSdk.getLimitEventAndDataUsage(context));
                Utility.setAppEventExtendedDeviceInfoParameters(jSONObject, FacebookSdk.getApplicationContext());
                jSONObject.put("application_package_name", context.getPackageName());
                Object[] objArr = {str};
                AppLinkData appLinkData = null;
                try {
                    JSONObject jSONObject2 = GraphRequest.newPostRequest(null, String.format("%s/activities", objArr), jSONObject, null).executeAndWait().getJSONObject();
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("applink_args");
                        long optLong = jSONObject2.optLong("click_time", -1);
                        String optString2 = jSONObject2.optString("applink_class");
                        String optString3 = jSONObject2.optString("applink_url");
                        if (!TextUtils.isEmpty(optString) && (appLinkData = AppLinkData.a(optString)) != null) {
                            if (optLong != -1) {
                                try {
                                    JSONObject jSONObject3 = appLinkData.c;
                                    if (jSONObject3 != null) {
                                        jSONObject3.put(AppLinkData.ARGUMENTS_TAPTIME_KEY, optLong);
                                    }
                                    Bundle bundle = appLinkData.d;
                                    if (bundle != null) {
                                        bundle.putString(AppLinkData.ARGUMENTS_TAPTIME_KEY, Long.toString(optLong));
                                    }
                                } catch (JSONException unused) {
                                    Utility.logd("com.facebook.applinks.AppLinkData", "Unable to put tap time in AppLinkData.arguments");
                                }
                            }
                            if (optString2 != null) {
                                try {
                                    JSONObject jSONObject4 = appLinkData.c;
                                    if (jSONObject4 != null) {
                                        jSONObject4.put(AppLinkData.ARGUMENTS_NATIVE_CLASS_KEY, optString2);
                                    }
                                    Bundle bundle2 = appLinkData.d;
                                    if (bundle2 != null) {
                                        bundle2.putString(AppLinkData.ARGUMENTS_NATIVE_CLASS_KEY, optString2);
                                    }
                                } catch (JSONException unused2) {
                                    Utility.logd("com.facebook.applinks.AppLinkData", "Unable to put app link class name in AppLinkData.arguments");
                                }
                            }
                            if (optString3 != null) {
                                try {
                                    JSONObject jSONObject5 = appLinkData.c;
                                    if (jSONObject5 != null) {
                                        jSONObject5.put(AppLinkData.ARGUMENTS_NATIVE_URL, optString3);
                                    }
                                    Bundle bundle3 = appLinkData.d;
                                    if (bundle3 != null) {
                                        bundle3.putString(AppLinkData.ARGUMENTS_NATIVE_URL, optString3);
                                    }
                                } catch (JSONException unused3) {
                                    Utility.logd("com.facebook.applinks.AppLinkData", "Unable to put app link URL in AppLinkData.arguments");
                                }
                            }
                        }
                    }
                } catch (Exception unused4) {
                    Utility.logd("com.facebook.applinks.AppLinkData", "Unable to fetch deferred applink from server");
                }
                completionHandler.onDeferredAppLinkDataFetched(appLinkData);
            } catch (JSONException e) {
                throw new FacebookException("An error occurred while preparing deferred app link", e);
            }
        }
    }

    @Nullable
    public static AppLinkData a(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("version");
            if (jSONObject.getJSONObject(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS).getString("method").equals("applink") && string.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                AppLinkData appLinkData = new AppLinkData();
                JSONObject jSONObject2 = jSONObject.getJSONObject(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_ARGS);
                appLinkData.c = jSONObject2;
                if (jSONObject2.has("ref")) {
                    appLinkData.a = appLinkData.c.getString("ref");
                } else if (appLinkData.c.has(ARGUMENTS_REFERER_DATA_KEY)) {
                    JSONObject jSONObject3 = appLinkData.c.getJSONObject(ARGUMENTS_REFERER_DATA_KEY);
                    if (jSONObject3.has("fb_ref")) {
                        appLinkData.a = jSONObject3.getString("fb_ref");
                    }
                }
                if (appLinkData.c.has("target_url")) {
                    Uri parse = Uri.parse(appLinkData.c.getString("target_url"));
                    appLinkData.b = parse;
                    appLinkData.f = b(parse);
                }
                if (appLinkData.c.has(ARGUMENTS_EXTRAS_KEY)) {
                    JSONObject jSONObject4 = appLinkData.c.getJSONObject(ARGUMENTS_EXTRAS_KEY);
                    if (jSONObject4.has(ShareConstants.DEEPLINK_CONTEXT)) {
                        JSONObject jSONObject5 = jSONObject4.getJSONObject(ShareConstants.DEEPLINK_CONTEXT);
                        if (jSONObject5.has(ShareConstants.PROMO_CODE)) {
                            appLinkData.e = jSONObject5.getString(ShareConstants.PROMO_CODE);
                        }
                    }
                }
                appLinkData.d = c(appLinkData.c);
                return appLinkData;
            }
        } catch (JSONException e2) {
            Utility.logd("com.facebook.applinks.AppLinkData", "Unable to parse AppLink JSON", e2);
        } catch (FacebookException e3) {
            Utility.logd("com.facebook.applinks.AppLinkData", "Unable to parse AppLink JSON", e3);
        }
        return null;
    }

    @Nullable
    @AutoHandleExceptions
    public static JSONObject b(@Nullable Uri uri) {
        String queryParameter;
        if (uri == null || (queryParameter = uri.getQueryParameter("al_applink_data")) == null) {
            return null;
        }
        try {
            return new JSONObject(queryParameter);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static Bundle c(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                bundle.putBundle(next, c((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                int i = 0;
                if (jSONArray.length() == 0) {
                    bundle.putStringArray(next, new String[0]);
                } else {
                    Object obj2 = jSONArray.get(0);
                    if (obj2 instanceof JSONObject) {
                        Bundle[] bundleArr = new Bundle[jSONArray.length()];
                        while (i < jSONArray.length()) {
                            bundleArr[i] = c(jSONArray.getJSONObject(i));
                            i++;
                        }
                        bundle.putParcelableArray(next, bundleArr);
                    } else if (!(obj2 instanceof JSONArray)) {
                        String[] strArr = new String[jSONArray.length()];
                        while (i < jSONArray.length()) {
                            strArr[i] = jSONArray.get(i).toString();
                            i++;
                        }
                        bundle.putStringArray(next, strArr);
                    } else {
                        throw new FacebookException("Nested arrays are not supported.");
                    }
                }
            } else {
                bundle.putString(next, obj.toString());
            }
        }
        return bundle;
    }

    @Nullable
    @AutoHandleExceptions
    public static AppLinkData createFromActivity(Activity activity) {
        Validate.notNull(activity, "activity");
        Intent intent = activity.getIntent();
        AppLinkData appLinkData = null;
        if (intent == null) {
            return null;
        }
        AppLinkData createFromAlApplinkData = createFromAlApplinkData(intent);
        if (createFromAlApplinkData == null) {
            createFromAlApplinkData = a(intent.getStringExtra("com.facebook.platform.APPLINK_ARGS"));
        }
        if (createFromAlApplinkData != null) {
            return createFromAlApplinkData;
        }
        Uri data = intent.getData();
        if (data != null) {
            appLinkData = new AppLinkData();
            appLinkData.b = data;
            appLinkData.f = b(data);
        }
        return appLinkData;
    }

    @Nullable
    @AutoHandleExceptions
    public static AppLinkData createFromAlApplinkData(Intent intent) {
        Bundle bundleExtra;
        String string;
        String string2;
        if (intent == null || (bundleExtra = intent.getBundleExtra("al_applink_data")) == null) {
            return null;
        }
        AppLinkData appLinkData = new AppLinkData();
        Uri data = intent.getData();
        appLinkData.b = data;
        appLinkData.f = b(data);
        if (appLinkData.b == null && (string2 = bundleExtra.getString("target_url")) != null) {
            appLinkData.b = Uri.parse(string2);
        }
        appLinkData.d = bundleExtra;
        appLinkData.c = null;
        Bundle bundle = bundleExtra.getBundle(ARGUMENTS_REFERER_DATA_KEY);
        if (bundle != null) {
            appLinkData.a = bundle.getString("fb_ref");
        }
        Bundle bundle2 = bundleExtra.getBundle(ARGUMENTS_EXTRAS_KEY);
        if (!(bundle2 == null || (string = bundle2.getString(ShareConstants.DEEPLINK_CONTEXT)) == null)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has(ShareConstants.PROMO_CODE)) {
                    appLinkData.e = jSONObject.getString(ShareConstants.PROMO_CODE);
                }
            } catch (JSONException e2) {
                Utility.logd("com.facebook.applinks.AppLinkData", "Unable to parse deeplink_context JSON", e2);
            }
        }
        return appLinkData;
    }

    public static void fetchDeferredAppLinkData(Context context, CompletionHandler completionHandler) {
        fetchDeferredAppLinkData(context, null, completionHandler);
    }

    public JSONObject getAppLinkData() {
        JSONObject jSONObject = this.f;
        return jSONObject != null ? jSONObject : new JSONObject();
    }

    @Nullable
    public Bundle getArgumentBundle() {
        return this.d;
    }

    @Nullable
    public String getPromotionCode() {
        return this.e;
    }

    @Nullable
    public String getRef() {
        return this.a;
    }

    @Nullable
    public Bundle getRefererData() {
        Bundle bundle = this.d;
        if (bundle != null) {
            return bundle.getBundle(ARGUMENTS_REFERER_DATA_KEY);
        }
        return null;
    }

    @Nullable
    public Uri getTargetUri() {
        return this.b;
    }

    public boolean isAutoAppLink() {
        Uri uri = this.b;
        if (uri == null) {
            return false;
        }
        String host = uri.getHost();
        String scheme = this.b.getScheme();
        String format = String.format("fb%s", FacebookSdk.getApplicationId());
        JSONObject jSONObject = this.f;
        if (!(jSONObject != null && jSONObject.optBoolean("is_auto_applink")) || !"applinks".equals(host) || !format.equals(scheme)) {
            return false;
        }
        return true;
    }

    public static void fetchDeferredAppLinkData(Context context, String str, CompletionHandler completionHandler) {
        Validate.notNull(context, "context");
        Validate.notNull(completionHandler, "completionHandler");
        if (str == null) {
            str = Utility.getMetadataApplicationId(context);
        }
        Validate.notNull(str, "applicationId");
        FacebookSdk.getExecutor().execute(new a(context.getApplicationContext(), str, completionHandler));
    }
}
