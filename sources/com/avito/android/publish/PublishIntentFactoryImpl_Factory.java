package com.avito.android.publish;

import android.app.Application;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublishIntentFactoryImpl_Factory implements Factory<PublishIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<CoreActivityIntentFactory> b;
    public final Provider<AbTestsConfigProvider> c;
    public final Provider<UserAdvertsTabTestGroup> d;

    public PublishIntentFactoryImpl_Factory(Provider<Application> provider, Provider<CoreActivityIntentFactory> provider2, Provider<AbTestsConfigProvider> provider3, Provider<UserAdvertsTabTestGroup> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PublishIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<CoreActivityIntentFactory> provider2, Provider<AbTestsConfigProvider> provider3, Provider<UserAdvertsTabTestGroup> provider4) {
        return new PublishIntentFactoryImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static PublishIntentFactoryImpl newInstance(Application application, CoreActivityIntentFactory coreActivityIntentFactory, AbTestsConfigProvider abTestsConfigProvider, UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        return new PublishIntentFactoryImpl(application, coreActivityIntentFactory, abTestsConfigProvider, userAdvertsTabTestGroup);
    }

    @Override // javax.inject.Provider
    public PublishIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
