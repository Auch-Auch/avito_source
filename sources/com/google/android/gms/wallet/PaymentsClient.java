package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.Wallet;
public class PaymentsClient extends GoogleApi<Wallet.WalletOptions> {
    public PaymentsClient(@NonNull Activity activity, @NonNull Wallet.WalletOptions walletOptions) {
        super(activity, Wallet.API, walletOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<Boolean> isReadyToPay(@NonNull IsReadyToPayRequest isReadyToPayRequest) {
        return doRead(new zzab(this, isReadyToPayRequest));
    }

    public Task<PaymentData> loadPaymentData(@NonNull PaymentDataRequest paymentDataRequest) {
        return doWrite(new zzad(this, paymentDataRequest));
    }

    public PaymentsClient(@NonNull Context context, @NonNull Wallet.WalletOptions walletOptions) {
        super(context, Wallet.API, walletOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
