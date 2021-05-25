package com.avito.android.analytics.di;

import android.app.Application;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage;
import com.avito.android.util.preferences.PreferenceFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BivrostStatisticsModule_ProvideBivrostStorageFactory implements Factory<BivrostTutorialSessionStorage> {
    public final Provider<Application> a;
    public final Provider<PreferenceFactory> b;

    public BivrostStatisticsModule_ProvideBivrostStorageFactory(Provider<Application> provider, Provider<PreferenceFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BivrostStatisticsModule_ProvideBivrostStorageFactory create(Provider<Application> provider, Provider<PreferenceFactory> provider2) {
        return new BivrostStatisticsModule_ProvideBivrostStorageFactory(provider, provider2);
    }

    public static BivrostTutorialSessionStorage provideBivrostStorage(Application application, PreferenceFactory preferenceFactory) {
        return (BivrostTutorialSessionStorage) Preconditions.checkNotNullFromProvides(BivrostStatisticsModule.provideBivrostStorage(application, preferenceFactory));
    }

    @Override // javax.inject.Provider
    public BivrostTutorialSessionStorage get() {
        return provideBivrostStorage(this.a.get(), this.b.get());
    }
}
