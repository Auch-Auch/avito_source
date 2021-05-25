package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
public final class zau implements zabm {
    private final /* synthetic */ zaq zaa;

    private zau(zaq zaq) {
        this.zaa = zaq;
    }

    @Override // com.google.android.gms.common.api.internal.zabm
    public final void zaa(@Nullable Bundle bundle) {
        this.zaa.zam.lock();
        try {
            this.zaa.zak = ConnectionResult.RESULT_SUCCESS;
            this.zaa.zah();
        } finally {
            this.zaa.zam.unlock();
        }
    }

    public /* synthetic */ zau(zaq zaq, zat zat) {
        this(zaq);
    }

    @Override // com.google.android.gms.common.api.internal.zabm
    public final void zaa(@NonNull ConnectionResult connectionResult) {
        this.zaa.zam.lock();
        try {
            this.zaa.zak = connectionResult;
            this.zaa.zah();
        } finally {
            this.zaa.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabm
    public final void zaa(int i, boolean z) {
        this.zaa.zam.lock();
        try {
            if (this.zaa.zal) {
                this.zaa.zal = false;
                this.zaa.zaa(i, z);
                return;
            }
            this.zaa.zal = true;
            this.zaa.zad.onConnectionSuspended(i);
            this.zaa.zam.unlock();
        } finally {
            this.zaa.zam.unlock();
        }
    }
}
