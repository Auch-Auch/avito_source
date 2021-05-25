package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzalu {
    @VisibleForTesting
    private static final zzazm<zzajx> zzdhv = new zzalt();
    @VisibleForTesting
    private static final zzazm<zzajx> zzdhw = new zzalw();
    private final zzakk zzdhx;

    public zzalu(Context context, zzbbg zzbbg, String str) {
        this.zzdhx = new zzakk(context, zzbbg, str, zzdhv, zzdhw);
    }

    public final <I, O> zzalm<I, O> zza(String str, zzaln<I> zzaln, zzalo<O> zzalo) {
        return new zzalv(this.zzdhx, str, zzaln, zzalo);
    }

    public final zzalz zztl() {
        return new zzalz(this.zzdhx);
    }
}
