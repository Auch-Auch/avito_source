package com.avito.android.advert_core.safedeal;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyAdvertSafeDealResourceProvider_Factory implements Factory<MyAdvertSafeDealResourceProvider> {
    public final Provider<Resources> a;

    public MyAdvertSafeDealResourceProvider_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static MyAdvertSafeDealResourceProvider_Factory create(Provider<Resources> provider) {
        return new MyAdvertSafeDealResourceProvider_Factory(provider);
    }

    public static MyAdvertSafeDealResourceProvider newInstance(Resources resources) {
        return new MyAdvertSafeDealResourceProvider(resources);
    }

    @Override // javax.inject.Provider
    public MyAdvertSafeDealResourceProvider get() {
        return newInstance(this.a.get());
    }
}
