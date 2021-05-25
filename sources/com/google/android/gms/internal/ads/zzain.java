package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
public final class zzain implements AdapterStatus {
    private final String description;
    private final int zzdfg;
    private final AdapterStatus.State zzdfh;

    public zzain(AdapterStatus.State state, String str, int i) {
        this.zzdfh = state;
        this.description = str;
        this.zzdfg = i;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final String getDescription() {
        return this.description;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final AdapterStatus.State getInitializationState() {
        return this.zzdfh;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final int getLatency() {
        return this.zzdfg;
    }
}
