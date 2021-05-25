package com.avito.android.vas_performance.di.perfomance_legacy;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.vas_performance.LegacyPerformanceVasViewModel;
import com.avito.android.vas_performance.di.VasDependencies;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/vas_performance/di/perfomance_legacy/PerformanceVasDependencies;", "Lcom/avito/android/vas_performance/di/VasDependencies;", "Lcom/avito/android/vas_performance/LegacyPerformanceVasViewModel;", "legacyPerformanceVasViewModel", "()Lcom/avito/android/vas_performance/LegacyPerformanceVasViewModel;", "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "performanceVasTracker", "()Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public interface PerformanceVasDependencies extends VasDependencies {
    @NotNull
    DeepLinkIntentFactory deeplinkIntentFactory();

    @NotNull
    LegacyPerformanceVasViewModel legacyPerformanceVasViewModel();

    @NotNull
    PerformanceVasTracker performanceVasTracker();
}
