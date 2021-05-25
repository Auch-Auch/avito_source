package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzec {
    public static int zzf(@NullableDecl Object obj) {
        return zzx(obj == null ? 0 : obj.hashCode());
    }

    public static int zzx(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * -862048943), 15)) * 461845907);
    }
}
