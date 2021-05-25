package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import com.google.android.gms.internal.vision.zzge;
import com.google.android.gms.internal.vision.zzgh;
import java.io.IOException;
public abstract class zzgh<MessageType extends zzge<MessageType, BuilderType>, BuilderType extends zzgh<MessageType, BuilderType>> implements zzjm {
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzhe zzhe, zzho zzho) throws IOException;

    public BuilderType zza(byte[] bArr, int i, int i2, zzho zzho) throws zzin {
        try {
            zzhe zza = zzhe.zza(bArr, 0, i2, false);
            zza(zza, zzho);
            zza.zzax(0);
            return this;
        } catch (zzin e) {
            throw e;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder K = a.K("byte array".length() + name.length() + 60, "Reading ", name, " from a ", "byte array");
            K.append(" threw an IOException (should never happen).");
            throw new RuntimeException(K.toString(), e2);
        }
    }

    /* renamed from: zzeh */
    public abstract BuilderType clone();

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.vision.zzgh<MessageType extends com.google.android.gms.internal.vision.zzge<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.vision.zzgh<MessageType, BuilderType>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzjm
    public final /* synthetic */ zzjm zza(zzjn zzjn) {
        if (zzgx().getClass().isInstance(zzjn)) {
            return zza((zzgh<MessageType, BuilderType>) ((zzge) zzjn));
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
