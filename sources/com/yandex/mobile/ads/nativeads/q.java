package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.ot;
import com.yandex.mobile.ads.impl.ox;
import com.yandex.mobile.ads.impl.qr;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public final class q {
    @NonNull
    private final qr a = new qr();

    @NonNull
    public static List<String> a(@NonNull List<ox> list) {
        HashSet hashSet = new HashSet();
        for (ox oxVar : list) {
            hashSet.addAll(a(oxVar));
        }
        return new ArrayList(hashSet);
    }

    @NonNull
    public static List<String> a(@NonNull ox oxVar) {
        HashSet hashSet = new HashSet();
        for (ot otVar : qr.a(oxVar)) {
            if (!TextUtils.isEmpty(otVar.d())) {
                hashSet.add(otVar.d());
            }
        }
        return new ArrayList(hashSet);
    }
}
