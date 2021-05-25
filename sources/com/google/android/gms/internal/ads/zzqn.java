package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.WeakHashMap;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzqn {
    private final Object lock = new Object();
    private final Context zzaai;
    private final zzbbg zzbpa;
    private final WeakHashMap<Object, Object> zzbqu = new WeakHashMap<>();
    private final ArrayList<Object> zzbqv = new ArrayList<>();
    private final zzakk zzbqw;

    public zzqn(Context context, zzbbg zzbbg) {
        this.zzaai = context.getApplicationContext();
        this.zzbpa = zzbbg;
        this.zzbqw = new zzakk(context.getApplicationContext(), zzbbg, (String) zzwe.zzpu().zzd(zzaat.zzclj));
    }
}
