package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
public final class zzbfm implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsPromptResult zzels;

    public zzbfm(JsPromptResult jsPromptResult) {
        this.zzels = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzels.cancel();
    }
}
