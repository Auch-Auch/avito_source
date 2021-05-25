package com.avito.android.di.module;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.analytics.features.AvitoAnalyticFeatures;
import com.avito.android.util.AvitoBuildInfo;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/di/module/BuildVariantFeaturesModule;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/util/AvitoBuildInfo;", "buildInfo", "Lcom/avito/android/analytics/features/AvitoAnalyticFeatures;", "remoteFeatures", "Lcom/avito/android/Features;", "provideFeatures", "(Landroid/content/Context;Lcom/avito/android/util/AvitoBuildInfo;Lcom/avito/android/analytics/features/AvitoAnalyticFeatures;)Lcom/avito/android/Features;", "<init>", "()V", "avito-release_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class BuildVariantFeaturesModule {
    @Provides
    @Singleton
    @NotNull
    public final Features provideFeatures(@NotNull Context context, @NotNull AvitoBuildInfo avitoBuildInfo, @NotNull AvitoAnalyticFeatures avitoAnalyticFeatures) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avitoBuildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(avitoAnalyticFeatures, "remoteFeatures");
        return new Features(context, avitoBuildInfo).getRemoteToggles().invoke().booleanValue() ? avitoAnalyticFeatures : new Features(context, avitoBuildInfo);
    }
}
