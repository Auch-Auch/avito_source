package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zad;
public final class zaao implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private final /* synthetic */ zaad zaa;

    private zaao(zaad zaad) {
        this.zaa = zaad;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        ClientSettings clientSettings = (ClientSettings) Preconditions.checkNotNull(zaad.zai(this.zaa));
        ((zad) Preconditions.checkNotNull(zaad.zaf(this.zaa))).zaa(new zaam(this.zaa));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zaad.zac(this.zaa).lock();
        try {
            if (zaad.zab(this.zaa, connectionResult)) {
                zaad.zaj(this.zaa);
                zaad.zak(this.zaa);
            } else {
                zaad.zaa(this.zaa, connectionResult);
            }
        } finally {
            zaad.zac(this.zaa).unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    public /* synthetic */ zaao(zaad zaad, zaag zaag) {
        this(zaad);
    }
}
