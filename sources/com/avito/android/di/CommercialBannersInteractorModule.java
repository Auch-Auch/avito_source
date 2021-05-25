package com.avito.android.di;

import com.avito.android.serp.BannerInfoFactory;
import com.avito.android.serp.BannerInfoFactoryImpl;
import com.avito.android.serp.CommercialBannerTimeProvider;
import com.avito.android.serp.CommercialBannerTimeProviderImpl;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.CommercialBannersAnalyticsInteractorImpl;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.serp.CommercialBannersInteractorImpl;
import com.avito.android.serp.ad.DfpBannerLoader;
import com.avito.android.serp.ad.DfpBannerLoaderImpl;
import com.avito.android.serp.ad.MyTargetBannerLoader;
import com.avito.android.serp.ad.MyTargetBannerLoaderImpl;
import com.avito.android.serp.ad.YandexBannerLoader;
import com.avito.android.serp.ad.YandexBannerLoaderImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0019H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH'¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/di/CommercialBannersInteractorModule;", "", "Lcom/avito/android/serp/CommercialBannersInteractorImpl;", "interactor", "Lcom/avito/android/serp/CommercialBannersInteractor;", "provideBannersInteractor", "(Lcom/avito/android/serp/CommercialBannersInteractorImpl;)Lcom/avito/android/serp/CommercialBannersInteractor;", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractorImpl;", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "bindSerpBannersAnalyticsInteractor", "(Lcom/avito/android/serp/CommercialBannersAnalyticsInteractorImpl;)Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "Lcom/avito/android/serp/CommercialBannerTimeProviderImpl;", "timeProvider", "Lcom/avito/android/serp/CommercialBannerTimeProvider;", "bindTimeProvider", "(Lcom/avito/android/serp/CommercialBannerTimeProviderImpl;)Lcom/avito/android/serp/CommercialBannerTimeProvider;", "Lcom/avito/android/serp/ad/DfpBannerLoaderImpl;", "loader", "Lcom/avito/android/serp/ad/DfpBannerLoader;", "provideDfpBannerLoader", "(Lcom/avito/android/serp/ad/DfpBannerLoaderImpl;)Lcom/avito/android/serp/ad/DfpBannerLoader;", "Lcom/avito/android/serp/ad/MyTargetBannerLoaderImpl;", "Lcom/avito/android/serp/ad/MyTargetBannerLoader;", "bindMyTargetBannerLoader", "(Lcom/avito/android/serp/ad/MyTargetBannerLoaderImpl;)Lcom/avito/android/serp/ad/MyTargetBannerLoader;", "Lcom/avito/android/serp/ad/YandexBannerLoaderImpl;", "Lcom/avito/android/serp/ad/YandexBannerLoader;", "bindYandexBannerLoader", "(Lcom/avito/android/serp/ad/YandexBannerLoaderImpl;)Lcom/avito/android/serp/ad/YandexBannerLoader;", "Lcom/avito/android/serp/BannerInfoFactoryImpl;", "factory", "Lcom/avito/android/serp/BannerInfoFactory;", "bindBannerInfoFactory", "(Lcom/avito/android/serp/BannerInfoFactoryImpl;)Lcom/avito/android/serp/BannerInfoFactory;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface CommercialBannersInteractorModule {
    @PerFragment
    @Binds
    @NotNull
    BannerInfoFactory bindBannerInfoFactory(@NotNull BannerInfoFactoryImpl bannerInfoFactoryImpl);

    @PerFragment
    @Binds
    @NotNull
    MyTargetBannerLoader bindMyTargetBannerLoader(@NotNull MyTargetBannerLoaderImpl myTargetBannerLoaderImpl);

    @Binds
    @NotNull
    CommercialBannersAnalyticsInteractor bindSerpBannersAnalyticsInteractor(@NotNull CommercialBannersAnalyticsInteractorImpl commercialBannersAnalyticsInteractorImpl);

    @Binds
    @NotNull
    CommercialBannerTimeProvider bindTimeProvider(@NotNull CommercialBannerTimeProviderImpl commercialBannerTimeProviderImpl);

    @PerFragment
    @Binds
    @NotNull
    YandexBannerLoader bindYandexBannerLoader(@NotNull YandexBannerLoaderImpl yandexBannerLoaderImpl);

    @PerFragment
    @Binds
    @NotNull
    CommercialBannersInteractor provideBannersInteractor(@NotNull CommercialBannersInteractorImpl commercialBannersInteractorImpl);

    @PerFragment
    @Binds
    @NotNull
    DfpBannerLoader provideDfpBannerLoader(@NotNull DfpBannerLoaderImpl dfpBannerLoaderImpl);
}
