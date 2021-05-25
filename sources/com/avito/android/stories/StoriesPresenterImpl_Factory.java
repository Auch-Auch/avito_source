package com.avito.android.stories;

import android.content.res.Resources;
import android.webkit.CookieManager;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StoriesPresenterImpl_Factory implements Factory<StoriesPresenterImpl> {
    public final Provider<StoriesInteractor> a;
    public final Provider<CookieManager> b;
    public final Provider<CookieProvider> c;
    public final Provider<DeepLinkFactory> d;
    public final Provider<StoriesArguments> e;
    public final Provider<Resources> f;

    public StoriesPresenterImpl_Factory(Provider<StoriesInteractor> provider, Provider<CookieManager> provider2, Provider<CookieProvider> provider3, Provider<DeepLinkFactory> provider4, Provider<StoriesArguments> provider5, Provider<Resources> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static StoriesPresenterImpl_Factory create(Provider<StoriesInteractor> provider, Provider<CookieManager> provider2, Provider<CookieProvider> provider3, Provider<DeepLinkFactory> provider4, Provider<StoriesArguments> provider5, Provider<Resources> provider6) {
        return new StoriesPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static StoriesPresenterImpl newInstance(StoriesInteractor storiesInteractor, CookieManager cookieManager, CookieProvider cookieProvider, DeepLinkFactory deepLinkFactory, StoriesArguments storiesArguments, Resources resources) {
        return new StoriesPresenterImpl(storiesInteractor, cookieManager, cookieProvider, deepLinkFactory, storiesArguments, resources);
    }

    @Override // javax.inject.Provider
    public StoriesPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
