package com.avito.android.help_center.help_center_articles.di;

import android.webkit.CookieManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class HelpCenterArticlesModule_ProvideCookieManager$help_center_releaseFactory implements Factory<CookieManager> {

    public static final class a {
        public static final HelpCenterArticlesModule_ProvideCookieManager$help_center_releaseFactory a = new HelpCenterArticlesModule_ProvideCookieManager$help_center_releaseFactory();
    }

    public static HelpCenterArticlesModule_ProvideCookieManager$help_center_releaseFactory create() {
        return a.a;
    }

    public static CookieManager provideCookieManager$help_center_release() {
        return (CookieManager) Preconditions.checkNotNullFromProvides(HelpCenterArticlesModule.provideCookieManager$help_center_release());
    }

    @Override // javax.inject.Provider
    public CookieManager get() {
        return provideCookieManager$help_center_release();
    }
}
