package com.avito.android.short_term_rent.hotels;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class HotelsActivity_MembersInjector implements MembersInjector<HotelsActivity> {
    public final Provider<HotelsViewModelFactory> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<Analytics> d;

    public HotelsActivity_MembersInjector(Provider<HotelsViewModelFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<HotelsActivity> create(Provider<HotelsViewModelFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<Analytics> provider4) {
        return new HotelsActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.hotels.HotelsActivity.analytics")
    public static void injectAnalytics(HotelsActivity hotelsActivity, Analytics analytics) {
        hotelsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.hotels.HotelsActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(HotelsActivity hotelsActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        hotelsActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.hotels.HotelsActivity.intentFactory")
    public static void injectIntentFactory(HotelsActivity hotelsActivity, ActivityIntentFactory activityIntentFactory) {
        hotelsActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.hotels.HotelsActivity.viewModelFactory")
    public static void injectViewModelFactory(HotelsActivity hotelsActivity, HotelsViewModelFactory hotelsViewModelFactory) {
        hotelsActivity.viewModelFactory = hotelsViewModelFactory;
    }

    public void injectMembers(HotelsActivity hotelsActivity) {
        injectViewModelFactory(hotelsActivity, this.a.get());
        injectIntentFactory(hotelsActivity, this.b.get());
        injectDeepLinkIntentFactory(hotelsActivity, this.c.get());
        injectAnalytics(hotelsActivity, this.d.get());
    }
}
