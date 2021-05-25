package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public final class zzxj extends zzgu implements zzxh {
    public zzxj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzwu zza(IObjectWrapper iObjectWrapper, zzvj zzvj, String str, zzamu zzamu, int i) throws RemoteException {
        zzwu zzwu;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, zzvj);
        obtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamu);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzwu = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzwu) {
                zzwu = (zzwu) queryLocalInterface;
            } else {
                zzwu = new zzww(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzwu;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzwu zzb(IObjectWrapper iObjectWrapper, zzvj zzvj, String str, zzamu zzamu, int i) throws RemoteException {
        zzwu zzwu;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, zzvj);
        obtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamu);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzwu = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzwu) {
                zzwu = (zzwu) queryLocalInterface;
            } else {
                zzwu = new zzww(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzwu;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzxk zzc(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzxk zzxk;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzxk = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzxk) {
                zzxk = (zzxk) queryLocalInterface;
            } else {
                zzxk = new zzxm(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzxk;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzaqw zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken);
        zzaqw zzai = zzaqz.zzai(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzai;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzwu zzc(IObjectWrapper iObjectWrapper, zzvj zzvj, String str, zzamu zzamu, int i) throws RemoteException {
        zzwu zzwu;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, zzvj);
        obtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamu);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzwu = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzwu) {
                zzwu = (zzwu) queryLocalInterface;
            } else {
                zzwu = new zzww(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzwu;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzwr zza(IObjectWrapper iObjectWrapper, String str, zzamu zzamu, int i) throws RemoteException {
        zzwr zzwr;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamu);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzwr = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzwr) {
                zzwr = (zzwr) queryLocalInterface;
            } else {
                zzwr = new zzwt(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzwr;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzaql zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken);
        zzaql zzag = zzaqk.zzag(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzag;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzaul zzb(IObjectWrapper iObjectWrapper, String str, zzamu zzamu, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamu);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken);
        zzaul zzap = zzauk.zzap(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzap;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzaea zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
        zzaea zzp = zzadz.zzp(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzawu zzb(IObjectWrapper iObjectWrapper, zzamu zzamu, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamu);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken);
        zzawu zzaq = zzawx.zzaq(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzaq;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzatm zza(IObjectWrapper iObjectWrapper, zzamu zzamu, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamu);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken);
        zzatm zzal = zzatp.zzal(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzal;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzxk zza(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzxk zzxk;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzxk = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzxk) {
                zzxk = (zzxk) queryLocalInterface;
            } else {
                zzxk = new zzxm(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzxk;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzwu zza(IObjectWrapper iObjectWrapper, zzvj zzvj, String str, int i) throws RemoteException {
        zzwu zzwu;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, zzvj);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzwu = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzwu) {
                zzwu = (zzwu) queryLocalInterface;
            } else {
                zzwu = new zzww(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzwu;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final zzaed zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper3);
        Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken);
        zzaed zzq = zzaeg.zzq(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzq;
    }
}
