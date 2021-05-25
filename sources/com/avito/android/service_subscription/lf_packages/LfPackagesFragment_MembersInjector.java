package com.avito.android.service_subscription.lf_packages;

import com.avito.android.analytics.Analytics;
import com.avito.android.service_subscription.di.LfPresenter;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class LfPackagesFragment_MembersInjector implements MembersInjector<LfPackagesFragment> {
    public final Provider<ServiceSubscriptionPresenter> a;
    public final Provider<Analytics> b;

    public LfPackagesFragment_MembersInjector(Provider<ServiceSubscriptionPresenter> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<LfPackagesFragment> create(Provider<ServiceSubscriptionPresenter> provider, Provider<Analytics> provider2) {
        return new LfPackagesFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.service_subscription.lf_packages.LfPackagesFragment.analytics")
    public static void injectAnalytics(LfPackagesFragment lfPackagesFragment, Analytics analytics) {
        lfPackagesFragment.analytics = analytics;
    }

    @LfPresenter
    @InjectedFieldSignature("com.avito.android.service_subscription.lf_packages.LfPackagesFragment.presenter")
    public static void injectPresenter(LfPackagesFragment lfPackagesFragment, ServiceSubscriptionPresenter serviceSubscriptionPresenter) {
        lfPackagesFragment.presenter = serviceSubscriptionPresenter;
    }

    public void injectMembers(LfPackagesFragment lfPackagesFragment) {
        injectPresenter(lfPackagesFragment, this.a.get());
        injectAnalytics(lfPackagesFragment, this.b.get());
    }
}
