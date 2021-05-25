package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Base64;
import com.avito.android.db.SubscriptionsContract;
import com.yandex.metrica.impl.ob.ah;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class bc {
    private final JSONObject a;
    @NonNull
    private final ado b;
    @NonNull
    private final Context c;
    @NonNull
    private final ah d;

    public bc(@NonNull Context context) {
        this(context, new ah(context), new ado());
    }

    @NonNull
    @TargetApi(21)
    private JSONArray h() throws JSONException {
        return new JSONArray(Build.SUPPORTED_ABIS);
    }

    @NonNull
    private JSONArray i() {
        ArrayList arrayList = new ArrayList();
        String str = Build.CPU_ABI;
        if (!"unknown".equals(str)) {
            arrayList.add(str);
        }
        String str2 = Build.CPU_ABI2;
        if (!"unknown".equals(str2)) {
            arrayList.add(str2);
        }
        return new JSONArray((Collection) arrayList);
    }

    private List<ResolveInfo> j() throws UnsupportedEncodingException {
        return dl.a(this.c, new String(Base64.decode("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLk1BSU4=", 0), "UTF-8"), new String(Base64.decode("YW5kcm9pZC5pbnRlbnQuY2F0ZWdvcnkuTEFVTkNIRVI=", 0), "UTF-8"));
    }

    @NonNull
    private Set<String> k() throws UnsupportedEncodingException {
        return a(l());
    }

    @NonNull
    private List<ResolveInfo> l() throws UnsupportedEncodingException {
        return dl.a(this.c, new String(Base64.decode("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLk1BSU4=", 0), "UTF-8"), new String(Base64.decode("YW5kcm9pZC5pbnRlbnQuY2F0ZWdvcnkuSE9NRQ==", 0), "UTF-8"));
    }

    @Nullable
    private String m() throws UnsupportedEncodingException {
        Intent intent = new Intent(new String(Base64.decode("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLk1BSU4=", 0), "UTF-8"));
        intent.addCategory(new String(Base64.decode("YW5kcm9pZC5pbnRlbnQuY2F0ZWdvcnkuSE9NRQ==", 0), "UTF-8"));
        ResolveInfo d2 = this.b.d(this.c, intent, 65536);
        if (d2 != null) {
            return d2.activityInfo.applicationInfo.packageName;
        }
        return null;
    }

    public bc a() {
        try {
            f();
            d();
        } catch (Throwable unused) {
        }
        b();
        return this;
    }

    public bc b() {
        try {
            Object obj = Class.forName("kotlin.KotlinVersion").getDeclaredField("CURRENT").get(null);
            int intValue = ((Integer) obj.getClass().getDeclaredMethod("getMajor", new Class[0]).invoke(obj, new Object[0])).intValue();
            int intValue2 = ((Integer) obj.getClass().getDeclaredMethod("getMinor", new Class[0]).invoke(obj, new Object[0])).intValue();
            ((JSONObject) a(this.a, "dfid", new JSONObject())).put("kotlin_runtime", new JSONObject().put("major", intValue).put("minor", intValue2).put("patch", ((Integer) obj.getClass().getDeclaredMethod("getPatch", new Class[0]).invoke(obj, new Object[0])).intValue()));
        } catch (ClassNotFoundException unused) {
        }
        return this;
    }

    public bc c() throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObject = (JSONObject) a(this.a, "dfid", new JSONObject());
        if (dl.a(21)) {
            jSONArray = h();
        } else {
            jSONArray = i();
        }
        jSONObject.put("cpu_abis", jSONArray);
        return this;
    }

    public bc d() throws JSONException {
        ((JSONObject) a(this.a, "dfid", new JSONObject())).put("boot_time", abu.a() / 1000);
        return this;
    }

    public bc e() throws Exception {
        Set<String> k = k();
        String m = m();
        JSONObject jSONObject = (JSONObject) a((JSONObject) a(this.a, "dfid", new JSONObject()), "apps", new JSONObject());
        JSONArray jSONArray = (JSONArray) a(jSONObject, "names", new JSONArray());
        JSONArray jSONArray2 = (JSONArray) a(jSONObject, "system_flags", new JSONArray());
        JSONArray jSONArray3 = (JSONArray) a(jSONObject, "disabled_flags", new JSONArray());
        JSONArray jSONArray4 = (JSONArray) a(jSONObject, "first_install_time", new JSONArray());
        JSONArray jSONArray5 = (JSONArray) a(jSONObject, SubscriptionsContract.Columns.LAST_UPDATE_TIME, new JSONArray());
        JSONArray jSONArray6 = (JSONArray) a(jSONObject, "launchers", new JSONArray());
        jSONObject.put("version", 0);
        Integer num = null;
        int i = 0;
        for (PackageInfo packageInfo : dl.a(this.c)) {
            jSONArray.put(packageInfo.packageName);
            jSONArray2.put((packageInfo.applicationInfo.flags & 1) == 1);
            jSONArray3.put(true ^ packageInfo.applicationInfo.enabled);
            a(jSONArray4, packageInfo);
            b(jSONArray5, packageInfo);
            if (k.contains(packageInfo.packageName)) {
                jSONArray6.put(i);
            }
            if (packageInfo.packageName.equals(m)) {
                num = Integer.valueOf(i);
            }
            i++;
        }
        jSONObject.putOpt("default_launcher", num);
        return this;
    }

    public bc f() throws JSONException {
        JSONObject jSONObject = (JSONObject) a(this.a, "dfid", new JSONObject());
        ah.a a3 = this.d.a();
        jSONObject.put("tds", a3.a);
        jSONObject.put("fds", a3.b);
        return this;
    }

    public String g() {
        return this.a.toString();
    }

    public String toString() {
        return this.a.toString();
    }

    @VisibleForTesting
    public bc(@NonNull Context context, @NonNull ah ahVar, @NonNull ado ado) {
        this.a = new JSONObject();
        this.c = context;
        this.d = ahVar;
        this.b = ado;
    }

    public bc a(boolean z) throws JSONException, UnsupportedEncodingException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = (JSONObject) a((JSONObject) a(this.a, "dfid", new JSONObject()), "au", new JSONObject());
        JSONArray jSONArray3 = (JSONArray) a(jSONObject, "aun", new JSONArray());
        JSONArray jSONArray4 = (JSONArray) a(jSONObject, "ausf", new JSONArray());
        JSONArray jSONArray5 = (JSONArray) a(jSONObject, "audf", new JSONArray());
        JSONArray jSONArray6 = (JSONArray) a(jSONObject, "aulu", new JSONArray());
        JSONArray jSONArray7 = new JSONArray();
        JSONArray jSONArray8 = (JSONArray) a(jSONObject, "aul", new JSONArray());
        if (z) {
            a(jSONObject, "aufi", jSONArray7);
        }
        List<ResolveInfo> l = l();
        Set<String> a3 = a(l);
        String m = m();
        HashSet hashSet = new HashSet();
        Integer num = null;
        List<ResolveInfo> j = j();
        j.addAll(l);
        int i = 0;
        for (ResolveInfo resolveInfo : j) {
            ApplicationInfo applicationInfo = resolveInfo.activityInfo.applicationInfo;
            if (hashSet.add(applicationInfo.packageName)) {
                jSONArray3.put(applicationInfo.packageName);
                jSONArray2 = jSONArray3;
                boolean z2 = (applicationInfo.flags & 1) == 1;
                jSONArray4.put(z2);
                jSONArray = jSONArray4;
                jSONArray6.put(new File(applicationInfo.sourceDir).lastModified());
                jSONArray5.put(!applicationInfo.enabled);
                if (z) {
                    a(jSONArray7, z2, applicationInfo);
                }
                if (a3.contains(applicationInfo.packageName)) {
                    jSONArray8.put(i);
                }
                if (applicationInfo.packageName.equals(m)) {
                    num = Integer.valueOf(i);
                }
                i++;
            } else {
                jSONArray2 = jSONArray3;
                jSONArray = jSONArray4;
            }
            jSONArray3 = jSONArray2;
            jSONArray4 = jSONArray;
        }
        jSONObject.putOpt("audl", num);
        return this;
    }

    private void b(JSONArray jSONArray, PackageInfo packageInfo) {
        jSONArray.put(packageInfo.lastUpdateTime / 1000);
    }

    private void a(@NonNull JSONArray jSONArray, boolean z, @NonNull ApplicationInfo applicationInfo) {
        if (z) {
            jSONArray.put(0);
            return;
        }
        PackageInfo a3 = this.b.a(this.c, applicationInfo.packageName);
        if (a3 == null) {
            jSONArray.put(0);
        } else {
            jSONArray.put(TimeUnit.MILLISECONDS.toSeconds(a3.firstInstallTime));
        }
    }

    @NonNull
    private Set<String> a(@NonNull List<ResolveInfo> list) {
        HashSet hashSet = new HashSet();
        for (ResolveInfo resolveInfo : list) {
            hashSet.add(resolveInfo.activityInfo.applicationInfo.packageName);
        }
        return hashSet;
    }

    private void a(JSONArray jSONArray, PackageInfo packageInfo) {
        jSONArray.put(packageInfo.firstInstallTime / 1000);
    }

    public static <T> T a(JSONObject jSONObject, String str, T t) throws JSONException {
        if (!jSONObject.has(str)) {
            jSONObject.put(str, t);
        }
        return (T) jSONObject.get(str);
    }
}
