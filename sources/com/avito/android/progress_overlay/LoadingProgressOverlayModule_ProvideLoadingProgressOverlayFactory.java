package com.avito.android.progress_overlay;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LoadingProgressOverlayModule_ProvideLoadingProgressOverlayFactory implements Factory<LoadingProgressOverlay> {
    public final LoadingProgressOverlayModule a;
    public final Provider<ProgressDialogRouter> b;
    public final Provider<Analytics> c;

    public LoadingProgressOverlayModule_ProvideLoadingProgressOverlayFactory(LoadingProgressOverlayModule loadingProgressOverlayModule, Provider<ProgressDialogRouter> provider, Provider<Analytics> provider2) {
        this.a = loadingProgressOverlayModule;
        this.b = provider;
        this.c = provider2;
    }

    public static LoadingProgressOverlayModule_ProvideLoadingProgressOverlayFactory create(LoadingProgressOverlayModule loadingProgressOverlayModule, Provider<ProgressDialogRouter> provider, Provider<Analytics> provider2) {
        return new LoadingProgressOverlayModule_ProvideLoadingProgressOverlayFactory(loadingProgressOverlayModule, provider, provider2);
    }

    public static LoadingProgressOverlay provideLoadingProgressOverlay(LoadingProgressOverlayModule loadingProgressOverlayModule, ProgressDialogRouter progressDialogRouter, Analytics analytics) {
        return (LoadingProgressOverlay) Preconditions.checkNotNullFromProvides(loadingProgressOverlayModule.provideLoadingProgressOverlay(progressDialogRouter, analytics));
    }

    @Override // javax.inject.Provider
    public LoadingProgressOverlay get() {
        return provideLoadingProgressOverlay(this.a, this.b.get(), this.c.get());
    }
}
