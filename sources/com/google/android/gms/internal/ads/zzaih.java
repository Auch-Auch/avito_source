package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
public interface zzaih extends IInterface {
    void onInitializationFailed(String str) throws RemoteException;

    void onInitializationSucceeded() throws RemoteException;
}
