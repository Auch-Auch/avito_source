package com.google.firebase.iid;

import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Objects;
@KeepForSdk
public class FirebaseIidMessengerCompat implements Parcelable {
    public static final Parcelable.Creator<FirebaseIidMessengerCompat> CREATOR = new a();
    public Messenger a;

    public static final class HandleOldParcelNameClassLoader extends ClassLoader {
        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            FirebaseInstanceId.j();
            return FirebaseIidMessengerCompat.class;
        }
    }

    public class a implements Parcelable.Creator<FirebaseIidMessengerCompat> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public FirebaseIidMessengerCompat createFromParcel(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                return new FirebaseIidMessengerCompat(readStrongBinder);
            }
            return null;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public FirebaseIidMessengerCompat[] newArray(int i) {
            return new FirebaseIidMessengerCompat[i];
        }
    }

    @KeepForSdk
    public FirebaseIidMessengerCompat(Handler handler) {
        this.a = new Messenger(handler);
    }

    public static int getSendingUid(Message message) {
        return message.sendingUid;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return getBinder().equals(((FirebaseIidMessengerCompat) obj).getBinder());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @KeepForSdk
    public IBinder getBinder() {
        Messenger messenger = this.a;
        Objects.requireNonNull(messenger);
        return messenger.getBinder();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getBinder().hashCode();
    }

    public void send(Message message) throws RemoteException {
        Messenger messenger = this.a;
        Objects.requireNonNull(messenger);
        messenger.send(message);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.a;
        Objects.requireNonNull(messenger);
        parcel.writeStrongBinder(messenger.getBinder());
    }

    public FirebaseIidMessengerCompat(IBinder iBinder) {
        this.a = new Messenger(iBinder);
    }
}
