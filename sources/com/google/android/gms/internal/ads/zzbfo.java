package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;
public final class zzbfo implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzels;
    private final /* synthetic */ EditText zzelt;

    public zzbfo(JsPromptResult jsPromptResult, EditText editText) {
        this.zzels = jsPromptResult;
        this.zzelt = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzels.confirm(this.zzelt.getText().toString());
    }
}
