package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
public final class zzedb extends ThreadLocal<Cipher> {
    private static Cipher zzbcr() {
        try {
            return zzedt.zzhzm.zzhs("AES/GCM/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.lang.ThreadLocal
    public final /* synthetic */ Cipher initialValue() {
        return zzbcr();
    }
}
