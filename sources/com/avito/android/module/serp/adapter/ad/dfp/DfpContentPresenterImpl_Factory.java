package com.avito.android.module.serp.adapter.ad.dfp;

import com.avito.android.design.widget.dfp_debug.DfpDebugPresenter;
import com.avito.android.serp.adapter.AdBannerEventListener;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpContentPresenterImpl_Factory implements Factory<DfpContentPresenterImpl> {
    public final Provider<AdBannerEventListener> a;
    public final Provider<DfpDebugPresenter> b;

    public DfpContentPresenterImpl_Factory(Provider<AdBannerEventListener> provider, Provider<DfpDebugPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DfpContentPresenterImpl_Factory create(Provider<AdBannerEventListener> provider, Provider<DfpDebugPresenter> provider2) {
        return new DfpContentPresenterImpl_Factory(provider, provider2);
    }

    public static DfpContentPresenterImpl newInstance(Lazy<AdBannerEventListener> lazy, DfpDebugPresenter dfpDebugPresenter) {
        return new DfpContentPresenterImpl(lazy, dfpDebugPresenter);
    }

    @Override // javax.inject.Provider
    public DfpContentPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get());
    }
}
