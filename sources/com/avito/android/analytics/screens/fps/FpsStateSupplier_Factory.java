package com.avito.android.analytics.screens.fps;

import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FpsStateSupplier_Factory implements Factory<FpsStateSupplier> {
    public final Provider<FpsStateListener> a;
    public final Provider<BuildInfo> b;

    public FpsStateSupplier_Factory(Provider<FpsStateListener> provider, Provider<BuildInfo> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FpsStateSupplier_Factory create(Provider<FpsStateListener> provider, Provider<BuildInfo> provider2) {
        return new FpsStateSupplier_Factory(provider, provider2);
    }

    public static FpsStateSupplier newInstance(FpsStateListener fpsStateListener, BuildInfo buildInfo) {
        return new FpsStateSupplier(fpsStateListener, buildInfo);
    }

    @Override // javax.inject.Provider
    public FpsStateSupplier get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
