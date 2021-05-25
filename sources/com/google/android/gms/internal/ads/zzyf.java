package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
public interface zzyf extends IInterface {
    String getMediationAdapterClassName() throws RemoteException;

    String getResponseId() throws RemoteException;
}
