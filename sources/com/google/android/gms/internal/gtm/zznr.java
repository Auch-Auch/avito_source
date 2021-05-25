package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import java.util.Collections;
import java.util.List;
public final class zznr {
    private final List<zzno> zzatu;
    private final List<zzno> zzatv;
    private final List<zzno> zzatw;
    private final List<zzno> zzatx;

    private zznr(List<zzno> list, List<zzno> list2, List<zzno> list3, List<zzno> list4) {
        this.zzatu = Collections.unmodifiableList(list);
        this.zzatv = Collections.unmodifiableList(list2);
        this.zzatw = Collections.unmodifiableList(list3);
        this.zzatx = Collections.unmodifiableList(list4);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzatu);
        String valueOf2 = String.valueOf(this.zzatv);
        String valueOf3 = String.valueOf(this.zzatw);
        String valueOf4 = String.valueOf(this.zzatx);
        return a.v(a.K(valueOf4.length() + valueOf3.length() + valueOf2.length() + valueOf.length() + 71, "Positive predicates: ", valueOf, "  Negative predicates: ", valueOf2), "  Add tags: ", valueOf3, "  Remove tags: ", valueOf4);
    }

    public final List<zzno> zzlw() {
        return this.zzatu;
    }

    public final List<zzno> zzlx() {
        return this.zzatv;
    }

    public final List<zzno> zzly() {
        return this.zzatw;
    }

    public final List<zzno> zzlz() {
        return this.zzatx;
    }
}
