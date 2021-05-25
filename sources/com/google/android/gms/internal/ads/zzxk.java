package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
public interface zzxk extends IInterface {
    String getVersionString() throws RemoteException;

    void initialize() throws RemoteException;

    void setAppMuted(boolean z) throws RemoteException;

    void setAppVolume(float f) throws RemoteException;

    void zza(zzaim zzaim) throws RemoteException;

    void zza(zzamu zzamu) throws RemoteException;

    void zza(zzzw zzzw) throws RemoteException;

    void zza(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zzch(String str) throws RemoteException;

    void zzci(String str) throws RemoteException;

    float zzqd() throws RemoteException;

    boolean zzqe() throws RemoteException;

    List<zzaif> zzqf() throws RemoteException;

    void zzqg() throws RemoteException;
}
