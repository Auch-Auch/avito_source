package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public abstract class zzxg extends zzgt implements zzxh {
    public zzxg() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzwu zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvj) zzgw.zza(parcel, zzvj.CREATOR), parcel.readString(), zzamt.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza);
                return true;
            case 2:
                zzwu zzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvj) zzgw.zza(parcel, zzvj.CREATOR), parcel.readString(), zzamt.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzb);
                return true;
            case 3:
                zzwr zza2 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzamt.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza2);
                return true;
            case 4:
                zzxk zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzc);
                return true;
            case 5:
                zzaea zza3 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza3);
                return true;
            case 6:
                zzatm zza4 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzamt.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza4);
                return true;
            case 7:
                zzaqw zzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzd);
                return true;
            case 8:
                zzaql zzb2 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzb2);
                return true;
            case 9:
                zzxk zza5 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza5);
                return true;
            case 10:
                zzwu zza6 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvj) zzgw.zza(parcel, zzvj.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza6);
                return true;
            case 11:
                zzaed zza7 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza7);
                return true;
            case 12:
                zzaul zzb3 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzamt.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzb3);
                return true;
            case 13:
                zzwu zzc2 = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvj) zzgw.zza(parcel, zzvj.CREATOR), parcel.readString(), zzamt.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzc2);
                return true;
            case 14:
                zzawu zzb4 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzamt.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzb4);
                return true;
            default:
                return false;
        }
    }
}
