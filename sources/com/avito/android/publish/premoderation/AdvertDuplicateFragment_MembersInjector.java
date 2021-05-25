package com.avito.android.publish.premoderation;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AdvertDuplicateFragment_MembersInjector implements MembersInjector<AdvertDuplicateFragment> {
    public final Provider<AdvertDuplicatePresenter> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<DeepLinkIntentFactory> c;

    public AdvertDuplicateFragment_MembersInjector(Provider<AdvertDuplicatePresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<AdvertDuplicateFragment> create(Provider<AdvertDuplicatePresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3) {
        return new AdvertDuplicateFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.publish.premoderation.AdvertDuplicateFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(AdvertDuplicateFragment advertDuplicateFragment, ActivityIntentFactory activityIntentFactory) {
        advertDuplicateFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.premoderation.AdvertDuplicateFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(AdvertDuplicateFragment advertDuplicateFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        advertDuplicateFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.premoderation.AdvertDuplicateFragment.presenter")
    public static void injectPresenter(AdvertDuplicateFragment advertDuplicateFragment, AdvertDuplicatePresenter advertDuplicatePresenter) {
        advertDuplicateFragment.presenter = advertDuplicatePresenter;
    }

    public void injectMembers(AdvertDuplicateFragment advertDuplicateFragment) {
        injectPresenter(advertDuplicateFragment, this.a.get());
        injectActivityIntentFactory(advertDuplicateFragment, this.b.get());
        injectDeepLinkIntentFactory(advertDuplicateFragment, this.c.get());
    }
}
