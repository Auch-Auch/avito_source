package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzp;
public final class zzapu implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzapr zzdmg;

    public zzapu(zzapr zzapr) {
        this.zzdmg = zzapr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent createIntent = this.zzdmg.createIntent();
        zzp.zzkp();
        zzayh.zza(this.zzdmg.zzvr, createIntent);
    }
}
