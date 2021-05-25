package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
public abstract class zzasf extends zzgt implements zzasc {
    public zzasf() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            zzash zzash = null;
            zzasj zzasj = null;
            zzasj zzasj2 = null;
            zzasj zzasj3 = null;
            zzasj zzasj4 = null;
            if (i == 2) {
                zzarw zzarw = (zzarw) zzgw.zza(parcel, zzarw.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (queryLocalInterface instanceof zzash) {
                        zzash = (zzash) queryLocalInterface;
                    } else {
                        zzash = new zzasg(readStrongBinder);
                    }
                }
                zza(zzarw, zzash);
                parcel2.writeNoException();
            } else if (i == 4) {
                zzasp zzasp = (zzasp) zzgw.zza(parcel, zzasp.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface2 instanceof zzasj) {
                        zzasj4 = (zzasj) queryLocalInterface2;
                    } else {
                        zzasj4 = new zzasl(readStrongBinder2);
                    }
                }
                zza(zzasp, zzasj4);
                parcel2.writeNoException();
            } else if (i == 5) {
                zzasp zzasp2 = (zzasp) zzgw.zza(parcel, zzasp.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface3 instanceof zzasj) {
                        zzasj3 = (zzasj) queryLocalInterface3;
                    } else {
                        zzasj3 = new zzasl(readStrongBinder3);
                    }
                }
                zzb(zzasp2, zzasj3);
                parcel2.writeNoException();
            } else if (i == 6) {
                zzasp zzasp3 = (zzasp) zzgw.zza(parcel, zzasp.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface4 instanceof zzasj) {
                        zzasj2 = (zzasj) queryLocalInterface4;
                    } else {
                        zzasj2 = new zzasl(readStrongBinder4);
                    }
                }
                zzc(zzasp3, zzasj2);
                parcel2.writeNoException();
            } else if (i != 7) {
                return false;
            } else {
                String readString = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface5 instanceof zzasj) {
                        zzasj = (zzasj) queryLocalInterface5;
                    } else {
                        zzasj = new zzasl(readStrongBinder5);
                    }
                }
                zza(readString, zzasj);
                parcel2.writeNoException();
            }
        } else {
            zzary zza = zza((zzarw) zzgw.zza(parcel, zzarw.CREATOR));
            parcel2.writeNoException();
            zzgw.zzb(parcel2, zza);
        }
        return true;
    }
}
