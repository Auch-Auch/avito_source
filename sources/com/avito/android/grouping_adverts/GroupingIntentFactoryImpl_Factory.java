package com.avito.android.grouping_adverts;

import android.app.Application;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.navigation.NavigationTabProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GroupingIntentFactoryImpl_Factory implements Factory<GroupingIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<CoreActivityIntentFactory> b;
    public final Provider<NavigationTabProvider> c;
    public final Provider<Features> d;

    public GroupingIntentFactoryImpl_Factory(Provider<Application> provider, Provider<CoreActivityIntentFactory> provider2, Provider<NavigationTabProvider> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static GroupingIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<CoreActivityIntentFactory> provider2, Provider<NavigationTabProvider> provider3, Provider<Features> provider4) {
        return new GroupingIntentFactoryImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static GroupingIntentFactoryImpl newInstance(Application application, CoreActivityIntentFactory coreActivityIntentFactory, NavigationTabProvider navigationTabProvider, Features features) {
        return new GroupingIntentFactoryImpl(application, coreActivityIntentFactory, navigationTabProvider, features);
    }

    @Override // javax.inject.Provider
    public GroupingIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
