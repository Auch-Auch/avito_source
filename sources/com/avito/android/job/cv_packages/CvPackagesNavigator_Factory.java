package com.avito.android.job.cv_packages;

import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CvPackagesNavigator_Factory implements Factory<CvPackagesNavigator> {
    public final Provider<AppCompatActivity> a;
    public final Provider<DeepLinkIntentFactory> b;

    public CvPackagesNavigator_Factory(Provider<AppCompatActivity> provider, Provider<DeepLinkIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CvPackagesNavigator_Factory create(Provider<AppCompatActivity> provider, Provider<DeepLinkIntentFactory> provider2) {
        return new CvPackagesNavigator_Factory(provider, provider2);
    }

    public static CvPackagesNavigator newInstance(AppCompatActivity appCompatActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        return new CvPackagesNavigator(appCompatActivity, deepLinkIntentFactory);
    }

    @Override // javax.inject.Provider
    public CvPackagesNavigator get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
