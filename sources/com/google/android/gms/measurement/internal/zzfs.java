package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzng;
import com.google.firebase.messaging.Constants;
import kotlinx.coroutines.DebugKt;
public final class zzfs implements Runnable {
    private final /* synthetic */ zzd zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzft zzc;

    public zzfs(zzft zzft, zzd zzd, ServiceConnection serviceConnection) {
        this.zzc = zzft;
        this.zza = zzd;
        this.zzb = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzft zzft = this.zzc;
        zzfq zzfq = zzft.zza;
        String str = zzft.zzb;
        zzd zzd = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle zza2 = zzfq.zza(str, zzd);
        zzfq.zza.zzq().zzd();
        if (zza2 != null) {
            long j = zza2.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzfq.zza.zzr().zzi().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza2.getString(Constants.INSTALL_REFERRER);
                if (string == null || string.isEmpty()) {
                    zzfq.zza.zzr().zzf().zza("No referrer defined in Install Referrer response");
                } else {
                    zzfq.zza.zzr().zzx().zza("InstallReferrer API result", string);
                    Bundle zza3 = zzfq.zza.zzi().zza(Uri.parse(string.length() != 0 ? "?".concat(string) : new String("?")));
                    if (zza3 == null) {
                        zzfq.zza.zzr().zzf().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zza3.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = zza2.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzfq.zza.zzr().zzf().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zza3.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzfq.zza.zzc().zzi.zza()) {
                            zzfq.zza.zzu();
                            zzfq.zza.zzr().zzx().zza("Install Referrer campaign has already been logged");
                        } else if (!zzng.zzb() || !zzfq.zza.zzb().zza(zzaq.zzca) || zzfq.zza.zzab()) {
                            zzfq.zza.zzc().zzi.zza(j);
                            zzfq.zza.zzu();
                            zzfq.zza.zzr().zzx().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                            zza3.putString("_cis", "referrer API");
                            zzfq.zza.zzh().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zza3);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzfq.zza.zzn(), serviceConnection);
        }
    }
}
