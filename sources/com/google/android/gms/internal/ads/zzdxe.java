package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
public final class zzdxe {
    private static final CopyOnWriteArrayList<zzdxb> zzhqy = new CopyOnWriteArrayList<>();

    public static zzdxb zzhl(String str) throws GeneralSecurityException {
        Iterator<zzdxb> it = zzhqy.iterator();
        while (it.hasNext()) {
            zzdxb next = it.next();
            if (next.zzhj(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
