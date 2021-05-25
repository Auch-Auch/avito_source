package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.login.DefaultAudience;
import com.facebook.messenger.MessengerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
@AutoHandleExceptions
public final class NativeProtocol {
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
    public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";
    public static final String AUDIENCE_EVERYONE = "everyone";
    public static final String AUDIENCE_FRIENDS = "friends";
    public static final String AUDIENCE_ME = "only_me";
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";
    public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";
    public static final String IMAGE_URL_KEY = "url";
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 65545;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 65544;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 65547;
    public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 65546;
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20160327 = 20160327;
    public static final int PROTOCOL_VERSION_20170213 = 20170213;
    public static final int PROTOCOL_VERSION_20170411 = 20170411;
    public static final int PROTOCOL_VERSION_20170417 = 20170417;
    public static final int PROTOCOL_VERSION_20171115 = 20171115;
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
    public static final String RESULT_ARGS_GRAPH_DOMAIN = "graph_domain";
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";
    public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    public static final String WEB_DIALOG_ACTION = "action";
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
    public static final String WEB_DIALOG_PARAMS = "params";
    public static final String WEB_DIALOG_URL = "url";
    public static final List<f> a;
    public static final List<f> b;
    public static final Map<String, List<f>> c;
    public static final AtomicBoolean d = new AtomicBoolean(false);
    public static final List<Integer> e = Arrays.asList(Integer.valueOf((int) PROTOCOL_VERSION_20170417), Integer.valueOf((int) PROTOCOL_VERSION_20160327), Integer.valueOf((int) PROTOCOL_VERSION_20141218), Integer.valueOf((int) PROTOCOL_VERSION_20141107), Integer.valueOf((int) PROTOCOL_VERSION_20141028), Integer.valueOf((int) PROTOCOL_VERSION_20141001), Integer.valueOf((int) PROTOCOL_VERSION_20140701), Integer.valueOf((int) PROTOCOL_VERSION_20140324), Integer.valueOf((int) PROTOCOL_VERSION_20140204), Integer.valueOf((int) PROTOCOL_VERSION_20131107), Integer.valueOf((int) PROTOCOL_VERSION_20130618), Integer.valueOf((int) PROTOCOL_VERSION_20130502), Integer.valueOf((int) PROTOCOL_VERSION_20121101));

    public static class ProtocolVersionQueryResult {
        public f a;
        public int b;

        public static ProtocolVersionQueryResult create(f fVar, int i) {
            ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult();
            protocolVersionQueryResult.a = fVar;
            protocolVersionQueryResult.b = i;
            return protocolVersionQueryResult;
        }

        public static ProtocolVersionQueryResult createEmpty() {
            ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult();
            protocolVersionQueryResult.b = -1;
            return protocolVersionQueryResult;
        }

        @Nullable
        public f getAppInfo() {
            return this.a;
        }

