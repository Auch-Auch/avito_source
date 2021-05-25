package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.nativeads.ag;
import com.yandex.mobile.ads.nativeads.r;
public final class ok {
    @NonNull
    private final fo a;
    @NonNull
    private final cq b;
    @NonNull
    private final oh c;
    @NonNull
    private final r d;
    @NonNull
    private final ag e;

    public ok(@NonNull fo foVar, @NonNull cq cqVar, @NonNull oh ohVar, @NonNull ag agVar, @NonNull r rVar) {
        this.a = foVar;
        this.b = cqVar;
        this.c = ohVar;
        this.e = agVar;
        this.d = rVar;
    }

    @Nullable
    public final oj a(@NonNull Context context, @NonNull pa paVar) {
        String a3 = paVar.a();
        a3.hashCode();
        char c2 = 65535;
        switch (a3.hashCode()) {
            case -342500282:
                if (a3.equals("shortcut")) {
                    c2 = 0;
                    break;
                }
                break;
            case -191501435:
                if (a3.equals("feedback")) {
                    c2 = 1;
                    break;
                }
                break;
            case 94756344:
                if (a3.equals("close")) {
                    c2 = 2;
                    break;
                }
                break;
            case 629233382:
                if (a3.equals("deeplink")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new op(new ra(context, this.b, this.e));
            case 1:
                return new oo(new qx(this.a, this.b, this.e, this.d));
            case 2:
                return new om(this.b, this.d);
            case 3:
                return new on(new qs(context, this.b, this.c));
            default:
                return null;
        }
    }
}
