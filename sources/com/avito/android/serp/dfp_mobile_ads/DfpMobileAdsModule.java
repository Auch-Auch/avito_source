package com.avito.android.serp.dfp_mobile_ads;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/dfp_mobile_ads/DfpMobileAdsModule;", "", "Lcom/avito/android/serp/dfp_mobile_ads/DfpMobileAdsWrapper;", "provideMobileAdsWrapper$serp_release", "()Lcom/avito/android/serp/dfp_mobile_ads/DfpMobileAdsWrapper;", "provideMobileAdsWrapper", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class DfpMobileAdsModule {
    @NotNull
    public static final DfpMobileAdsModule INSTANCE = new DfpMobileAdsModule();

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final DfpMobileAdsWrapper provideMobileAdsWrapper$serp_release() {
        return new DfpMobileAdsWrapper();
    }
}
