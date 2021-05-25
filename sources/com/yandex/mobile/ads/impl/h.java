package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.b;
public abstract class h extends iv {
    private boolean h;
    private Runnable i = new Runnable() { // from class: com.yandex.mobile.ads.impl.h.1
        @Override // java.lang.Runnable
        public final void run() {
            h hVar = h.this;
            hVar.a(hVar.k());
        }
    };

    @SuppressLint({"VisibleForTests"})
    public h(@NonNull Context context, @NonNull ck ckVar, @NonNull b bVar) {
        super(context, ckVar, bVar);
        if (q() && dw.b()) {
            this.h = true;
        }
    }

    private void h() {
        a();
        x z = z();
        if (z != null && z.x() && this.h && !E()) {
            this.a.postDelayed(this.i, (long) z.u());
            z.s();
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv
    public void b(int i2) {
        super.b(i2);
        h();
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.it, com.yandex.mobile.ads.impl.ab
    public void d() {
        super.d();
        a(false);
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public final void j() {
        super.j();
        h();
    }

    @Override // com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.AdEventListener
    public void onAdFailedToLoad(@NonNull AdRequestError adRequestError) {
        super.onAdFailedToLoad(adRequestError);
        if (5 != adRequestError.getCode() && 2 != adRequestError.getCode()) {
            h();
        }
    }

    private void a() {
        this.a.removeCallbacks(this.i);
    }

    public final void a(boolean z) {
        this.h = z;
        if (z) {
            h();
        } else {
            a();
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.impl.ah.b
    public void a(@NonNull Intent intent) {
        super.a(intent);
        h();
    }
}
