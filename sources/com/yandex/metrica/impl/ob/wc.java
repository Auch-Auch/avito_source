package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.vk.sdk.api.VKApiConst;
import com.yandex.metrica.impl.ob.abc;
public class wc {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    @Deprecated
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @Nullable
    public final String h;
    @Nullable
    public final String i;
    @Nullable
    public final String j;
    @Nullable
    public final String k;
    @Nullable
    public final String l;
    @Nullable
    public final String m;
    @Nullable
    public final String n;
    @Nullable
    public final String o;
    @Nullable
    public final String p;

    public wc(@NonNull abc.a aVar) {
        String str;
        this.a = aVar.a("dId");
        this.b = aVar.a("uId");
        this.c = aVar.b("kitVer");
        this.d = aVar.a("analyticsSdkVersionName");
        this.e = aVar.a("kitBuildNumber");
        this.f = aVar.a("kitBuildType");
        this.g = aVar.a("appVer");
        this.h = aVar.optString("app_debuggable", "0");
        this.i = aVar.a("appBuild");
        this.j = aVar.a("osVer");
        this.l = aVar.a(VKApiConst.LANG);
        this.m = aVar.a("root");
        this.p = aVar.a("commit_hash");
        this.n = aVar.optString("app_framework", cx.b());
        int optInt = aVar.optInt("osApiLev", -1);
        String str2 = null;
        if (optInt == -1) {
            str = null;
        } else {
            str = String.valueOf(optInt);
        }
        this.k = str;
        int optInt2 = aVar.optInt("attribution_id", 0);
        this.o = optInt2 > 0 ? String.valueOf(optInt2) : str2;
    }

    public wc() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
    }
}
