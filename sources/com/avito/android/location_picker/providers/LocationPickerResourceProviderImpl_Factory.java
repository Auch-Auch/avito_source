package com.avito.android.location_picker.providers;

import android.content.res.Resources;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class LocationPickerResourceProviderImpl_Factory implements Factory<LocationPickerResourceProviderImpl> {
    public final Provider<Resources> a;
    public final Provider<Locale> b;

    public LocationPickerResourceProviderImpl_Factory(Provider<Resources> provider, Provider<Locale> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LocationPickerResourceProviderImpl_Factory create(Provider<Resources> provider, Provider<Locale> provider2) {
        return new LocationPickerResourceProviderImpl_Factory(provider, provider2);
    }

    public static LocationPickerResourceProviderImpl newInstance(Resources resources, Locale locale) {
        return new LocationPickerResourceProviderImpl(resources, locale);
    }

    @Override // javax.inject.Provider
    public LocationPickerResourceProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
