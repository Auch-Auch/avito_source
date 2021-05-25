package com.avito.android.shop.filter;

import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopsFilterPresenterImpl_Factory implements Factory<ShopsFilterPresenterImpl> {
    public final Provider<ShopsFilterInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<Resources> c;
    public final Provider<TreeStateIdGenerator> d;
    public final Provider<Analytics> e;
    public final Provider<ShopsSearchParameters> f;
    public final Provider<Bundle> g;

    public ShopsFilterPresenterImpl_Factory(Provider<ShopsFilterInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<Resources> provider3, Provider<TreeStateIdGenerator> provider4, Provider<Analytics> provider5, Provider<ShopsSearchParameters> provider6, Provider<Bundle> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static ShopsFilterPresenterImpl_Factory create(Provider<ShopsFilterInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<Resources> provider3, Provider<TreeStateIdGenerator> provider4, Provider<Analytics> provider5, Provider<ShopsSearchParameters> provider6, Provider<Bundle> provider7) {
        return new ShopsFilterPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ShopsFilterPresenterImpl newInstance(ShopsFilterInteractor shopsFilterInteractor, SchedulersFactory3 schedulersFactory3, Resources resources, TreeStateIdGenerator treeStateIdGenerator, Analytics analytics, ShopsSearchParameters shopsSearchParameters, Bundle bundle) {
        return new ShopsFilterPresenterImpl(shopsFilterInteractor, schedulersFactory3, resources, treeStateIdGenerator, analytics, shopsSearchParameters, bundle);
    }

    @Override // javax.inject.Provider
    public ShopsFilterPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
