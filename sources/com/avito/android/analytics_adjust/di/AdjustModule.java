package com.avito.android.analytics_adjust.di;

import com.adjust.sdk.sig.BuildConfig;
import com.avito.android.analytics.EventObserver;
import com.avito.android.analytics_adjust.Adjust;
import com.avito.android.analytics_adjust.AdjustEventObserver;
import com.avito.android.analytics_adjust.AdjustEventTracker;
import com.avito.android.analytics_adjust.AdjustEventTrackerImpl;
import com.avito.android.analytics_adjust.AdjustImpl;
import com.avito.android.analytics_adjust.Criteo;
import com.avito.android.analytics_adjust.CriteoImpl;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics_adjust/di/AdjustModule;", "", "Lcom/avito/android/analytics_adjust/AdjustImpl;", BuildConfig.FLAVOR, "Lcom/avito/android/analytics_adjust/Adjust;", "bindAdjust", "(Lcom/avito/android/analytics_adjust/AdjustImpl;)Lcom/avito/android/analytics_adjust/Adjust;", "Lcom/avito/android/analytics_adjust/CriteoImpl;", "criteo", "Lcom/avito/android/analytics_adjust/Criteo;", "bindCriteo", "(Lcom/avito/android/analytics_adjust/CriteoImpl;)Lcom/avito/android/analytics_adjust/Criteo;", "Lcom/avito/android/analytics_adjust/AdjustEventTrackerImpl;", "adjustEventTracker", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "bindAdjustEventTracker", "(Lcom/avito/android/analytics_adjust/AdjustEventTrackerImpl;)Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "Lcom/avito/android/analytics_adjust/AdjustEventObserver;", "adjustEventObserver", "Lcom/avito/android/analytics/EventObserver;", "bindAdjustEventObserver", "(Lcom/avito/android/analytics_adjust/AdjustEventObserver;)Lcom/avito/android/analytics/EventObserver;", "analytics-adjust_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AdjustModule {
    @Singleton
    @Binds
    @NotNull
    Adjust bindAdjust(@NotNull AdjustImpl adjustImpl);

    @Binds
    @IntoSet
    @NotNull
    @Singleton
    EventObserver bindAdjustEventObserver(@NotNull AdjustEventObserver adjustEventObserver);

    @Singleton
    @Binds
    @NotNull
    AdjustEventTracker bindAdjustEventTracker(@NotNull AdjustEventTrackerImpl adjustEventTrackerImpl);

    @Singleton
    @Binds
    @NotNull
    Criteo bindCriteo(@NotNull CriteoImpl criteoImpl);
}
