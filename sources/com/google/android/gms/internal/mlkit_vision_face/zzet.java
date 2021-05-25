package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzet;
import com.google.android.gms.internal.mlkit_vision_face.zzeu;
public abstract class zzet<MessageType extends zzeu<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> implements zzho {
    public abstract BuilderType zza(MessageType messagetype);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.mlkit_vision_face.zzet<MessageType extends com.google.android.gms.internal.mlkit_vision_face.zzeu<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.mlkit_vision_face.zzet<MessageType, BuilderType>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_face.zzho
    public final /* synthetic */ zzho zza(zzhl zzhl) {
        if (zzi().getClass().isInstance(zzhl)) {
            return zza((zzet<MessageType, BuilderType>) ((zzeu) zzhl));
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    /* renamed from: zzb */
    public abstract BuilderType clone();
}
