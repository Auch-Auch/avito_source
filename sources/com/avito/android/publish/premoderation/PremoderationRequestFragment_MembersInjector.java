package com.avito.android.publish.premoderation;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PremoderationRequestFragment_MembersInjector implements MembersInjector<PremoderationRequestFragment> {
    public final Provider<PremoderationRequestViewModelFactory> a;
    public final Provider<LoadingProgressOverlay> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<ActivityIntentFactory> d;

    public PremoderationRequestFragment_MembersInjector(Provider<PremoderationRequestViewModelFactory> provider, Provider<LoadingProgressOverlay> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<ActivityIntentFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<PremoderationRequestFragment> create(Provider<PremoderationRequestViewModelFactory> provider, Provider<LoadingProgressOverlay> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<ActivityIntentFactory> provider4) {
        return new PremoderationRequestFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.publish.premoderation.PremoderationRequestFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(PremoderationRequestFragment premoderationRequestFragment, ActivityIntentFactory activityIntentFactory) {
        premoderationRequestFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.premoderation.PremoderationRequestFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PremoderationRequestFragment premoderationRequestFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        premoderationRequestFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.premoderation.PremoderationRequestFragment.loadingProgress")
    public static void injectLoadingProgress(PremoderationRequestFragment premoderationRequestFragment, LoadingProgressOverlay loadingProgressOverlay) {
        premoderationRequestFragment.loadingProgress = loadingProgressOverlay;
    }

    @InjectedFieldSignature("com.avito.android.publish.premoderation.PremoderationRequestFragment.viewModelFactory")
    public static void injectViewModelFactory(PremoderationRequestFragment premoderationRequestFragment, PremoderationRequestViewModelFactory premoderationRequestViewModelFactory) {
        premoderationRequestFragment.viewModelFactory = premoderationRequestViewModelFactory;
    }

    public void injectMembers(PremoderationRequestFragment premoderationRequestFragment) {
        injectViewModelFactory(premoderationRequestFragment, this.a.get());
        injectLoadingProgress(premoderationRequestFragment, this.b.get());
        injectDeepLinkIntentFactory(premoderationRequestFragment, this.c.get());
        injectActivityIntentFactory(premoderationRequestFragment, this.d.get());
    }
}
