package com.avito.android.module.serp.adapter.ad.mytarget;

import com.avito.android.Features;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.serp.adapter.AdBannerEventListener;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyTargetAppInstallPresenterImpl_Factory implements Factory<MyTargetAppInstallPresenterImpl> {
    public final Provider<AdBannerEventListener> a;
    public final Provider<MyTargetImageBgProvider> b;
    public final Provider<Features> c;

    public MyTargetAppInstallPresenterImpl_Factory(Provider<AdBannerEventListener> provider, Provider<MyTargetImageBgProvider> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MyTargetAppInstallPresenterImpl_Factory create(Provider<AdBannerEventListener> provider, Provider<MyTargetImageBgProvider> provider2, Provider<Features> provider3) {
        return new MyTargetAppInstallPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static MyTargetAppInstallPresenterImpl newInstance(Lazy<AdBannerEventListener> lazy, MyTargetImageBgProvider myTargetImageBgProvider, Features features) {
        return new MyTargetAppInstallPresenterImpl(lazy, myTargetImageBgProvider, features);
    }

    @Override // javax.inject.Provider
    public MyTargetAppInstallPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get());
    }
}
