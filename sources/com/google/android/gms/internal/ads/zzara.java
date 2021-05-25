package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
public final class zzara extends zzgt implements zzarb {
    public static zzarb zzaj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        if (queryLocalInterface instanceof zzarb) {
            return (zzarb) queryLocalInterface;
        }
        return new zzard(iBinder);
    }
}
