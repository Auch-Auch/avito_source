package com.avito.android.user_stats.storage;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorage;", "", "", "time", "", "setSmbStatsTooltipWasClosed", "(J)V", "setSmbStatsWasVisited", "()V", "getSmbStatsLastTimeShown", "()J", "smbStatsLastTimeShown", "", "getSmbStatsShownCount", "()I", "smbStatsShownCount", "", "getSmbStatsVisited", "()Z", "smbStatsVisited", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public interface SmbStatsTooltipSessionStorage {
    long getSmbStatsLastTimeShown();

    int getSmbStatsShownCount();

    boolean getSmbStatsVisited();

    void setSmbStatsTooltipWasClosed(long j);

    void setSmbStatsWasVisited();
}
