package com.google.android.gms.internal.gtm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import com.avito.android.geo.GeoPositionModelKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Random;
import ru.avito.messenger.internal.ConstantsKt;
@ShowFirstParty
public final class zzdz {
    private final String zzaec;
    private final Random zzafj;
    private final Context zzrm;

    public zzdz(Context context, String str) {
        this(context, str, new Random());
    }

    private final long zza(long j, long j2) {
        SharedPreferences zzhp = zzhp();
        long max = Math.max(0L, zzhp.getLong("FORBIDDEN_COUNT", 0));
        return (long) (this.zzafj.nextFloat() * ((float) (j + ((long) ((((float) max) / ((float) ((max + Math.max(0L, zzhp.getLong("SUCCESSFUL_COUNT", 0))) + 1))) * ((float) (j2 - j)))))));
    }

    private final SharedPreferences zzhp() {
        Context context = this.zzrm;
        String valueOf = String.valueOf(this.zzaec);
        return context.getSharedPreferences(valueOf.length() != 0 ? "v5_gtmContainerRefreshPolicy_".concat(valueOf) : new String("v5_gtmContainerRefreshPolicy_"), 0);
    }

    public final long zzhl() {
        return zza(7200000, 259200000) + 43200000;
    }

    public final long zzhm() {
        return zza(GeoPositionModelKt.MIN_GEO_REPORT_TIMEOUT, 86400000) + ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS;
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzhn() {
        long j;
        SharedPreferences zzhp = zzhp();
        long j2 = zzhp.getLong("FORBIDDEN_COUNT", 0);
        long j3 = zzhp.getLong("SUCCESSFUL_COUNT", 0);
        SharedPreferences.Editor edit = zzhp.edit();
        if (j2 == 0) {
            j = 3;
        } else {
            j = Math.min(10L, j2 + 1);
        }
        long max = Math.max(0L, Math.min(j3, 10 - j));
        edit.putLong("FORBIDDEN_COUNT", j);
        edit.putLong("SUCCESSFUL_COUNT", max);
        edit.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzho() {
        SharedPreferences zzhp = zzhp();
        long j = zzhp.getLong("SUCCESSFUL_COUNT", 0);
        long j2 = zzhp.getLong("FORBIDDEN_COUNT", 0);
        long min = Math.min(10L, j + 1);
        long max = Math.max(0L, Math.min(j2, 10 - min));
        SharedPreferences.Editor edit = zzhp.edit();
        edit.putLong("SUCCESSFUL_COUNT", min);
        edit.putLong("FORBIDDEN_COUNT", max);
        edit.apply();
    }

    public final long zzkd() {
        if (Math.max(0L, zzhp().getLong("FORBIDDEN_COUNT", 0)) == 0) {
            return 0;
        }
        return zza(10000, GeoPositionModelKt.MIN_GEO_REPORT_TIMEOUT) + 10000;
    }

    public final boolean zzke() {
        return Math.max(0, zzhp().getLong("FORBIDDEN_COUNT", 0)) > 0;
    }

    @VisibleForTesting
    private zzdz(Context context, String str, Random random) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
        this.zzaec = (String) Preconditions.checkNotNull(str);
        this.zzafj = random;
    }
}
