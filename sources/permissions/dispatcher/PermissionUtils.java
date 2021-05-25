package permissions.dispatcher;

import android.app.Activity;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
public final class PermissionUtils {
    public static final SimpleArrayMap<String, Integer> a;

    static {
        SimpleArrayMap<String, Integer> simpleArrayMap = new SimpleArrayMap<>(13);
        a = simpleArrayMap;
        simpleArrayMap.put("com.android.voicemail.permission.ADD_VOICEMAIL", 14);
        simpleArrayMap.put("android.permission.READ_CALL_LOG", 16);
        simpleArrayMap.put("android.permission.READ_EXTERNAL_STORAGE", 16);
        simpleArrayMap.put("android.permission.WRITE_CALL_LOG", 16);
        simpleArrayMap.put("android.permission.BODY_SENSORS", 20);
        simpleArrayMap.put("android.permission.SYSTEM_ALERT_WINDOW", 23);
        simpleArrayMap.put("android.permission.WRITE_SETTINGS", 23);
        simpleArrayMap.put("android.permission.READ_PHONE_NUMBERS", 26);
        simpleArrayMap.put("android.permission.ANSWER_PHONE_CALLS", 26);
        simpleArrayMap.put("android.permission.ACCEPT_HANDOVER", 28);
        simpleArrayMap.put("android.permission.ACTIVITY_RECOGNITION", 29);
        simpleArrayMap.put("android.permission.ACCESS_MEDIA_LOCATION", 29);
        simpleArrayMap.put("android.permission.ACCESS_BACKGROUND_LOCATION", 29);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (androidx.core.content.PermissionChecker.checkSelfPermission(r7, r4) == 0) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean hasSelfPermissions(android.content.Context r7, java.lang.String... r8) {
        /*
            int r0 = r8.length
            r1 = 0
            r2 = 0
        L_0x0003:
            r3 = 1
            if (r2 >= r0) goto L_0x002e
            r4 = r8[r2]
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r5 = permissions.dispatcher.PermissionUtils.a
            java.lang.Object r5 = r5.get(r4)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x001d
            int r6 = android.os.Build.VERSION.SDK_INT
            int r5 = r5.intValue()
            if (r6 < r5) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r5 = 0
            goto L_0x001e
        L_0x001d:
            r5 = 1
        L_0x001e:
            if (r5 == 0) goto L_0x002b
            int r4 = androidx.core.content.PermissionChecker.checkSelfPermission(r7, r4)     // Catch:{ RuntimeException -> 0x0027 }
            if (r4 != 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r3 = 0
        L_0x0028:
            if (r3 != 0) goto L_0x002b
            return r1
        L_0x002b:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x002e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: permissions.dispatcher.PermissionUtils.hasSelfPermissions(android.content.Context, java.lang.String[]):boolean");
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String... strArr) {
        for (String str : strArr) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verifyPermissions(int... iArr) {
        if (iArr.length == 0) {
            return false;
        }
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean shouldShowRequestPermissionRationale(Fragment fragment, String... strArr) {
        for (String str : strArr) {
            if (fragment.shouldShowRequestPermissionRationale(str)) {
                return true;
            }
        }
        return false;
    }
}
