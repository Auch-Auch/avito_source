package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public final class zzat {
    private static final Comparator<byte[]> zzce = new zzaw();
    private final List<byte[]> zzca = new ArrayList();
    private final List<byte[]> zzcb = new ArrayList(64);
    private int zzcc = 0;
    private final int zzcd = 4096;

    public zzat(int i) {
    }

    private final synchronized void zzn() {
        while (this.zzcc > this.zzcd) {
            byte[] remove = this.zzca.remove(0);
            this.zzcb.remove(remove);
            this.zzcc -= remove.length;
        }
    }

    public final synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.zzcd) {
                this.zzca.add(bArr);
                int binarySearch = Collections.binarySearch(this.zzcb, bArr, zzce);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.zzcb.add(binarySearch, bArr);
                this.zzcc += bArr.length;
                zzn();
            }
        }
    }

    public final synchronized byte[] zzf(int i) {
        for (int i2 = 0; i2 < this.zzcb.size(); i2++) {
            byte[] bArr = this.zzcb.get(i2);
            if (bArr.length >= i) {
                this.zzcc -= bArr.length;
                this.zzcb.remove(i2);
                this.zzca.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
