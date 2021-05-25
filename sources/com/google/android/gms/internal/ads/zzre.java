package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzre {
    private final Object lock = new Object();
    private int score;
    private final int zzbsb;
    private final int zzbsc;
    private final int zzbsd;
    private final boolean zzbse;
    private final zzrp zzbsf;
    private final zzsa zzbsg;
    private ArrayList<String> zzbsh = new ArrayList<>();
    private ArrayList<String> zzbsi = new ArrayList<>();
    private ArrayList<zzrn> zzbsj = new ArrayList<>();
    private int zzbsk = 0;
    private int zzbsl = 0;
    private int zzbsm = 0;
    private String zzbsn = "";
    private String zzbso = "";
    private String zzbsp = "";

    public zzre(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.zzbsb = i;
        this.zzbsc = i2;
        this.zzbsd = i3;
        this.zzbse = z;
        this.zzbsf = new zzrp(i4);
        this.zzbsg = new zzsa(i5, i6, i7);
    }

    private final void zzc(@Nullable String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.zzbsd) {
            synchronized (this.lock) {
                this.zzbsh.add(str);
                this.zzbsk += str.length();
                if (z) {
                    this.zzbsi.add(str);
                    this.zzbsj.add(new zzrn(f, f2, f3, f4, this.zzbsi.size() - 1));
                }
            }
        }
    }

    @VisibleForTesting
    private final int zzh(int i, int i2) {
        if (this.zzbse) {
            return this.zzbsc;
        }
        return (i2 * this.zzbsc) + (i * this.zzbsb);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzre)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzre) obj).zzbsn;
        return str != null && str.equals(this.zzbsn);
    }

    public final int getScore() {
        return this.score;
    }

    public final int hashCode() {
        return this.zzbsn.hashCode();
    }

    public final String toString() {
        int i = this.zzbsl;
        int i2 = this.score;
        int i3 = this.zzbsk;
        String zza = zza(this.zzbsh, 100);
        String zza2 = zza(this.zzbsi, 100);
        String str = this.zzbsn;
        String str2 = this.zzbso;
        String str3 = this.zzbsp;
        StringBuilder sb = new StringBuilder(a.q0(str3, a.q0(str2, a.q0(str, a.q0(zza2, a.q0(zza, 165))))));
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(zza);
        a.n1(sb, "\n viewableText", zza2, "\n signture: ", str);
        return a.v(sb, "\n viewableSignture: ", str2, "\n viewableSignatureForVertical: ", str3);
    }

    public final void zza(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
        synchronized (this.lock) {
            if (this.zzbsm < 0) {
                zzbbd.zzef("ActivityContent: negative number of WebViews.");
            }
            zzme();
        }
    }

    public final void zzb(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
    }

    public final void zzbw(int i) {
        this.zzbsl = i;
    }

    public final boolean zzlw() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbsm == 0;
        }
        return z;
    }

    public final String zzlx() {
        return this.zzbsn;
    }

    public final String zzly() {
        return this.zzbso;
    }

    public final String zzlz() {
        return this.zzbsp;
    }

    public final void zzma() {
        synchronized (this.lock) {
            this.score -= 100;
        }
    }

    public final void zzmb() {
        synchronized (this.lock) {
            this.zzbsm--;
        }
    }

    public final void zzmc() {
        synchronized (this.lock) {
            this.zzbsm++;
        }
    }

    public final void zzmd() {
        synchronized (this.lock) {
            int zzh = zzh(this.zzbsk, this.zzbsl);
            if (zzh > this.score) {
                this.score = zzh;
            }
        }
    }

    public final void zzme() {
        synchronized (this.lock) {
            int zzh = zzh(this.zzbsk, this.zzbsl);
            if (zzh > this.score) {
                this.score = zzh;
                if (!zzp.zzkt().zzwj().zzwy()) {
                    this.zzbsn = this.zzbsf.zza(this.zzbsh);
                    this.zzbso = this.zzbsf.zza(this.zzbsi);
                }
                if (!zzp.zzkt().zzwj().zzxa()) {
                    this.zzbsp = this.zzbsg.zza(this.zzbsi, this.zzbsj);
                }
            }
        }
    }

    @VisibleForTesting
    public final int zzmf() {
        return this.zzbsk;
    }

    private static String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList.get(i2);
            i2++;
            sb.append(str);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        if (sb2.length() < 100) {
            return sb2;
        }
        return sb2.substring(0, 100);
    }
}
