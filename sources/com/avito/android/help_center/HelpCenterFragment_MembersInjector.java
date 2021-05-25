package com.avito.android.help_center;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class HelpCenterFragment_MembersInjector implements MembersInjector<HelpCenterFragment> {
    public final Provider<HelpCenterPresenter> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<DeepLinkFactory> d;
    public final Provider<Analytics> e;

    public HelpCenterFragment_MembersInjector(Provider<HelpCenterPresenter> provider, Provider<ImplicitIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<DeepLinkFactory> provider4, Provider<Analytics> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<HelpCenterFragment> create(Provider<HelpCenterPresenter> provider, Provider<ImplicitIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<DeepLinkFactory> provider4, Provider<Analytics> provider5) {
        return new HelpCenterFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.help_center.HelpCenterFragment.analytics")
    public static void injectAnalytics(HelpCenterFragment helpCenterFragment, Analytics analytics) {
        helpCenterFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.help_center.HelpCenterFragment.deeplinkFactory")
    public static void injectDeeplinkFactory(HelpCenterFragment helpCenterFragment, DeepLinkFactory deepLinkFactory) {
        helpCenterFragment.deeplinkFactory = deepLinkFactory;
    }

    @InjectedFieldSignature("com.avito.android.help_center.HelpCenterFragment.deeplinkIntentFactory")
    public static void injectDeeplinkIntentFactory(HelpCenterFragment helpCenterFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        helpCenterFragment.deeplinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.help_center.HelpCenterFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(HelpCenterFragment helpCenterFragment, ImplicitIntentFactory implicitIntentFactory) {
        helpCenterFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.help_center.HelpCenterFragment.presenter")
    public static void injectPresenter(HelpCenterFragment helpCenterFragment, HelpCenterPresenter helpCenterPresenter) {
        helpCenterFragment.presenter = helpCenterPresenter;
    }

    public void injectMembers(HelpCenterFragment helpCenterFragment) {
        injectPresenter(helpCenterFragment, this.a.get());
        injectImplicitIntentFactory(helpCenterFragment, this.b.get());
        injectDeeplinkIntentFactory(helpCenterFragment, this.c.get());
        injectDeeplinkFactory(helpCenterFragment, this.d.get());
        injectAnalytics(helpCenterFragment, this.e.get());
    }
}
