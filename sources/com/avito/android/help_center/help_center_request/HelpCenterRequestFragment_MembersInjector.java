package com.avito.android.help_center.help_center_request;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class HelpCenterRequestFragment_MembersInjector implements MembersInjector<HelpCenterRequestFragment> {
    public final Provider<HelpCenterRequestPresenter> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<Analytics> c;

    public HelpCenterRequestFragment_MembersInjector(Provider<HelpCenterRequestPresenter> provider, Provider<ImplicitIntentFactory> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<HelpCenterRequestFragment> create(Provider<HelpCenterRequestPresenter> provider, Provider<ImplicitIntentFactory> provider2, Provider<Analytics> provider3) {
        return new HelpCenterRequestFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.help_center.help_center_request.HelpCenterRequestFragment.analytics")
    public static void injectAnalytics(HelpCenterRequestFragment helpCenterRequestFragment, Analytics analytics) {
        helpCenterRequestFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.help_center.help_center_request.HelpCenterRequestFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(HelpCenterRequestFragment helpCenterRequestFragment, ImplicitIntentFactory implicitIntentFactory) {
        helpCenterRequestFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.help_center.help_center_request.HelpCenterRequestFragment.presenter")
    public static void injectPresenter(HelpCenterRequestFragment helpCenterRequestFragment, HelpCenterRequestPresenter helpCenterRequestPresenter) {
        helpCenterRequestFragment.presenter = helpCenterRequestPresenter;
    }

    public void injectMembers(HelpCenterRequestFragment helpCenterRequestFragment) {
        injectPresenter(helpCenterRequestFragment, this.a.get());
        injectImplicitIntentFactory(helpCenterRequestFragment, this.b.get());
        injectAnalytics(helpCenterRequestFragment, this.c.get());
    }
}
