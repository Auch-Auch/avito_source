package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_vision_face.zzbm;
import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
public class zzeh implements zzel.zzb {
    public static final Component<?> zza = Component.builder(zzeh.class).add(Dependency.required(Context.class)).factory(zzeg.zza).build();
    private static final GmsLogger zzb = new GmsLogger("ClearcutTransport", "");
    private final ClearcutLogger zzc;

    public zzeh(Context context) {
        this.zzc = ClearcutLogger.anonymousLogger(context, "FIREBASE_ML_SDK");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzel.zzb
    public final void zza(zzbm.zzad zzad) {
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
