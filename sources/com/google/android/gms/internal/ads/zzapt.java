package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
public final class zzapt implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzapr zzdmg;

    public zzapt(zzapr zzapr) {
        this.zzdmg = zzapr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdmg.zzdx("Operation denied by user.");
    }
}
