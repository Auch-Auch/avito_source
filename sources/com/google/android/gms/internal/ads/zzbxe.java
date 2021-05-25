package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
public class zzbxe<ListenerT> {
    @GuardedBy("this")
    private final Map<ListenerT, Executor> zzfts = new HashMap();

    public zzbxe(Set<zzbys<ListenerT>> set) {
        zzb(set);
    }

    private final synchronized void zzb(Set<zzbys<ListenerT>> set) {
        for (zzbys<ListenerT> zzbys : set) {
            zza(zzbys);
        }
    }

    public final synchronized void zza(zzbys<ListenerT> zzbys) {
        zza(zzbys.zzfum, zzbys.executor);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.zzfts.put(listenert, executor);
    }

    public final synchronized void zza(zzbxg<ListenerT> zzbxg) {
        for (Map.Entry<ListenerT, Executor> entry : this.zzfts.entrySet()) {
            entry.getValue().execute(new Runnable(zzbxg, entry.getKey()) { // from class: com.google.android.gms.internal.ads.zzbxh
                private final Object zzdij;
                private final zzbxg zzftt;

                {
                    this.zzftt = r1;
                    this.zzdij = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.zzftt.zzp(this.zzdij);
                    } catch (Throwable th) {
                        zzp.zzkt().zzb(th, "EventEmitter.notify");
                        zzaxy.zza("Event emitter exception.", th);
                    }
                }
            });
        }
    }
}
