package com.yandex.mobile.ads.rewarded;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.bq;
import com.yandex.mobile.ads.impl.eh;
import com.yandex.mobile.ads.impl.in;
import com.yandex.mobile.ads.impl.js;
import com.yandex.mobile.ads.impl.kq;
import com.yandex.mobile.ads.impl.kr;
import com.yandex.mobile.ads.impl.tg;
import com.yandex.mobile.ads.impl.th;
import com.yandex.mobile.ads.impl.v;
import com.yandex.mobile.ads.impl.x;
public final class b extends in {
    @NonNull
    private final a h;
    @NonNull
    private final eh i = new eh();
    @NonNull
    private final th j;
    @NonNull
    private final js k;
    @Nullable
    private tg l;

    public b(@NonNull Context context, @NonNull a aVar) {
        super(context, com.yandex.mobile.ads.b.REWARDED, aVar);
        this.h = aVar;
        this.j = new th(aVar);
        js jsVar = new js();
        this.k = jsVar;
        aVar.a(jsVar);
    }

    public final void F() {
        tg tgVar = this.l;
        if (tgVar != null) {
            tgVar.a();
        }
    }

    public final void c(@Nullable String str) {
        this.f.e(str);
    }

    @Override // com.yandex.mobile.ads.impl.in, com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.impl.y.a
    public final void a(int i2, @Nullable Bundle bundle) {
        if (i2 != 13) {
            super.a(i2, bundle);
        } else {
            F();
        }
    }

    @Override // com.yandex.mobile.ads.impl.in
    @NonNull
    public final kq a(@NonNull kr krVar) {
        return krVar.a(this);
    }

    @Override // com.yandex.mobile.ads.impl.in, com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab
    public final void a(@NonNull x<String> xVar) {
        this.k.a(xVar);
        bq o = xVar.o();
        boolean z = true;
        if (o == null || (!o.c() ? o.a() == null : o.b() == null)) {
            z = false;
        }
        if (z) {
            super.a(xVar);
        } else {
            onAdFailedToLoad(v.e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.in
    public final void a() {
        this.l = this.j.a(this.b, this.f, this.g);
        super.a();
    }

    public final void a(@Nullable RewardedAdEventListener rewardedAdEventListener) {
        this.h.a(rewardedAdEventListener);
    }
}
