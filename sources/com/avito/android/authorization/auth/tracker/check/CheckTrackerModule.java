package com.avito.android.authorization.auth.tracker.check;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.performance.ContentTracker;
import com.avito.android.performance.ContentTrackerImpl;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.IntoSet;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/authorization/auth/tracker/check/CheckTrackerModule;", "", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/performance/ContentTracker;", "provideContentTracker", "(Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;)Lcom/avito/android/performance/ContentTracker;", "tracker", "provideContentTrackerToSet", "(Lcom/avito/android/performance/ContentTracker;)Lcom/avito/android/performance/ContentTracker;", "", "NAME", "Ljava/lang/String;", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class CheckTrackerModule {
    @NotNull
    public static final CheckTrackerModule INSTANCE = new CheckTrackerModule();
    @NotNull
    public static final String NAME = "check";

    @Provides
    @JvmStatic
    @Reusable
    @Named(NAME)
    @NotNull
    public static final ContentTracker provideContentTracker(@NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        return new ContentTrackerImpl(NAME, screenFlowTrackerProvider);
    }

    @Provides
    @JvmStatic
    @Reusable
    @IntoSet
    @NotNull
    public static final ContentTracker provideContentTrackerToSet(@Named("check") @NotNull ContentTracker contentTracker) {
        Intrinsics.checkNotNullParameter(contentTracker, "tracker");
        return contentTracker;
    }
}
