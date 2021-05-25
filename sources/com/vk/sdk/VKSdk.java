package com.vk.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vk.sdk.VKServiceActivity;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.payments.VKPaymentsCallback;
import com.vk.sdk.payments.VKPaymentsReceiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
public class VKSdk {
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_API_ERRORS = false;
    public static final String SDK_API_VERSION = "com_vk_sdk_ApiVersion";
    public static final String SDK_APP_ID = "com_vk_sdk_AppId";
    public static final String SDK_TAG = "VK SDK";
    public static Handler b = new Handler(Looper.getMainLooper());
    public static int c = 0;
    public static boolean d = false;
    public static VKSdk e = null;
    public static boolean f = false;
    public static String g;
    public static volatile LoginState h;
    public static ArrayList<String> i;
    public static final List<VKAccessTokenTracker> j = new CopyOnWriteArrayList();
    public final Context a;

    public enum LoginState {
        Unknown,
        LoggedOut,
        Pending,
        LoggedIn
    }

    public static class a implements Runnable {
        public final /* synthetic */ VKAccessToken a;
        public final /* synthetic */ VKAccessToken b;

        public a(VKAccessToken vKAccessToken, VKAccessToken vKAccessToken2) {
            this.a = vKAccessToken;
            this.b = vKAccessToken2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (VKAccessTokenTracker vKAccessTokenTracker : VKSdk.j) {
                vKAccessTokenTracker.onVKAccessTokenChanged(this.a, this.b);
            }
        }
    }

    public static class b extends VKRequest.VKRequestListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ VKCallback b;
        public final /* synthetic */ Context c;

        public b(Context context, VKCallback vKCallback, Context context2) {
            this.a = context;
            this.b = vKCallback;
            this.c = context2;
        }

        @Override // com.vk.sdk.api.VKRequest.VKRequestListener
        public void onComplete(VKResponse vKResponse) {
            VKSdk.e(this.a, this.b);
        }

