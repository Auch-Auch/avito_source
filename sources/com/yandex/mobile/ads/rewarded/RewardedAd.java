package com.yandex.mobile.ads.rewarded;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.impl.ad;
import com.yandex.mobile.ads.impl.dt;
import com.yandex.mobile.ads.impl.ik;
public final class RewardedAd extends ik {
    @NonNull
    private final b a;

    public RewardedAd(@NonNull Context context) {
        super(context);
        a aVar = new a(context);
        b bVar = new b(context, aVar);
        this.a = bVar;
        aVar.a(bVar.s());
    }

    public final void destroy() {
        if (!dt.a((ad) this.a)) {
            this.a.e();
        }
    }

    public final String getBlockId() {
        return this.a.r();
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

    public final void setRewardedAdEventListener(@Nullable RewardedAdEventListener rewardedAdEventListener) {
        this.a.a(rewardedAdEventListener);
    }

    public final void setUserId(String str) {
        this.a.c(str);
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
