package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
public interface zzana extends IInterface {
    void onAdClicked() throws RemoteException;

    void onAdClosed() throws RemoteException;

    void onAdFailedToLoad(int i) throws RemoteException;

    void onAdImpression() throws RemoteException;

    void onAdLeftApplication() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdOpened() throws RemoteException;

    void onAppEvent(String str, String str2) throws RemoteException;

    void onVideoEnd() throws RemoteException;

    void onVideoPause() throws RemoteException;

    void onVideoPlay() throws RemoteException;

    void zza(zzaes zzaes, String str) throws RemoteException;

    void zza(zzanb zzanb) throws RemoteException;

    void zza(zzaug zzaug) throws RemoteException;

    void zzb(Bundle bundle) throws RemoteException;

    void zzb(zzaue zzaue) throws RemoteException;

    void zzb(zzuw zzuw) throws RemoteException;

    void zzc(int i, String str) throws RemoteException;

    void zzdd(int i) throws RemoteException;

    void zzdn(String str) throws RemoteException;

    void zzdo(String str) throws RemoteException;

    void zzty() throws RemoteException;

    void zztz() throws RemoteException;
}
