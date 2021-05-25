package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzrd {
    private final Object lock = new Object();
    @VisibleForTesting
    private int zzbrz;
    private List<zzre> zzbsa = new LinkedList();

    public final boolean zza(zzre zzre) {
        synchronized (this.lock) {
            if (this.zzbsa.contains(zzre)) {
                return true;
            }
            return false;
        }
    }

    public final boolean zzb(zzre zzre) {
        synchronized (this.lock) {
            Iterator<zzre> it = this.zzbsa.iterator();
            while (it.hasNext()) {
                zzre next = it.next();
                if (!zzp.zzkt().zzwj().zzwy()) {
                    if (zzre != next && next.zzlx().equals(zzre.zzlx())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzp.zzkt().zzwj().zzxa() && zzre != next && next.zzlz().equals(zzre.zzlz())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzre zzre) {
        synchronized (this.lock) {
            if (this.zzbsa.size() >= 10) {
                int size = this.zzbsa.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzbbd.zzef(sb.toString());
                this.zzbsa.remove(0);
            }
            int i = this.zzbrz;
            this.zzbrz = i + 1;
            zzre.zzbw(i);
            zzre.zzmd();
            this.zzbsa.add(zzre);
        }
    }

    @Nullable
    public final zzre zzo(boolean z) {
        synchronized (this.lock) {
            zzre zzre = null;
            if (this.zzbsa.size() == 0) {
                zzbbd.zzef("Queue empty");
                return null;
            }
            int i = 0;
            if (this.zzbsa.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                int i3 = 0;
                for (zzre zzre2 : this.zzbsa) {
                    int score = zzre2.getScore();
                    if (score > i2) {
                        i = i3;
                        zzre = zzre2;
                        i2 = score;
                    }
                    i3++;
                }
                this.zzbsa.remove(i);
                return zzre;
            }
            zzre zzre3 = this.zzbsa.get(0);
            if (z) {
                this.zzbsa.remove(0);
            } else {
                zzre3.zzma();
            }
            return zzre3;
        }
    }
}
