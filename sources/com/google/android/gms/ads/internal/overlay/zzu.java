package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaqk;
import com.google.android.gms.internal.ads.zzut;
public final class zzu extends zzaqk {
    private Activity zzaas;
    private boolean zzdnu = false;
    private AdOverlayInfoParcel zzdpb;
    private boolean zzdpc = false;

    public zzu(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdpb = adOverlayInfoParcel;
        this.zzaas = activity;
    }

    private final synchronized void zzva() {
        if (!this.zzdpc) {
            zzo zzo = this.zzdpb.zzdor;
            if (zzo != null) {
                zzo.zzui();
            }
            this.zzdpc = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onBackPressed() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onCreate(Bundle bundle) {
        zzo zzo;
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdpb;
        if (adOverlayInfoParcel == null) {
            this.zzaas.finish();
        } else if (z) {
            this.zzaas.finish();
        } else {
            if (bundle == null) {
                zzut zzut = adOverlayInfoParcel.zzcgq;
                if (zzut != null) {
                    zzut.onAdClicked();
                }
                if (!(this.zzaas.getIntent() == null || !this.zzaas.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || (zzo = this.zzdpb.zzdor) == null)) {
                    zzo.zzuj();
                }
            }
            zzp.zzkn();
            Activity activity = this.zzaas;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdpb;
            if (!zzb.zza(activity, adOverlayInfoParcel2.zzdoq, adOverlayInfoParcel2.zzdov)) {
                this.zzaas.finish();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onDestroy() throws RemoteException {
        if (this.zzaas.isFinishing()) {
            zzva();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onPause() throws RemoteException {
        zzo zzo = this.zzdpb.zzdor;
        if (zzo != null) {
            zzo.onPause();
        }
        if (this.zzaas.isFinishing()) {
            zzva();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onRestart() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onResume() throws RemoteException {
        if (this.zzdnu) {
            this.zzaas.finish();
            return;
        }
        this.zzdnu = true;
        zzo zzo = this.zzdpb.zzdor;
        if (zzo != null) {
            zzo.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdnu);
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onStart() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onStop() throws RemoteException {
        if (this.zzaas.isFinishing()) {
            zzva();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void zzad(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void zzdo() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final boolean zzuq() throws RemoteException {
        return false;
    }
}
