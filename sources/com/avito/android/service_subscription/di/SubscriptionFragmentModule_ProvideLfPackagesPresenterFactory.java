package com.avito.android.service_subscription.di;

import com.avito.android.service_subscription.ServiceSubscriptionInteractor;
import com.avito.android.service_subscription.subscription_new.ColorParser;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SubscriptionFragmentModule_ProvideLfPackagesPresenterFactory implements Factory<ServiceSubscriptionPresenter> {
    public final Provider<ServiceSubscriptionInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<ColorParser> c;
    public final Provider<Kundle> d;

    public SubscriptionFragmentModule_ProvideLfPackagesPresenterFactory(Provider<ServiceSubscriptionInteractor> provider, Provider<SchedulersFactory> provider2, Provider<ColorParser> provider3, Provider<Kundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SubscriptionFragmentModule_ProvideLfPackagesPresenterFactory create(Provider<ServiceSubscriptionInteractor> provider, Provider<SchedulersFactory> provider2, Provider<ColorParser> provider3, Provider<Kundle> provider4) {
        return new SubscriptionFragmentModule_ProvideLfPackagesPresenterFactory(provider, provider2, provider3, provider4);
    }

    public static ServiceSubscriptionPresenter provideLfPackagesPresenter(ServiceSubscriptionInteractor serviceSubscriptionInteractor, SchedulersFactory schedulersFactory, ColorParser colorParser, Kundle kundle) {
        return (ServiceSubscriptionPresenter) Preconditions.checkNotNullFromProvides(SubscriptionFragmentModule.provideLfPackagesPresenter(serviceSubscriptionInteractor, schedulersFactory, colorParser, kundle));
    }

    @Override // javax.inject.Provider
    public ServiceSubscriptionPresenter get() {
        return provideLfPackagesPresenter(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
