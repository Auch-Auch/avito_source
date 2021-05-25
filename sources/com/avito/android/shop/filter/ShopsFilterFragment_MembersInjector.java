package com.avito.android.shop.filter;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.DeviceMetrics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ShopsFilterFragment_MembersInjector implements MembersInjector<ShopsFilterFragment> {
    public final Provider<ShopsFilterPresenter> a;
    public final Provider<Analytics> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<DeviceMetrics> d;

    public ShopsFilterFragment_MembersInjector(Provider<ShopsFilterPresenter> provider, Provider<Analytics> provider2, Provider<ActivityIntentFactory> provider3, Provider<DeviceMetrics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<ShopsFilterFragment> create(Provider<ShopsFilterPresenter> provider, Provider<Analytics> provider2, Provider<ActivityIntentFactory> provider3, Provider<DeviceMetrics> provider4) {
        return new ShopsFilterFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.shop.filter.ShopsFilterFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ShopsFilterFragment shopsFilterFragment, ActivityIntentFactory activityIntentFactory) {
        shopsFilterFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.shop.filter.ShopsFilterFragment.analytics")
    public static void injectAnalytics(ShopsFilterFragment shopsFilterFragment, Analytics analytics) {
        shopsFilterFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.shop.filter.ShopsFilterFragment.deviceMetrics")
    public static void injectDeviceMetrics(ShopsFilterFragment shopsFilterFragment, DeviceMetrics deviceMetrics) {
        shopsFilterFragment.deviceMetrics = deviceMetrics;
    }

    @InjectedFieldSignature("com.avito.android.shop.filter.ShopsFilterFragment.presenter")
    public static void injectPresenter(ShopsFilterFragment shopsFilterFragment, ShopsFilterPresenter shopsFilterPresenter) {
        shopsFilterFragment.presenter = shopsFilterPresenter;
    }

    public void injectMembers(ShopsFilterFragment shopsFilterFragment) {
        injectPresenter(shopsFilterFragment, this.a.get());
        injectAnalytics(shopsFilterFragment, this.b.get());
        injectActivityIntentFactory(shopsFilterFragment, this.c.get());
        injectDeviceMetrics(shopsFilterFragment, this.d.get());
    }
}
