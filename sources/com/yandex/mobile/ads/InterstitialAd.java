package com.yandex.mobile.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.ad;
import com.yandex.mobile.ads.impl.dt;
import com.yandex.mobile.ads.impl.ik;
import com.yandex.mobile.ads.impl.jy;
import com.yandex.mobile.ads.impl.jz;
public final class InterstitialAd extends ik {
    @NonNull
    private final jz a;

    public InterstitialAd(@NonNull Context context) {
        super(context);
        jy jyVar = new jy(context);
        jz jzVar = new jz(context, jyVar);
        this.a = jzVar;
        jyVar.a(jzVar.s());
    }

    public final void destroy() {
        if (!dt.a((ad) this.a)) {
            this.a.e();
        }
    }

    public final String getBlockId() {
        return this.a.r();
    }

    public final InterstitialEventListener getInterstitialEventListener() {
        return this.a.F();
    }

    public final boolean isLoaded() {
        return this.a.A();
    }

    public final void loadAd(AdRequest adRequest) {
        this.a.a(adRequest);
    }

    public final void setBlockId(String str) {
        this.a.a_(str);
    }

    public final void setInterstitialEventListener(InterstitialEventListener interstitialEventListener) {
        this.a.a(interstitialEventListener);
    }

    public final void shouldOpenLinksInApp(boolean z) {
        this.a.a_(z);
    }

    public final void show() {
        if (this.a.A()) {
            this.a.a();
        }
    }
}
