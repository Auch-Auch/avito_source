package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
public final class zzbhg extends MutableContextWrapper {
    private Context zzaai;
    private Activity zzecv;
    private Context zzepo;

    public zzbhg(Context context) {
        super(context);
        setBaseContext(context);
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public final Object getSystemService(String str) {
        return this.zzepo.getSystemService(str);
    }

    @Override // android.content.MutableContextWrapper
    public final void setBaseContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.zzaai = applicationContext;
        this.zzecv = context instanceof Activity ? (Activity) context : null;
        this.zzepo = context;
        super.setBaseContext(applicationContext);
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public final void startActivity(Intent intent) {
        Activity activity = this.zzecv;
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.zzaai.startActivity(intent);
    }

    public final Context zzaaz() {
        return this.zzepo;
    }

    public final Activity zzzq() {
        return this.zzecv;
    }
}
