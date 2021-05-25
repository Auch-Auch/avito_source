package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzav;
import com.google.android.gms.internal.mlkit_common.zzds;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
public class zzdo implements zzds.zza {
    public static final Component<?> zza = Component.builder(zzdo.class).add(Dependency.required(Context.class)).factory(zzdn.zza).build();
    private static final GmsLogger zzb = new GmsLogger("ClearcutTransport", "");
    private final ClearcutLogger zzc;

    public zzdo(Context context) {
        this.zzc = ClearcutLogger.anonymousLogger(context, "FIREBASE_ML_SDK");
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzds.zza
    public final void zza(zzav.zzad zzad) {
        GmsLogger gmsLogger = zzb;
        String valueOf = String.valueOf(zzad);
        StringBuilder sb = new StringBuilder(valueOf.length() + 30);
        sb.append("Logging FirebaseMlSdkLogEvent ");
        sb.append(valueOf);
        gmsLogger.d("ClearcutTransport", sb.toString());
        try {
            this.zzc.newEvent(zzad.zzf()).log();
        } catch (SecurityException e) {
            zzb.e("ClearcutTransport", "Exception thrown from the logging side", e);
        }
    }
}
