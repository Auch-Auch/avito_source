package com.avito.android.delivery.profile_settings;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DeliveryProfileSettingsActivity_MembersInjector implements MembersInjector<DeliveryProfileSettingsActivity> {
    public final Provider<DeliveryProfileSettingsViewModel> a;
    public final Provider<Analytics> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<AttributedTextFormatter> d;
    public final Provider<BaseScreenPerformanceTracker> e;

    public DeliveryProfileSettingsActivity_MembersInjector(Provider<DeliveryProfileSettingsViewModel> provider, Provider<Analytics> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<AttributedTextFormatter> provider4, Provider<BaseScreenPerformanceTracker> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<DeliveryProfileSettingsActivity> create(Provider<DeliveryProfileSettingsViewModel> provider, Provider<Analytics> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<AttributedTextFormatter> provider4, Provider<BaseScreenPerformanceTracker> provider5) {
        return new DeliveryProfileSettingsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.delivery.profile_settings.DeliveryProfileSettingsActivity.analytics")
    public static void injectAnalytics(DeliveryProfileSettingsActivity deliveryProfileSettingsActivity, Analytics analytics) {
        deliveryProfileSettingsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.delivery.profile_settings.DeliveryProfileSettingsActivity.attributedTextFormatter")
    public static void injectAttributedTextFormatter(DeliveryProfileSettingsActivity deliveryProfileSettingsActivity, AttributedTextFormatter attributedTextFormatter) {
        deliveryProfileSettingsActivity.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.profile_settings.DeliveryProfileSettingsActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(DeliveryProfileSettingsActivity deliveryProfileSettingsActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        deliveryProfileSettingsActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.delivery.profile_settings.DeliveryProfileSettingsActivity.tracker")
    public static void injectTracker(DeliveryProfileSettingsActivity deliveryProfileSettingsActivity, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        deliveryProfileSettingsActivity.tracker = baseScreenPerformanceTracker;
    }

    @InjectedFieldSignature("com.avito.android.delivery.profile_settings.DeliveryProfileSettingsActivity.viewModel")
    public static void injectViewModel(DeliveryProfileSettingsActivity deliveryProfileSettingsActivity, DeliveryProfileSettingsViewModel deliveryProfileSettingsViewModel) {
        deliveryProfileSettingsActivity.viewModel = deliveryProfileSettingsViewModel;
    }

    public void injectMembers(DeliveryProfileSettingsActivity deliveryProfileSettingsActivity) {
        injectViewModel(deliveryProfileSettingsActivity, this.a.get());
        injectAnalytics(deliveryProfileSettingsActivity, this.b.get());
        injectDeepLinkIntentFactory(deliveryProfileSettingsActivity, this.c.get());
        injectAttributedTextFormatter(deliveryProfileSettingsActivity, this.d.get());
        injectTracker(deliveryProfileSettingsActivity, this.e.get());
    }
}
