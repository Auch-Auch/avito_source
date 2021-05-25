package com.google.android.gms.common.internal;

import a2.b.a.a.a;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
public final class zaw extends RemoteCreator<zam> {
    private static final zaw zaa = new zaw();

    private zaw() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zaa(Context context, int i, int i2) throws RemoteCreator.RemoteCreatorException {
        return zaa.zab(context, i, i2);
    }

    private final View zab(Context context, int i, int i2) throws RemoteCreator.RemoteCreatorException {
        try {
            zau zau = new zau(i, i2, null);
            return (View) ObjectWrapper.unwrap(((zam) getRemoteCreatorInstance(context)).zaa(ObjectWrapper.wrap(context), zau));
        } catch (Exception e) {
            throw new RemoteCreator.RemoteCreatorException(a.p2(64, "Could not get button with size ", i, " and color ", i2), e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ zam getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (queryLocalInterface instanceof zam) {
            return (zam) queryLocalInterface;
        }
        return new zal(iBinder);
    }
}
