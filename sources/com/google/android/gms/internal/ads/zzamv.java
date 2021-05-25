package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
public interface zzamv extends IInterface {
    void destroy() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzyg getVideoController() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzaih zzaih, List<zzaip> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzaua zzaua, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvc zzvc, String str, zzana zzana) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvc zzvc, String str, zzaua zzaua, String str2) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvc zzvc, String str, String str2, zzana zzana) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvc zzvc, String str, String str2, zzana zzana, zzadm zzadm, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvj zzvj, zzvc zzvc, String str, zzana zzana) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvj zzvj, zzvc zzvc, String str, String str2, zzana zzana) throws RemoteException;

    void zza(zzvc zzvc, String str) throws RemoteException;

    void zza(zzvc zzvc, String str, String str2) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper, zzvc zzvc, String str, zzana zzana) throws RemoteException;

    void zzc(IObjectWrapper iObjectWrapper, zzvc zzvc, String str, zzana zzana) throws RemoteException;

    void zzs(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzt(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzto() throws RemoteException;

    zzand zztp() throws RemoteException;

    zzani zztq() throws RemoteException;

    Bundle zztr() throws RemoteException;

    Bundle zzts() throws RemoteException;

    boolean zztt() throws RemoteException;

    zzaes zztu() throws RemoteException;

    zzanj zztv() throws RemoteException;

    zzapo zztw() throws RemoteException;

    zzapo zztx() throws RemoteException;
}
