package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdsq {
    private final String className;
    private final zzdsp zzhlo;
    private zzdsp zzhlp;
    private boolean zzhlq;

    private zzdsq(String str) {
        zzdsp zzdsp = new zzdsp();
        this.zzhlo = zzdsp;
        this.zzhlp = zzdsp;
        this.zzhlq = false;
        this.className = (String) zzdsv.checkNotNull(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        zzdsp zzdsp = this.zzhlo.zzhln;
        String str = "";
        while (zzdsp != null) {
            Object obj = zzdsp.value;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
            }
            zzdsp = zzdsp.zzhln;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzdsq zzy(@NullableDecl Object obj) {
        zzdsp zzdsp = new zzdsp();
        this.zzhlp.zzhln = zzdsp;
        this.zzhlp = zzdsp;
        zzdsp.value = obj;
        return this;
    }
}
