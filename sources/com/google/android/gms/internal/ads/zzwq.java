package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
public abstract class zzwq extends zzgt implements zzwr {
    public zzwq() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzwl zzwl = null;
        zzxi zzxi = null;
        switch (i) {
            case 1:
                zzwm zzqc = zzqc();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzqc);
                return true;
            case 2:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzwl) {
                        zzwl = (zzwl) queryLocalInterface;
                    } else {
                        zzwl = new zzwn(readStrongBinder);
                    }
                }
                zzb(zzwl);
                parcel2.writeNoException();
                return true;
            case 3:
                zza(zzaev.zzs(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                zza(zzafa.zzt(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                zza(parcel.readString(), zzafg.zzv(parcel.readStrongBinder()), zzafb.zzu(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                zza((zzadm) zzgw.zza(parcel, zzadm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface2 instanceof zzxi) {
                        zzxi = (zzxi) queryLocalInterface2;
                    } else {
                        zzxi = new zzxl(readStrongBinder2);
                    }
                }
                zzb(zzxi);
                parcel2.writeNoException();
                return true;
            case 8:
                zza(zzafj.zzw(parcel.readStrongBinder()), (zzvj) zzgw.zza(parcel, zzvj.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                zza((PublisherAdViewOptions) zzgw.zza(parcel, PublisherAdViewOptions.CREATOR));
                parcel2.writeNoException();
                return true;
            case 10:
                zza(zzafo.zzx(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zza((zzair) zzgw.zza(parcel, zzair.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzajc.zzab(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
