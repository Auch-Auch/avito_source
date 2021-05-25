package com.avito.android.extended_profile.di;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExtendedProfileModule_ProvideIsTabletFactory implements Factory<Boolean> {
    public final Provider<Resources> a;

    public ExtendedProfileModule_ProvideIsTabletFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ExtendedProfileModule_ProvideIsTabletFactory create(Provider<Resources> provider) {
        return new ExtendedProfileModule_ProvideIsTabletFactory(provider);
    }

    public static boolean provideIsTablet(Resources resources) {
        return ExtendedProfileModule.INSTANCE.provideIsTablet(resources);
    }

    @Override // javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provideIsTablet(this.a.get()));
    }
}
