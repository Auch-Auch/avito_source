package com.avito.android.di.module;

import com.avito.android.analytics_adjust.di.AdjustAppToken;
import com.avito.android.analytics_adjust.di.AdjustDefaultTracker;
import com.avito.android.util.AvitoBuildInfo;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/di/module/AdjustTokenModule;", "", "", "provideAdjustAppToken", "()Ljava/lang/String;", "Lcom/avito/android/util/AvitoBuildInfo;", "buildInfo", "provideAdjustDefaultTracker", "(Lcom/avito/android/util/AvitoBuildInfo;)Ljava/lang/String;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AdjustTokenModule {
    @NotNull
    public static final AdjustTokenModule INSTANCE = new AdjustTokenModule();

    @Provides
    @JvmStatic
    @AdjustAppToken
    @NotNull
    @Singleton
    public static final String provideAdjustAppToken() {
        return "3ihxlnl1sha8";
    }

    @Provides
    @JvmStatic
    @Nullable
    @Singleton
    @AdjustDefaultTracker
    public static final String provideAdjustDefaultTracker(@NotNull AvitoBuildInfo avitoBuildInfo) {
        Intrinsics.checkNotNullParameter(avitoBuildInfo, "buildInfo");
        return avitoBuildInfo.getAdjustDefaultTracker();
    }
}
