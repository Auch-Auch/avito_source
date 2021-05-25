package com.avito.android.di.module;

import android.app.Application;
import android.view.Display;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreApplicationModule_ProvideDisplayFactory implements Factory<Display> {
    public final CoreApplicationModule a;
    public final Provider<Application> b;

    public CoreApplicationModule_ProvideDisplayFactory(CoreApplicationModule coreApplicationModule, Provider<Application> provider) {
        this.a = coreApplicationModule;
        this.b = provider;
    }

    public static CoreApplicationModule_ProvideDisplayFactory create(CoreApplicationModule coreApplicationModule, Provider<Application> provider) {
        return new CoreApplicationModule_ProvideDisplayFactory(coreApplicationModule, provider);
    }

    public static Display provideDisplay(CoreApplicationModule coreApplicationModule, Application application) {
        return (Display) Preconditions.checkNotNullFromProvides(coreApplicationModule.provideDisplay(application));
    }

    @Override // javax.inject.Provider
    public Display get() {
        return provideDisplay(this.a, this.b.get());
    }
}
