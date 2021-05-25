package com.avito.android.user_stats.storage;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionContract;", "", "", "c", "Ljava/lang/String;", "getSMB_STATS_WAS_VISITED", "()Ljava/lang/String;", "SMB_STATS_WAS_VISITED", AuthSource.SEND_ABUSE, "getTOOLTIP_LAST_TIME_WAS_SHOWN", "TOOLTIP_LAST_TIME_WAS_SHOWN", AuthSource.BOOKING_ORDER, "getTOOLTIP_COUNT_WAS_SHOWN", "TOOLTIP_COUNT_WAS_SHOWN", "<init>", "()V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class SmbStatsTooltipSessionContract {
    @NotNull
    public static final SmbStatsTooltipSessionContract INSTANCE = new SmbStatsTooltipSessionContract();
    @NotNull
    public static final String a = a.c3("smb_stats_", "last_time_shown");
    @NotNull
    public static final String b = a.c3("smb_stats_", "count_shown");
    @NotNull
    public static final String c = a.c3("smb_stats_", "visited");

    @NotNull
    public final String getSMB_STATS_WAS_VISITED() {
        return c;
    }

    @NotNull
    public final String getTOOLTIP_COUNT_WAS_SHOWN() {
        return b;
    }

    @NotNull
    public final String getTOOLTIP_LAST_TIME_WAS_SHOWN() {
        return a;
    }
}
