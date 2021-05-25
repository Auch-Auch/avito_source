package com.avito.android.analytics;

import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ClickStreamDeepLinkActivity_MembersInjector implements MembersInjector<ClickStreamDeepLinkActivity> {
    public final Provider<ClickStreamLinkHandler> a;
    public final Provider<DeepLinkIntentFactory> b;

    public ClickStreamDeepLinkActivity_MembersInjector(Provider<ClickStreamLinkHandler> provider, Provider<DeepLinkIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<ClickStreamDeepLinkActivity> create(Provider<ClickStreamLinkHandler> provider, Provider<DeepLinkIntentFactory> provider2) {
        return new ClickStreamDeepLinkActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.analytics.ClickStreamDeepLinkActivity.clickStreamLinkHandler")
    public static void injectClickStreamLinkHandler(ClickStreamDeepLinkActivity clickStreamDeepLinkActivity, ClickStreamLinkHandler clickStreamLinkHandler) {
        clickStreamDeepLinkActivity.clickStreamLinkHandler = clickStreamLinkHandler;
    }

    @InjectedFieldSignature("com.avito.android.analytics.ClickStreamDeepLinkActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ClickStreamDeepLinkActivity clickStreamDeepLinkActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        clickStreamDeepLinkActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    public void injectMembers(ClickStreamDeepLinkActivity clickStreamDeepLinkActivity) {
        injectClickStreamLinkHandler(clickStreamDeepLinkActivity, this.a.get());
        injectDeepLinkIntentFactory(clickStreamDeepLinkActivity, this.b.get());
    }
}
