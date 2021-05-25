package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;
public final class zzbfn implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzelr;

    public zzbfn(JsResult jsResult) {
        this.zzelr = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzelr.confirm();
    }
}
