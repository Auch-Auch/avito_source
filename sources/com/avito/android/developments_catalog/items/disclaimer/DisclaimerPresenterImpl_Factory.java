package com.avito.android.developments_catalog.items.disclaimer;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DisclaimerPresenterImpl_Factory implements Factory<DisclaimerPresenterImpl> {
    public final Provider<DisclaimerDetailsClickListener> a;

    public DisclaimerPresenterImpl_Factory(Provider<DisclaimerDetailsClickListener> provider) {
        this.a = provider;
    }

    public static DisclaimerPresenterImpl_Factory create(Provider<DisclaimerDetailsClickListener> provider) {
        return new DisclaimerPresenterImpl_Factory(provider);
    }

    public static DisclaimerPresenterImpl newInstance(DisclaimerDetailsClickListener disclaimerDetailsClickListener) {
        return new DisclaimerPresenterImpl(disclaimerDetailsClickListener);
    }

    @Override // javax.inject.Provider
    public DisclaimerPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