        public int getProtocolVersion() {
            return this.b;
        }
    }

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                for (f fVar : NativeProtocol.a) {
                    fVar.a(true);
                }
            } finally {
                NativeProtocol.d.set(z);
            }
        }
    }

    public static class b extends f {
        public b(a aVar) {
            super(null);
        }

        @Override // com.facebook.internal.NativeProtocol.f
        public String b() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.f
        public String c() {
            return "com.facebook.arstudio.player";
        }
    }

    public static class c extends f {
        public c(a aVar) {
            super(null);
        }

        @Override // com.facebook.internal.NativeProtocol.f
        public String b() {
            return "com.facebook.lite.platform.LoginGDPDialogActivity";
        }

        @Override // com.facebook.internal.NativeProtocol.f
        public String c() {
            return "com.facebook.lite";
        }
    }

    public static class d extends f {
        public d(a aVar) {
            super(null);
        }

        @Override // com.facebook.internal.NativeProtocol.f
        public String b() {
            return "com.facebook.katana.ProxyAuth";
        }

        @Override // com.facebook.internal.NativeProtocol.f
        public String c() {
            return "com.facebook.katana";
        }
    }

    public static class e extends f {
        public e(a aVar) {
            super(null);
        }

        @Override // com.facebook.internal.NativeProtocol.f
        public String b() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.f
        public String c() {
            return MessengerUtils.PACKAGE_NAME;
        }
    }

    public static abstract class f {
        public TreeSet<Integer> a;

        public f() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
            if (r1.isEmpty() == false) goto L_0x0013;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized void a(boolean r1) {
            /*
                r0 = this;
                monitor-enter(r0)
                if (r1 != 0) goto L_0x000d
                java.util.TreeSet<java.lang.Integer> r1 = r0.a     // Catch:{ all -> 0x0015 }
                if (r1 == 0) goto L_0x000d
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0015 }
                if (r1 == 0) goto L_0x0013
            L_0x000d:
                java.util.TreeSet r1 = com.facebook.internal.NativeProtocol.a(r0)     // Catch:{ all -> 0x0015 }
                r0.a = r1     // Catch:{ all -> 0x0015 }
            L_0x0013:
                monitor-exit(r0)
                return
            L_0x0015:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.f.a(boolean):void");
        }

        public abstract String b();

        public abstract String c();

        public f(a aVar) {
        }
    }

    public static class g extends f {
        public g(a aVar) {
            super(null);
        }

        @Override // com.facebook.internal.NativeProtocol.f
        public String b() {
            return "com.facebook.katana.ProxyAuth";
        }

        @Override // com.facebook.internal.NativeProtocol.f
        public String c() {
            return "com.facebook.wakizashi";
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(null));
        arrayList.add(new g(null));
        a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new d(null));
        arrayList2.add(new g(null));
        ArrayList arrayList3 = new ArrayList(arrayList2);
        arrayList3.add(0, new b(null));
        b = arrayList3;
        HashMap hashMap = new HashMap();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new e(null));
        hashMap.put(ACTION_OGACTIONPUBLISH_DIALOG, arrayList);
        hashMap.put(ACTION_FEED_DIALOG, arrayList);
        hashMap.put(ACTION_LIKE_DIALOG, arrayList);
        hashMap.put(ACTION_APPINVITE_DIALOG, arrayList);
        hashMap.put(ACTION_MESSAGE_DIALOG, arrayList4);
        hashMap.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList4);
        hashMap.put(ACTION_CAMERA_EFFECT, arrayList3);
        hashMap.put(ACTION_SHARE_STORY, arrayList);
        c = hashMap;
    }

    public static TreeSet a(f fVar) {
        ProviderInfo providerInfo;
        TreeSet treeSet = new TreeSet();
        ContentResolver contentResolver = FacebookSdk.getApplicationContext().getContentResolver();
        String[] strArr = {"version"};
        StringBuilder L = a2.b.a.a.a.L("content://");
        L.append(fVar.c());
        L.append(".provider.PlatformProvider/versions");
        Uri parse = Uri.parse(L.toString());
        Cursor cursor = null;
        try {
            try {
                providerInfo = FacebookSdk.getApplicationContext().getPackageManager().resolveContentProvider(fVar.c() + ".provider.PlatformProvider", 0);
            } catch (RuntimeException unused) {
                providerInfo = null;
            }
            if (providerInfo != null) {
                try {
                    cursor = contentResolver.query(parse, strArr, null, null, null);
                } catch (IllegalArgumentException | NullPointerException | SecurityException unused2) {
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        treeSet.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("version"))));
                    }
                }
            }
            return treeSet;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Lcom/facebook/internal/NativeProtocol$f;Ljava/lang/String;Ljava/util/Collection<Ljava/lang/String;>;Ljava/lang/String;ZZLcom/facebook/login/DefaultAudience;Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent; */
    public static Intent b(f fVar, String str, Collection collection, String str2, boolean z, DefaultAudience defaultAudience, String str3, String str4, boolean z2) {
        String b2 = fVar.b();
        if (b2 == null) {
            return null;
        }
        Intent putExtra = new Intent().setClassName(fVar.c(), b2).putExtra("client_id", str);
        putExtra.putExtra(FACEBOOK_SDK_VERSION_KEY, FacebookSdk.getSdkVersion());
        if (!Utility.isNullOrEmpty(collection)) {
            putExtra.putExtra("scope", TextUtils.join(",", collection));
        }
        if (!Utility.isNullOrEmpty(str2)) {
            putExtra.putExtra("e2e", str2);
        }
        putExtra.putExtra("state", str3);
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        if (z) {
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, defaultAudience.getNativeProtocolAudience());
        }
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, FacebookSdk.getGraphApiVersion());
        putExtra.putExtra("auth_type", str4);
        if (z2) {
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_FAIL_ON_LOGGED_OUT, true);
        }
        return putExtra;
    }

    public static ProtocolVersionQueryResult c(List<f> list, int[] iArr) {
        updateAllAvailableProtocolVersionsAsync();
        if (list == null) {
            return ProtocolVersionQueryResult.createEmpty();
        }
        for (f fVar : list) {
            TreeSet<Integer> treeSet = fVar.a;
            if (treeSet == null || treeSet.isEmpty()) {
                fVar.a(false);
            }
            int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(fVar.a, getLatestKnownVersion(), iArr);
            if (computeLatestAvailableVersionFromVersionSpec != -1) {
                return ProtocolVersionQueryResult.create(fVar, computeLatestAvailableVersionFromVersionSpec);
            }
        }
        return ProtocolVersionQueryResult.createEmpty();
    }

    public static int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> treeSet, int i, int[] iArr) {
        int length = iArr.length - 1;
        Iterator<Integer> descendingIterator = treeSet.descendingIterator();
        int i2 = -1;
        while (descendingIterator.hasNext()) {
            int intValue = descendingIterator.next().intValue();
            i2 = Math.max(i2, intValue);
            while (length >= 0 && iArr[length] > intValue) {
                length--;
            }
            if (length < 0) {
                return -1;
            }
            if (iArr[length] == intValue) {
                if (length % 2 == 0) {
                    return Math.min(i2, i);
                }
                return -1;
            }
        }
        return -1;
    }

    public static Bundle createBundleForException(FacebookException facebookException) {
        if (facebookException == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(BRIDGE_ARG_ERROR_DESCRIPTION, facebookException.toString());
        if (facebookException instanceof FacebookOperationCanceledException) {
            bundle.putString("error_type", ERROR_USER_CANCELED);
        }
        return bundle;
    }

    public static Intent createFacebookLiteIntent(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        return d(context, b(new c(null), str, collection, str2, z2, defaultAudience, str3, str4, false));
    }

    public static Intent createPlatformActivityIntent(Context context, String str, String str2, ProtocolVersionQueryResult protocolVersionQueryResult, Bundle bundle) {
        f fVar;
        Intent d2;
        if (protocolVersionQueryResult == null || (fVar = protocolVersionQueryResult.a) == null || (d2 = d(context, new Intent().setAction("com.facebook.platform.PLATFORM_ACTIVITY").setPackage(fVar.c()).addCategory("android.intent.category.DEFAULT"))) == null) {
            return null;
        }
        setupProtocolRequestIntent(d2, str, str2, protocolVersionQueryResult.b, bundle);
        return d2;
    }

    public static Intent createPlatformServiceIntent(Context context) {
        for (f fVar : a) {
            Intent e2 = e(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(fVar.c()).addCategory("android.intent.category.DEFAULT"));
            if (e2 != null) {
                return e2;
            }
        }
        return null;
    }

    public static Intent createProtocolResultIntent(Intent intent, Bundle bundle, FacebookException facebookException) {
        UUID callIdFromIntent = getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra(EXTRA_PROTOCOL_VERSION, getProtocolVersionFromIntent(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", callIdFromIntent.toString());
        if (facebookException != null) {
            bundle2.putBundle("error", createBundleForException(facebookException));
        }
        intent2.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
        if (bundle != null) {
            intent2.putExtra(EXTRA_PROTOCOL_METHOD_RESULTS, bundle);
        }
        return intent2;
    }

    public static List<Intent> createProxyAuthIntents(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4, boolean z3) {
        ArrayList arrayList = new ArrayList();
        for (f fVar : a) {
            Intent b2 = b(fVar, str, collection, str2, z2, defaultAudience, str3, str4, z3);
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        return arrayList;
    }

    public static Intent createTokenRefreshIntent(Context context) {
        for (f fVar : a) {
            Intent e2 = e(context, new Intent().setClassName(fVar.c(), "com.facebook.katana.platform.TokenRefreshService"));
            if (e2 != null) {
                return e2;
            }
        }
        return null;
    }

    public static Intent d(Context context, Intent intent) {
        ResolveInfo resolveActivity;
        if (intent == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null || !FacebookSignatureValidator.validateSignature(context, resolveActivity.activityInfo.packageName)) {
            return null;
        }
        return intent;
    }

    public static Intent e(Context context, Intent intent) {
        ResolveInfo resolveService;
        if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null || !FacebookSignatureValidator.validateSignature(context, resolveService.serviceInfo.packageName)) {
            return null;
        }
        return intent;
    }

    public static Bundle getBridgeArgumentsFromIntent(Intent intent) {
        if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            return null;
        }
        return intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
    }

    public static UUID getCallIdFromIntent(Intent intent) {
        String str;
        if (intent == null) {
            return null;
        }
        if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
            str = bundleExtra != null ? bundleExtra.getString("action_id") : null;
        } else {
            str = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
        }
        if (str == null) {
            return null;
        }
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static Bundle getErrorDataFromResultIntent(Intent intent) {
        if (!isErrorResult(intent)) {
            return null;
        }
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        if (bridgeArgumentsFromIntent != null) {
            return bridgeArgumentsFromIntent.getBundle("error");
        }
        return intent.getExtras();
    }

    public static FacebookException getExceptionFromErrorData(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("error_type");
        if (string == null) {
            string = bundle.getString(STATUS_ERROR_TYPE);
        }
        String string2 = bundle.getString(BRIDGE_ARG_ERROR_DESCRIPTION);
        if (string2 == null) {
            string2 = bundle.getString(STATUS_ERROR_DESCRIPTION);
        }
        if (string == null || !string.equalsIgnoreCase(ERROR_USER_CANCELED)) {
            return new FacebookException(string2);
        }
        return new FacebookOperationCanceledException(string2);
    }

    public static ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(String str, int[] iArr) {
        return c(c.get(str), iArr);
    }

    public static int getLatestAvailableProtocolVersionForService(int i) {
        return c(a, new int[]{i}).getProtocolVersion();
    }

    public static final int getLatestKnownVersion() {
        return e.get(0).intValue();
    }

    public static Bundle getMethodArgumentsFromIntent(Intent intent) {
        if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            return intent.getExtras();
        }
        return intent.getBundleExtra(EXTRA_PROTOCOL_METHOD_ARGS);
    }

    public static int getProtocolVersionFromIntent(Intent intent) {
        return intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
    }

    public static Bundle getSuccessResultsFromIntent(Intent intent) {
        int protocolVersionFromIntent = getProtocolVersionFromIntent(intent);
        Bundle extras = intent.getExtras();
        return (!isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) || extras == null) ? extras : extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
    }

    public static boolean isErrorResult(Intent intent) {
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        if (bridgeArgumentsFromIntent != null) {
            return bridgeArgumentsFromIntent.containsKey("error");
        }
        return intent.hasExtra(STATUS_ERROR_TYPE);
    }

    public static boolean isVersionCompatibleWithBucketedIntent(int i) {
        return e.contains(Integer.valueOf(i)) && i >= 20140701;
    }

    public static void setupProtocolRequestIntent(Intent intent, String str, String str2, int i, Bundle bundle) {
        String applicationId = FacebookSdk.getApplicationId();
        String applicationName = FacebookSdk.getApplicationName();
        intent.putExtra(EXTRA_PROTOCOL_VERSION, i).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, applicationId);
        if (isVersionCompatibleWithBucketedIntent(i)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", str);
            Utility.putNonEmptyString(bundle2, BRIDGE_ARG_APP_NAME_STRING, applicationName);
            intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle);
            return;
        }
        intent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
        if (!Utility.isNullOrEmpty(applicationName)) {
            intent.putExtra(EXTRA_APPLICATION_NAME, applicationName);
        }
        intent.putExtras(bundle);
    }

    public static void updateAllAvailableProtocolVersionsAsync() {
        if (d.compareAndSet(false, true)) {
            FacebookSdk.getExecutor().execute(new a());
        }
    }
}
