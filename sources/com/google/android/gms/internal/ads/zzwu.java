package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public interface zzwu extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getAdUnitId() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzyg getVideoController() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(zzaac zzaac) throws RemoteException;

    void zza(zzabq zzabq) throws RemoteException;

    void zza(zzaqv zzaqv) throws RemoteException;

    void zza(zzarb zzarb, String str) throws RemoteException;

    void zza(zzatt zzatt) throws RemoteException;

    void zza(zzsi zzsi) throws RemoteException;

    void zza(zzvj zzvj) throws RemoteException;

    void zza(zzvm zzvm) throws RemoteException;

    void zza(zzwg zzwg) throws RemoteException;

    void zza(zzwl zzwl) throws RemoteException;

    void zza(zzxb zzxb) throws RemoteException;

    void zza(zzxc zzxc) throws RemoteException;

    void zza(zzxi zzxi) throws RemoteException;

    void zza(zzya zzya) throws RemoteException;

    void zza(zzym zzym) throws RemoteException;

    boolean zza(zzvc zzvc) throws RemoteException;

    void zzbp(String str) throws RemoteException;

    IObjectWrapper zzkc() throws RemoteException;

    void zzkd() throws RemoteException;

    zzvj zzke() throws RemoteException;

    String zzkf() throws RemoteException;

    zzyf zzkg() throws RemoteException;

    zzxc zzkh() throws RemoteException;

    zzwl zzki() throws RemoteException;
}
