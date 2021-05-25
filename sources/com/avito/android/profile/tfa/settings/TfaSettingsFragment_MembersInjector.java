package com.avito.android.profile.tfa.settings;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class TfaSettingsFragment_MembersInjector implements MembersInjector<TfaSettingsFragment> {
    public final Provider<TfaSettingsPresenter> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<DeepLinkIntentFactory> c;

    public TfaSettingsFragment_MembersInjector(Provider<TfaSettingsPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<TfaSettingsFragment> create(Provider<TfaSettingsPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3) {
        return new TfaSettingsFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.profile.tfa.settings.TfaSettingsFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(TfaSettingsFragment tfaSettingsFragment, ActivityIntentFactory activityIntentFactory) {
        tfaSettingsFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.tfa.settings.TfaSettingsFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(TfaSettingsFragment tfaSettingsFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        tfaSettingsFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.tfa.settings.TfaSettingsFragment.presenter")
    public static void injectPresenter(TfaSettingsFragment tfaSettingsFragment, TfaSettingsPresenter tfaSettingsPresenter) {
        tfaSettingsFragment.presenter = tfaSettingsPresenter;
    }

    public void injectMembers(TfaSettingsFragment tfaSettingsFragment) {
        injectPresenter(tfaSettingsFragment, this.a.get());
        injectActivityIntentFactory(tfaSettingsFragment, this.b.get());
        injectDeepLinkIntentFactory(tfaSettingsFragment, this.c.get());
    }
}
