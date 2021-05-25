package com.avito.android.analytics.screens.fps;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/analytics/screens/fps/FramesHolder;", "", "", "c", "Z", "getFirstTime", "()Z", "firstTime", "Lcom/avito/android/analytics/screens/fps/FpsState;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/fps/FpsState;", "getState", "()Lcom/avito/android/analytics/screens/fps/FpsState;", "state", "", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getFrames", "()Ljava/util/List;", "frames", "", "d", "Ljava/lang/String;", "getScreenName", "()Ljava/lang/String;", "screenName", "<init>", "(Ljava/util/List;Lcom/avito/android/analytics/screens/fps/FpsState;ZLjava/lang/String;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class FramesHolder {
    @NotNull
    public final List<Long> a;
    @NotNull
    public final FpsState b;
    public final boolean c;
    @NotNull
    public final String d;

    public FramesHolder(@NotNull List<Long> list, @NotNull FpsState fpsState, boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "frames");
        Intrinsics.checkNotNullParameter(fpsState, "state");
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.a = list;
        this.b = fpsState;
        this.c = z;
        this.d = str;
    }

    public final boolean getFirstTime() {
        return this.c;
    }

    @NotNull
    public final List<Long> getFrames() {
        return this.a;
    }

    @NotNull
    public final String getScreenName() {
        return this.d;
    }

    @NotNull
    public final FpsState getState() {
        return this.b;
    }
}
