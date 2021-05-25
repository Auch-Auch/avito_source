package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.zak;
public final class zaas implements zak {
    private final /* synthetic */ zaap zaa;

    public zaas(zaap zaap) {
        this.zaa = zaap;
    }

    @Override // com.google.android.gms.common.internal.zak
    @Nullable
    public final Bundle getConnectionHint() {
        return null;
    }

    @Override // com.google.android.gms.common.internal.zak
    public final boolean isConnected() {
        return this.zaa.isConnected();
    }
}
