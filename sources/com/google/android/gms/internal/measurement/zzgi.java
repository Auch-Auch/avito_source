package com.google.android.gms.internal.measurement;

import a2.b.a.a.a;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgj;
import java.io.IOException;
public abstract class zzgi<MessageType extends zzgj<MessageType, BuilderType>, BuilderType extends zzgi<MessageType, BuilderType>> implements zzjm {
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzhf zzhf, zzho zzho) throws IOException;

    public BuilderType zza(byte[] bArr, int i, int i2) throws zzij {
        try {
            zzhf zza = zzhf.zza(bArr, 0, i2, false);
            zza(zza, zzho.zza());
            zza.zza(0);
            return this;
        } catch (zzij e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    /* renamed from: zzp */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzho zzho) throws zzij {
        try {
            zzhf zza = zzhf.zza(bArr, 0, i2, false);
            zza(zza, zzho);
            zza.zza(0);
            return this;
        } catch (zzij e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    private final String zza(String str) {
        String name = getClass().getName();
        StringBuilder K = a.K(a.q0(str, name.length() + 60), "Reading ", name, " from a ", str);
        K.append(" threw an IOException (should never happen).");
        return K.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.measurement.zzgi<MessageType extends com.google.android.gms.internal.measurement.zzgj<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.measurement.zzgi<MessageType, BuilderType>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzjm
    public final /* synthetic */ zzjm zza(zzjj zzjj) {
        if (h_().getClass().isInstance(zzjj)) {
            return zza((zzgi<MessageType, BuilderType>) ((zzgj) zzjj));
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final /* synthetic */ zzjm zza(byte[] bArr, zzho zzho) throws zzij {
        return zza(bArr, 0, bArr.length, zzho);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final /* synthetic */ zzjm zza(byte[] bArr) throws zzij {
        return zza(bArr, 0, bArr.length);
    }
}
