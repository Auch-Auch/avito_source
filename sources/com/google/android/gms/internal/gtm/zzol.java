package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
public final class zzol extends zzoa<String> {
    private final String zzauu;
    private final List<zzoa<?>> zzauv;

    public zzol(String str, List<zzoa<?>> list) {
        Preconditions.checkNotNull(str, "Instruction name must be a string.");
        Preconditions.checkNotNull(list);
        this.zzauu = str;
        this.zzauv = list;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    /* renamed from: toString */
    public final String value() {
        String str = this.zzauu;
        String obj = this.zzauv.toString();
        return a.t2(a.q0(obj, a.q0(str, 3)), "*", str, ": ", obj);
    }

    public final String zzmj() {
        return this.zzauu;
    }

    public final List<zzoa<?>> zzmk() {
        return this.zzauv;
    }
}
