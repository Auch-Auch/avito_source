package a2.j.b.e.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
public final class n2 {
    public final Context a;

    public n2(Context context) {
        this.a = context;
    }

    public static String a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                return bundle.getString("local_testing_dir");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }
}
