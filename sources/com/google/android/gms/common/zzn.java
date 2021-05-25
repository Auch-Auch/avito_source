package com.google.android.gms.common;

import java.util.concurrent.Callable;
public final class zzn extends zzl {
    private final Callable<String> zzb;

    private zzn(Callable<String> callable) {
        super(false, null, null);
        this.zzb = callable;
    }

    @Override // com.google.android.gms.common.zzl
    public final String zzb() {
        try {
            return this.zzb.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
