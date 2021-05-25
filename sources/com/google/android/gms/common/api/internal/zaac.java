package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;
public final class zaac implements zaay {
    private final zaax zaa;
    private boolean zab = false;

    public zaac(zaax zaax) {
        this.zaa = zaax;
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T t) {
        return (T) zab(t);
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zaa() {
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zaa(@Nullable Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(T t) {
        try {
            this.zaa.zad.zae.zaa(t);
            zaap zaap = this.zaa.zad;
            Api.Client client = zaap.zab.get(t.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.zaa.zab.containsKey(t.getClientKey())) {
                t.run(client);
            } else {
                t.setFailedResult(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.zaa.zaa(new zaab(this, this));
        }
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zac() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zaa(new zaae(this, this));
        }
    }

    public final void zad() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zad.zae.zaa();
            zab();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zaa(int i) {
        this.zaa.zaa((ConnectionResult) null);
        this.zaa.zae.zaa(i, this.zab);
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final boolean zab() {
        if (this.zab) {
            return false;
        }
        Set<zack> set = this.zaa.zad.zad;
        if (set == null || set.isEmpty()) {
            this.zaa.zaa((ConnectionResult) null);
            return true;
        }
        this.zab = true;
        for (zack zack : set) {
            zack.zaa();
        }
        return false;
    }
}
