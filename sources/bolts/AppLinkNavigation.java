package bolts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import bolts.AppLink;
import com.avito.android.remote.model.payment.status.PaymentStateKt;
import com.facebook.applinks.AppLinkData;
import com.facebook.internal.NativeProtocol;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class AppLinkNavigation {
    public static AppLinkResolver d;
    public final AppLink a;
    public final Bundle b;
    public final Bundle c;

    public enum NavigationResult {
        FAILED(PaymentStateKt.PAYMENT_STATE_FAILED, false),
        WEB("web", true),
        APP("app", true);
        
        public String a;
        public boolean b;

        /* access modifiers changed from: public */
        NavigationResult(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public String getCode() {
            return this.a;
        }

        public boolean isSucceeded() {
            return this.b;
        }
    }

    public static class a implements Continuation<AppLink, NavigationResult> {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
        @Override // bolts.Continuation
        public NavigationResult then(Task<AppLink> task) throws Exception {
            return AppLinkNavigation.navigate(this.a, task.getResult());
        }
    }

    public AppLinkNavigation(AppLink appLink, Bundle bundle, Bundle bundle2) {
        if (appLink != null) {
            bundle = bundle == null ? new Bundle() : bundle;
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            this.a = appLink;
            this.b = bundle;
            this.c = bundle2;
            return;
        }
        throw new IllegalArgumentException("appLink must not be null.");
    }

    public static AppLinkResolver c(Context context) {
        if (getDefaultResolver() != null) {
            return getDefaultResolver();
        }
        return new WebViewAppLinkResolver(context);
    }

    public static AppLinkResolver getDefaultResolver() {
        return d;
    }

    public static Task<NavigationResult> navigateInBackground(Context context, Uri uri, AppLinkResolver appLinkResolver) {
        return appLinkResolver.getAppLinkFromUrlInBackground(uri).onSuccess(new a(context), Task.UI_THREAD_EXECUTOR);
    }

    public static void setDefaultResolver(AppLinkResolver appLinkResolver) {
        d = appLinkResolver;
    }

    public final JSONObject a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            jSONObject.put(str, b(bundle.get(str)));
        }
        return jSONObject;
    }

    public final Object b(Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            return a((Bundle) obj);
        }
        if (obj instanceof CharSequence) {
            return obj.toString();
        }
        if (obj instanceof List) {
            JSONArray jSONArray = new JSONArray();
            for (Object obj2 : (List) obj) {
                jSONArray.put(b(obj2));
            }
            return jSONArray;
        }
        int i = 0;
        if (obj instanceof SparseArray) {
            JSONArray jSONArray2 = new JSONArray();
            SparseArray sparseArray = (SparseArray) obj;
            while (i < sparseArray.size()) {
                jSONArray2.put(sparseArray.keyAt(i), b(sparseArray.valueAt(i)));
                i++;
            }
            return jSONArray2;
        } else if (obj instanceof Character) {
            return obj.toString();
        } else {
            if (obj instanceof Boolean) {
                return obj;
            }
            if (obj instanceof Number) {
                if ((obj instanceof Double) || (obj instanceof Float)) {
                    return Double.valueOf(((Number) obj).doubleValue());
                }
                return Long.valueOf(((Number) obj).longValue());
            } else if (obj instanceof boolean[]) {
                JSONArray jSONArray3 = new JSONArray();
                boolean[] zArr = (boolean[]) obj;
                int length = zArr.length;
                while (i < length) {
                    jSONArray3.put(b(Boolean.valueOf(zArr[i])));
                    i++;
                }
                return jSONArray3;
            } else if (obj instanceof char[]) {
                JSONArray jSONArray4 = new JSONArray();
                char[] cArr = (char[]) obj;
                int length2 = cArr.length;
                while (i < length2) {
                    jSONArray4.put(b(Character.valueOf(cArr[i])));
                    i++;
                }
                return jSONArray4;
            } else if (obj instanceof CharSequence[]) {
                JSONArray jSONArray5 = new JSONArray();
                CharSequence[] charSequenceArr = (CharSequence[]) obj;
                int length3 = charSequenceArr.length;
                while (i < length3) {
                    jSONArray5.put(b(charSequenceArr[i]));
                    i++;
                }
                return jSONArray5;
            } else if (obj instanceof double[]) {
                JSONArray jSONArray6 = new JSONArray();
                double[] dArr = (double[]) obj;
                int length4 = dArr.length;
                while (i < length4) {
                    jSONArray6.put(b(Double.valueOf(dArr[i])));
                    i++;
                }
                return jSONArray6;
            } else if (obj instanceof float[]) {
                JSONArray jSONArray7 = new JSONArray();
                float[] fArr = (float[]) obj;
                int length5 = fArr.length;
                while (i < length5) {
                    jSONArray7.put(b(Float.valueOf(fArr[i])));
                    i++;
                }
                return jSONArray7;
            } else if (obj instanceof int[]) {
                JSONArray jSONArray8 = new JSONArray();
                int[] iArr = (int[]) obj;
                int length6 = iArr.length;
                while (i < length6) {
                    jSONArray8.put(b(Integer.valueOf(iArr[i])));
                    i++;
                }
                return jSONArray8;
            } else if (obj instanceof long[]) {
                JSONArray jSONArray9 = new JSONArray();
                long[] jArr = (long[]) obj;
                int length7 = jArr.length;
                while (i < length7) {
                    jSONArray9.put(b(Long.valueOf(jArr[i])));
                    i++;
                }
                return jSONArray9;
            } else if (obj instanceof short[]) {
                JSONArray jSONArray10 = new JSONArray();
                short[] sArr = (short[]) obj;
                int length8 = sArr.length;
                while (i < length8) {
                    jSONArray10.put(b(Short.valueOf(sArr[i])));
                    i++;
                }
                return jSONArray10;
            } else if (!(obj instanceof String[])) {
                return null;
            } else {
                JSONArray jSONArray11 = new JSONArray();
                String[] strArr = (String[]) obj;
                int length9 = strArr.length;
                while (i < length9) {
                    jSONArray11.put(b(strArr[i]));
                    i++;
                }
                return jSONArray11;
            }
        }
    }

    public final void d(Context context, Intent intent, NavigationResult navigationResult, JSONException jSONException) {
        HashMap hashMap = new HashMap();
        if (jSONException != null) {
            hashMap.put("error", jSONException.getLocalizedMessage());
        }
        hashMap.put("success", navigationResult.isSucceeded() ? "1" : "0");
        hashMap.put("type", navigationResult.getCode());
        MeasurementEvent.b(context, MeasurementEvent.APP_LINK_NAVIGATE_OUT_EVENT_NAME, intent, hashMap);
    }

    public AppLink getAppLink() {
        return this.a;
    }

    public Bundle getAppLinkData() {
        return this.c;
    }

    public Bundle getExtras() {
        return this.b;
    }

    public NavigationResult navigate(Context context) {
        Intent intent;
        String string;
        PackageManager packageManager = context.getPackageManager();
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        String packageName = context.getPackageName();
        if (packageName != null) {
            bundle2.putString("package", packageName);
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!(applicationInfo == null || (string = context.getString(applicationInfo.labelRes)) == null)) {
            bundle2.putString(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, string);
        }
        bundle.putAll(getAppLinkData());
        bundle.putString("target_url", getAppLink().getSourceUrl().toString());
        bundle.putString("version", "1.0");
        bundle.putString("user_agent", "Bolts Android 1.4.0");
        bundle.putBundle("referer_app_link", bundle2);
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, getExtras());
        Iterator<AppLink.Target> it = getAppLink().getTargets().iterator();
        while (true) {
            if (!it.hasNext()) {
                intent = null;
                break;
            }
            AppLink.Target next = it.next();
            intent = new Intent("android.intent.action.VIEW");
            if (next.getUrl() != null) {
                intent.setData(next.getUrl());
            } else {
                intent.setData(this.a.getSourceUrl());
            }
            intent.setPackage(next.getPackageName());
            if (next.getClassName() != null) {
                intent.setClassName(next.getPackageName(), next.getClassName());
            }
            intent.putExtra("al_applink_data", bundle);
            if (packageManager.resolveActivity(intent, 65536) != null) {
                break;
            }
        }
        NavigationResult navigationResult = NavigationResult.FAILED;
        if (intent != null) {
            navigationResult = NavigationResult.APP;
        } else {
            Uri webUrl = getAppLink().getWebUrl();
            if (webUrl != null) {
                try {
                    intent = new Intent("android.intent.action.VIEW", webUrl.buildUpon().appendQueryParameter("al_applink_data", a(bundle).toString()).build());
                    navigationResult = NavigationResult.WEB;
                } catch (JSONException e) {
                    d(context, intent, NavigationResult.FAILED, e);
                    throw new RuntimeException(e);
                }
            } else {
                intent = null;
            }
        }
        d(context, intent, navigationResult, null);
        if (intent != null) {
            context.startActivity(intent);
        }
        return navigationResult;
    }

    public static Task<NavigationResult> navigateInBackground(Context context, URL url, AppLinkResolver appLinkResolver) {
        return navigateInBackground(context, Uri.parse(url.toString()), appLinkResolver);
    }

    public static Task<NavigationResult> navigateInBackground(Context context, String str, AppLinkResolver appLinkResolver) {
        return navigateInBackground(context, Uri.parse(str), appLinkResolver);
    }

    public static Task<NavigationResult> navigateInBackground(Context context, Uri uri) {
        return navigateInBackground(context, uri, c(context));
    }

    public static Task<NavigationResult> navigateInBackground(Context context, URL url) {
        return navigateInBackground(context, url, c(context));
    }

    public static Task<NavigationResult> navigateInBackground(Context context, String str) {
        return navigateInBackground(context, str, c(context));
    }

    public static NavigationResult navigate(Context context, AppLink appLink) {
        return new AppLinkNavigation(appLink, null, null).navigate(context);
    }
}
