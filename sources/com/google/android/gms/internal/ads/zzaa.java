package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzaq;
import java.util.Collections;
import java.util.Map;
public abstract class zzaa<T> implements Comparable<zzaa<T>> {
    private final Object mLock;
    private final zzaq.zza zzap;
    private final int zzaq;
    private final String zzar;
    private final int zzas;
    @Nullable
    @GuardedBy("mLock")
    private zzai zzat;
    private Integer zzau;
    private zzae zzav;
    private boolean zzaw;
    @GuardedBy("mLock")
    private boolean zzax;
    @GuardedBy("mLock")
    private boolean zzay;
    private boolean zzaz;
    private zzan zzba;
    @Nullable
    private zzn zzbb;
    @GuardedBy("mLock")
    private zzac zzbc;

    public zzaa(int i, String str, @Nullable zzai zzai) {
        Uri parse;
        String host;
        this.zzap = zzaq.zza.zzbw ? new zzaq.zza() : null;
        this.mLock = new Object();
        this.zzaw = true;
        int i2 = 0;
        this.zzax = false;
        this.zzay = false;
        this.zzaz = false;
        this.zzbb = null;
        this.zzaq = i;
        this.zzar = str;
        this.zzat = zzai;
        this.zzba = new zzq();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i2 = host.hashCode();
        }
        this.zzas = i2;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        zzaa zzaa = (zzaa) obj;
        zzaf zzaf = zzaf.NORMAL;
        if (zzaf == zzaf) {
            return this.zzau.intValue() - zzaa.zzau.intValue();
        }
        return 0;
    }

    public Map<String, String> getHeaders() throws zzl {
        return Collections.emptyMap();
    }

    public final int getMethod() {
        return this.zzaq;
    }

    public final String getUrl() {
        return this.zzar;
    }

    public final boolean isCanceled() {
        synchronized (this.mLock) {
        }
        return false;
    }

    @Override // java.lang.Object
    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzas));
        String concat = valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        isCanceled();
        String str = this.zzar;
        String valueOf2 = String.valueOf(zzaf.NORMAL);
        String valueOf3 = String.valueOf(this.zzau);
        return a.v(a.K(valueOf3.length() + valueOf2.length() + a.q0(concat, a.q0(str, "[ ] ".length() + 3)), "[ ] ", str, " ", concat), " ", valueOf2, " ", valueOf3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.ads.zzaa<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final zzaa<?> zza(zzae zzae) {
        this.zzav = zzae;
        return this;
    }

    public abstract zzaj<T> zza(zzy zzy);

    public abstract void zza(T t);

    public final void zzb(zzao zzao) {
        zzai zzai;
        synchronized (this.mLock) {
            zzai = this.zzat;
        }
        if (zzai != null) {
            zzai.zzc(zzao);
        }
    }

    public final void zzc(String str) {
        if (zzaq.zza.zzbw) {
            this.zzap.zza(str, Thread.currentThread().getId());
        }
    }

    public final int zzd() {
        return this.zzas;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.ads.zzaa<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final zzaa<?> zze(int i) {
        this.zzau = Integer.valueOf(i);
        return this;
    }

    @Nullable
    public final zzn zzf() {
        return this.zzbb;
    }

    public byte[] zzg() throws zzl {
        return null;
    }

    public final boolean zzh() {
        return this.zzaw;
    }

    public final int zzi() {
        return this.zzba.zzb();
    }

    public final zzan zzj() {
        return this.zzba;
    }

    public final void zzk() {
        synchronized (this.mLock) {
            this.zzay = true;
        }
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzay;
        }
        return z;
    }

    public final void zzm() {
        zzac zzac;
        synchronized (this.mLock) {
            zzac = this.zzbc;
        }
        if (zzac != null) {
            zzac.zza(this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.ads.zzaa<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final zzaa<?> zza(zzn zzn) {
        this.zzbb = zzn;
        return this;
    }

    public final void zzd(String str) {
        zzae zzae = this.zzav;
        if (zzae != null) {
            zzae.zzf(this);
        }
        if (zzaq.zza.zzbw) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzad(this, str, id));
                return;
            }
            this.zzap.zza(str, id);
            this.zzap.zzd(toString());
        }
    }

    public final String zze() {
        String str = this.zzar;
        int i = this.zzaq;
        if (i == 0 || i == -1) {
            return str;
        }
        String num = Integer.toString(i);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + String.valueOf(num).length() + 1);
        sb.append(num);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    public final void zza(zzac zzac) {
        synchronized (this.mLock) {
            this.zzbc = zzac;
        }
    }

    public final void zza(zzaj<?> zzaj) {
        zzac zzac;
        synchronized (this.mLock) {
            zzac = this.zzbc;
        }
        if (zzac != null) {
            zzac.zza(this, zzaj);
        }
    }

    public final void zzd(int i) {
        zzae zzae = this.zzav;
        if (zzae != null) {
            zzae.zza(this, i);
        }
    }
}
