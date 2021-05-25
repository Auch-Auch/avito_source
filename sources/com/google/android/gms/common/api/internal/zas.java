package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
public final class zas implements zabm {
    private final /* synthetic */ zaq zaa;

    private zas(zaq zaq) {
        this.zaa = zaq;
    }

    @Override // com.google.android.gms.common.api.internal.zabm
    public final void zaa(@Nullable Bundle bundle) {
        this.zaa.zam.lock();
        try {
            this.zaa.zaa(bundle);
            this.zaa.zaj = ConnectionResult.RESULT_SUCCESS;
            this.zaa.zah();
        } finally {
            this.zaa.zam.unlock();
        }
    }

    public /* synthetic */ zas(zaq zaq, zat zat) {
        this(zaq);
    }

    @Override // com.google.android.gms.common.api.internal.zabm
    public final void zaa(@NonNull ConnectionResult connectionResult) {
        this.zaa.zam.lock();
        try {
            this.zaa.zaj = connectionResult;
            this.zaa.zah();
        } finally {
            this.zaa.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabm
    public final void zaa(int i, boolean z) {
        this.zaa.zam.lock();
        try {
            if (!(this.zaa.zal) && this.zaa.zak != null) {
                if (this.zaa.zak.isSuccess()) {
                    this.zaa.zal = true;
                    this.zaa.zae.onConnectionSuspended(i);
                    this.zaa.zam.unlock();
                    return;
                }
            }
            this.zaa.zal = false;
            this.zaa.zaa(i, z);
        } finally {
            this.zaa.zam.unlock();
        }
    }
}
