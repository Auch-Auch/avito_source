package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
public final class zzczi implements zzden<zzczj> {
    private final zzdln zzfqn;
    private final zzdvw zzgse;
    private final View zzgsf;
    private final Context zzvr;

    public zzczi(zzdvw zzdvw, Context context, zzdln zzdln, @Nullable ViewGroup viewGroup) {
        this.zzgse = zzdvw;
        this.zzvr = context;
        this.zzfqn = zzdln;
        this.zzgsf = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzczj> zzaqs() {
        return this.zzgse.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzczl
            private final zzczi zzgsi;

            {
                this.zzgsi = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgsi.zzaqt();
            }
        });
    }

    public final /* synthetic */ zzczj zzaqt() throws Exception {
        Context context = this.zzvr;
        zzvj zzvj = this.zzfqn.zzbpb;
        ArrayList arrayList = new ArrayList();
        View view = this.zzgsf;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int i = -1;
            if (parent instanceof ViewGroup) {
                i = ((ViewGroup) parent).indexOfChild(view);
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzczj(context, zzvj, arrayList);
    }
}
