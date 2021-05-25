package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_vision_common.zzcq;
import com.google.android.gms.internal.mlkit_vision_common.zzr;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
public class zzcm implements zzcq.zzb {
    public static final Component<?> zza = Component.builder(zzcm.class).add(Dependency.required(Context.class)).factory(zzcl.zza).build();
    private static final GmsLogger zzb = new GmsLogger("ClearcutTransport", "");
    private final ClearcutLogger zzc;

    public zzcm(Context context) {
        this.zzc = ClearcutLogger.anonymousLogger(context, "FIREBASE_ML_SDK");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzcq.zzb
    public final void zza(zzr.zzad zzad) {
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
