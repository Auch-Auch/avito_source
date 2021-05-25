package com.avito.android.select.new_metro.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.select.new_metro.analytics.SelectMetroAnalytics;
import com.avito.android.select.new_metro.analytics.SelectMetroSingletonAnalyticsImpl;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/select/new_metro/di/SelectMetroBaseModule;", "", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;", "getAnalyticsInteractor", "(Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SelectMetroBaseModule {
    @NotNull
    public static final SelectMetroBaseModule INSTANCE = new SelectMetroBaseModule();

    @Provides
    @Reusable
    @NotNull
    public final SelectMetroAnalytics getAnalyticsInteractor(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new SelectMetroSingletonAnalyticsImpl(analytics);
    }
}
