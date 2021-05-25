package com.avito.android.brandspace.interactor;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspaceAnalyticsInteractorImpl_Factory implements Factory<BrandspaceAnalyticsInteractorImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<Analytics> c;
    public final Provider<TreeStateIdGenerator> d;
    public final Provider<TreeClickStreamParent> e;
    public final Provider<SchedulersFactory3> f;

    public BrandspaceAnalyticsInteractorImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<Analytics> provider3, Provider<TreeStateIdGenerator> provider4, Provider<TreeClickStreamParent> provider5, Provider<SchedulersFactory3> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static BrandspaceAnalyticsInteractorImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<Analytics> provider3, Provider<TreeStateIdGenerator> provider4, Provider<TreeClickStreamParent> provider5, Provider<SchedulersFactory3> provider6) {
        return new BrandspaceAnalyticsInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static BrandspaceAnalyticsInteractorImpl newInstance(String str, String str2, Analytics analytics, TreeStateIdGenerator treeStateIdGenerator, TreeClickStreamParent treeClickStreamParent, SchedulersFactory3 schedulersFactory3) {
        return new BrandspaceAnalyticsInteractorImpl(str, str2, analytics, treeStateIdGenerator, treeClickStreamParent, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public BrandspaceAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
