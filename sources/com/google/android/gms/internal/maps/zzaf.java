package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;
public interface zzaf extends IInterface {
    Tile getTile(int i, int i2, int i3) throws RemoteException;
}
