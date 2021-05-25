package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;
public final class zzbfk implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzelr;

    public zzbfk(JsResult jsResult) {
        this.zzelr = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzelr.cancel();
    }
}
