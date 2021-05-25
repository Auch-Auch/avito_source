package com.avito.android.autodeal_details.di;

import android.webkit.CookieManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AutoDealDetailsModule_ProvideCookieManagerFactory implements Factory<CookieManager> {

    public static final class a {
        public static final AutoDealDetailsModule_ProvideCookieManagerFactory a = new AutoDealDetailsModule_ProvideCookieManagerFactory();
    }

    public static AutoDealDetailsModule_ProvideCookieManagerFactory create() {
        return a.a;
    }

    public static CookieManager provideCookieManager() {
        return (CookieManager) Preconditions.checkNotNullFromProvides(AutoDealDetailsModule.INSTANCE.provideCookieManager());
    }

    @Override // javax.inject.Provider
    public CookieManager get() {
        return provideCookieManager();
    }
}