        @Override // com.vk.sdk.api.VKRequest.VKRequestListener
        public void onError(VKError vKError) {
            VKError vKError2;
            if (!(vKError == null || (vKError2 = vKError.apiError) == null || vKError2.errorCode != 5)) {
                Context context = this.c;
                Handler handler = VKSdk.b;
                VKAccessToken a3 = VKAccessToken.a(context, null);
                if (a3 != null) {
                    VKSdk.c(a3, null);
                }
            }
            VKSdk.e(this.a, this.b);
        }
    }

    public VKSdk(Context context) {
        this.a = context;
    }

    public static void a(LoginState loginState, VKCallback<LoginState> vKCallback) {
        h = loginState;
        if (vKCallback != null) {
            vKCallback.onResult(h);
        }
    }

    public static synchronized VKSdk b(Context context, int i2, String str) {
        VKSdk vKSdk;
        synchronized (VKSdk.class) {
            if (c == 0) {
                e = new VKSdk(context);
                c = i2;
                if (TextUtils.isEmpty(str)) {
                    str = "5.21";
                }
                g = str;
                h = LoginState.Unknown;
                wakeUpSession(context);
            }
            vKSdk = e;
        }
        return vKSdk;
    }

    public static void c(VKAccessToken vKAccessToken, VKAccessToken vKAccessToken2) {
        b.post(new a(vKAccessToken, vKAccessToken2));
    }

    public static VKSdk customInitialize(Context context, int i2, String str) {
        if (i2 == 0) {
            i2 = PreferenceManager.getDefaultSharedPreferences(context).getInt("VK_SDK_APP_ID_PLEASE_DONT_TOUCH", 0);
        }
        if (TextUtils.isEmpty(str)) {
            str = PreferenceManager.getDefaultSharedPreferences(context).getString("VK_SDK_APP_VERSION_PLEASE_DONT_TOUCH", "5.21");
        }
        if (i2 != 0) {
            f = true;
            VKSdk b2 = b(context, i2, str);
            int i3 = c;
            if (i3 != 0) {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
                edit.putInt("VK_SDK_APP_ID_PLEASE_DONT_TOUCH", i3);
                edit.apply();
            }
            String str2 = g;
            if (str2 != null) {
                SharedPreferences.Editor edit2 = PreferenceManager.getDefaultSharedPreferences(context).edit();
                edit2.putString("VK_SDK_APP_VERSION_PLEASE_DONT_TOUCH", str2);
                edit2.apply();
            }
            return b2;
        }
        throw new RuntimeException("your_app_id is 0");
    }

    @NonNull
    public static ArrayList<String> d(String... strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strArr));
        if (!arrayList.contains("offline")) {
            arrayList.add("offline");
        }
        return arrayList;
    }

    public static void e(Context context, VKCallback<LoginState> vKCallback) {
        if (context != null) {
            VKUIHelper.a = context.getApplicationContext();
        }
        if (VKAccessToken.currentToken() != null) {
            a(LoginState.LoggedIn, vKCallback);
        } else {
            a(LoginState.LoggedOut, vKCallback);
        }
    }

    public static VKAccessToken getAccessToken() {
        return VKAccessToken.currentToken();
    }

    public static String getApiVersion() {
        return g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0088, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x008a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.vk.sdk.VKSdk initialize(android.content.Context r8) {
        /*
            int r0 = com.vk.sdk.VKSdk.c
            if (r0 == 0) goto L_0x0007
            com.vk.sdk.VKSdk r8 = com.vk.sdk.VKSdk.e
            return r8
        L_0x0007:
            boolean r0 = r8 instanceof android.app.Application
            java.lang.String r1 = "VKSdk.initialize(Context) must be call from Application#onCreate()"
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = "Application context cannot be null"
            java.util.Objects.requireNonNull(r8, r0)
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            r8.<init>(r1)
            throw r8
        L_0x0018:
            java.lang.Class<android.app.Application> r0 = android.app.Application.class
            java.lang.String r2 = "onCreate"
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r3 = r3.getStackTrace()
            int r4 = r3.length
            int r4 = r4 + -2
        L_0x0027:
            r5 = 0
            if (r4 < 0) goto L_0x0046
            r6 = r3[r4]
            java.lang.String r7 = r6.getClassName()     // Catch:{ ClassCastException | ClassNotFoundException -> 0x0043 }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassCastException | ClassNotFoundException -> 0x0043 }
            r7.asSubclass(r0)     // Catch:{ ClassCastException | ClassNotFoundException -> 0x0043 }
            java.lang.String r6 = r6.getMethodName()     // Catch:{ ClassCastException | ClassNotFoundException -> 0x0043 }
            boolean r6 = r2.equals(r6)     // Catch:{ ClassCastException | ClassNotFoundException -> 0x0043 }
            if (r6 == 0) goto L_0x0043
            r0 = 1
            goto L_0x0047
        L_0x0043:
            int r4 = r4 + -1
            goto L_0x0027
        L_0x0046:
            r0 = 0
        L_0x0047:
            if (r0 == 0) goto L_0x0099
            android.content.res.Resources r0 = r8.getResources()
            java.lang.String r1 = r8.getPackageName()
            java.lang.String r2 = "com_vk_sdk_AppId"
            java.lang.String r3 = "integer"
            int r0 = r0.getIdentifier(r2, r3, r1)
            android.content.res.Resources r1 = r8.getResources()     // Catch:{ Exception -> 0x0066 }
            int r0 = r1.getInteger(r0)     // Catch:{ Exception -> 0x0066 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
        L_0x006a:
            int r0 = r0.intValue()
            if (r0 == 0) goto L_0x0091
            android.content.res.Resources r1 = r8.getResources()
            java.lang.String r2 = r8.getPackageName()
            java.lang.String r3 = "com_vk_sdk_ApiVersion"
            java.lang.String r4 = "string"
            int r1 = r1.getIdentifier(r3, r4, r2)
            java.lang.String r1 = r8.getString(r1)     // Catch:{ Exception -> 0x008a }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x008a }
            if (r2 == 0) goto L_0x008c
        L_0x008a:
            java.lang.String r1 = "5.21"
        L_0x008c:
            com.vk.sdk.VKSdk r8 = b(r8, r0, r1)
            return r8
        L_0x0091:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r0 = "String <integer name=\"com_vk_sdk_AppId\">your_app_id</integer> did not find in your resources.xml"
            r8.<init>(r0)
            throw r8
        L_0x0099:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            r8.<init>(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vk.sdk.VKSdk.initialize(android.content.Context):com.vk.sdk.VKSdk");
    }

    public static boolean isCustomInitialize() {
        return f;
    }

    public static boolean isIsPaymentsEnable() {
        return d;
    }

    public static boolean isLoggedIn() {
        VKAccessToken currentToken = VKAccessToken.currentToken();
        return currentToken != null && !currentToken.isExpired();
    }

    public static void login(@NonNull Activity activity, String... strArr) {
        ArrayList<String> d2 = d(strArr);
        i = d2;
        int i2 = VKServiceActivity.a;
        Context applicationContext = activity.getApplicationContext();
        VKServiceActivity.VKServiceType vKServiceType = VKServiceActivity.VKServiceType.Authorization;
        Intent a3 = VKServiceActivity.a(applicationContext, vKServiceType);
        a3.putStringArrayListExtra("arg2", d2);
        activity.startActivityForResult(a3, vKServiceType.getOuterCode());
    }

    @SuppressLint({"NewApi"})
    public static void logout() {
        Context applicationContext = VKUIHelper.getApplicationContext();
        CookieManager.getInstance().removeAllCookies(null);
        VKAccessToken.a(VKUIHelper.getApplicationContext(), null);
        e(applicationContext, null);
    }

    public static void notifySdkAboutApiError(VKError vKError) {
        VKAccessToken a3;
        if (vKError.errorCode == 5 && (a3 = VKAccessToken.a(VKUIHelper.getApplicationContext(), null)) != null) {
            c(a3, null);
        }
    }

    public static boolean onActivityResult(int i2, int i3, @Nullable Intent intent, @NonNull VKCallback<VKAccessToken> vKCallback) {
        if (i2 != VKServiceActivity.VKServiceType.Authorization.getOuterCode()) {
            return false;
        }
        if (i3 == -1) {
            vKCallback.onResult(VKAccessToken.currentToken());
            return true;
        } else if (i3 != 0) {
            return true;
        } else {
            long j2 = 0;
            if (intent != null) {
                j2 = intent.getLongExtra("vk_extra_error_id", 0);
            }
            vKCallback.onError((VKError) VKObject.getRegisteredObject(j2));
            return true;
        }
    }

    public static void requestUserState(Context context, VKPaymentsCallback vKPaymentsCallback) {
        VKPaymentsCallback.requestUserState(context, vKPaymentsCallback);
    }

    public static boolean wakeUpSession(@NonNull Context context) {
        return wakeUpSession(context, null);
    }

    public void withPayments() {
        d = true;
        VKPaymentsReceiver.onReceiveStatic(this.a);
    }

    public static class c {
        public VKAccessToken a;
        public VKAccessToken b;
        public VKError c;

        public c(VKAccessToken vKAccessToken) {
            this.a = vKAccessToken;
        }

        public c(VKAccessToken vKAccessToken, VKAccessToken vKAccessToken2) {
            this.a = vKAccessToken2;
            this.b = vKAccessToken;
        }

        public c(VKError vKError) {
            this.c = vKError;
        }
    }

    public static boolean wakeUpSession(@NonNull Context context, VKCallback<LoginState> vKCallback) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            VKUIHelper.a = applicationContext.getApplicationContext();
        }
        VKAccessToken currentToken = VKAccessToken.currentToken();
        if (currentToken == null || currentToken.accessToken == null || currentToken.isExpired()) {
            e(context, vKCallback);
            return false;
        }
        a(LoginState.Pending, vKCallback);
        b bVar = new b(context, vKCallback, applicationContext);
        VKRequest vKRequest = new VKRequest("stats.trackVisitor");
        vKRequest.attempts = 0;
        vKRequest.executeWithListener(bVar);
        return true;
    }

    public static void login(@NonNull Fragment fragment, String... strArr) {
        ArrayList<String> d2 = d(strArr);
        i = d2;
        int i2 = VKServiceActivity.a;
        Application application = fragment.getActivity().getApplication();
        VKServiceActivity.VKServiceType vKServiceType = VKServiceActivity.VKServiceType.Authorization;
        Intent a3 = VKServiceActivity.a(application, vKServiceType);
        a3.putStringArrayListExtra("arg2", d2);
        fragment.startActivityForResult(a3, vKServiceType.getOuterCode());
    }
}
