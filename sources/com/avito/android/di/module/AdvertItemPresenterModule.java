package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.serp.adapter.AdvertGridItemPresenter;
import com.avito.android.serp.adapter.AdvertGridItemPresenterImpl;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.AdvertListItemPresenter;
import com.avito.android.serp.adapter.AdvertListItemPresenterImpl;
import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import com.avito.android.serp.adapter.RdsAdvertItemPresenterImpl;
import com.avito.android.serp.adapter.RdsAdvertItemPresenterKt;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\f\u0010\rJ7\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0012\u001a\u00020\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0014\u001a\u00020\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/di/module/AdvertItemPresenterModule;", "", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "onboardingHandler", "Lcom/avito/android/serp/adapter/AdvertGridItemPresenter;", "provideAdvertGridItemPresenter", "(Ldagger/Lazy;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;)Lcom/avito/android/serp/adapter/AdvertGridItemPresenter;", "Lcom/avito/android/serp/adapter/AdvertListItemPresenter;", "provideAdvertListItemPresenter", "(Ldagger/Lazy;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;)Lcom/avito/android/serp/adapter/AdvertListItemPresenter;", "Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;", "provideRdsAdvertItemPresenter", "(Ldagger/Lazy;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;", "provideRdsRecommendationAdvertItemPresenter", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DateTimeFormatterModule.class})
public final class AdvertItemPresenterModule {
    @NotNull
    public static final AdvertItemPresenterModule INSTANCE = new AdvertItemPresenterModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final AdvertGridItemPresenter provideAdvertGridItemPresenter(@NotNull Lazy<AdvertItemListener> lazy, @NotNull Analytics analytics, @NotNull Features features, @Nullable SerpOnboardingHandler serpOnboardingHandler) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new AdvertGridItemPresenterImpl(lazy, analytics, features, serpOnboardingHandler);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final AdvertListItemPresenter provideAdvertListItemPresenter(@NotNull Lazy<AdvertItemListener> lazy, @NotNull Analytics analytics, @NotNull Features features, @Nullable SerpOnboardingHandler serpOnboardingHandler) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new AdvertListItemPresenterImpl(lazy, analytics, features, serpOnboardingHandler);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final RdsAdvertItemPresenter provideRdsAdvertItemPresenter(@NotNull Lazy<AdvertItemListener> lazy, @NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new RdsAdvertItemPresenterImpl(lazy, analytics, null, !features.getFrescoKeepOnDetach().invoke().booleanValue(), 4, null);
    }

    @Provides
    @JvmStatic
    @ComplementarySectionAdvertItemPresenter
    @Reusable
    @NotNull
    public static final RdsAdvertItemPresenter provideRdsRecommendationAdvertItemPresenter(@NotNull Lazy<AdvertItemListener> lazy, @NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new RdsAdvertItemPresenterImpl(lazy, analytics, x.setOf(RdsAdvertItemPresenterKt.EX_DATE), !features.getFrescoKeepOnDetach().invoke().booleanValue());
    }
}
