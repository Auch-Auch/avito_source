package com.avito.android.serp.adapter.witcher;

import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.util.Kundle;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class WitcherItemPresenterImpl_Factory implements Factory<WitcherItemPresenterImpl> {
    public final Provider<WitcherResourceProvider> a;
    public final Provider<WitcherItemListener> b;
    public final Provider<Kundle> c;
    public final Provider<WitcherAnalyticsInteractor> d;
    public final Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> e;

    public WitcherItemPresenterImpl_Factory(Provider<WitcherResourceProvider> provider, Provider<WitcherItemListener> provider2, Provider<Kundle> provider3, Provider<WitcherAnalyticsInteractor> provider4, Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static WitcherItemPresenterImpl_Factory create(Provider<WitcherResourceProvider> provider, Provider<WitcherItemListener> provider2, Provider<Kundle> provider3, Provider<WitcherAnalyticsInteractor> provider4, Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> provider5) {
        return new WitcherItemPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static WitcherItemPresenterImpl newInstance(WitcherResourceProvider witcherResourceProvider, Lazy<WitcherItemListener> lazy, Kundle kundle, WitcherAnalyticsInteractor witcherAnalyticsInteractor, SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> singleManuallyExposedAbTestGroup) {
        return new WitcherItemPresenterImpl(witcherResourceProvider, lazy, kundle, witcherAnalyticsInteractor, singleManuallyExposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public WitcherItemPresenterImpl get() {
        return newInstance(this.a.get(), DoubleCheck.lazy(this.b), this.c.get(), this.d.get(), this.e.get());
    }
}
