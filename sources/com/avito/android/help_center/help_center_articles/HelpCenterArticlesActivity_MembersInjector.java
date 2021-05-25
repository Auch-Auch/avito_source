package com.avito.android.help_center.help_center_articles;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class HelpCenterArticlesActivity_MembersInjector implements MembersInjector<HelpCenterArticlesActivity> {
    public final Provider<HelpCenterArticlesPresenter> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<Analytics> c;

    public HelpCenterArticlesActivity_MembersInjector(Provider<HelpCenterArticlesPresenter> provider, Provider<ImplicitIntentFactory> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<HelpCenterArticlesActivity> create(Provider<HelpCenterArticlesPresenter> provider, Provider<ImplicitIntentFactory> provider2, Provider<Analytics> provider3) {
        return new HelpCenterArticlesActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.help_center.help_center_articles.HelpCenterArticlesActivity.analytics")
    public static void injectAnalytics(HelpCenterArticlesActivity helpCenterArticlesActivity, Analytics analytics) {
        helpCenterArticlesActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.help_center.help_center_articles.HelpCenterArticlesActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(HelpCenterArticlesActivity helpCenterArticlesActivity, ImplicitIntentFactory implicitIntentFactory) {
        helpCenterArticlesActivity.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.help_center.help_center_articles.HelpCenterArticlesActivity.presenter")
    public static void injectPresenter(HelpCenterArticlesActivity helpCenterArticlesActivity, HelpCenterArticlesPresenter helpCenterArticlesPresenter) {
        helpCenterArticlesActivity.presenter = helpCenterArticlesPresenter;
    }

    public void injectMembers(HelpCenterArticlesActivity helpCenterArticlesActivity) {
        injectPresenter(helpCenterArticlesActivity, this.a.get());
        injectImplicitIntentFactory(helpCenterArticlesActivity, this.b.get());
        injectAnalytics(helpCenterArticlesActivity, this.c.get());
    }
}
