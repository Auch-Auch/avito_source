package com.yandex.mobile.ads.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.yandex.metrica.YandexMetrica;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public final class dw {
    private static final Object a = new Object();
    private static volatile dw b;
    private static final List<String> d = new ArrayList<String>() { // from class: com.yandex.mobile.ads.impl.dw.1
        private static final long serialVersionUID = 5712356855156500689L;

        {
            add("com.yandex.mobile.ads.AdActivity");
        }
    };
    private static final List<String> e = new ArrayList<String>() { // from class: com.yandex.mobile.ads.impl.dw.2
        private static final long serialVersionUID = 7066618132468587294L;

        {
            add("android.permission.ACCESS_NETWORK_STATE");
            add("android.permission.INTERNET");
        }
    };
    private boolean c = true;

    public static class a extends Exception {
        private static final long serialVersionUID = 3046464751153928670L;

        public a(String str) {
            super(str);
        }
    }

    public static dw a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new dw();
                }
            }
        }
        return b;
    }

    public static boolean b() {
        try {
            YandexMetrica.getLibraryVersion();
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public final boolean a(Context context) throws a {
        if (this.c) {
            synchronized (a) {
                if (this.c) {
                    if (id.a(context)) {
                        PackageManager packageManager = context.getPackageManager();
                        String packageName = context.getPackageName();
                        Iterator it = new ArrayList(d).iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            try {
                                packageManager.getActivityInfo(new ComponentName(packageName, str), 32);
                            } catch (PackageManager.NameNotFoundException unused) {
                                throw new a(String.format("Please, check %s activity in AndroidManifest file.", str));
                            }
                        }
                        try {
                            ArrayList arrayList = new ArrayList(e);
                            String[] strArr = packageManager.getPackageInfo(packageName, 4096).requestedPermissions;
                            if (strArr != null) {
                                arrayList.removeAll(Arrays.asList(strArr));
                                if (arrayList.size() > 0) {
                                    throw new a(String.format("Please, check %s permission in AndroidManifest file.", arrayList));
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                            throw new a(String.format("Please, check %s permission in AndroidManifest file.", e));
                        }
                    }
                    this.c = false;
                }
            }
        }
        return true;
    }
}
