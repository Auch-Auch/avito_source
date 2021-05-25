package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
@ParametersAreNonnullByDefault
public final class zzsp {
    private final Object zzbus = new Object();
    @GuardedBy("poolLock")
    private boolean zzbut = false;
}
