package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
public abstract class zzxn extends zzgt implements zzxk {
    public zzxn() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                initialize();
                parcel2.writeNoException();
                return true;
            case 2:
                setAppVolume(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            case 3:
                zzch(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                setAppMuted(zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zza(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                float zzqd = zzqd();
                parcel2.writeNoException();
                parcel2.writeFloat(zzqd);
                return true;
            case 8:
                boolean zzqe = zzqe();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zzqe);
                return true;
            case 9:
                String versionString = getVersionString();
                parcel2.writeNoException();
                parcel2.writeString(versionString);
                return true;
            case 10:
                zzci(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza(zzamt.zzac(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                zza(zzail.zzaa(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                List<zzaif> zzqf = zzqf();
                parcel2.writeNoException();
                parcel2.writeTypedList(zzqf);
                return true;
            case 14:
                zza((zzzw) zzgw.zza(parcel, zzzw.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzqg();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
