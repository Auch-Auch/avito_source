package com.google.android.play.core.splitinstall;

import a2.j.b.e.a.i.b0;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.html_formatter.jsoup.JsoupExtensionsKt;
import com.google.android.play.core.internal.aa;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
public final class z {
    public static final aa c = new aa("SplitInstallInfoProvider");
    public final Context a;
    public final String b;

    public z(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public static boolean a(String str) {
        return str.startsWith("config.");
    }

    public static boolean b(String str) {
        return a(str) || str.contains(".config.");
    }

    public final Set<String> a() {
        HashSet hashSet = new HashSet();
        Iterator it = ((HashSet) d()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!b(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public final Set<String> b() {
        f c2 = c();
        if (c2 == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Set<String> d = d();
        ((HashSet) d).add("");
        Set<String> a3 = a();
        a3.add("");
        for (Map.Entry<String, Set<String>> entry : c2.a(a3).entrySet()) {
            if (d.containsAll(entry.getValue())) {
                hashSet.add(entry.getKey());
            }
        }
        return hashSet;
    }

    public final f c() {
        String a3;
        Bundle e = e();
        f fVar = null;
        if (e == null) {
            c.d("No metadata found in Context.", new Object[0]);
            return null;
        }
        int i = e.getInt("com.android.vending.splits");
        if (i == 0) {
            c.d("No metadata found in AndroidManifest.", new Object[0]);
            return null;
        }
        try {
            b0 b0Var = new b0(this.a.getResources().getXml(i));
            while (b0Var.a.next() != 1) {
                try {
                    if (b0Var.a.getEventType() == 2) {
                        if (b0Var.a.getName().equals("splits")) {
                            while (b0Var.a.next() != 3) {
                                if (b0Var.a.getEventType() == 2) {
                                    if (!b0Var.a.getName().equals(BaseAnalyticKt.ANALYTIC_FAIL_MODULE) || (a3 = b0Var.a("name")) == null) {
                                        b0Var.b();
                                    } else {
                                        while (b0Var.a.next() != 3) {
                                            if (b0Var.a.getEventType() == 2) {
                                                if (b0Var.a.getName().equals("language")) {
                                                    while (b0Var.a.next() != 3) {
                                                        if (b0Var.a.getEventType() == 2) {
                                                            if (b0Var.a.getName().equals("entry")) {
                                                                String a4 = b0Var.a("key");
                                                                String a5 = b0Var.a(JsoupExtensionsKt.SPLIT_MARK);
                                                                b0Var.b();
                                                                if (!(a4 == null || a5 == null)) {
                                                                    b0Var.b.a(a3, a4, a5);
                                                                }
                                                            } else {
                                                                b0Var.b();
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    b0Var.b();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            b0Var.b();
                        }
                    }
                } catch (IOException | IllegalStateException | XmlPullParserException unused) {
                }
            }
            fVar = b0Var.b.a();
            if (fVar == null) {
                c.d("Can't parse languages metadata.", new Object[0]);
            }
            return fVar;
        } catch (Resources.NotFoundException unused2) {
            c.d("Resource with languages metadata doesn't exist.", new Object[0]);
            return null;
        }
    }

    public final Set<String> d() {
        HashSet hashSet = new HashSet();
        Bundle e = e();
        if (e != null) {
            String string = e.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                c.a("App has no fused modules.", new Object[0]);
            } else {
                Collections.addAll(hashSet, string.split(",", -1));
                hashSet.remove("");
            }
        }
        String[] strArr = null;
        try {
            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.b, 0);
            if (packageInfo != null) {
                strArr = packageInfo.splitNames;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            c.d("App is not found in PackageManager", new Object[0]);
        }
        if (strArr != null) {
            c.a("Adding splits from package manager: %s", Arrays.toString(strArr));
            Collections.addAll(hashSet, strArr);
        } else {
            c.a("No splits are found or app cannot be found in package manager.", new Object[0]);
        }
        x xVar = y.a.get();
        if (xVar != null) {
            hashSet.addAll(xVar.a());
        }
        return hashSet;
    }

    public final Bundle e() {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.b, 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                return bundle;
            }
            c.a("App has no applicationInfo or metaData", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            c.d("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }
}
