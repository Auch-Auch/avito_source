package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class zzmo {
    private String zzafk;
    private final zzmz zzaso;
    @VisibleForTesting
    private final Map<String, zzmr<zznm>> zzasp;
    private final Map<String, zznk> zzasq;
    private final Context zzrm;
    private final Clock zzsd;

    public zzmo(Context context) {
        this(context, new HashMap(), new zzmz(context), DefaultClock.getInstance());
    }

    public final void zza(String str, @Nullable String str2, @Nullable String str3, List<Integer> list, zzmp zzmp, zzdz zzdz) {
        boolean z;
        Preconditions.checkArgument(!list.isEmpty());
        zzmw zzmw = new zzmw();
        zzfd zzkr = zzfd.zzkr();
        if (zzkr.isPreview()) {
            if (str.equals(zzkr.getContainerId())) {
                z = true;
                zza(zzmw.zza(new zzmk(str, str2, str3, z, zzfd.zzkr().zzks())), Collections.unmodifiableList(list), 0, zzmp, zzdz);
            }
        }
        z = false;
        zza(zzmw.zza(new zzmk(str, str2, str3, z, zzfd.zzkr().zzks())), Collections.unmodifiableList(list), 0, zzmp, zzdz);
    }

    @VisibleForTesting
    private zzmo(Context context, Map<String, zznk> map, zzmz zzmz, Clock clock) {
        this.zzafk = null;
        this.zzasp = new HashMap();
        this.zzrm = context.getApplicationContext();
        this.zzsd = clock;
        this.zzaso = zzmz;
        this.zzasq = map;
    }

    @VisibleForTesting
    public final void zza(zzmw zzmw, List<Integer> list, int i, zzmp zzmp, @Nullable zzdz zzdz) {
        long j;
        int i2 = i;
        while (true) {
            if (i2 == 0) {
                zzev.zzab("Starting to fetch a new resource");
            }
            boolean z = true;
            if (i2 >= list.size()) {
                String valueOf = String.valueOf(zzmw.zzlk().getContainerId());
                String concat = valueOf.length() != 0 ? "There is no valid resource for the container: ".concat(valueOf) : new String("There is no valid resource for the container: ");
                zzev.zzab(concat);
                zzmp.zza(new zzmx(new Status(16, concat), list.get(i2 - 1).intValue()));
                return;
            }
            int intValue = list.get(i2).intValue();
            if (intValue == 0) {
                zzmk zzlk = zzmw.zzlk();
                zzmr<zznm> zzmr = this.zzasp.get(zzlk.getContainerId());
                if (!zzmw.zzlk().zzlg()) {
                    if (zzmr != null) {
                        j = zzmr.zzlj();
                    } else {
                        j = this.zzaso.zzcg(zzlk.getContainerId());
                    }
                    if (j + PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS >= this.zzsd.currentTimeMillis()) {
                        z = false;
                    }
                }
                if (z) {
                    zznk zznk = this.zzasq.get(zzmw.getId());
                    if (zznk == null) {
                        zznk = new zznk();
                        this.zzasq.put(zzmw.getId(), zznk);
                    }
                    String containerId = zzlk.getContainerId();
                    StringBuilder sb = new StringBuilder(a.q0(containerId, 43));
                    sb.append("Attempting to fetch container ");
                    sb.append(containerId);
                    sb.append(" from network");
                    zzev.zzab(sb.toString());
                    zznk.zza(this.zzrm, zzmw, 0, new zzmq(this, 0, zzmw, zzmt.zzasw, list, i2, zzmp, zzdz));
                    return;
                }
                i2++;
            } else if (intValue == 1) {
                zzmk zzlk2 = zzmw.zzlk();
                String containerId2 = zzlk2.getContainerId();
                StringBuilder sb2 = new StringBuilder(a.q0(containerId2, 52));
                sb2.append("Attempting to fetch container ");
                sb2.append(containerId2);
                sb2.append(" from a saved resource");
                zzev.zzab(sb2.toString());
                this.zzaso.zza(zzlk2.zzlf(), new zzmq(this, 1, zzmw, zzmt.zzasw, list, i2, zzmp, null));
                return;
            } else if (intValue == 2) {
                zzmk zzlk3 = zzmw.zzlk();
                String containerId3 = zzlk3.getContainerId();
                StringBuilder sb3 = new StringBuilder(a.q0(containerId3, 56));
                sb3.append("Attempting to fetch container ");
                sb3.append(containerId3);
                sb3.append(" from the default resource");
                zzev.zzab(sb3.toString());
                this.zzaso.zza(zzlk3.zzlf(), zzlk3.zzld(), new zzmq(this, 2, zzmw, zzmt.zzasw, list, i2, zzmp, null));
                return;
            } else {
                throw new UnsupportedOperationException(a.m2(36, "Unknown fetching source: ", i2));
            }
        }
    }

    @VisibleForTesting
    public final void zza(Status status, zzmy zzmy) {
        String containerId = zzmy.zzlp().getContainerId();
        zznm zzlq = zzmy.zzlq();
        if (this.zzasp.containsKey(containerId)) {
            zzmr<zznm> zzmr = this.zzasp.get(containerId);
            zzmr.zzo(this.zzsd.currentTimeMillis());
            if (status == Status.RESULT_SUCCESS) {
                zzmr.zzb(status);
                zzmr.zzp(zzlq);
                return;
            }
            return;
        }
        this.zzasp.put(containerId, new zzmr<>(status, zzlq, this.zzsd.currentTimeMillis()));
    }
}
