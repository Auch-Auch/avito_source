package com.avito.android.autoteka_details;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractor;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AutotekaDetailsFragment_MembersInjector implements MembersInjector<AutotekaDetailsFragment> {
    public final Provider<AutotekaDetailsPresenter> a;
    public final Provider<AutotekaDetailsInteractor> b;
    public final Provider<ImplicitIntentFactory> c;
    public final Provider<Analytics> d;
    public final Provider<Features> e;

    public AutotekaDetailsFragment_MembersInjector(Provider<AutotekaDetailsPresenter> provider, Provider<AutotekaDetailsInteractor> provider2, Provider<ImplicitIntentFactory> provider3, Provider<Analytics> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<AutotekaDetailsFragment> create(Provider<AutotekaDetailsPresenter> provider, Provider<AutotekaDetailsInteractor> provider2, Provider<ImplicitIntentFactory> provider3, Provider<Analytics> provider4, Provider<Features> provider5) {
        return new AutotekaDetailsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.autoteka_details.AutotekaDetailsFragment.analytics")
    public static void injectAnalytics(AutotekaDetailsFragment autotekaDetailsFragment, Analytics analytics) {
        autotekaDetailsFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.autoteka_details.AutotekaDetailsFragment.features")
    public static void injectFeatures(AutotekaDetailsFragment autotekaDetailsFragment, Features features) {
        autotekaDetailsFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.autoteka_details.AutotekaDetailsFragment.implicitIntent")
    public static void injectImplicitIntent(AutotekaDetailsFragment autotekaDetailsFragment, ImplicitIntentFactory implicitIntentFactory) {
        autotekaDetailsFragment.implicitIntent = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.autoteka_details.AutotekaDetailsFragment.interactor")
    public static void injectInteractor(AutotekaDetailsFragment autotekaDetailsFragment, AutotekaDetailsInteractor autotekaDetailsInteractor) {
        autotekaDetailsFragment.interactor = autotekaDetailsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.autoteka_details.AutotekaDetailsFragment.presenter")
    public static void injectPresenter(AutotekaDetailsFragment autotekaDetailsFragment, AutotekaDetailsPresenter autotekaDetailsPresenter) {
        autotekaDetailsFragment.presenter = autotekaDetailsPresenter;
    }

    public void injectMembers(AutotekaDetailsFragment autotekaDetailsFragment) {
        injectPresenter(autotekaDetailsFragment, this.a.get());
        injectInteractor(autotekaDetailsFragment, this.b.get());
        injectImplicitIntent(autotekaDetailsFragment, this.c.get());
        injectAnalytics(autotekaDetailsFragment, this.d.get());
        injectFeatures(autotekaDetailsFragment, this.e.get());
    }
}
