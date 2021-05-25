package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
public class zzeky implements zzbs, Closeable, Iterator<zzbp> {
    private static zzelg zzdc = zzelg.zzn(zzeky.class);
    private static final zzbp zziqi = new zzekx("eof ");
    public long zzawf = 0;
    public long zzbgh = 0;
    public zzela zziqf;
    public zzbo zziqj;
    private zzbp zziqk = null;
    public long zziql = 0;
    private List<zzbp> zziqm = new ArrayList();

    /* access modifiers changed from: private */
    /* renamed from: zzbjl */
    public final zzbp next() {
        zzbp zza;
        zzbp zzbp = this.zziqk;
        if (zzbp == null || zzbp == zziqi) {
            zzela zzela = this.zziqf;
            if (zzela == null || this.zziql >= this.zzawf) {
                this.zziqk = zziqi;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzela) {
                    this.zziqf.zzfc(this.zziql);
                    zza = this.zziqj.zza(this.zziqf, this);
                    this.zziql = this.zziqf.position();
                }
                return zza;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zziqk = null;
            return zzbp;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zziqf.close();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        zzbp zzbp = this.zziqk;
        if (zzbp == zziqi) {
            return false;
        }
        if (zzbp != null) {
            return true;
        }
        try {
            this.zziqk = (zzbp) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zziqk = zziqi;
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zziqm.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.zziqm.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void zza(zzela zzela, long j, zzbo zzbo) throws IOException {
        this.zziqf = zzela;
        long position = zzela.position();
        this.zzbgh = position;
        this.zziql = position;
        zzela.zzfc(zzela.position() + j);
        this.zzawf = zzela.position();
        this.zziqj = zzbo;
    }

    public final List<zzbp> zzbjk() {
        if (this.zziqf == null || this.zziqk == zziqi) {
            return this.zziqm;
        }
        return new zzele(this.zziqm, this);
    }
}
