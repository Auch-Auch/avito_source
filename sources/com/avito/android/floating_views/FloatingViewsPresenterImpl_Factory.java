package com.avito.android.floating_views;

import android.os.Bundle;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FloatingViewsPresenterImpl_Factory implements Factory<FloatingViewsPresenterImpl> {
    public final Provider<Bundle> a;

    public FloatingViewsPresenterImpl_Factory(Provider<Bundle> provider) {
        this.a = provider;
    }

    public static FloatingViewsPresenterImpl_Factory create(Provider<Bundle> provider) {
        return new FloatingViewsPresenterImpl_Factory(provider);
    }

    public static FloatingViewsPresenterImpl newInstance(Bundle bundle) {
        return new FloatingViewsPresenterImpl(bundle);
    }

    @Override // javax.inject.Provider
    public FloatingViewsPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
