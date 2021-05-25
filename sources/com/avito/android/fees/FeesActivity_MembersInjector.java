package com.avito.android.fees;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class FeesActivity_MembersInjector implements MembersInjector<FeesActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<FeesInteractor> b;
    public final Provider<FeesPresenter> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<Analytics> e;
    public final Provider<PublishAnalyticsDataProvider> f;
    public final Provider<Features> g;
    public final Provider<DialogRouter> h;
    public final Provider<AbTestsConfigProvider> i;
    public final Provider<AccountStateProvider> j;

    public FeesActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<FeesInteractor> provider2, Provider<FeesPresenter> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<Analytics> provider5, Provider<PublishAnalyticsDataProvider> provider6, Provider<Features> provider7, Provider<DialogRouter> provider8, Provider<AbTestsConfigProvider> provider9, Provider<AccountStateProvider> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static MembersInjector<FeesActivity> create(Provider<ActivityIntentFactory> provider, Provider<FeesInteractor> provider2, Provider<FeesPresenter> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<Analytics> provider5, Provider<PublishAnalyticsDataProvider> provider6, Provider<Features> provider7, Provider<DialogRouter> provider8, Provider<AbTestsConfigProvider> provider9, Provider<AccountStateProvider> provider10) {
        return new FeesActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @InjectedFieldSignature("com.avito.android.fees.FeesActivity.abTestConfigProvider")
    public static void injectAbTestConfigProvider(FeesActivity feesActivity, AbTestsConfigProvider abTestsConfigProvider) {
        feesActivity.abTestConfigProvider = abTestsConfigProvider;
    }

    @InjectedFieldSignature("com.avito.android.fees.FeesActivity.accountStateProvider")
    public static void injectAccountStateProvider(FeesActivity feesActivity, AccountStateProvider accountStateProvider) {
        feesActivity.accountStateProvider = accountStateProvider;
    }

    @InjectedFieldSignature("com.avito.android.fees.FeesActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(FeesActivity feesActivity, ActivityIntentFactory activityIntentFactory) {
        feesActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.fees.FeesActivity.analytics")
    public static void injectAnalytics(FeesActivity feesActivity, Analytics analytics) {
        feesActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.fees.FeesActivity.analyticsData")
    public static void injectAnalyticsData(FeesActivity feesActivity, PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        feesActivity.analyticsData = publishAnalyticsDataProvider;
    }

    @InjectedFieldSignature("com.avito.android.fees.FeesActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(FeesActivity feesActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        feesActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.fees.FeesActivity.dialogRouter")
    public static void injectDialogRouter(FeesActivity feesActivity, DialogRouter dialogRouter) {
        feesActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.fees.FeesActivity.features")
    public static void injectFeatures(FeesActivity feesActivity, Features features) {
        feesActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.fees.FeesActivity.feesInteractor")
    public static void injectFeesInteractor(FeesActivity feesActivity, FeesInteractor feesInteractor) {
        feesActivity.feesInteractor = feesInteractor;
    }

    @InjectedFieldSignature("com.avito.android.fees.FeesActivity.feesPresenter")
    public static void injectFeesPresenter(FeesActivity feesActivity, FeesPresenter feesPresenter) {
        feesActivity.feesPresenter = feesPresenter;
    }

    public void injectMembers(FeesActivity feesActivity) {
        injectActivityIntentFactory(feesActivity, this.a.get());
        injectFeesInteractor(feesActivity, this.b.get());
        injectFeesPresenter(feesActivity, this.c.get());
        injectDeepLinkIntentFactory(feesActivity, this.d.get());
        injectAnalytics(feesActivity, this.e.get());
        injectAnalyticsData(feesActivity, this.f.get());
        injectFeatures(feesActivity, this.g.get());
        injectDialogRouter(feesActivity, this.h.get());
        injectAbTestConfigProvider(feesActivity, this.i.get());
        injectAccountStateProvider(feesActivity, this.j.get());
    }
}
