package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.atomic.AtomicReference;
public abstract class zak extends LifecycleCallback implements DialogInterface.OnCancelListener {
    public volatile boolean zaa;
    public final AtomicReference<zam> zab;
    public final GoogleApiAvailability zac;
    private final Handler zad;

    public zak(LifecycleFragment lifecycleFragment) {
        this(lifecycleFragment, GoogleApiAvailability.getInstance());
    }

    private static int zaa(@Nullable zam zam) {
        if (zam == null) {
            return -1;
        }
        return zam.zaa();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.common.api.internal.zam> r0 = r4.zab
            java.lang.Object r0 = r0.get()
            com.google.android.gms.common.api.internal.zam r0 = (com.google.android.gms.common.api.internal.zam) r0
            r1 = 1
            r2 = 0
            if (r5 == r1) goto L_0x0030
            r6 = 2
            if (r5 == r6) goto L_0x0010
            goto L_0x0060
        L_0x0010:
            com.google.android.gms.common.GoogleApiAvailability r5 = r4.zac
            android.app.Activity r6 = r4.getActivity()
            int r5 = r5.isGooglePlayServicesAvailable(r6)
            if (r5 != 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r1 = 0
        L_0x001e:
            if (r0 != 0) goto L_0x0021
            return
        L_0x0021:
            com.google.android.gms.common.ConnectionResult r6 = r0.zab()
            int r6 = r6.getErrorCode()
            r7 = 18
            if (r6 != r7) goto L_0x0061
            if (r5 != r7) goto L_0x0061
            return
        L_0x0030:
            r5 = -1
            if (r6 != r5) goto L_0x0034
            goto L_0x0061
        L_0x0034:
            if (r6 != 0) goto L_0x0060
            if (r0 != 0) goto L_0x0039
            return
        L_0x0039:
            r5 = 13
            if (r7 == 0) goto L_0x0043
            java.lang.String r6 = "<<ResolutionFailureErrorDetail>>"
            int r5 = r7.getIntExtra(r6, r5)
        L_0x0043:
            com.google.android.gms.common.api.internal.zam r6 = new com.google.android.gms.common.api.internal.zam
            com.google.android.gms.common.ConnectionResult r7 = new com.google.android.gms.common.ConnectionResult
            r1 = 0
            com.google.android.gms.common.ConnectionResult r3 = r0.zab()
            java.lang.String r3 = r3.toString()
            r7.<init>(r5, r1, r3)
            int r5 = zaa(r0)
            r6.<init>(r7, r5)
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.common.api.internal.zam> r5 = r4.zab
            r5.set(r6)
            r0 = r6
        L_0x0060:
            r1 = 0
        L_0x0061:
            if (r1 == 0) goto L_0x0067
            r4.zab()
            return
        L_0x0067:
            if (r0 == 0) goto L_0x0074
            com.google.android.gms.common.ConnectionResult r5 = r0.zab()
            int r6 = r0.zaa()
            r4.zaa(r5, r6)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zak.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        zaa(new ConnectionResult(13, null), zaa(this.zab.get()));
        zab();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zab.set(bundle.getBoolean("resolving_error", false) ? new zam(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zam zam = this.zab.get();
        if (zam != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zam.zaa());
            bundle.putInt("failed_status", zam.zab().getErrorCode());
            bundle.putParcelable("failed_resolution", zam.zab().getResolution());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.zaa = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.zaa = false;
    }

    public abstract void zaa();

    public abstract void zaa(ConnectionResult connectionResult, int i);

    public final void zab() {
        this.zab.set(null);
        zaa();
    }

    @VisibleForTesting
    public zak(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zab = new AtomicReference<>(null);
        this.zad = new zap(Looper.getMainLooper());
        this.zac = googleApiAvailability;
    }

    public final void zab(ConnectionResult connectionResult, int i) {
        zam zam = new zam(connectionResult, i);
        if (this.zab.compareAndSet(null, zam)) {
            this.zad.post(new zal(this, zam));
        }
    }
}
