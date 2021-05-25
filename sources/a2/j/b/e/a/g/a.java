package a2.j.b.e.a.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import com.google.android.play.core.internal.aa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class a {
    public static final aa c = new aa("MissingSplitsAppComponentsHelper");
    public final Context a;
    public final PackageManager b;

    public a(Context context, PackageManager packageManager) {
        this.a = context;
        this.b = packageManager;
    }

    public final void a(List<ComponentInfo> list, int i) {
        for (ComponentInfo componentInfo : list) {
            this.b.setComponentEnabledSetting(new ComponentName(componentInfo.packageName, componentInfo.name), i, 1);
        }
    }

    public final List<ComponentInfo> b() {
        try {
            ArrayList arrayList = new ArrayList();
            PackageInfo packageInfo = this.b.getPackageInfo(this.a.getPackageName(), 526);
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            if (providerInfoArr != null) {
                Collections.addAll(arrayList, providerInfoArr);
            }
            ActivityInfo[] activityInfoArr = packageInfo.receivers;
            if (activityInfoArr != null) {
                Collections.addAll(arrayList, activityInfoArr);
            }
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            if (serviceInfoArr != null) {
                Collections.addAll(arrayList, serviceInfoArr);
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            c.d("Failed to resolve own package : %s", e);
            return Collections.emptyList();
        }
    }
}
