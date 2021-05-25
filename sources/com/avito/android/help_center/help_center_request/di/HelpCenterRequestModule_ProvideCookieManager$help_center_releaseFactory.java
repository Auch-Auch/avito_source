package com.avito.android.help_center.help_center_request.di;

import android.webkit.CookieManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class HelpCenterRequestModule_ProvideCookieManager$help_center_releaseFactory implements Factory<CookieManager> {

    public static final class a {
        public static final HelpCenterRequestModule_ProvideCookieManager$help_center_releaseFactory a = new HelpCenterRequestModule_ProvideCookieManager$help_center_releaseFactory();
    }

    public static HelpCenterRequestModule_ProvideCookieManager$help_center_releaseFactory create() {
        return a.a;
    }

    public static CookieManager provideCookieManager$help_center_release() {
        return (CookieManager) Preconditions.checkNotNullFromProvides(HelpCenterRequestModule.provideCookieManager$help_center_release());
    }

    @Override // javax.inject.Provider
    public CookieManager get() {
        return provideCookieManager$help_center_release();
    }
}
