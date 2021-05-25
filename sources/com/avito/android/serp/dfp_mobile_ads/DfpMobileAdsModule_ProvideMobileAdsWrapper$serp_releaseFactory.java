package com.avito.android.serp.dfp_mobile_ads;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class DfpMobileAdsModule_ProvideMobileAdsWrapper$serp_releaseFactory implements Factory<DfpMobileAdsWrapper> {

    public static final class a {
        public static final DfpMobileAdsModule_ProvideMobileAdsWrapper$serp_releaseFactory a = new DfpMobileAdsModule_ProvideMobileAdsWrapper$serp_releaseFactory();
    }

    public static DfpMobileAdsModule_ProvideMobileAdsWrapper$serp_releaseFactory create() {
        return a.a;
    }

    public static DfpMobileAdsWrapper provideMobileAdsWrapper$serp_release() {
        return (DfpMobileAdsWrapper) Preconditions.checkNotNullFromProvides(DfpMobileAdsModule.provideMobileAdsWrapper$serp_release());
    }

    @Override // javax.inject.Provider
    public DfpMobileAdsWrapper get() {
        return provideMobileAdsWrapper$serp_release();
    }
}
