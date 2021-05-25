package com.avito.android.serp.adapter.warning;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpWarningItemPresenterImpl_Factory implements Factory<SerpWarningItemPresenterImpl> {
    public final Provider<SerpWarningItemListener> a;

    public SerpWarningItemPresenterImpl_Factory(Provider<SerpWarningItemListener> provider) {
        this.a = provider;
    }

    public static SerpWarningItemPresenterImpl_Factory create(Provider<SerpWarningItemListener> provider) {
        return new SerpWarningItemPresenterImpl_Factory(provider);
    }

    public static SerpWarningItemPresenterImpl newInstance(Lazy<SerpWarningItemListener> lazy) {
        return new SerpWarningItemPresenterImpl(lazy);
    }

    @Override // javax.inject.Provider
    public SerpWarningItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
