package com.avito.android.serp.adapter.onboarding;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp_core.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/serp/adapter/onboarding/SerpBadgeResourceProviderImpl;", "Lcom/avito/android/serp/adapter/onboarding/SerpBadgeResourceProvider;", "", "getImvOnboardingGoodPriceMessage", "()Ljava/lang/String;", "getImvOnboardingGreatPriceMessage", "getCarOwnerOnboardingMessage", "getOnboardingButtonText", "", "isTablet", "()Z", "isLandscape", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpBadgeResourceProviderImpl implements SerpBadgeResourceProvider {
    public final Resources a;

    @Inject
    public SerpBadgeResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpBadgeResourceProvider
    @NotNull
    public String getCarOwnerOnboardingMessage() {
        String string = this.a.getString(R.string.serp_onboarding_car_owner);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…erp_onboarding_car_owner)");
        return string;
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpBadgeResourceProvider
    @NotNull
    public String getImvOnboardingGoodPriceMessage() {
        String string = this.a.getString(R.string.serp_onboarding_imv_good_price);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…nboarding_imv_good_price)");
        return string;
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpBadgeResourceProvider
    @NotNull
    public String getImvOnboardingGreatPriceMessage() {
        String string = this.a.getString(R.string.serp_onboarding_imv_great_price);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…boarding_imv_great_price)");
        return string;
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpBadgeResourceProvider
    @NotNull
    public String getOnboardingButtonText() {
        String string = this.a.getString(R.string.serp_onboarding_button_text);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…p_onboarding_button_text)");
        return string;
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpBadgeResourceProvider
    public boolean isLandscape() {
        return this.a.getConfiguration().orientation == 2;
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpBadgeResourceProvider
    public boolean isTablet() {
        return this.a.getBoolean(com.avito.android.ui_components.R.bool.is_tablet);
    }
}
