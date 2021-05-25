package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
public final class zzed extends zzdy {
    private zzed(Context context, String str, boolean z, int i) {
        super(context, str, z, i);
    }

    public static zzed zzb(String str, Context context, boolean z) {
        return zzb(str, context, false, zzcw.zznj);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final List<Callable<Void>> zza(zzex zzex, Context context, zzcf.zza.C0192zza zza, zzby.zza zza2) {
        if (zzex.zzcg() == null || !this.zzxj) {
            return super.zza(zzex, context, zza, zza2);
        }
        int zzbu = zzex.zzbu();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zza(zzex, context, zza, zza2));
        arrayList.add(new zzfr(zzex, "mLW4WfBtN0b1ZboDT/Xcg0iQ140V7G6lHXVBVeBNgLy2jqsT86h2d5npN9bwHugA", "7PTXHfesCwrygeE6a5SpFPYapA+6N5AjzCxH/Yeev9s=", zza, zzbu, 24));
        return arrayList;
    }

    public static zzed zzb(String str, Context context, boolean z, int i) {
        zzdy.zza(context, z);
        zzdy.zza(str, context, z, i);
        return new zzed(context, str, z, i);
    }
}
