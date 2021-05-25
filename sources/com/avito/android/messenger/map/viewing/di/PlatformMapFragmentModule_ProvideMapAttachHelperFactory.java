package com.avito.android.messenger.map.viewing.di;

import com.avito.android.Features;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PlatformMapFragmentModule_ProvideMapAttachHelperFactory implements Factory<AvitoMapAttachHelper> {
    public final Provider<Features> a;

    public PlatformMapFragmentModule_ProvideMapAttachHelperFactory(Provider<Features> provider) {
        this.a = provider;
    }

    public static PlatformMapFragmentModule_ProvideMapAttachHelperFactory create(Provider<Features> provider) {
        return new PlatformMapFragmentModule_ProvideMapAttachHelperFactory(provider);
    }

    public static AvitoMapAttachHelper provideMapAttachHelper(Features features) {
        return (AvitoMapAttachHelper) Preconditions.checkNotNullFromProvides(PlatformMapFragmentModule.provideMapAttachHelper(features));
    }

    @Override // javax.inject.Provider
    public AvitoMapAttachHelper get() {
        return provideMapAttachHelper(this.a.get());
    }
}
