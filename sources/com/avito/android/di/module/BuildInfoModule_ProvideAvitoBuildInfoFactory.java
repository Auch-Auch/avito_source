package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.util.AvitoBuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BuildInfoModule_ProvideAvitoBuildInfoFactory implements Factory<AvitoBuildInfo> {
    public final BuildInfoModule a;
    public final Provider<Application> b;

    public BuildInfoModule_ProvideAvitoBuildInfoFactory(BuildInfoModule buildInfoModule, Provider<Application> provider) {
        this.a = buildInfoModule;
        this.b = provider;
    }

    public static BuildInfoModule_ProvideAvitoBuildInfoFactory create(BuildInfoModule buildInfoModule, Provider<Application> provider) {
        return new BuildInfoModule_ProvideAvitoBuildInfoFactory(buildInfoModule, provider);
    }

    public static AvitoBuildInfo provideAvitoBuildInfo(BuildInfoModule buildInfoModule, Application application) {
        return (AvitoBuildInfo) Preconditions.checkNotNullFromProvides(buildInfoModule.provideAvitoBuildInfo(application));
    }

    @Override // javax.inject.Provider
    public AvitoBuildInfo get() {
        return provideAvitoBuildInfo(this.a, this.b.get());
    }
}
