package com.avito.android.lastclick;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\tR*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/avito/android/lastclick/LastClick;", "", "", "<set-?>", AuthSource.SEND_ABUSE, "J", "getTimestamp", "()J", "getTimestamp$annotations", "()V", "timestamp", "<init>", "Updater", "android_release"}, k = 1, mv = {1, 4, 2})
public final class LastClick {
    @NotNull
    public static final LastClick INSTANCE = new LastClick();
    public static long a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/lastclick/LastClick$Updater;", "", "", "update", "()V", "updateFromDeeplink", "<init>", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class Updater {
        @NotNull
        public static final Updater INSTANCE = new Updater();

        @JvmStatic
        public static final void update() {
            Logs.debug$default("LastClick", "touch_detected", null, 4, null);
            LastClick.a = System.currentTimeMillis();
        }

        @JvmStatic
        public static final void updateFromDeeplink() {
            Logs.debug$default("LastClick", "touch_from_deeplink", null, 4, null);
            long j = 0;
            if (LastClick.getTimestamp() != 0) {
                j = System.currentTimeMillis();
            }
            LastClick.a = j;
        }
    }

    public static final long getTimestamp() {
        return a;
    }

    @JvmStatic
    public static /* synthetic */ void getTimestamp$annotations() {
    }
}
