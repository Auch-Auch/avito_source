package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzagl;
import com.google.android.gms.internal.ads.zzagn;
import com.google.android.gms.internal.ads.zzbbg;
import com.google.android.gms.internal.ads.zzbfq;
import com.google.android.gms.internal.ads.zzut;
@SafeParcelable.Class(creator = "AdOverlayInfoCreator")
@SafeParcelable.Reserved({1})
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzm();
    @SafeParcelable.Field(id = 11)
    public final int orientation;
    @SafeParcelable.Field(id = 13)
    public final String url;
    @SafeParcelable.Field(id = 14)
    public final zzbbg zzbpa;
    @SafeParcelable.Field(getter = "getAdClickListenerAsBinder", id = 3, type = "android.os.IBinder")
    public final zzut zzcgq;
    @SafeParcelable.Field(getter = "getAdMetadataGmsgListenerAsBinder", id = 18, type = "android.os.IBinder")
    public final zzagl zzddv;
    @SafeParcelable.Field(getter = "getAppEventGmsgListenerAsBinder", id = 6, type = "android.os.IBinder")
    public final zzagn zzddw;
    @SafeParcelable.Field(getter = "getAdWebViewAsBinder", id = 5, type = "android.os.IBinder")
    public final zzbfq zzdgc;
    @SafeParcelable.Field(id = 2)
    public final zzd zzdoq;
    @SafeParcelable.Field(getter = "getAdOverlayListenerAsBinder", id = 4, type = "android.os.IBinder")
    public final zzo zzdor;
    @SafeParcelable.Field(id = 7)
    public final String zzdos;
    @SafeParcelable.Field(id = 8)
    public final boolean zzdot;
    @SafeParcelable.Field(id = 9)
    public final String zzdou;
    @SafeParcelable.Field(getter = "getLeaveApplicationListenerAsBinder", id = 10, type = "android.os.IBinder")
    public final zzt zzdov;
    @SafeParcelable.Field(id = 12)
    public final int zzdow;
    @SafeParcelable.Field(id = 16)
    public final String zzdox;
    @SafeParcelable.Field(id = 17)
    public final zzi zzdoy;

    public AdOverlayInfoParcel(zzut zzut, zzo zzo, zzt zzt, zzbfq zzbfq, int i, zzbbg zzbbg, String str, zzi zzi, String str2, String str3) {
        this.zzdoq = null;
        this.zzcgq = null;
        this.zzdor = zzo;
        this.zzdgc = zzbfq;
        this.zzddv = null;
        this.zzddw = null;
        this.zzdos = str2;
        this.zzdot = false;
        this.zzdou = str3;
        this.zzdov = null;
        this.orientation = i;
        this.zzdow = 1;
        this.url = null;
        this.zzbpa = zzbbg;
        this.zzdox = str;
        this.zzdoy = zzi;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdoq, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzcgq).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzdor).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzdgc).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zzddw).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdos, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdot);
        SafeParcelWriter.writeString(parcel, 9, this.zzdou, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzdov).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.orientation);
        SafeParcelWriter.writeInt(parcel, 12, this.zzdow);
        SafeParcelWriter.writeString(parcel, 13, this.url, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzbpa, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzdox, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzdoy, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzddv).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AdOverlayInfoParcel(zzut zzut, zzo zzo, zzt zzt, zzbfq zzbfq, boolean z, int i, zzbbg zzbbg) {
        this.zzdoq = null;
        this.zzcgq = zzut;
        this.zzdor = zzo;
        this.zzdgc = zzbfq;
        this.zzddv = null;
        this.zzddw = null;
        this.zzdos = null;
        this.zzdot = z;
        this.zzdou = null;
        this.zzdov = zzt;
        this.orientation = i;
        this.zzdow = 2;
        this.url = null;
        this.zzbpa = zzbbg;
        this.zzdox = null;
        this.zzdoy = null;
    }

    public AdOverlayInfoParcel(zzut zzut, zzo zzo, zzagl zzagl, zzagn zzagn, zzt zzt, zzbfq zzbfq, boolean z, int i, String str, zzbbg zzbbg) {
        this.zzdoq = null;
        this.zzcgq = zzut;
        this.zzdor = zzo;
        this.zzdgc = zzbfq;
        this.zzddv = zzagl;
        this.zzddw = zzagn;
        this.zzdos = null;
        this.zzdot = z;
        this.zzdou = null;
        this.zzdov = zzt;
        this.orientation = i;
        this.zzdow = 3;
        this.url = str;
        this.zzbpa = zzbbg;
        this.zzdox = null;
        this.zzdoy = null;
    }

    public AdOverlayInfoParcel(zzut zzut, zzo zzo, zzagl zzagl, zzagn zzagn, zzt zzt, zzbfq zzbfq, boolean z, int i, String str, String str2, zzbbg zzbbg) {
        this.zzdoq = null;
        this.zzcgq = zzut;
        this.zzdor = zzo;
        this.zzdgc = zzbfq;
        this.zzddv = zzagl;
        this.zzddw = zzagn;
        this.zzdos = str2;
        this.zzdot = z;
        this.zzdou = str;
        this.zzdov = zzt;
        this.orientation = i;
        this.zzdow = 3;
        this.url = null;
        this.zzbpa = zzbbg;
        this.zzdox = null;
        this.zzdoy = null;
    }

    public AdOverlayInfoParcel(zzd zzd, zzut zzut, zzo zzo, zzt zzt, zzbbg zzbbg) {
        this.zzdoq = zzd;
        this.zzcgq = zzut;
        this.zzdor = zzo;
        this.zzdgc = null;
        this.zzddv = null;
        this.zzddw = null;
        this.zzdos = null;
        this.zzdot = false;
        this.zzdou = null;
        this.zzdov = zzt;
        this.orientation = -1;
        this.zzdow = 4;
        this.url = null;
        this.zzbpa = zzbbg;
        this.zzdox = null;
        this.zzdoy = null;
    }

    @SafeParcelable.Constructor
    public AdOverlayInfoParcel(@SafeParcelable.Param(id = 2) zzd zzd, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) IBinder iBinder2, @SafeParcelable.Param(id = 5) IBinder iBinder3, @SafeParcelable.Param(id = 6) IBinder iBinder4, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) String str2, @SafeParcelable.Param(id = 10) IBinder iBinder5, @SafeParcelable.Param(id = 11) int i, @SafeParcelable.Param(id = 12) int i2, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) zzbbg zzbbg, @SafeParcelable.Param(id = 16) String str4, @SafeParcelable.Param(id = 17) zzi zzi, @SafeParcelable.Param(id = 18) IBinder iBinder6) {
        this.zzdoq = zzd;
        this.zzcgq = (zzut) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzdor = (zzo) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzdgc = (zzbfq) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzddv = (zzagl) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zzddw = (zzagn) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzdos = str;
        this.zzdot = z;
        this.zzdou = str2;
        this.zzdov = (zzt) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.orientation = i;
        this.zzdow = i2;
        this.url = str3;
        this.zzbpa = zzbbg;
        this.zzdox = str4;
        this.zzdoy = zzi;
    }
}
