package com.avito.android.serp.adapter.onboarding.di;

import com.avito.android.di.PerFragment;
import com.avito.android.serp.adapter.onboarding.SerpBadgeResourceProvider;
import com.avito.android.serp.adapter.onboarding.SerpBadgeResourceProviderImpl;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandlerImpl;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/adapter/onboarding/di/SerpOnboardingModule;", "", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerImpl;", "handler", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "bindSerpOnboardingHandler", "(Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandlerImpl;)Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "Lcom/avito/android/serp/adapter/onboarding/SerpBadgeResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/serp/adapter/onboarding/SerpBadgeResourceProvider;", "bindSerpBadgeOnboardingResourceProvider", "(Lcom/avito/android/serp/adapter/onboarding/SerpBadgeResourceProviderImpl;)Lcom/avito/android/serp/adapter/onboarding/SerpBadgeResourceProvider;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface SerpOnboardingModule {
    @PerFragment
    @Binds
    @NotNull
    SerpBadgeResourceProvider bindSerpBadgeOnboardingResourceProvider(@NotNull SerpBadgeResourceProviderImpl serpBadgeResourceProviderImpl);

    @PerFragment
    @Binds
    @NotNull
    SerpOnboardingHandler bindSerpOnboardingHandler(@NotNull SerpOnboardingHandlerImpl serpOnboardingHandlerImpl);
}
