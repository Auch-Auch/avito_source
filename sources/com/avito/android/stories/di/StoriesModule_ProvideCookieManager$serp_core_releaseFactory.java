package com.avito.android.stories.di;

import android.webkit.CookieManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StoriesModule_ProvideCookieManager$serp_core_releaseFactory implements Factory<CookieManager> {

    public static final class a {
        public static final StoriesModule_ProvideCookieManager$serp_core_releaseFactory a = new StoriesModule_ProvideCookieManager$serp_core_releaseFactory();
    }

    public static StoriesModule_ProvideCookieManager$serp_core_releaseFactory create() {
        return a.a;
    }

    public static CookieManager provideCookieManager$serp_core_release() {
        return (CookieManager) Preconditions.checkNotNullFromProvides(StoriesModule.provideCookieManager$serp_core_release());
    }

    @Override // javax.inject.Provider
    public CookieManager get() {
        return provideCookieManager$serp_core_release();
    }
}
