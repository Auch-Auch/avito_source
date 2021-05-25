package com.avito.android.user_advert.advert.autobooking_block;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoBookingBlockResourceProvider_Factory implements Factory<AutoBookingBlockResourceProvider> {
    public final Provider<Resources> a;

    public AutoBookingBlockResourceProvider_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static AutoBookingBlockResourceProvider_Factory create(Provider<Resources> provider) {
        return new AutoBookingBlockResourceProvider_Factory(provider);
    }

    public static AutoBookingBlockResourceProvider newInstance(Resources resources) {
        return new AutoBookingBlockResourceProvider(resources);
    }

    @Override // javax.inject.Provider
    public AutoBookingBlockResourceProvider get() {
        return newInstance(this.a.get());
    }
}
