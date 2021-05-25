package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
public final class zzapz implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzapx zzdmx;

    public zzapz(zzapx zzapx) {
        this.zzdmx = zzapx;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdmx.zzdx("User canceled the download.");
    }
}
