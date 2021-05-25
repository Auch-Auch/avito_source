package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;
public final class zzaxt {
    @GuardedBy("this")
    private String zzdpz = "0";
    @GuardedBy("this")
    private BigInteger zzdzd = BigInteger.ONE;

    public final synchronized String zzwt() {
        String bigInteger;
        bigInteger = this.zzdzd.toString();
        this.zzdzd = this.zzdzd.add(BigInteger.ONE);
        this.zzdpz = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzwu() {
        return this.zzdpz;
    }
}
