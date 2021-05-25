package com.avito.android.publish.input_vin;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InputVinResourceProvider_Factory implements Factory<InputVinResourceProvider> {
    public final Provider<Resources> a;

    public InputVinResourceProvider_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static InputVinResourceProvider_Factory create(Provider<Resources> provider) {
        return new InputVinResourceProvider_Factory(provider);
    }

    public static InputVinResourceProvider newInstance(Resources resources) {
        return new InputVinResourceProvider(resources);
    }

    @Override // javax.inject.Provider
    public InputVinResourceProvider get() {
        return newInstance(this.a.get());
    }
}
