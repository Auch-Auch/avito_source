package a2.g.s;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
@AutoHandleExceptions
public class k {
    public final InternalAppEventsLogger a;
    public String b;
    public String c;

    public k(Context context, String str) {
        PackageInfo packageInfo;
        this.b = str;
        this.a = new InternalAppEventsLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) != null) {
                this.c = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static Bundle c(String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", str);
        bundle.putString("3_method", "");
        bundle.putString("2_result", "");
        bundle.putString("5_error_message", "");
        bundle.putString("4_error_code", "");
        bundle.putString("6_extras", "");
        return bundle;
    }

    public void a(String str) {
        Bundle c2 = c(str);
        c2.putString("2_result", PublicConstantsKt.FAILURE);
        this.a.logEventImplicitly("fb_mobile_login_status_complete", c2);
    }

    public void b(String str, String str2, String str3) {
        Bundle c2 = c("");
        c2.putString("2_result", "error");
        c2.putString("5_error_message", str2);
        c2.putString("3_method", str3);
        this.a.logEventImplicitly(str, c2);
    }
}
