package com.google.android.gms.internal.ads;

import android.os.Environment;
import java.util.concurrent.Callable;
public final class zzaad implements Callable<Boolean> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() throws Exception {
        return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
    }
}
