package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;
public final class zzbma implements zzo, zzbtm, zzbtp, zzqu {
    private final Clock zzbpw;
    private final zzblr zzfmg;
    private final zzbly zzfmh;
    private final Set<zzbfq> zzfmi = new HashSet();
    private final zzamg<JSONObject, JSONObject> zzfmj;
    private final Executor zzfmk;
    private final AtomicBoolean zzfml = new AtomicBoolean(false);
    @GuardedBy("this")
    private final zzbmc zzfmm = new zzbmc();
    private boolean zzfmn = false;
    private WeakReference<?> zzfmo = new WeakReference<>(this);

    public zzbma(zzalz zzalz, zzbly zzbly, Executor executor, zzblr zzblr, Clock clock) {
        this.zzfmg = zzblr;
        zzalq<JSONObject> zzalq = zzalp.zzdhs;
        this.zzfmj = zzalz.zzb("google.afma.activeView.handleUpdate", zzalq, zzalq);
        this.zzfmh = zzbly;
        this.zzfmk = executor;
        this.zzbpw = clock;
    }

    private final void zzagz() {
        for (zzbfq zzbfq : this.zzfmi) {
            this.zzfmg.zze(zzbfq);
        }
        this.zzfmg.zzagx();
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final synchronized void onAdImpression() {
        if (this.zzfml.compareAndSet(false, true)) {
            this.zzfmg.zza(this);
            zzagy();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onPause() {
        this.zzfmm.zzfmt = true;
        zzagy();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onResume() {
        this.zzfmm.zzfmt = false;
        zzagy();
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final synchronized void zza(zzqr zzqr) {
        zzbmc zzbmc = this.zzfmm;
        zzbmc.zzbrk = zzqr.zzbrk;
        zzbmc.zzfmw = zzqr;
        zzagy();
    }

    public final synchronized void zzagy() {
        if (!(this.zzfmo.get() != null)) {
            zzaha();
            return;
        }
        if (!this.zzfmn && this.zzfml.get()) {
            try {
                this.zzfmm.timestamp = this.zzbpw.elapsedRealtime();
                JSONObject zza = this.zzfmh.zzj(this.zzfmm);
                for (zzbfq zzbfq : this.zzfmi) {
                    this.zzfmk.execute(new Runnable(zzbfq, zza) { // from class: com.google.android.gms.internal.ads.zzblz
                        private final zzbfq zzepi;
                        private final JSONObject zzfmf;

                        {
                            this.zzepi = r1;
                            this.zzfmf = r2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzepi.zza("AFMA_updateActiveView", this.zzfmf);
                        }
                    });
                }
                zzbbm.zzb(this.zzfmj.zzf(zza), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e) {
                zzaxy.zza("Failed to call ActiveViewJS", e);
            }
        }
    }

    public final synchronized void zzaha() {
        zzagz();
        this.zzfmn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final synchronized void zzbz(@Nullable Context context) {
        this.zzfmm.zzfmt = true;
        zzagy();
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final synchronized void zzca(@Nullable Context context) {
        this.zzfmm.zzfmt = false;
        zzagy();
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final synchronized void zzcb(@Nullable Context context) {
        this.zzfmm.zzfmv = "u";
        zzagy();
        zzagz();
        this.zzfmn = true;
    }

    public final synchronized void zzf(zzbfq zzbfq) {
        this.zzfmi.add(zzbfq);
        this.zzfmg.zzd(zzbfq);
    }

    public final void zzo(Object obj) {
        this.zzfmo = new WeakReference<>(obj);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzui() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzuj() {
    }
}
