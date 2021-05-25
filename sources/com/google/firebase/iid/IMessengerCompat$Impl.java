package com.google.firebase.iid;

import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
public class IMessengerCompat$Impl extends Binder implements IInterface {
    @NonNull
    public final Handler a;

    @Override // android.os.IInterface
    @NonNull
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, @NonNull Parcel parcel, @NonNull Parcel parcel2, int i2) throws RemoteException {
        parcel.enforceInterface(getInterfaceDescriptor());
        if (i != 1) {
            return false;
        }
        send(parcel.readInt() != 0 ? (Message) Message.CREATOR.createFromParcel(parcel) : null);
        return true;
    }

    public void send(@NonNull Message message) throws RemoteException {
        message.arg2 = Binder.getCallingUid();
        this.a.dispatchMessage(message);
    }
}
