package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import com.google.android.gms.internal.gtm.zzpl;
import com.google.android.gms.internal.gtm.zzpm;
import java.io.IOException;
public abstract class zzpl<MessageType extends zzpl<MessageType, BuilderType>, BuilderType extends zzpm<MessageType, BuilderType>> implements zzsk {
    private static boolean zzavq = false;
    public int zzavp = 0;

    public void zzag(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final zzps zzmv() {
        try {
            zzqa zzam = zzps.zzam(zzpe());
            zzb(zzam.zznh());
            return zzam.zzng();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder K = a.K("ByteString".length() + name.length() + 62, "Serializing ", name, " to a ", "ByteString");
            K.append(" threw an IOException (should never happen).");
            throw new RuntimeException(K.toString(), e);
        }
    }

    public int zzmw() {
        throw new UnsupportedOperationException();
    }
}
