package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
public final class zzaqz extends zzgt implements zzaqw {
    public static zzaqw zzai(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        if (queryLocalInterface instanceof zzaqw) {
            return (zzaqw) queryLocalInterface;
        }
        return new zzaqy(iBinder);
    }
}
