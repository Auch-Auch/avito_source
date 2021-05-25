package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;
public final class zzal implements Callable<Void> {
    private final /* synthetic */ zzae zzvw;

    public zzal(zzae zzae) {
        this.zzvw = zzae;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        this.zzvw.zzvu.zzeb();
        return null;
    }
}
