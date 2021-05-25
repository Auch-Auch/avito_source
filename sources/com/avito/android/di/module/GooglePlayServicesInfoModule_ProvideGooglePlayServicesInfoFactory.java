package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.util.GooglePlayServicesInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GooglePlayServicesInfoModule_ProvideGooglePlayServicesInfoFactory implements Factory<GooglePlayServicesInfo> {
    public final Provider<Application> a;

    public GooglePlayServicesInfoModule_ProvideGooglePlayServicesInfoFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static GooglePlayServicesInfoModule_ProvideGooglePlayServicesInfoFactory create(Provider<Application> provider) {
        return new GooglePlayServicesInfoModule_ProvideGooglePlayServicesInfoFactory(provider);
    }

    public static GooglePlayServicesInfo provideGooglePlayServicesInfo(Application application) {
        return (GooglePlayServicesInfo) Preconditions.checkNotNullFromProvides(GooglePlayServicesInfoModule.provideGooglePlayServicesInfo(application));
    }

    @Override // javax.inject.Provider
    public GooglePlayServicesInfo get() {
        return provideGooglePlayServicesInfo(this.a.get());
    }
}
