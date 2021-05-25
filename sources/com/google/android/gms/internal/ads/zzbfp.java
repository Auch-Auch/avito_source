package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
public final class zzbfp implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzels;

    public zzbfp(JsPromptResult jsPromptResult) {
        this.zzels = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzels.cancel();
    }
}
