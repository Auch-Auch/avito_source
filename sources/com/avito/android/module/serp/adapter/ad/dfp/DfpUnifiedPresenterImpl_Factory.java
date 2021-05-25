package com.avito.android.module.serp.adapter.ad.dfp;

import com.avito.android.design.widget.dfp_debug.DfpDebugPresenter;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.avito.android.util.SchedulersFactory3;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpUnifiedPresenterImpl_Factory implements Factory<DfpUnifiedPresenterImpl> {
    public final Provider<AdBannerEventListener> a;
    public final Provider<DfpDebugPresenter> b;
    public final Provider<SchedulersFactory3> c;

    public DfpUnifiedPresenterImpl_Factory(Provider<AdBannerEventListener> provider, Provider<DfpDebugPresenter> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DfpUnifiedPresenterImpl_Factory create(Provider<AdBannerEventListener> provider, Provider<DfpDebugPresenter> provider2, Provider<SchedulersFactory3> provider3) {
        return new DfpUnifiedPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static DfpUnifiedPresenterImpl newInstance(Lazy<AdBannerEventListener> lazy, DfpDebugPresenter dfpDebugPresenter, SchedulersFactory3 schedulersFactory3) {
        return new DfpUnifiedPresenterImpl(lazy, dfpDebugPresenter, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public DfpUnifiedPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get());
    }
}
