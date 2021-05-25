package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.bo;
import com.yandex.mobile.ads.impl.ox;
import com.yandex.mobile.ads.impl.oy;
import java.util.ArrayList;
import java.util.List;
public final class o {
    @NonNull
    public static bh a(@NonNull p pVar, @NonNull ox oxVar) {
        return new bh(oxVar.c(), a(oxVar.d(), pVar.c().e()), a(oxVar.f(), pVar.c().f()), oxVar.e());
    }

    @NonNull
    public static c a(@NonNull p pVar, @NonNull bh bhVar, @NonNull bf bfVar, @NonNull t tVar) {
        return new c(pVar, new af(new m(bhVar.a(), ao.a())), bhVar, bfVar, tVar);
    }

    @NonNull
    private static List<ba> a(@NonNull List<? extends NativeGenericAd> list) {
        ArrayList arrayList = new ArrayList();
        for (NativeGenericAd nativeGenericAd : list) {
            arrayList.add((ba) nativeGenericAd);
        }
        return arrayList;
    }

    @NonNull
    private static <T> List<T> a(@Nullable T t, @Nullable List<T> list) {
        ArrayList arrayList = new ArrayList();
        if (t != null) {
            arrayList.add(t);
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @NonNull
    public static NativeAdUnit a(@NonNull Context context, @NonNull p pVar, @NonNull j jVar, @NonNull t tVar) {
        ArrayList arrayList = new ArrayList();
        List<ox> c = pVar.c().c();
        bg b = tVar.b();
        for (ox oxVar : c) {
            bf a = b.a(oxVar);
            w wVar = new w(context, oxVar, jVar, a);
            c a3 = a(pVar, new bh(oxVar.c(), a(oxVar.d(), (List<bo>) null), a(oxVar.f(), (List<String>) null), oxVar.e()), a, tVar);
            if (NativeAdType.CONTENT == oxVar.b()) {
                arrayList.add(new aw(context, oxVar, wVar, jVar, a3));
            } else if (NativeAdType.APP_INSTALL == oxVar.b()) {
                arrayList.add(new aq(context, oxVar, wVar, jVar, a3));
            } else if (NativeAdType.IMAGE == oxVar.b()) {
                arrayList.add(new bb(context, oxVar, wVar, jVar, a3));
            }
        }
        List<ba> a4 = a(arrayList);
        oy c2 = pVar.c();
        bh bhVar = new bh(c2.b(), a((Object) null, c2.e()), a((Object) null, c2.f()), null);
        return new ab(context, arrayList, jVar, new c(pVar, new ac(a4, new aa(bhVar.a(), ao.a())), bhVar, new ae(bhVar.a()), tVar));
    }
}
