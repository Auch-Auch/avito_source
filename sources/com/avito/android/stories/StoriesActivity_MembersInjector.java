package com.avito.android.stories;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class StoriesActivity_MembersInjector implements MembersInjector<StoriesActivity> {
    public final Provider<StoriesPresenter> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<ImplicitIntentFactory> c;

    public StoriesActivity_MembersInjector(Provider<StoriesPresenter> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<StoriesActivity> create(Provider<StoriesPresenter> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3) {
        return new StoriesActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.stories.StoriesActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(StoriesActivity storiesActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        storiesActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.stories.StoriesActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(StoriesActivity storiesActivity, ImplicitIntentFactory implicitIntentFactory) {
        storiesActivity.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.stories.StoriesActivity.presenter")
    public static void injectPresenter(StoriesActivity storiesActivity, StoriesPresenter storiesPresenter) {
        storiesActivity.presenter = storiesPresenter;
    }

    public void injectMembers(StoriesActivity storiesActivity) {
        injectPresenter(storiesActivity, this.a.get());
        injectDeepLinkIntentFactory(storiesActivity, this.b.get());
        injectImplicitIntentFactory(storiesActivity, this.c.get());
    }
}
