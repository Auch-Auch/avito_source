package com.avito.android.user_stats.storage;

import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.di.SmbTooltipPreferences;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorageImpl;", "Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorage;", "", "time", "", "setSmbStatsTooltipWasClosed", "(J)V", "setSmbStatsWasVisited", "()V", "", "getSmbStatsShownCount", "()I", "smbStatsShownCount", "getSmbStatsLastTimeShown", "()J", "smbStatsLastTimeShown", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "", "getSmbStatsVisited", "()Z", "smbStatsVisited", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class SmbStatsTooltipSessionStorageImpl implements SmbStatsTooltipSessionStorage {
    public final Preferences a;

    @Inject
    public SmbStatsTooltipSessionStorageImpl(@SmbTooltipPreferences @NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorage
    public long getSmbStatsLastTimeShown() {
        return this.a.getLong(SmbStatsTooltipSessionContract.INSTANCE.getTOOLTIP_LAST_TIME_WAS_SHOWN(), 0);
    }

    @Override // com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorage
    public int getSmbStatsShownCount() {
        return this.a.getInt(SmbStatsTooltipSessionContract.INSTANCE.getTOOLTIP_COUNT_WAS_SHOWN(), 0);
    }

    @Override // com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorage
    public boolean getSmbStatsVisited() {
        return this.a.getBoolean(SmbStatsTooltipSessionContract.INSTANCE.getSMB_STATS_WAS_VISITED(), false);
    }

    @Override // com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorage
    public void setSmbStatsTooltipWasClosed(long j) {
        SharedPreferences.Editor edit = this.a.getSharedPreferences().edit();
        SmbStatsTooltipSessionContract smbStatsTooltipSessionContract = SmbStatsTooltipSessionContract.INSTANCE;
        edit.putLong(smbStatsTooltipSessionContract.getTOOLTIP_LAST_TIME_WAS_SHOWN(), j).putInt(smbStatsTooltipSessionContract.getTOOLTIP_COUNT_WAS_SHOWN(), getSmbStatsShownCount() + 1).apply();
    }

    @Override // com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorage
    public void setSmbStatsWasVisited() {
        this.a.getSharedPreferences().edit().putBoolean(SmbStatsTooltipSessionContract.INSTANCE.getSMB_STATS_WAS_VISITED(), true).apply();
    }
}
