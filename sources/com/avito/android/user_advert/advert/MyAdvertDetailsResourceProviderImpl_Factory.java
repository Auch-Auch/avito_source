package com.avito.android.user_advert.advert;

import android.content.res.Resources;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyAdvertDetailsResourceProviderImpl_Factory implements Factory<MyAdvertDetailsResourceProviderImpl> {
    public final Provider<Resources> a;
    public final Provider<SupportEmailResourceProvider> b;

    public MyAdvertDetailsResourceProviderImpl_Factory(Provider<Resources> provider, Provider<SupportEmailResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MyAdvertDetailsResourceProviderImpl_Factory create(Provider<Resources> provider, Provider<SupportEmailResourceProvider> provider2) {
        return new MyAdvertDetailsResourceProviderImpl_Factory(provider, provider2);
    }

    public static MyAdvertDetailsResourceProviderImpl newInstance(Resources resources, SupportEmailResourceProvider supportEmailResourceProvider) {
        return new MyAdvertDetailsResourceProviderImpl(resources, supportEmailResourceProvider);
    }

    @Override // javax.inject.Provider
    public MyAdvertDetailsResourceProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
