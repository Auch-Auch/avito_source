package com.avito.android.service_subscription.subscription_new;

import com.avito.android.analytics.Analytics;
import com.avito.android.service_subscription.di.SubscriptionPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ServiceSubscriptionFragment_MembersInjector implements MembersInjector<ServiceSubscriptionFragment> {
    public final Provider<ServiceSubscriptionPresenter> a;
    public final Provider<Analytics> b;

    public ServiceSubscriptionFragment_MembersInjector(Provider<ServiceSubscriptionPresenter> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<ServiceSubscriptionFragment> create(Provider<ServiceSubscriptionPresenter> provider, Provider<Analytics> provider2) {
        return new ServiceSubscriptionFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.service_subscription.subscription_new.ServiceSubscriptionFragment.analytics")
    public static void injectAnalytics(ServiceSubscriptionFragment serviceSubscriptionFragment, Analytics analytics) {
        serviceSubscriptionFragment.analytics = analytics;
    }

    @SubscriptionPresenter
    @InjectedFieldSignature("com.avito.android.service_subscription.subscription_new.ServiceSubscriptionFragment.presenter")
    public static void injectPresenter(ServiceSubscriptionFragment serviceSubscriptionFragment, ServiceSubscriptionPresenter serviceSubscriptionPresenter) {
        serviceSubscriptionFragment.presenter = serviceSubscriptionPresenter;
    }

    public void injectMembers(ServiceSubscriptionFragment serviceSubscriptionFragment) {
        injectPresenter(serviceSubscriptionFragment, this.a.get());
        injectAnalytics(serviceSubscriptionFragment, this.b.get());
    }
}
