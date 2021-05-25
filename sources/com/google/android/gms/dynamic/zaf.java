package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
public final class zaf implements View.OnClickListener {
    private final /* synthetic */ Context zaa;
    private final /* synthetic */ Intent zab;

    public zaf(Context context, Intent intent) {
        this.zaa = context;
        this.zab = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.zaa.startActivity(this.zab);
        } catch (ActivityNotFoundException unused) {
        }
    }
}
