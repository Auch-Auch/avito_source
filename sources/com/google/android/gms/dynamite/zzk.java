package com.google.android.gms.dynamite;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public interface zzk extends IInterface {
    int zza(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException;

    IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException;

    IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException;

    int zzb() throws RemoteException;

    int zzb(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException;

    IObjectWrapper zzb(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException;

    IObjectWrapper zzc(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException;
}
