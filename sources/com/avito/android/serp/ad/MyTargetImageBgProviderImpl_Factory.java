package com.avito.android.serp.ad;

import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyTargetImageBgProviderImpl_Factory implements Factory<MyTargetImageBgProviderImpl> {
    public final Provider<SchedulersFactory3> a;

    public MyTargetImageBgProviderImpl_Factory(Provider<SchedulersFactory3> provider) {
        this.a = provider;
    }

    public static MyTargetImageBgProviderImpl_Factory create(Provider<SchedulersFactory3> provider) {
        return new MyTargetImageBgProviderImpl_Factory(provider);
    }

    public static MyTargetImageBgProviderImpl newInstance(SchedulersFactory3 schedulersFactory3) {
        return new MyTargetImageBgProviderImpl(schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public MyTargetImageBgProviderImpl get() {
        return newInstance(this.a.get());
    }
}
