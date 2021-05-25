package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public abstract class zzoa<T> {
    public Map<String, zzoa<?>> zzaud;

    public abstract String toString();

    public abstract T value();

    public final void zzc(String str, zzoa<?> zzoa) {
        if (this.zzaud == null) {
            this.zzaud = new HashMap();
        }
        this.zzaud.put(str, zzoa);
    }

    public final boolean zzcn(String str) {
        Map<String, zzoa<?>> map = this.zzaud;
        return map != null && map.containsKey(str);
    }

    public zzoa<?> zzco(String str) {
        Map<String, zzoa<?>> map = this.zzaud;
        return map != null ? map.get(str) : zzog.zzaum;
    }

    public boolean zzcp(String str) {
        return false;
    }

    public zzgz zzcq(String str) {
        throw new IllegalStateException(a.s2(a.q0(str, 56), "Attempting to access Native Method ", str, " on unsupported type."));
    }

    public Iterator<zzoa<?>> zzmf() {
        return new zzoc(null);
    }

    public final Iterator<zzoa<?>> zzmg() {
        Map<String, zzoa<?>> map = this.zzaud;
        if (map == null) {
            return new zzoc(null);
        }
        return new zzob(this, map.keySet().iterator());
    }
}
