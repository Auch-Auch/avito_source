package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.bd;
import com.yandex.mobile.ads.mediation.banner.MediatedBannerAdapter;
import java.lang.ref.WeakReference;
public final class a implements MediatedBannerAdapter.MediatedBannerAdapterListener {
    @NonNull
    private final WeakReference<com.yandex.mobile.ads.impl.a> a;
    @NonNull
    private final g b;
    @NonNull
    private final bd<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> c;
    private boolean d;

    public a(@NonNull com.yandex.mobile.ads.impl.a aVar, @NonNull bd<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> bdVar, @NonNull g gVar) {
        this.c = bdVar;
        this.b = gVar;
        this.a = new WeakReference<>(aVar);
    }

    @Override // com.yandex.mobile.ads.mediation.banner.MediatedBannerAdapter.MediatedBannerAdapterListener
    public final void onAdClicked() {
        com.yandex.mobile.ads.impl.a aVar = this.a.get();
        if (aVar != null) {
            this.c.b(aVar.n());
        }
    }

    @Override // com.yandex.mobile.ads.mediation.banner.MediatedBannerAdapter.MediatedBannerAdapterListener
    public final void onAdFailedToLoad(@NonNull AdRequestError adRequestError) {
        com.yandex.mobile.ads.impl.a aVar = this.a.get();
        if (aVar != null) {
            Context n = aVar.n();
            if (!this.d) {
                this.c.a(n, adRequestError, (AdRequestError) this);
            } else {
                this.c.b(n, adRequestError, this);
            }
        }
    }

    @Override // com.yandex.mobile.ads.mediation.banner.MediatedBannerAdapter.MediatedBannerAdapterListener
    public final void onAdLeftApplication() {
        com.yandex.mobile.ads.impl.a aVar = this.a.get();
        if (aVar != null) {
            aVar.onAdLeftApplication();
        }
    }

    @Override // com.yandex.mobile.ads.mediation.banner.MediatedBannerAdapter.MediatedBannerAdapterListener
    public final void onAdLoaded(@NonNull View view) {
        com.yandex.mobile.ads.impl.a aVar = this.a.get();
        if (aVar != null) {
            Context context = view.getContext();
            if (!this.d) {
                this.d = true;
                this.c.e(context);
            } else {
                this.c.d(context);
            }
            this.b.a(view);
            aVar.onAdLoaded();
        }
    }
}
