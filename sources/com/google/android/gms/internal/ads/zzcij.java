package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zza;
import java.util.Map;
import java.util.concurrent.Executor;
public final class zzcij {
    private final zzavu zzboc;
    private final zzeg zzenn;
    private final Executor zzfmk;
    private final zzbtu zzfqj;
    private final zzbur zzfvb;
    private final zzbst zzfvv;
    private final zzbma zzfvw;
    private final zzbyr zzfvy;
    private final zzbui zzgcs;
    private final zzbws zzgct;
    private final zza zzgdh;
    private final zzbto zzgdi;
    private final zzbwl zzgdj;

    public zzcij(zzbst zzbst, zzbtu zzbtu, zzbui zzbui, zzbur zzbur, zzbws zzbws, Executor executor, zzbyr zzbyr, zzbma zzbma, zza zza, zzbto zzbto, @Nullable zzavu zzavu, zzeg zzeg, zzbwl zzbwl) {
        this.zzfvv = zzbst;
        this.zzfqj = zzbtu;
        this.zzgcs = zzbui;
        this.zzfvb = zzbur;
        this.zzgct = zzbws;
        this.zzfmk = executor;
        this.zzfvy = zzbyr;
        this.zzfvw = zzbma;
        this.zzgdh = zza;
        this.zzgdi = zzbto;
        this.zzboc = zzavu;
        this.zzenn = zzeg;
        this.zzgdj = zzbwl;
    }

    public static zzdvt<?> zza(zzbfq zzbfq, String str, String str2) {
        zzbbq zzbbq = new zzbbq();
        zzbfq.zzabe().zza(new zzbhf(zzbbq) { // from class: com.google.android.gms.internal.ads.zzciu
            private final zzbbq zzbvp;

            {
                this.zzbvp = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbhf
            public final void zzak(boolean z) {
                zzbbq zzbbq2 = this.zzbvp;
                if (z) {
                    zzbbq2.set(null);
                } else {
                    zzbbq2.setException(new Exception("Ad Web View failed to load."));
                }
            }
        });
        zzbfq.zzb(str, str2, null);
        return zzbbq;
    }

    public final /* synthetic */ void zzae(View view) {
        this.zzgdh.recordClick();
        zzavu zzavu = this.zzboc;
        if (zzavu != null) {
            zzavu.zzvp();
        }
    }

    public final /* synthetic */ void zzann() {
        this.zzfqj.onAdLeftApplication();
    }

    public final /* synthetic */ void zzano() {
        this.zzfvv.onAdClicked();
    }

    public final void zzb(zzbfq zzbfq, boolean z) {
        zzdw zzca;
        zzbfq.zzabe().zza(new zzut(this) { // from class: com.google.android.gms.internal.ads.zzcim
            private final zzcij zzgdl;

            {
                this.zzgdl = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzut
            public final void onAdClicked() {
                this.zzgdl.zzano();
            }
        }, this.zzgcs, this.zzfvb, new zzagn(this) { // from class: com.google.android.gms.internal.ads.zzcil
            private final zzcij zzgdl;

            {
                this.zzgdl = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzagn
            public final void onAppEvent(String str, String str2) {
                this.zzgdl.zzp(str, str2);
            }
        }, new zzt(this) { // from class: com.google.android.gms.internal.ads.zzcio
            private final zzcij zzgdl;

            {
                this.zzgdl = r1;
            }

            @Override // com.google.android.gms.ads.internal.overlay.zzt
            public final void zzuz() {
                this.zzgdl.zzann();
            }
        }, z, null, this.zzgdh, new zzcit(this), this.zzboc);
        zzbfq.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.google.android.gms.internal.ads.zzcin
            private final zzcij zzgdl;

            {
                this.zzgdl = r1;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.zzgdl.zza(view, motionEvent);
            }
        });
        zzbfq.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.gms.internal.ads.zzciq
            private final zzcij zzgdl;

            {
                this.zzgdl = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.zzgdl.zzae(view);
            }
        });
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcqn)).booleanValue() && (zzca = this.zzenn.zzca()) != null) {
            zzca.zzb(zzbfq.getView());
        }
        this.zzfvy.zza(zzbfq, this.zzfmk);
        this.zzfvy.zza(new zzqu(zzbfq) { // from class: com.google.android.gms.internal.ads.zzcip
            private final zzbfq zzepi;

            {
                this.zzepi = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzqu
            public final void zza(zzqr zzqr) {
                zzbhc zzabe = this.zzepi.zzabe();
                Rect rect = zzqr.zzbrq;
                zzabe.zza(rect.left, rect.top, false);
            }
        }, this.zzfmk);
        this.zzfvy.zzv(zzbfq.getView());
        zzbfq.zza("/trackActiveViewUnit", new zzahf(this, zzbfq) { // from class: com.google.android.gms.internal.ads.zzcis
            private final zzbfq zzgak;
            private final zzcij zzgdl;

            {
                this.zzgdl = r1;
                this.zzgak = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzahf
            public final void zza(Object obj, Map map) {
                this.zzgdl.zza(this.zzgak, (zzbfq) obj, map);
            }
        });
        this.zzfvw.zzo(zzbfq);
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcnx)).booleanValue()) {
            this.zzgdi.zza(zzcir.zzn(zzbfq), this.zzfmk);
        }
    }

    public final /* synthetic */ void zzp(String str, String str2) {
        this.zzgct.onAppEvent(str, str2);
    }

    public final /* synthetic */ void zza(zzbfq zzbfq, zzbfq zzbfq2, Map map) {
        this.zzfvw.zzf(zzbfq);
    }

    public final /* synthetic */ boolean zza(View view, MotionEvent motionEvent) {
        this.zzgdh.recordClick();
        zzavu zzavu = this.zzboc;
        if (zzavu == null) {
            return false;
        }
        zzavu.zzvp();
        return false;
    }
}
