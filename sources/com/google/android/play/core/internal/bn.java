package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
public final class bn extends i implements bp {
    public bn(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    @Override // com.google.android.play.core.internal.bp
    public final void a(String str, int i, Bundle bundle, br brVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        k.a(a, bundle);
        k.a(a, brVar);
        a(4, a);
    }

    @Override // com.google.android.play.core.internal.bp
    public final void a(String str, int i, br brVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        k.a(a, brVar);
        a(5, a);
    }

    @Override // com.google.android.play.core.internal.bp
    public final void a(String str, br brVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        k.a(a, brVar);
        a(6, a);
    }

    @Override // com.google.android.play.core.internal.bp
    public final void a(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        k.a(a, bundle);
        k.a(a, brVar);
        a(2, a);
    }

    @Override // com.google.android.play.core.internal.bp
    public final void b(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        k.a(a, bundle);
        k.a(a, brVar);
        a(7, a);
    }

    @Override // com.google.android.play.core.internal.bp
    public final void c(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        k.a(a, bundle);
        k.a(a, brVar);
        a(8, a);
    }

    @Override // com.google.android.play.core.internal.bp
    public final void d(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        k.a(a, bundle);
        k.a(a, brVar);
        a(13, a);
    }

    @Override // com.google.android.play.core.internal.bp
    public final void e(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        k.a(a, bundle);
        k.a(a, brVar);
        a(14, a);
    }
}
