package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public abstract class zzamy extends zzgt implements zzamv {
    public zzamy() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzana zzana = null;
        switch (i) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvj zzvj = (zzvj) zzgw.zza(parcel, zzvj.CREATOR);
                zzvc zzvc = (zzvc) zzgw.zza(parcel, zzvc.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface instanceof zzana) {
                        zzana = (zzana) queryLocalInterface;
                    } else {
                        zzana = new zzanc(readStrongBinder);
                    }
                }
                zza(asInterface, zzvj, zzvc, readString, zzana);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper zzto = zzto();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzto);
                return true;
            case 3:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvc zzvc2 = (zzvc) zzgw.zza(parcel, zzvc.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface2 instanceof zzana) {
                        zzana = (zzana) queryLocalInterface2;
                    } else {
                        zzana = new zzanc(readStrongBinder2);
                    }
                }
                zza(asInterface2, zzvc2, readString2, zzana);
                parcel2.writeNoException();
                return true;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 5:
                destroy();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvj zzvj2 = (zzvj) zzgw.zza(parcel, zzvj.CREATOR);
                zzvc zzvc3 = (zzvc) zzgw.zza(parcel, zzvc.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface3 instanceof zzana) {
                        zzana = (zzana) queryLocalInterface3;
                    } else {
                        zzana = new zzanc(readStrongBinder3);
                    }
                }
                zza(asInterface3, zzvj2, zzvc3, readString3, readString4, zzana);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvc zzvc4 = (zzvc) zzgw.zza(parcel, zzvc.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface4 instanceof zzana) {
                        zzana = (zzana) queryLocalInterface4;
                    } else {
                        zzana = new zzanc(readStrongBinder4);
                    }
                }
                zza(asInterface4, zzvc4, readString5, readString6, zzana);
                parcel2.writeNoException();
                return true;
            case 8:
                pause();
                parcel2.writeNoException();
                return true;
            case 9:
                resume();
                parcel2.writeNoException();
                return true;
            case 10:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvc) zzgw.zza(parcel, zzvc.CREATOR), parcel.readString(), zzaud.zzan(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza((zzvc) zzgw.zza(parcel, zzvc.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                showVideo();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean isInitialized = isInitialized();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, isInitialized);
                return true;
            case 14:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvc zzvc5 = (zzvc) zzgw.zza(parcel, zzvc.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface5 instanceof zzana) {
                        zzana = (zzana) queryLocalInterface5;
                    } else {
                        zzana = new zzanc(readStrongBinder5);
                    }
                }
                zza(asInterface5, zzvc5, readString7, readString8, zzana, (zzadm) zzgw.zza(parcel, zzadm.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                zzand zztp = zztp();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zztp);
                return true;
            case 16:
                zzani zztq = zztq();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zztq);
                return true;
            case 17:
                Bundle zztr = zztr();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, zztr);
                return true;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, interstitialAdapterInfo);
                return true;
            case 19:
                Bundle zzts = zzts();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, zzts);
                return true;
            case 20:
                zza((zzvc) zzgw.zza(parcel, zzvc.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                zzs(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zztt = zztt();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zztt);
                return true;
            case 23:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzaud.zzan(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                zzaes zztu = zztu();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zztu);
                return true;
            case 25:
                setImmersiveMode(zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                zzyg videoController = getVideoController();
                parcel2.writeNoException();
                zzgw.zza(parcel2, videoController);
                return true;
            case 27:
                zzanj zztv = zztv();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zztv);
                return true;
            case 28:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvc zzvc6 = (zzvc) zzgw.zza(parcel, zzvc.CREATOR);
                String readString9 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface6 instanceof zzana) {
                        zzana = (zzana) queryLocalInterface6;
                    } else {
                        zzana = new zzanc(readStrongBinder6);
                    }
                }
                zzb(asInterface6, zzvc6, readString9, zzana);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                zzt(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 31:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzaik.zzz(parcel.readStrongBinder()), parcel.createTypedArrayList(zzaip.CREATOR));
                parcel2.writeNoException();
                return true;
            case 32:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvc zzvc7 = (zzvc) zzgw.zza(parcel, zzvc.CREATOR);
                String readString10 = parcel.readString();
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface7 instanceof zzana) {
                        zzana = (zzana) queryLocalInterface7;
                    } else {
                        zzana = new zzanc(readStrongBinder7);
                    }
                }
                zzc(asInterface7, zzvc7, readString10, zzana);
                parcel2.writeNoException();
                return true;
            case 33:
                zzapo zztw = zztw();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, zztw);
                return true;
            case 34:
                zzapo zztx = zztx();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, zztx);
                return true;
        }
    }
}
