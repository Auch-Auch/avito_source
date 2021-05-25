package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.File;
public final class bw {
    public static rz a(@NonNull Context context, int i) {
        sd.a("Yandex Mobile Ads");
        sd.b = false;
        sm smVar = new sm(new sx(context, new te()).a());
        File a = bs.a(context, "mobileads-volley-cache");
        return new rz(new so(a, (int) dy.a(a)), smVar, i);
    }
}
