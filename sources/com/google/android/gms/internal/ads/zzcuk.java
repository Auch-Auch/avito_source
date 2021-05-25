package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public final class zzcuk<AdT> implements zzduv<zzdlj, AdT> {
    private final Executor executor;
    private final zzdps zzfli;
    private final ScheduledExecutorService zzfnh;
    private final zzdpf zzfqo;
    private final zzbsx zzfue;
    private final zzbpi<AdT> zzgnm;
    private final zzcud zzgnn;

    public zzcuk(zzdpf zzdpf, zzcud zzcud, zzbsx zzbsx, zzdps zzdps, zzbpi<AdT> zzbpi, Executor executor2, ScheduledExecutorService scheduledExecutorService) {
        this.zzfqo = zzdpf;
        this.zzgnn = zzcud;
        this.zzfue = zzbsx;
        this.zzfli = zzdps;
        this.zzgnm = zzbpi;
        this.executor = executor2;
        this.zzfnh = scheduledExecutorService;
    }

    public final /* synthetic */ zzdvt zza(zzdlj zzdlj, zzdkx zzdkx, zzcre zzcre, Throwable th) throws Exception {
        return this.zzgnn.zza(zzdlj.zzhbq.zzhbn, zzdkx, zzdvl.zza(zzcre.zzb(zzdlj, zzdkx), (long) zzdkx.zzhax, TimeUnit.MILLISECONDS, this.zzfnh));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduv
    public final /* synthetic */ zzdvt zzf(zzdlj zzdlj) throws Exception {
        zzdlj zzdlj2 = zzdlj;
        zzdos zzauz = this.zzfqo.zzu(zzdpg.RENDER_CONFIG_INIT).zze(zzdvl.immediateFailedFuture(new zzcuh(zzdmd.zzhcq, "No ad config."))).zzauz();
        this.zzfue.zza(new zzblo(zzdlj2, this.zzfli), this.executor);
        int i = 0;
        for (zzdkx zzdkx : zzdlj2.zzhbq.zzhbm) {
            Iterator<String> it = zzdkx.zzhaf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                zzcre<AdT> zze = this.zzgnm.zze(zzdkx.zzhag, next);
                if (zze != null && zze.zza(zzdlj2, zzdkx)) {
                    zzdox zza = this.zzfqo.zza((zzdpf) zzdpg.RENDER_CONFIG_WATERFALL, (zzdvt) zzauz);
                    StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 26);
                    sb.append("render-config-");
                    sb.append(i);
                    sb.append("-");
                    sb.append(next);
                    zzauz = zza.zzgx(sb.toString()).zza(Throwable.class, new zzduv(this, zzdlj2, zzdkx, zze) { // from class: com.google.android.gms.internal.ads.zzcuj
                        private final zzdkx zzfoo;
                        private final zzdlj zzgbj;
                        private final zzcuk zzgnk;
                        private final zzcre zzgnl;

                        {
                            this.zzgnk = r1;
                            this.zzgbj = r2;
                            this.zzfoo = r3;
                            this.zzgnl = r4;
                        }

                        @Override // com.google.android.gms.internal.ads.zzduv
                        public final zzdvt zzf(Object obj) {
                            return this.zzgnk.zza(this.zzgbj, this.zzfoo, this.zzgnl, (Throwable) obj);
                        }
                    }).zzauz();
                    break;
                }
            }
            i++;
        }
        return zzauz;
    }
}
