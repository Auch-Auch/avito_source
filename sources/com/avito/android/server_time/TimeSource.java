package com.avito.android.server_time;

import android.os.SystemClock;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/server_time/TimeSource;", "", "", "now", "()J", "timeout", "", "sleep", "(J)V", "Ljava/util/TimeZone;", "getTimeZone", "()Ljava/util/TimeZone;", "timeZone", MessengerShareContentUtility.PREVIEW_DEFAULT, "server-time_release"}, k = 1, mv = {1, 4, 2})
public interface TimeSource {
    @NotNull
    public static final DEFAULT DEFAULT = DEFAULT.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/server_time/TimeSource$DEFAULT;", "Lcom/avito/android/server_time/TimeSource;", "", "now", "()J", "timeout", "", "sleep", "(J)V", "Ljava/util/TimeZone;", "getTimeZone", "()Ljava/util/TimeZone;", "timeZone", "<init>", "()V", "server-time_release"}, k = 1, mv = {1, 4, 2})
    public static final class DEFAULT implements TimeSource {
        public static final /* synthetic */ DEFAULT a = new DEFAULT();

        @Override // com.avito.android.server_time.TimeSource
        @NotNull
        public TimeZone getTimeZone() {
            TimeZone timeZone = TimeZone.getDefault();
            Intrinsics.checkNotNullExpressionValue(timeZone, "TimeZone.getDefault()");
            return timeZone;
        }

        @Override // com.avito.android.server_time.TimeSource
        public long now() {
            return System.currentTimeMillis();
        }

        @Override // com.avito.android.server_time.TimeSource
        public void sleep(long j) {
            SystemClock.sleep(j);
        }
    }

    @NotNull
    TimeZone getTimeZone();

    long now();

    void sleep(long j);
}
