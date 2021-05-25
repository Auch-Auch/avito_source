package com.avito.android.location_picker.di;

import com.avito.android.Features;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationPickerModule_ProvideMapAttachHelperFactory implements Factory<AvitoMapAttachHelper> {
    public final Provider<Features> a;

    public LocationPickerModule_ProvideMapAttachHelperFactory(Provider<Features> provider) {
        this.a = provider;
    }

    public static LocationPickerModule_ProvideMapAttachHelperFactory create(Provider<Features> provider) {
        return new LocationPickerModule_ProvideMapAttachHelperFactory(provider);
    }

    public static AvitoMapAttachHelper provideMapAttachHelper(Features features) {
        return (AvitoMapAttachHelper) Preconditions.checkNotNullFromProvides(LocationPickerModule.INSTANCE.provideMapAttachHelper(features));
    }

    @Override // javax.inject.Provider
    public AvitoMapAttachHelper get() {
        return provideMapAttachHelper(this.a.get());
    }
}
