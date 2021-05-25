package com.avito.android.progress_overlay;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LoadingProgressOverlayImpl_Factory implements Factory<LoadingProgressOverlayImpl> {
    public final Provider<Analytics> a;
    public final Provider<ProgressDialogRouter> b;

    public LoadingProgressOverlayImpl_Factory(Provider<Analytics> provider, Provider<ProgressDialogRouter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LoadingProgressOverlayImpl_Factory create(Provider<Analytics> provider, Provider<ProgressDialogRouter> provider2) {
        return new LoadingProgressOverlayImpl_Factory(provider, provider2);
    }

    public static LoadingProgressOverlayImpl newInstance(Analytics analytics, ProgressDialogRouter progressDialogRouter) {
        return new LoadingProgressOverlayImpl(analytics, progressDialogRouter);
    }

    @Override // javax.inject.Provider
    public LoadingProgressOverlayImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
