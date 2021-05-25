package com.facebook.messenger;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import bolts.AppLinks;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.HashSet;
import java.util.Set;
public class MessengerUtils {
    public static final String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
    public static final String EXTRA_EXTERNAL_URI = "com.facebook.orca.extra.EXTERNAL_URI";
    public static final String EXTRA_IS_COMPOSE = "com.facebook.orca.extra.IS_COMPOSE";
    public static final String EXTRA_IS_REPLY = "com.facebook.orca.extra.IS_REPLY";
    public static final String EXTRA_METADATA = "com.facebook.orca.extra.METADATA";
    public static final String EXTRA_PARTICIPANTS = "com.facebook.orca.extra.PARTICIPANTS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
    public static final String EXTRA_REPLY_TOKEN_KEY = "com.facebook.orca.extra.REPLY_TOKEN";
    public static final String EXTRA_THREAD_TOKEN_KEY = "com.facebook.orca.extra.THREAD_TOKEN";
    public static final String ORCA_THREAD_CATEGORY_20150314 = "com.facebook.orca.category.PLATFORM_THREAD_20150314";
    public static final String PACKAGE_NAME = "com.facebook.orca";
    public static final int PROTOCOL_VERSION_20150314 = 20150314;

    public static void finishShareToMessenger(Activity activity, ShareToMessengerParams shareToMessengerParams) {
        Intent intent = activity.getIntent();
        Set<String> categories = intent.getCategories();
        if (categories == null) {
            activity.setResult(0, null);
            activity.finish();
        } else if (categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
            Bundle appLinkExtras = AppLinks.getAppLinkExtras(intent);
            Intent intent2 = new Intent();
            if (categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
                intent2.putExtra(EXTRA_PROTOCOL_VERSION, PROTOCOL_VERSION_20150314);
                intent2.putExtra(EXTRA_THREAD_TOKEN_KEY, appLinkExtras.getString(EXTRA_THREAD_TOKEN_KEY));
                intent2.setDataAndType(shareToMessengerParams.uri, shareToMessengerParams.mimeType);
                intent2.setFlags(1);
                intent2.putExtra(EXTRA_APP_ID, FacebookSdk.getApplicationId());
                intent2.putExtra(EXTRA_METADATA, shareToMessengerParams.metaData);
                intent2.putExtra(EXTRA_EXTERNAL_URI, shareToMessengerParams.externalUri);
                activity.setResult(-1, intent2);
                activity.finish();
                return;
            }
            throw new RuntimeException();
        } else {
            activity.setResult(0, null);
            activity.finish();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0067 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.facebook.internal.instrument.crashshield.AutoHandleExceptions
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messenger.MessengerThreadParams getMessengerThreadParamsForIntent(android.content.Intent r8) {
        /*
            java.util.Set r0 = r8.getCategories()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r2 = "com.facebook.orca.category.PLATFORM_THREAD_20150314"
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x006b
            android.os.Bundle r8 = bolts.AppLinks.getAppLinkExtras(r8)
            java.lang.String r0 = "com.facebook.orca.extra.THREAD_TOKEN"
            java.lang.String r0 = r8.getString(r0)
            java.lang.String r1 = "com.facebook.orca.extra.METADATA"
            java.lang.String r1 = r8.getString(r1)
            java.lang.String r2 = "com.facebook.orca.extra.PARTICIPANTS"
            java.lang.String r2 = r8.getString(r2)
            java.lang.String r3 = "com.facebook.orca.extra.IS_REPLY"
            boolean r3 = r8.getBoolean(r3)
            java.lang.String r4 = "com.facebook.orca.extra.IS_COMPOSE"
            boolean r8 = r8.getBoolean(r4)
            com.facebook.messenger.MessengerThreadParams$Origin r4 = com.facebook.messenger.MessengerThreadParams.Origin.UNKNOWN
            if (r3 == 0) goto L_0x0039
            com.facebook.messenger.MessengerThreadParams$Origin r4 = com.facebook.messenger.MessengerThreadParams.Origin.REPLY_FLOW
            goto L_0x003d
        L_0x0039:
            if (r8 == 0) goto L_0x003d
            com.facebook.messenger.MessengerThreadParams$Origin r4 = com.facebook.messenger.MessengerThreadParams.Origin.COMPOSE_FLOW
        L_0x003d:
            com.facebook.messenger.MessengerThreadParams r8 = new com.facebook.messenger.MessengerThreadParams
            if (r2 == 0) goto L_0x0063
            int r3 = r2.length()
            if (r3 != 0) goto L_0x0048
            goto L_0x0063
        L_0x0048:
            java.lang.String r3 = ","
            java.lang.String[] r2 = r2.split(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r5 = r2.length
            r6 = 0
        L_0x0055:
            if (r6 >= r5) goto L_0x0067
            r7 = r2[r6]
            java.lang.String r7 = r7.trim()
            r3.add(r7)
            int r6 = r6 + 1
            goto L_0x0055
        L_0x0063:
            java.util.List r3 = java.util.Collections.emptyList()
        L_0x0067:
            r8.<init>(r4, r0, r1, r3)
            return r8
        L_0x006b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messenger.MessengerUtils.getMessengerThreadParamsForIntent(android.content.Intent):com.facebook.messenger.MessengerThreadParams");
    }

    public static boolean hasMessengerInstalled(Context context) {
        return FacebookSignatureValidator.validateSignature(context, PACKAGE_NAME);
    }

    @AutoHandleExceptions
    public static void openMessengerInPlayStore(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.facebook.orca")));
        } catch (ActivityNotFoundException unused) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.facebook.orca")));
        }
    }

    @AutoHandleExceptions
    public static void shareToMessenger(Activity activity, int i, ShareToMessengerParams shareToMessengerParams) {
        if (!hasMessengerInstalled(activity)) {
            openMessengerInPlayStore(activity);
            return;
        }
        ContentResolver contentResolver = activity.getContentResolver();
        HashSet hashSet = new HashSet();
        Cursor query = contentResolver.query(Uri.parse("content://com.facebook.orca.provider.MessengerPlatformProvider/versions"), new String[]{"version"}, null, null, null);
        if (query != null) {
            try {
                int columnIndex = query.getColumnIndex("version");
                while (query.moveToNext()) {
                    hashSet.add(Integer.valueOf(query.getInt(columnIndex)));
                }
            } finally {
                query.close();
            }
        }
        if (hashSet.contains(Integer.valueOf((int) PROTOCOL_VERSION_20150314))) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setFlags(1);
                intent.setPackage(PACKAGE_NAME);
                intent.putExtra("android.intent.extra.STREAM", shareToMessengerParams.uri);
                intent.setType(shareToMessengerParams.mimeType);
                String applicationId = FacebookSdk.getApplicationId();
                if (applicationId != null) {
                    intent.putExtra(EXTRA_PROTOCOL_VERSION, PROTOCOL_VERSION_20150314);
                    intent.putExtra(EXTRA_APP_ID, applicationId);
                    intent.putExtra(EXTRA_METADATA, shareToMessengerParams.metaData);
                    intent.putExtra(EXTRA_EXTERNAL_URI, shareToMessengerParams.externalUri);
                }
                activity.startActivityForResult(intent, i);
            } catch (ActivityNotFoundException unused) {
                activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME));
            }
        } else {
            openMessengerInPlayStore(activity);
        }
    }
}
