package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzp;
public final class zzazj implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzazg zzebi;

    public zzazj(zzazg zzazg) {
        this.zzebi = zzazg;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        zzp.zzkp();
        zzayh.zza(this.zzebi.val$context, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
