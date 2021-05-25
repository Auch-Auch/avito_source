package com.google.android.gms.wallet;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.Wallet;
public class WalletObjectsClient extends GoogleApi<Wallet.WalletOptions> {
    public WalletObjectsClient(@NonNull Activity activity, @Nullable Wallet.WalletOptions walletOptions) {
        super(activity, Wallet.API, walletOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<AutoResolvableVoidResult> createWalletObjects(@NonNull CreateWalletObjectsRequest createWalletObjectsRequest) {
        return doWrite(new zzak(this, createWalletObjectsRequest));
    }
}
