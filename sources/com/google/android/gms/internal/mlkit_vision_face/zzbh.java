package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;
import java.util.Set;
public final class zzbh {
    public static boolean zza(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }
}
