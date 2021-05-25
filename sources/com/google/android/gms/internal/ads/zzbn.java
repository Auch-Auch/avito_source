package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.io.Closeable;
import java.io.IOException;
public class zzbn extends zzeky implements Closeable {
    private static zzelg zzdc = zzelg.zzn(zzbn.class);

    public zzbn(zzela zzela, zzbo zzbo) throws IOException {
        zza(zzela, zzela.size(), zzbo);
    }

    @Override // com.google.android.gms.internal.ads.zzeky, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zziqf.close();
    }

    @Override // com.google.android.gms.internal.ads.zzeky, java.lang.Object
    public String toString() {
        String obj = this.zziqf.toString();
        return a.s2(a.q0(obj, 7), "model(", obj, ")");
    }
}
