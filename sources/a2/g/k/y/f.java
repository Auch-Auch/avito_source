package a2.g.k.y;

import a2.b.a.a.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.work.PeriodicWorkRequest;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.SourceApplicationInfo;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.internal.security.CertificateUtil;
import java.util.Locale;
import ru.avito.messenger.internal.ConstantsKt;
@AutoHandleExceptions
public class f {
    public static final String a = "a2.g.k.y.f";
    public static final long[] b = {300000, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, 1800000, ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    public static void a(String str, SourceApplicationInfo sourceApplicationInfo, String str2, Context context) {
        String str3;
        Bundle y1 = a.y1(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, "Unclassified");
        try {
            PackageManager packageManager = context.getPackageManager();
            String str4 = "PCKGCHKSUM;" + packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
            SharedPreferences sharedPreferences = context.getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0);
            str3 = sharedPreferences.getString(str4, null);
            if (str3 == null || str3.length() != 32) {
                str3 = AppCompatDelegateImpl.i.K(packageManager.getApplicationInfo(context.getPackageName(), 0).sourceDir);
                sharedPreferences.edit().putString(str4, str3).apply();
            }
        } catch (Exception unused) {
            str3 = null;
        }
        y1.putString(AppEventsConstants.EVENT_PARAM_PACKAGE_FP, str3);
        y1.putString(AppEventsConstants.EVENT_PARAM_APP_CERT_HASH, CertificateUtil.getCertificateHash(context));
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(str, str2, null);
        internalAppEventsLogger.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, y1);
        if (InternalAppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            internalAppEventsLogger.flush();
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0085: APUT  
      (r4v3 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Integer : 0x0081: INVOKE  (r5v3 java.lang.Integer) = (r7v1 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    public static void b(String str, e eVar, String str2) {
        Long l;
        if (eVar != null) {
            Long l2 = eVar.d;
            Long valueOf = Long.valueOf((l2 == null ? 0 : l2.longValue()) - eVar.b.longValue());
            if (valueOf.longValue() < 0) {
                valueOf = 0L;
                Logger.log(LoggingBehavior.APP_EVENTS, a, "Clock skew detected");
            }
            Long valueOf2 = Long.valueOf((eVar.a == null || (l = eVar.b) == null) ? 0 : l.longValue() - eVar.a.longValue());
            if (valueOf2.longValue() < 0) {
                Logger.log(LoggingBehavior.APP_EVENTS, a, "Clock skew detected");
                valueOf2 = 0L;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, eVar.c);
            Locale locale = Locale.ROOT;
            Object[] objArr = new Object[1];
            long longValue = valueOf.longValue();
            int i = 0;
            while (true) {
                long[] jArr = b;
                if (i >= jArr.length || jArr[i] >= longValue) {
                    break;
                }
                i++;
            }
            objArr[0] = Integer.valueOf(i);
            bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, String.format(locale, "session_quanta_%d", objArr));
            SourceApplicationInfo sourceApplicationInfo = eVar.e;
            bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified");
            bundle.putLong(Constants.LOG_TIME_APP_EVENT_KEY, eVar.b.longValue() / 1000);
            new InternalAppEventsLogger(str, str2, null).logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, ((double) valueOf2.longValue()) / 1000.0d, bundle);
        }
    }
}
