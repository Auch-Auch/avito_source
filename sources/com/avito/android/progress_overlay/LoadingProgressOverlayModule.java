package com.avito.android.progress_overlay;

import com.avito.android.analytics.Analytics;
import com.avito.android.di.PerFragment;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/progress_overlay/LoadingProgressOverlayModule;", "", "Lcom/avito/android/progress_overlay/ProgressDialogRouter;", "progressDialogRouter", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "provideLoadingProgressOverlay", "(Lcom/avito/android/progress_overlay/ProgressDialogRouter;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "<init>", "()V", "progress-overlay_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class LoadingProgressOverlayModule {
    @Provides
    @PerFragment
    @NotNull
    public final LoadingProgressOverlay provideLoadingProgressOverlay(@NotNull ProgressDialogRouter progressDialogRouter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(progressDialogRouter, "progressDialogRouter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new LoadingProgressOverlayImpl(analytics, progressDialogRouter);
    }
}
