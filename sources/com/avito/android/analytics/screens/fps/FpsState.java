package com.avito.android.analytics.screens.fps;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/analytics/screens/fps/FpsState;", "", "<init>", "()V", "Create", "Idle", "Scroll", "Stop", "Lcom/avito/android/analytics/screens/fps/FpsState$Idle;", "Lcom/avito/android/analytics/screens/fps/FpsState$Scroll;", "Lcom/avito/android/analytics/screens/fps/FpsState$Create;", "Lcom/avito/android/analytics/screens/fps/FpsState$Stop;", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public abstract class FpsState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/analytics/screens/fps/FpsState$Create;", "Lcom/avito/android/analytics/screens/fps/FpsState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    public static final class Create extends FpsState {
        @NotNull
        public static final Create INSTANCE = new Create();

        public Create() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "create";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/analytics/screens/fps/FpsState$Idle;", "Lcom/avito/android/analytics/screens/fps/FpsState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    public static final class Idle extends FpsState {
        @NotNull
        public static final Idle INSTANCE = new Idle();

        public Idle() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "idle";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/analytics/screens/fps/FpsState$Scroll;", "Lcom/avito/android/analytics/screens/fps/FpsState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    public static final class Scroll extends FpsState {
        @NotNull
        public static final Scroll INSTANCE = new Scroll();

        public Scroll() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "scroll";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/analytics/screens/fps/FpsState$Stop;", "Lcom/avito/android/analytics/screens/fps/FpsState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    public static final class Stop extends FpsState {
        @NotNull
        public static final Stop INSTANCE = new Stop();

        public Stop() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "stop";
        }
    }

    public FpsState() {
    }

    public FpsState(j jVar) {
    }
}
