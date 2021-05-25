package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class zzo implements zzac {
    private final Map<String, List<zzaa<?>>> zzy = new HashMap();
    private final zzm zzz;

    public zzo(zzm zzm) {
        this.zzz = zzm;
    }

    /* access modifiers changed from: public */
    private final synchronized boolean zzb(zzaa<?> zzaa) {
        String zze = zzaa.zze();
        if (this.zzy.containsKey(zze)) {
            List<zzaa<?>> list = this.zzy.get(zze);
            if (list == null) {
                list = new ArrayList<>();
            }
            zzaa.zzc("waiting-for-response");
            list.add(zzaa);
            this.zzy.put(zze, list);
            if (zzaq.DEBUG) {
                zzaq.d("Request for cacheKey=%s is in flight, putting on hold.", zze);
            }
            return true;
        }
        this.zzy.put(zze, null);
        zzaa.zza((zzac) this);
        if (zzaq.DEBUG) {
            zzaq.d("new request, sending to network %s", zze);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzac
    public final void zza(zzaa<?> zzaa, zzaj<?> zzaj) {
        List<zzaa<?>> remove;
        zzn zzn = zzaj.zzbs;
        if (zzn == null || zzn.zza()) {
            zza(zzaa);
            return;
        }
        String zze = zzaa.zze();
        synchronized (this) {
            remove = this.zzy.remove(zze);
        }
        if (remove != null) {
            if (zzaq.DEBUG) {
                zzaq.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zze);
            }
            for (zzaa<?> zzaa2 : remove) {
                this.zzz.zzo.zzb(zzaa2, zzaj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzac
    public final synchronized void zza(zzaa<?> zzaa) {
        String zze = zzaa.zze();
        List<zzaa<?>> remove = this.zzy.remove(zze);
        if (remove != null && !remove.isEmpty()) {
            if (zzaq.DEBUG) {
                zzaq.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), zze);
            }
            zzaa<?> remove2 = remove.remove(0);
            this.zzy.put(zze, remove);
            remove2.zza((zzac) this);
            try {
                this.zzz.zzm.put(remove2);
            } catch (InterruptedException e) {
                zzaq.e("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.zzz.quit();
            }
        }
    }
}
