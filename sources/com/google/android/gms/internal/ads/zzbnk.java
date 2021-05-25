package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.concurrent.Executor;
public final class zzbnk extends zzbni {
    private final View view;
    @Nullable
    private final zzbfq zzdgc;
    private final Executor zzfmk;
    private final zzdkw zzfnm;
    private final zzbpe zzfoc;
    private final zzcdg zzfod;
    private final zzbyw zzfoe;
    private final zzeli<zzcwz> zzfof;
    private zzvj zzfog;
    private final Context zzvr;

    public zzbnk(zzbpg zzbpg, Context context, zzdkw zzdkw, View view2, @Nullable zzbfq zzbfq, zzbpe zzbpe, zzcdg zzcdg, zzbyw zzbyw, zzeli<zzcwz> zzeli, Executor executor) {
        super(zzbpg);
        this.zzvr = context;
        this.view = view2;
        this.zzdgc = zzbfq;
        this.zzfnm = zzdkw;
        this.zzfoc = zzbpe;
        this.zzfod = zzcdg;
        this.zzfoe = zzbyw;
        this.zzfof = zzeli;
        this.zzfmk = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final zzyg getVideoController() {
        try {
            return this.zzfoc.getVideoController();
        } catch (zzdlr unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final void zza(ViewGroup viewGroup, zzvj zzvj) {
        zzbfq zzbfq;
        if (viewGroup != null && (zzbfq = this.zzdgc) != null) {
            zzbfq.zza(zzbhj.zzb(zzvj));
            viewGroup.setMinimumHeight(zzvj.heightPixels);
            viewGroup.setMinimumWidth(zzvj.widthPixels);
            this.zzfog = zzvj;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final zzdkw zzahp() {
        boolean z;
        zzvj zzvj = this.zzfog;
        if (zzvj != null) {
            return zzdls.zzf(zzvj);
        }
        zzdkx zzdkx = this.zzfpf;
        if (zzdkx.zzhba) {
            Iterator<String> it = zzdkx.zzhaf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (next != null && next.contains("FirstParty")) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return new zzdkw(this.view.getWidth(), this.view.getHeight(), false);
            }
        }
        return zzdls.zza(this.zzfpf.zzhan, this.zzfnm);
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final View zzahq() {
        return this.view;
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final zzdkw zzahu() {
        return this.zzfnm;
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final int zzahv() {
        return this.zzflg.zzhbq.zzhbn.zzhbe;
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzahw() {
        this.zzfmk.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbnj
            private final zzbnk zzfob;

            {
                this.zzfob = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfob.zzahx();
            }
        });
        super.zzahw();
    }

    public final /* synthetic */ void zzahx() {
        if (this.zzfod.zzamf() != null) {
            try {
                this.zzfod.zzamf().zza(this.zzfof.get(), ObjectWrapper.wrap(this.zzvr));
            } catch (RemoteException e) {
                zzbbd.zzc("RemoteException when notifyAdLoad is called", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final void zzkd() {
        this.zzfoe.zzaki();
    }
}
