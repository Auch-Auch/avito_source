package com.facebook;

import a2.g.j;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.internal.logging.monitor.MonitorManager;
import java.io.File;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class FacebookSdk {
    public static final String ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY = "com.facebook.sdk.AdvertiserIDCollectionEnabled";
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    public static final String AUTO_INIT_ENABLED_PROPERTY = "com.facebook.sdk.AutoInitEnabled";
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";
    public static final String DATA_PROCESSING_OPTIONS_PREFERENCES = "com.facebook.sdk.DataProcessingOptions";
    public static final String DATA_PROCESSION_OPTIONS = "data_processing_options";
    public static final String DATA_PROCESSION_OPTIONS_COUNTRY = "data_processing_options_country";
    public static final String DATA_PROCESSION_OPTIONS_STATE = "data_processing_options_state";
    public static final String MONITOR_ENABLED_PROPERTY = "com.facebook.sdk.MonitorEnabled";
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    public static final HashSet<LoggingBehavior> a = new HashSet<>(Arrays.asList(LoggingBehavior.DEVELOPER_ERRORS));
    public static Executor b;
    public static volatile String c;
    @Nullable
    public static volatile String d;
    public static volatile String e;
    public static volatile Boolean f;
    public static volatile String g = "facebook.com";
    public static AtomicLong h = new AtomicLong(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
    public static boolean hasCustomTabsPrefetching = false;
    public static volatile boolean i = false;
    public static boolean ignoreAppSwitchToLoggedOut = false;
    public static boolean j = false;
    public static LockOnGetVariable<File> k;
    public static Context l;
    public static int m = 64206;
    public static final Object n = new Object();
    public static String o = ServerProtocol.getDefaultAPIVersion();
    public static Boolean p;
    public static Boolean q;
    public static GraphRequestCreator r = new a();

    @VisibleForTesting
    public interface GraphRequestCreator {
        GraphRequest createPostRequest(@Nullable AccessToken accessToken, String str, JSONObject jSONObject, @Nullable GraphRequest.Callback callback);
    }

    public interface InitializeCallback {
        void onInitialized();
    }

    public static class a implements GraphRequestCreator {
        @Override // com.facebook.FacebookSdk.GraphRequestCreator
        public GraphRequest createPostRequest(@Nullable AccessToken accessToken, String str, JSONObject jSONObject, @Nullable GraphRequest.Callback callback) {
            return GraphRequest.newPostRequest(null, str, jSONObject, null);
        }
    }

    public static class b implements Callable<File> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public File call() throws Exception {
            return FacebookSdk.l.getCacheDir();
        }
    }

    public static class c implements FeatureManager.Callback {
        @Override // com.facebook.internal.FeatureManager.Callback
        public void onCompleted(boolean z) {
            if (z) {
                InstrumentManager.start();
            }
        }
    }

    public static class d implements FeatureManager.Callback {
        @Override // com.facebook.internal.FeatureManager.Callback
        public void onCompleted(boolean z) {
            if (z) {
                AppEventsManager.start();
            }
        }
    }

    public static class e implements FeatureManager.Callback {
        @Override // com.facebook.internal.FeatureManager.Callback
        public void onCompleted(boolean z) {
            if (z) {
                FacebookSdk.hasCustomTabsPrefetching = true;
            }
        }
    }

    public static class f implements FeatureManager.Callback {
        @Override // com.facebook.internal.FeatureManager.Callback
        public void onCompleted(boolean z) {
            if (z) {
                FacebookSdk.ignoreAppSwitchToLoggedOut = true;
            }
        }
    }

    public static class g implements FeatureManager.Callback {
        @Override // com.facebook.internal.FeatureManager.Callback
        public void onCompleted(boolean z) {
            if (z) {
                MonitorManager.start();
            }
        }
    }

    public static class h implements Callable<Void> {
        public final /* synthetic */ InitializeCallback a;
        public final /* synthetic */ Context b;

        public h(InitializeCallback initializeCallback, Context context) {
            this.a = initializeCallback;
            this.b = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0111  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0129  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x013c A[SYNTHETIC, Splitter:B:51:0x013c] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x014a  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0160  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x019c A[Catch:{ NameNotFoundException -> 0x01a8 }] */
        @Override // java.util.concurrent.Callable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
            // Method dump skipped, instructions count: 438
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.h.call():java.lang.Object");
        }
    }

    public static class i implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public i(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.a;
            String str = this.b;
            HashSet<LoggingBehavior> hashSet = FacebookSdk.a;
            if (context == null || str == null) {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            }
            try {
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
                String str2 = str + "ping";
                long j = sharedPreferences.getLong(str2, 0);
                try {
                    GraphRequest createPostRequest = FacebookSdk.r.createPostRequest(null, String.format("%s/activities", str), AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.getAnonymousAppDeviceGUID(context), FacebookSdk.getLimitEventAndDataUsage(context), context), null);
                    if (j == 0 && createPostRequest.executeAndWait().getError() == null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putLong(str2, System.currentTimeMillis());
                        edit.apply();
                    }
                } catch (JSONException e) {
                    throw new FacebookException("An error occurred while publishing install.", e);
                }
            } catch (Exception e2) {
                Utility.logd("Facebook-publish", e2);
            }
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        p = bool;
        q = bool;
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (c == null) {
                        Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                                c = str.substring(2);
                            } else {
                                c = str;
                            }
                        } else if (obj instanceof Number) {
                            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (d == null) {
                        d = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
                    }
                    if (e == null) {
                        e = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
                    }
                    if (m == 64206) {
                        m = applicationInfo.metaData.getInt(CALLBACK_OFFSET_PROPERTY, 64206);
                    }
                    if (f == null) {
                        f = Boolean.valueOf(applicationInfo.metaData.getBoolean(CODELESS_DEBUG_LOG_ENABLED_PROPERTY, false));
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    public static void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        HashSet<LoggingBehavior> hashSet = a;
        synchronized (hashSet) {
            hashSet.add(loggingBehavior);
            if (hashSet.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
                LoggingBehavior loggingBehavior2 = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                if (!hashSet.contains(loggingBehavior2)) {
                    hashSet.add(loggingBehavior2);
                }
            }
        }
    }

    public static void clearLoggingBehaviors() {
        HashSet<LoggingBehavior> hashSet = a;
        synchronized (hashSet) {
            hashSet.clear();
        }
    }

    public static void fullyInitialize() {
        q = Boolean.TRUE;
    }

    public static boolean getAdvertiserIDCollectionEnabled() {
        j.b();
        return j.f.a();
    }

    public static Context getApplicationContext() {
        Validate.sdkInitialized();
        return l;
    }

    public static String getApplicationId() {
        Validate.sdkInitialized();
        return c;
    }

    @Nullable
    public static String getApplicationName() {
        Validate.sdkInitialized();
        return d;
    }

    @AutoHandleExceptions
    public static String getApplicationSignature(Context context) {
        PackageManager packageManager;
        Validate.sdkInitialized();
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (!(signatureArr == null || signatureArr.length == 0)) {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(packageInfo.signatures[0].toByteArray());
                return Base64.encodeToString(instance.digest(), 9);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static boolean getAutoInitEnabled() {
        j.b();
        return j.d.a();
    }

    public static boolean getAutoLogAppEventsEnabled() {
        j.b();
        return j.e.a();
    }

    public static File getCacheDir() {
        Validate.sdkInitialized();
        return k.getValue();
    }

    public static int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return m;
    }

    public static String getClientToken() {
        Validate.sdkInitialized();
        return e;
    }

    public static boolean getCodelessDebugLogEnabled() {
        Validate.sdkInitialized();
        return f.booleanValue();
    }

    public static boolean getCodelessSetupEnabled() {
        j.b();
        return j.g.a();
    }

    public static Executor getExecutor() {
        synchronized (n) {
            if (b == null) {
                b = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return b;
    }

    public static String getFacebookDomain() {
        return g;
    }

    public static String getGraphApiVersion() {
        Utility.logd("com.facebook.FacebookSdk", String.format("getGraphApiVersion: %s", o));
        return o;
    }

    public static String getGraphDomain() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        String graphDomain = currentAccessToken != null ? currentAccessToken.getGraphDomain() : null;
        if (graphDomain == null) {
            return g;
        }
        if (graphDomain.equals("gaming")) {
            return g.replace("facebook.com", "fb.gg");
        }
        return g;
    }

    public static boolean getLimitEventAndDataUsage(Context context) {
        Validate.sdkInitialized();
        return context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    public static Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        HashSet<LoggingBehavior> hashSet = a;
        synchronized (hashSet) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(hashSet));
        }
        return unmodifiableSet;
    }

    public static boolean getMonitorEnabled() {
        j.b();
        return j.h.a();
    }

    public static long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return h.get();
    }

    public static String getSdkVersion() {
        return "8.1.0";
    }

    public static boolean isDebugEnabled() {
        return i;
    }

    public static boolean isFacebookRequestCode(int i2) {
        int i3 = m;
        return i2 >= i3 && i2 < i3 + 100;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static synchronized boolean isFullyInitialized() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            booleanValue = q.booleanValue();
        }
        return booleanValue;
    }

    public static synchronized boolean isInitialized() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            booleanValue = p.booleanValue();
        }
        return booleanValue;
    }

    public static boolean isLegacyTokenUpgradeSupported() {
        return j;
    }

    public static boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        boolean z;
        HashSet<LoggingBehavior> hashSet = a;
        synchronized (hashSet) {
            z = isDebugEnabled() && hashSet.contains(loggingBehavior);
        }
        return z;
    }

    @AutoHandleExceptions
    public static void publishInstallAsync(Context context, String str) {
        getExecutor().execute(new i(context.getApplicationContext(), str));
    }

    public static void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        HashSet<LoggingBehavior> hashSet = a;
        synchronized (hashSet) {
            hashSet.remove(loggingBehavior);
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, int i2) {
        synchronized (FacebookSdk.class) {
            sdkInitialize(context, i2, null);
        }
    }

    public static void setAdvertiserIDCollectionEnabled(boolean z) {
        j.f.b = Boolean.valueOf(z);
        j.f.d = System.currentTimeMillis();
        if (j.b.get()) {
            j.f(j.f);
        } else {
            j.b();
        }
    }

    public static void setApplicationId(String str) {
        c = str;
    }

    public static void setApplicationName(String str) {
        d = str;
    }

    public static void setAutoInitEnabled(boolean z) {
        j.d.b = Boolean.valueOf(z);
        j.d.d = System.currentTimeMillis();
        if (j.b.get()) {
            j.f(j.d);
        } else {
            j.b();
        }
        if (z) {
            fullyInitialize();
        }
    }

    public static void setAutoLogAppEventsEnabled(boolean z) {
        j.e.b = Boolean.valueOf(z);
        j.e.d = System.currentTimeMillis();
        if (j.b.get()) {
            j.f(j.e);
        } else {
            j.b();
        }
        if (z) {
            ActivityLifecycleTracker.startTracking((Application) l, c);
        }
    }

    public static void setCacheDir(File file) {
        k = new LockOnGetVariable<>(file);
    }

    public static void setClientToken(String str) {
        e = str;
    }

    public static void setCodelessDebugLogEnabled(boolean z) {
        f = Boolean.valueOf(z);
    }

    @AutoHandleExceptions
    public static void setDataProcessingOptions(String[] strArr) {
        setDataProcessingOptions(strArr, 0, 0);
    }

    public static void setExecutor(Executor executor) {
        Validate.notNull(executor, "executor");
        synchronized (n) {
            b = executor;
        }
    }

    public static void setFacebookDomain(String str) {
        g = str;
    }

    public static void setGraphApiVersion(String str) {
        if (!Utility.isNullOrEmpty(str) && !o.equals(str)) {
            o = str;
        }
    }

    @VisibleForTesting
    public static void setGraphRequestCreator(GraphRequestCreator graphRequestCreator) {
        r = graphRequestCreator;
    }

    public static void setIsDebugEnabled(boolean z) {
        i = z;
    }

    public static void setLegacyTokenUpgradeSupported(boolean z) {
        j = z;
    }

    public static void setLimitEventAndDataUsage(Context context, boolean z) {
        context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z).apply();
    }

    public static void setMonitorEnabled(boolean z) {
        j.h.b = Boolean.valueOf(z);
        j.h.d = System.currentTimeMillis();
        if (j.b.get()) {
            j.f(j.h);
        } else {
            j.b();
        }
    }

    public static void setOnProgressThreshold(long j2) {
        h.set(j2);
    }

    @AutoHandleExceptions
    public static void setDataProcessingOptions(String[] strArr, int i2, int i3) {
        if (strArr == null) {
            strArr = new String[0];
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DATA_PROCESSION_OPTIONS, new JSONArray((Collection) Arrays.asList(strArr)));
            jSONObject.put(DATA_PROCESSION_OPTIONS_COUNTRY, i2);
            jSONObject.put(DATA_PROCESSION_OPTIONS_STATE, i3);
            l.getSharedPreferences(DATA_PROCESSING_OPTIONS_PREFERENCES, 0).edit().putString(DATA_PROCESSION_OPTIONS, jSONObject.toString()).apply();
        } catch (JSONException unused) {
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, int i2, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            if (p.booleanValue()) {
                if (i2 != m) {
                    throw new FacebookException("The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method");
                }
            }
            if (i2 >= 0) {
                m = i2;
                sdkInitialize(context, initializeCallback);
            } else {
                throw new FacebookException("The callback request code offset can't be negative.");
            }
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context) {
        synchronized (FacebookSdk.class) {
            sdkInitialize(context, (InitializeCallback) null);
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            if (p.booleanValue()) {
                if (initializeCallback != null) {
                    initializeCallback.onInitialized();
                }
                return;
            }
            Validate.notNull(context, "applicationContext");
            Validate.hasFacebookActivity(context, false);
            Validate.hasInternetPermissions(context, false);
            l = context.getApplicationContext();
            AppEventsLogger.getAnonymousAppDeviceGUID(context);
            a(l);
            if (!Utility.isNullOrEmpty(c)) {
                p = Boolean.TRUE;
                if (getAutoInitEnabled()) {
                    fullyInitialize();
                }
                if (l instanceof Application) {
                    j.b();
                    if (j.e.a()) {
                        ActivityLifecycleTracker.startTracking((Application) l, c);
                    }
                }
                FetchedAppSettingsManager.loadAppSettingsAsync();
                NativeProtocol.updateAllAvailableProtocolVersionsAsync();
                BoltsMeasurementEventListener.getInstance(l);
                k = new LockOnGetVariable<>(new b());
                FeatureManager.checkFeature(FeatureManager.Feature.Instrument, new c());
                FeatureManager.checkFeature(FeatureManager.Feature.AppEvents, new d());
                FeatureManager.checkFeature(FeatureManager.Feature.ChromeCustomTabsPrefetching, new e());
                FeatureManager.checkFeature(FeatureManager.Feature.IgnoreAppSwitchToLoggedOut, new f());
                FeatureManager.checkFeature(FeatureManager.Feature.Monitoring, new g());
                getExecutor().execute(new FutureTask(new h(initializeCallback, context)));
                return;
            }
            throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
        }
    }
}
