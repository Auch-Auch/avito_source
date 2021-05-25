package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import com.google.android.gms.internal.ads.zzeeu;
import com.google.android.gms.internal.ads.zzeev;
import java.io.IOException;
public abstract class zzeeu<MessageType extends zzeev<MessageType, BuilderType>, BuilderType extends zzeeu<MessageType, BuilderType>> implements zzeic {
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzefq zzefq, zzegc zzegc) throws IOException;

    public BuilderType zza(byte[] bArr, int i, int i2, zzegc zzegc) throws zzegz {
        try {
            zzefq zzb = zzefq.zzb(bArr, 0, i2, false);
            zza(zzb, zzegc);
            zzb.zzfy(0);
            return this;
        } catch (zzegz e) {
            throw e;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder K = a.K("byte array".length() + name.length() + 60, "Reading ", name, " from a ", "byte array");
            K.append(" threw an IOException (should never happen).");
            throw new RuntimeException(K.toString(), e2);
        }
    }

    /* renamed from: zzbcz */
    public abstract BuilderType clone();

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.ads.zzeeu<MessageType extends com.google.android.gms.internal.ads.zzeev<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.ads.zzeeu<MessageType, BuilderType>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzeic
    public final /* synthetic */ zzeic zzf(zzehz zzehz) {
        if (zzbfr().getClass().isInstance(zzehz)) {
            return zza((zzeev) zzehz);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
