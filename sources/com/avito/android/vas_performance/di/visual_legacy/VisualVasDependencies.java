package com.avito.android.vas_performance.di.visual_legacy;

import com.avito.android.vas_performance.LegacyVisualVasViewModel;
import com.avito.android.vas_performance.di.VasDependencies;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/vas_performance/di/visual_legacy/VisualVasDependencies;", "Lcom/avito/android/vas_performance/di/VasDependencies;", "Lcom/avito/android/vas_performance/LegacyVisualVasViewModel;", "visualVasViewModel", "()Lcom/avito/android/vas_performance/LegacyVisualVasViewModel;", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "visualVasTracker", "()Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public interface VisualVasDependencies extends VasDependencies {
    @NotNull
    VisualVasTracker visualVasTracker();

    @NotNull
    LegacyVisualVasViewModel visualVasViewModel();
}
