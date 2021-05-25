package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import java.util.Arrays;
import java.util.List;
public final class zzgy extends zzhb {
    private final String name;
    private zzfl zzape = null;
    private final List<String> zzarg;
    private final List<zzol> zzarh;

    public zzgy(zzfl zzfl, String str, List<String> list, List<zzol> list2) {
        this.name = str;
        this.zzarg = list;
        this.zzarh = list2;
    }

    public final String getName() {
        return this.name;
    }

    public final String toString() {
        String str = this.name;
        String obj = this.zzarg.toString();
        String obj2 = this.zzarh.toString();
        StringBuilder K = a.K(a.q0(obj2, a.q0(obj, a.q0(str, 26))), str, "\n\tparams: ", obj, "\n\t: statements: ");
        K.append(obj2);
        return K.toString();
    }

    public final void zza(zzfl zzfl) {
        this.zzape = zzfl;
    }

    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        try {
            zzfl zzku = this.zzape.zzku();
            for (int i = 0; i < this.zzarg.size(); i++) {
                if (zzoaArr.length > i) {
                    zzku.zza(this.zzarg.get(i), zzoaArr[i]);
                } else {
                    zzku.zza(this.zzarg.get(i), zzog.zzaum);
                }
            }
            zzku.zza("arguments", new zzoh(Arrays.asList(zzoaArr)));
            for (zzol zzol : this.zzarh) {
                zzoa zza = zzoo.zza(zzku, zzol);
                if ((zza instanceof zzog) && ((zzog) zza).zzmh()) {
                    return ((zzog) zza).value();
                }
            }
        } catch (RuntimeException e) {
            String str = this.name;
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + String.valueOf(str).length() + 33);
            sb.append("Internal error - Function call: ");
            sb.append(str);
            sb.append("\n");
            sb.append(message);
            zzev.zzav(sb.toString());
        }
        return zzog.zzaum;
    }
}
