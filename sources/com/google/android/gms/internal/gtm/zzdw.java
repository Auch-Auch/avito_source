package com.google.android.gms.internal.gtm;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
public final class zzdw implements zzmp, Runnable {
    private final /* synthetic */ zzdq zzanc;

    private zzdw(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public final void run() {
        Preconditions.checkState(this.zzanc.state == 2);
        if (!zzfd.zzkr().zzbw(this.zzanc.zzaec)) {
            String str = this.zzanc.zzaec;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24);
            sb.append("Refreshing container ");
            sb.append(str);
            sb.append("...");
            zzev.zzab(sb.toString());
            ArrayList arrayList = new ArrayList();
            arrayList.add(0);
            this.zzanc.zzamu.zza(this.zzanc.zzaec, this.zzanc.zzams, this.zzanc.zzamr, arrayList, this, this.zzanc.zzamy);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzmp
    public final void zza(zzmx zzmx) {
        if (zzmx.getStatus() == Status.RESULT_SUCCESS) {
            String str = this.zzanc.zzaec;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
            sb.append("Refreshed container ");
            sb.append(str);
            sb.append(". Reinitializing runtime...");
            zzev.zzab(sb.toString());
            this.zzanc.zzamv.execute(new zzdx(this.zzanc, zzmx));
            return;
        }
        zzdq zzdq = this.zzanc;
        zzdq.zzn(zzdq.zzamy.zzhm());
    }

    public /* synthetic */ zzdw(zzdq zzdq, zzdr zzdr) {
        this(zzdq);
    }
}
