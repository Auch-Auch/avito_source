package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;
public class zzarh {
    @GuardedBy("InternalQueryInfoGenerator.class")
    private static zzawu zzdph;
    @Nullable
    private final zzyo zzacu;
    private final AdFormat zzdpg;
    private final Context zzvr;

    public zzarh(Context context, AdFormat adFormat, @Nullable zzyo zzyo) {
        this.zzvr = context;
        this.zzdpg = adFormat;
        this.zzacu = zzyo;
    }

    @Nullable
    public static zzawu zzs(Context context) {
        zzawu zzawu;
        synchronized (zzarh.class) {
            if (zzdph == null) {
                zzdph = zzwe.zzpr().zza(context, new zzamr());
            }
            zzawu = zzdph;
        }
        return zzawu;
    }

    public final void zza(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzvc zzvc;
        zzawu zzs = zzs(this.zzvr);
        if (zzs == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzvr);
        zzyo zzyo = this.zzacu;
        if (zzyo == null) {
            zzvc = new zzvf().zzph();
        } else {
            zzvc = zzvh.zza(this.zzvr, zzyo);
        }
        try {
            zzs.zza(wrap, new zzaxa(null, this.zzdpg.name(), null, zzvc), new zzarg(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
