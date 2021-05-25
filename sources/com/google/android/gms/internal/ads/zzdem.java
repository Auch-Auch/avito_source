package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
public final class zzdem<T> {
    private final Executor executor;
    private final Set<zzden<? extends zzdek<T>>> zzgvi;

    public zzdem(Executor executor2, Set<zzden<? extends zzdek<T>>> set) {
        this.executor = executor2;
        this.zzgvi = set;
    }

    public final zzdvt<T> zzt(T t) {
        ArrayList arrayList = new ArrayList(this.zzgvi.size());
        for (zzden<? extends zzdek<T>> zzden : this.zzgvi) {
            zzdvt<? extends zzdek<T>> zzaqs = zzden.zzaqs();
            if (zzacn.zzdaw.get().booleanValue()) {
                zzaqs.addListener(new Runnable(zzden, zzp.zzkw().elapsedRealtime()) { // from class: com.google.android.gms.internal.ads.zzdep
                    private final zzden zzgvj;
                    private final long zzgvk;

                    {
                        this.zzgvj = r1;
                        this.zzgvk = r2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzden zzden2 = this.zzgvj;
                        long j = this.zzgvk;
                        String canonicalName = zzden2.getClass().getCanonicalName();
                        long elapsedRealtime = zzp.zzkw().elapsedRealtime() - j;
                        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
                        sb.append("Signal runtime : ");
                        sb.append(canonicalName);
                        sb.append(" = ");
                        sb.append(elapsedRealtime);
                        zzaxy.zzei(sb.toString());
                    }
                }, zzbbi.zzedz);
            }
            arrayList.add(zzaqs);
        }
        return zzdvl.zzk(arrayList).zza(new Callable(arrayList, t) { // from class: com.google.android.gms.internal.ads.zzdeo
            private final Object zzdij;
            private final List zzgup;

            {
                this.zzgup = r1;
                this.zzdij = r2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                List<zzdvt> list = this.zzgup;
                Object obj = this.zzdij;
                for (zzdvt zzdvt : list) {
                    zzdek zzdek = (zzdek) zzdvt.get();
                    if (zzdek != null) {
                        zzdek.zzs(obj);
                    }
                }
                return obj;
            }
        }, this.executor);
    }
}
