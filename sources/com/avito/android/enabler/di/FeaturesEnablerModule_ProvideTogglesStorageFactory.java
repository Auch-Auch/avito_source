package com.avito.android.enabler.di;

import android.content.Context;
import com.avito.android.enabler.TogglesStorage;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FeaturesEnablerModule_ProvideTogglesStorageFactory implements Factory<TogglesStorage> {
    private final Provider<BuildInfo> buildInfoProvider;
    private final Provider<Context> contextProvider;

    public FeaturesEnablerModule_ProvideTogglesStorageFactory(Provider<Context> provider, Provider<BuildInfo> provider2) {
        this.contextProvider = provider;
        this.buildInfoProvider = provider2;
    }

    public static FeaturesEnablerModule_ProvideTogglesStorageFactory create(Provider<Context> provider, Provider<BuildInfo> provider2) {
        return new FeaturesEnablerModule_ProvideTogglesStorageFactory(provider, provider2);
    }

    public static TogglesStorage provideTogglesStorage(Context context, BuildInfo buildInfo) {
        return (TogglesStorage) Preconditions.checkNotNullFromProvides(FeaturesEnablerModule.provideTogglesStorage(context, buildInfo));
    }

    @Override // javax.inject.Provider
    public TogglesStorage get() {
        return provideTogglesStorage(this.contextProvider.get(), this.buildInfoProvider.get());
    }
}
