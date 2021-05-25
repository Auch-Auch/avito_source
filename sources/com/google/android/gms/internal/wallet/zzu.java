package com.google.android.gms.internal.wallet;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.WalletConstants;
import java.lang.ref.WeakReference;
public final class zzu extends zzx {
    private final int zzag;
    private final WeakReference<Activity> zzeq;

    public zzu(Activity activity, int i) {
        this.zzeq = new WeakReference<>(activity);
        this.zzag = i;
    }

    @Override // com.google.android.gms.internal.wallet.zzx, com.google.android.gms.internal.wallet.zzq
    public final void zza(int i, MaskedWallet maskedWallet, Bundle bundle) {
        int i2;
        Activity activity = this.zzeq.get();
        if (activity != null) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzag);
                } catch (IntentSender.SendIntentException unused) {
                }
            } else {
                Intent intent = new Intent();
                if (connectionResult.isSuccess()) {
                    i2 = -1;
                    intent.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", maskedWallet);
                } else {
                    int i3 = i == 408 ? 0 : 1;
                    intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
                    i2 = i3;
                }
                PendingIntent createPendingResult = activity.createPendingResult(this.zzag, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(i2);
                    } catch (PendingIntent.CanceledException unused2) {
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.wallet.zzx, com.google.android.gms.internal.wallet.zzq
    public final void zza(int i, FullWallet fullWallet, Bundle bundle) {
        int i2;
        Activity activity = this.zzeq.get();
        if (activity != null) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzag);
                } catch (IntentSender.SendIntentException unused) {
                }
            } else {
                Intent intent = new Intent();
                if (connectionResult.isSuccess()) {
                    i2 = -1;
                    intent.putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", fullWallet);
                } else {
                    int i3 = i == 408 ? 0 : 1;
                    intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
                    i2 = i3;
                }
                PendingIntent createPendingResult = activity.createPendingResult(this.zzag, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(i2);
                    } catch (PendingIntent.CanceledException unused2) {
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.wallet.zzx, com.google.android.gms.internal.wallet.zzq
    public final void zza(int i, boolean z, Bundle bundle) {
        Activity activity = this.zzeq.get();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent createPendingResult = activity.createPendingResult(this.zzag, intent, 1073741824);
            if (createPendingResult != null) {
                try {
                    createPendingResult.send(-1);
                } catch (PendingIntent.CanceledException unused) {
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.wallet.zzx, com.google.android.gms.internal.wallet.zzq
    public final void zza(int i, Bundle bundle) {
        Preconditions.checkNotNull(bundle, "Bundle should not be null");
        Activity activity = this.zzeq.get();
        if (activity != null) {
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzag);
                } catch (IntentSender.SendIntentException unused) {
                }
            } else {
                String.valueOf(connectionResult).length();
                Intent intent = new Intent();
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, 413);
                PendingIntent createPendingResult = activity.createPendingResult(this.zzag, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                    } catch (PendingIntent.CanceledException unused2) {
                    }
                }
            }
        }
    }
}
