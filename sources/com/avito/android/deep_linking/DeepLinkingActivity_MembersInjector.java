package com.avito.android.deep_linking;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DeepLinkingActivity_MembersInjector implements MembersInjector<DeepLinkingActivity> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<DeepLinkContainerIntentFactory> b;
    public final Provider<DeepLinkingPresenter> c;

    public DeepLinkingActivity_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<DeepLinkContainerIntentFactory> provider2, Provider<DeepLinkingPresenter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<DeepLinkingActivity> create(Provider<DeepLinkIntentFactory> provider, Provider<DeepLinkContainerIntentFactory> provider2, Provider<DeepLinkingPresenter> provider3) {
        return new DeepLinkingActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.deep_linking.DeepLinkingActivity.deepLinkContainerIntentFactory")
    public static void injectDeepLinkContainerIntentFactory(DeepLinkingActivity deepLinkingActivity, DeepLinkContainerIntentFactory deepLinkContainerIntentFactory) {
        deepLinkingActivity.deepLinkContainerIntentFactory = deepLinkContainerIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.deep_linking.DeepLinkingActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(DeepLinkingActivity deepLinkingActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        deepLinkingActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.deep_linking.DeepLinkingActivity.presenter")
    public static void injectPresenter(DeepLinkingActivity deepLinkingActivity, DeepLinkingPresenter deepLinkingPresenter) {
        deepLinkingActivity.presenter = deepLinkingPresenter;
    }

    public void injectMembers(DeepLinkingActivity deepLinkingActivity) {
        injectDeepLinkIntentFactory(deepLinkingActivity, this.a.get());
        injectDeepLinkContainerIntentFactory(deepLinkingActivity, this.b.get());
        injectPresenter(deepLinkingActivity, this.c.get());
    }
}
