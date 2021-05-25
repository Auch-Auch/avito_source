package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;
public final class zzbfl implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsResult zzelr;

    public zzbfl(JsResult jsResult) {
        this.zzelr = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzelr.cancel();
    }
}
