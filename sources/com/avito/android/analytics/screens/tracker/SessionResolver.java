package com.avito.android.analytics.screens.tracker;

import com.avito.android.analytics.screens.ScreenTimeProvider;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "", "", "sessionName", "()Ljava/lang/String;", "", "elapsed", "()J", "Impl", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface SessionResolver {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/SessionResolver$Impl;", "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "", "sessionName", "()Ljava/lang/String;", "", "elapsed", "()J", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "screenTimeProvider", "<init>", "(Lcom/avito/android/analytics/screens/ScreenTimeProvider;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements SessionResolver {
        public final ScreenTimeProvider a;

        @Inject
        public Impl(@NotNull ScreenTimeProvider screenTimeProvider) {
            Intrinsics.checkNotNullParameter(screenTimeProvider, "screenTimeProvider");
            this.a = screenTimeProvider;
        }

        @Override // com.avito.android.analytics.screens.tracker.SessionResolver
        public long elapsed() {
            if (this.a.lastClickTimestamp() == 0) {
                return this.a.startupTimeTimestamp();
            }
            return this.a.touchTimeDiff();
        }

        @Override // com.avito.android.analytics.screens.tracker.SessionResolver
        @NotNull
        public String sessionName() {
            return this.a.lastClickTimestamp() == 0 ? "appStart" : "touch";
        }
    }

    long elapsed();

    @NotNull
    String sessionName();
}
