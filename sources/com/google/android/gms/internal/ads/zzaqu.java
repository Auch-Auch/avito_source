package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
public final class zzaqu extends zzgt implements zzaqv {
    public static zzaqv zzah(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        if (queryLocalInterface instanceof zzaqv) {
            return (zzaqv) queryLocalInterface;
        }
        return new zzaqx(iBinder);
    }
}
