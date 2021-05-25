package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;
public final class zal implements Runnable {
    public final /* synthetic */ zak zaa;
    private final zam zab;

    public zal(zak zak, zam zam) {
        this.zaa = zak;
        this.zab = zam;
    }

    @Override // java.lang.Runnable
    @MainThread
    public final void run() {
        if (this.zaa.zaa) {
            ConnectionResult zab2 = this.zab.zab();
            if (zab2.hasResolution()) {
                zak zak = this.zaa;
                zak.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zak.getActivity(), (PendingIntent) Preconditions.checkNotNull(zab2.getResolution()), this.zab.zaa(), false), 1);
                return;
            }
            zak zak2 = this.zaa;
            if (zak2.zac.getErrorResolutionIntent(zak2.getActivity(), zab2.getErrorCode(), null) != null) {
                zak zak3 = this.zaa;
                zak3.zac.zaa(zak3.getActivity(), this.zaa.mLifecycleFragment, zab2.getErrorCode(), 2, this.zaa);
            } else if (zab2.getErrorCode() == 18) {
                Dialog zaa2 = GoogleApiAvailability.zaa(this.zaa.getActivity(), this.zaa);
                zak zak4 = this.zaa;
                zak4.zac.zaa(zak4.getActivity().getApplicationContext(), new zan(this, zaa2));
            } else {
                this.zaa.zaa(zab2, this.zab.zaa());
            }
        }
    }
}
