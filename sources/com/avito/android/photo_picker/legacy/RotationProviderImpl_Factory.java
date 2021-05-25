package com.avito.android.photo_picker.legacy;

import android.view.Display;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RotationProviderImpl_Factory implements Factory<RotationProviderImpl> {
    public final Provider<Display> a;

    public RotationProviderImpl_Factory(Provider<Display> provider) {
        this.a = provider;
    }

    public static RotationProviderImpl_Factory create(Provider<Display> provider) {
        return new RotationProviderImpl_Factory(provider);
    }

    public static RotationProviderImpl newInstance(Display display) {
        return new RotationProviderImpl(display);
    }

    @Override // javax.inject.Provider
    public RotationProviderImpl get() {
        return newInstance(this.a.get());
    }
}
