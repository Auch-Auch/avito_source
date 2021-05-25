package com.avito.android.serp.adapter.onboarding;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/adapter/onboarding/SerpBadgeResourceProvider;", "", "", "getImvOnboardingGoodPriceMessage", "()Ljava/lang/String;", "getImvOnboardingGreatPriceMessage", "getCarOwnerOnboardingMessage", "getOnboardingButtonText", "", "isTablet", "()Z", "isLandscape", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpBadgeResourceProvider {
    @NotNull
    String getCarOwnerOnboardingMessage();

    @NotNull
    String getImvOnboardingGoodPriceMessage();

    @NotNull
    String getImvOnboardingGreatPriceMessage();

    @NotNull
    String getOnboardingButtonText();

    boolean isLandscape();

    boolean isTablet();
}
