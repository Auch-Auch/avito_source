package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public interface zzaql extends IInterface {
    void onActivityResult(int i, int i2, Intent intent) throws RemoteException;

    void onBackPressed() throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onPause() throws RemoteException;

    void onRestart() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;

    void zzad(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzdo() throws RemoteException;

    boolean zzuq() throws RemoteException;
}
