package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"StaticFieldLeak"})
public final class hd {
    private static final Object a = new Object();
    private static volatile hd b;
    @NonNull
    private final Context c;
    @NonNull
    private final hg d = new hg();
    @NonNull
    private final hf e = new hf();

    private hd(@NonNull Context context) {
        this.c = context.getApplicationContext();
    }

    @NonNull
    public static hd a(@NonNull Context context) {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new hd(context);
                }
            }
        }
        return b;
    }

    @Nullable
    public final Location a() {
        Location a3;
        synchronized (a) {
            Context context = this.c;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new hp(context));
            fz a4 = fy.a().a(context);
            if (a4 != null && !a4.j()) {
                arrayList.add(hk.a(context));
                arrayList.add(hl.a(context));
            }
            a3 = hg.a(a(arrayList));
        }
        return a3;
    }

    @NonNull
    private static List<Location> a(@NonNull List<he> list) {
        ArrayList arrayList = new ArrayList();
        for (he heVar : list) {
            Location a3 = heVar.a();
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return arrayList;
    }
}
