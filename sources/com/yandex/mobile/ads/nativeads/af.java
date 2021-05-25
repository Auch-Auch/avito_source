package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Pair;
import android.view.View;
import com.yandex.mobile.ads.impl.ah;
import com.yandex.mobile.ads.impl.an;
import com.yandex.mobile.ads.impl.co;
import com.yandex.mobile.ads.impl.eg;
import com.yandex.mobile.ads.nativeads.au;
public class af implements be {
    @VisibleForTesting
    @NonNull
    public final au a;
    @NonNull
    private final ah b = ah.a();
    @Nullable
    private ag c;

    public af(@NonNull au auVar) {
        this.a = auVar;
    }

    @Override // com.yandex.mobile.ads.nativeads.be
    public final void a(@NonNull ag agVar) {
        this.c = agVar;
        this.a.a(agVar);
    }

    @Override // com.yandex.mobile.ads.nativeads.be
    @NonNull
    public final bk b() {
        return this.a.e();
    }

    @Override // com.yandex.mobile.ads.nativeads.be
    @NonNull
    public final an a(@NonNull Context context, int i) {
        an.a aVar;
        View c2;
        boolean z = true;
        String str = null;
        if (!this.b.a(context)) {
            aVar = an.a.APPLICATION_INACTIVE;
        } else if (a()) {
            aVar = an.a.SUPERVIEW_HIDDEN;
        } else {
            ag agVar = this.c;
            if ((agVar == null || (c2 = agVar.c()) == null) ? true : eg.a(c2, 10)) {
                aVar = an.a.TOO_SMALL;
            } else {
                ag agVar2 = this.c;
                if (agVar2 != null && eg.b(agVar2.c(), i)) {
                    z = false;
                }
                if (z) {
                    aVar = an.a.NOT_VISIBLE_FOR_PERCENT;
                } else {
                    au.a a3 = this.a.a();
                    an.a b2 = a3.b();
                    str = a3.a();
                    aVar = b2;
                }
            }
        }
        Pair pair = new Pair(aVar, str);
        an a4 = a(context, (an.a) pair.first);
        a4.a((String) pair.second);
        return a4;
    }

    public an a(@NonNull Context context, an.a aVar) {
        return new an(aVar, new co());
    }

    @Override // com.yandex.mobile.ads.nativeads.be
    @VisibleForTesting
    public final boolean a() {
        View c2;
        ag agVar = this.c;
        if (agVar == null || (c2 = agVar.c()) == null) {
            return true;
        }
        return eg.d(c2);
    }
}
