package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.OrientationTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
import org.jetbrains.annotations.Nullable;
public final class AvitoApplicationModule_ProvideOrientationTrackerFactory implements Factory<OrientationTracker> {
    public final AvitoApplicationModule a;
    public final Provider<Features> b;
    public final Provider<Analytics> c;
    public final Provider<Application> d;

    public AvitoApplicationModule_ProvideOrientationTrackerFactory(AvitoApplicationModule avitoApplicationModule, Provider<Features> provider, Provider<Analytics> provider2, Provider<Application> provider3) {
        this.a = avitoApplicationModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static AvitoApplicationModule_ProvideOrientationTrackerFactory create(AvitoApplicationModule avitoApplicationModule, Provider<Features> provider, Provider<Analytics> provider2, Provider<Application> provider3) {
        return new AvitoApplicationModule_ProvideOrientationTrackerFactory(avitoApplicationModule, provider, provider2, provider3);
    }

    @Nullable
    public static OrientationTracker provideOrientationTracker(AvitoApplicationModule avitoApplicationModule, Features features, Analytics analytics, Application application) {
        return avitoApplicationModule.provideOrientationTracker(features, analytics, application);
    }

    @Override // javax.inject.Provider
    @Nullable
    public OrientationTracker get() {
        return provideOrientationTracker(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
