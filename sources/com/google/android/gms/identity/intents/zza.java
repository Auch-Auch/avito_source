package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.internal.identity.zze;
public final class zza extends Api.AbstractClientBuilder<zze, Address.AddressOptions> {
    /* Return type fixed from 'com.google.android.gms.common.api.Api$Client' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener] */
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ zze buildClient(Context context, Looper looper, ClientSettings clientSettings, Address.AddressOptions addressOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Address.AddressOptions addressOptions2 = addressOptions;
        Preconditions.checkArgument(context instanceof Activity, "An Activity must be used for Address APIs");
        if (addressOptions2 == null) {
            addressOptions2 = new Address.AddressOptions();
        }
        return new zze((Activity) context, looper, clientSettings, addressOptions2.theme, connectionCallbacks, onConnectionFailedListener);
    }
}
