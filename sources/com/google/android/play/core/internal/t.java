package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
public abstract class t extends j implements u {
    public t() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    @Override // com.google.android.play.core.internal.j
    public final boolean a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                a(parcel.readInt(), (Bundle) k.a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) k.a(parcel, Bundle.CREATOR);
                a(readInt);
                return true;
            case 4:
                int readInt2 = parcel.readInt();
                Bundle bundle2 = (Bundle) k.a(parcel, Bundle.CREATOR);
                b(readInt2);
                return true;
            case 5:
                a(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 6:
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundle3 = (Bundle) k.a(parcel, creator);
                b((Bundle) k.a(parcel, creator));
                return true;
            case 7:
                a((Bundle) k.a(parcel, Bundle.CREATOR));
                return true;
            case 8:
                Parcelable.Creator creator2 = Bundle.CREATOR;
                Bundle bundle4 = (Bundle) k.a(parcel, creator2);
                c((Bundle) k.a(parcel, creator2));
                return true;
            case 9:
            default:
                return false;
            case 10:
                Parcelable.Creator creator3 = Bundle.CREATOR;
                Bundle bundle5 = (Bundle) k.a(parcel, creator3);
                d((Bundle) k.a(parcel, creator3));
                return true;
            case 11:
                Parcelable.Creator creator4 = Bundle.CREATOR;
                a((Bundle) k.a(parcel, creator4), (Bundle) k.a(parcel, creator4));
                return true;
            case 12:
                Parcelable.Creator creator5 = Bundle.CREATOR;
                b((Bundle) k.a(parcel, creator5), (Bundle) k.a(parcel, creator5));
                return true;
            case 13:
                Parcelable.Creator creator6 = Bundle.CREATOR;
                c((Bundle) k.a(parcel, creator6), (Bundle) k.a(parcel, creator6));
                return true;
            case 14:
                Parcelable.Creator creator7 = Bundle.CREATOR;
                Bundle bundle6 = (Bundle) k.a(parcel, creator7);
                Bundle bundle7 = (Bundle) k.a(parcel, creator7);
                b();
                return true;
            case 15:
                Bundle bundle8 = (Bundle) k.a(parcel, Bundle.CREATOR);
                a();
                return true;
        }
    }
}
