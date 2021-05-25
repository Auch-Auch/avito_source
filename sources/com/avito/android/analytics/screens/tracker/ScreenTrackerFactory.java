package com.avito.android.analytics.screens.tracker;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "createScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "", "contentType", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "createInitTracker", "(Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/TimerFactory;Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "createDiInjectTracker", "(Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/TimerFactory;Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface ScreenTrackerFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ ScreenDiInjectTracker createDiInjectTracker$default(ScreenTrackerFactory screenTrackerFactory, Screen screen, TimerFactory timerFactory, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str = InternalConstsKt.SCREEN;
                }
                return screenTrackerFactory.createDiInjectTracker(screen, timerFactory, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDiInjectTracker");
        }

        public static /* synthetic */ ScreenInitTracker createInitTracker$default(ScreenTrackerFactory screenTrackerFactory, Screen screen, TimerFactory timerFactory, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str = InternalConstsKt.SCREEN;
                }
                return screenTrackerFactory.createInitTracker(screen, timerFactory, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createInitTracker");
        }
    }

    @NotNull
    ScreenDiInjectTracker createDiInjectTracker(@NotNull Screen screen, @NotNull TimerFactory timerFactory, @NotNull String str);

    @NotNull
    ScreenInitTracker createInitTracker(@NotNull Screen screen, @NotNull TimerFactory timerFactory, @NotNull String str);

    @NotNull
    ScreenFlowTrackerProvider createScreenFlowTrackerProvider(@NotNull Screen screen, @NotNull TimerFactory timerFactory);
}
