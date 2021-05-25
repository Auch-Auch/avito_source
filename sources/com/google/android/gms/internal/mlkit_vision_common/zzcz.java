package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzcz;
import com.google.android.gms.internal.mlkit_vision_common.zzda;
public abstract class zzcz<MessageType extends zzda<MessageType, BuilderType>, BuilderType extends zzcz<MessageType, BuilderType>> implements zzfu {
    public abstract BuilderType zza(MessageType messagetype);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.mlkit_vision_common.zzcz<MessageType extends com.google.android.gms.internal.mlkit_vision_common.zzda<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.mlkit_vision_common.zzcz<MessageType, BuilderType>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfu
    public final /* synthetic */ zzfu zza(zzfr zzfr) {
        if (zzi().getClass().isInstance(zzfr)) {
            return zza((zzcz<MessageType, BuilderType>) ((zzda) zzfr));
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    /* renamed from: zzb */
    public abstract BuilderType clone();
}
