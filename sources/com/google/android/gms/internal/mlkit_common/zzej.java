package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzeg;
import com.google.android.gms.internal.mlkit_common.zzej;
public abstract class zzej<MessageType extends zzeg<MessageType, BuilderType>, BuilderType extends zzej<MessageType, BuilderType>> implements zzha {
    public abstract BuilderType zza(MessageType messagetype);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.mlkit_common.zzej<MessageType extends com.google.android.gms.internal.mlkit_common.zzeg<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.mlkit_common.zzej<MessageType, BuilderType>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_common.zzha
    public final /* synthetic */ zzha zza(zzhb zzhb) {
        if (zzn().getClass().isInstance(zzhb)) {
            return zza((zzej<MessageType, BuilderType>) ((zzeg) zzhb));
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    /* renamed from: zzb */
    public abstract BuilderType clone();
}
