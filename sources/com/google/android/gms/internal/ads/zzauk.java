package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public abstract class zzauk extends zzgt implements zzaul {
    public zzauk() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzaul zzap(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        if (queryLocalInterface instanceof zzaul) {
            return (zzaul) queryLocalInterface;
        }
        return new zzaun(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaut zzaut = null;
        zzaut zzaut2 = null;
        zzauu zzauu = null;
        zzaum zzaum = null;
        switch (i) {
            case 1:
                zzvc zzvc = (zzvc) zzgw.zza(parcel, zzvc.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    if (queryLocalInterface instanceof zzaut) {
                        zzaut = (zzaut) queryLocalInterface;
                    } else {
                        zzaut = new zzauv(readStrongBinder);
                    }
                }
                zza(zzvc, zzaut);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    if (queryLocalInterface2 instanceof zzaum) {
                        zzaum = (zzaum) queryLocalInterface2;
                    } else {
                        zzaum = new zzauo(readStrongBinder2);
                    }
                }
                zza(zzaum);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean isLoaded = isLoaded();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, isLoaded);
                return true;
            case 4:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 5:
                zzh(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    if (queryLocalInterface3 instanceof zzauu) {
                        zzauu = (zzauu) queryLocalInterface3;
                    } else {
                        zzauu = new zzaux(readStrongBinder3);
                    }
                }
                zza(zzauu);
                parcel2.writeNoException();
                return true;
            case 7:
                zza((zzavc) zzgw.zza(parcel, zzavc.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                zza(zzxy.zzh(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, adMetadata);
                return true;
            case 10:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 11:
                zzaug zzqw = zzqw();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzqw);
                return true;
            case 12:
                zzyf zzkg = zzkg();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzkg);
                return true;
            case 13:
                zza(zzyd.zzi(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 14:
                zzvc zzvc2 = (zzvc) zzgw.zza(parcel, zzvc.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    if (queryLocalInterface4 instanceof zzaut) {
                        zzaut2 = (zzaut) queryLocalInterface4;
                    } else {
                        zzaut2 = new zzauv(readStrongBinder4);
                    }
                }
                zzb(zzvc2, zzaut2);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
