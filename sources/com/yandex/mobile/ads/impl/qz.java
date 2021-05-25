package com.yandex.mobile.ads.impl;

import android.app.ActivityManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
public final class qz {
    private final int a;

    public qz(@NonNull Context context) {
        this.a = a(context);
    }

    private static int a(@NonNull Context context) {
        int round = Math.round(context.getResources().getDimension(17104896));
        try {
            return ((ActivityManager) context.getSystemService("activity")).getLauncherLargeIconSize();
        } catch (Exception unused) {
            return round;
        }
    }

    @NonNull
    public final List<ot> a(@NonNull ox oxVar) {
        ArrayList arrayList = new ArrayList();
        a(oxVar.a(), arrayList);
        List<oq> c = oxVar.c();
        if (c != null) {
            for (oq oqVar : c) {
                a(oqVar.d(), arrayList);
            }
        }
        return arrayList;
    }

    @NonNull
    private List<ot> a(@Nullable ou ouVar, @NonNull List<ot> list) {
        List<pa> a3;
        if (!(ouVar == null || (a3 = ouVar.a()) == null)) {
            for (pa paVar : a3) {
                if (paVar instanceof pd) {
                    list.add(a(((pd) paVar).b()));
                }
            }
        }
        return list;
    }

    @NonNull
    public final ot a(@NonNull String str) {
        ot otVar = new ot();
        otVar.a(str);
        otVar.b(this.a);
        otVar.a(this.a);
        return otVar;
    }
}
