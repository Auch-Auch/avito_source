package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
@SafeParcelable.Class(creator = "CommonWalletObjectCreator")
@SafeParcelable.Reserved({1})
@KeepName
public class CommonWalletObject extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CommonWalletObject> CREATOR = new zzb();
    @SafeParcelable.Field(id = 4)
    public String name;
    @SafeParcelable.Field(id = 10)
    public int state;
    @SafeParcelable.Field(id = 2)
    public String zzby;
    @SafeParcelable.Field(id = 5)
    public String zzca;
    @SafeParcelable.Field(id = 6)
    public String zzcd;
    @SafeParcelable.Field(id = 7)
    public String zzce;
    @SafeParcelable.Field(id = 8)
    public String zzcf;
    @SafeParcelable.Field(id = 9)
    @Deprecated
    public String zzcg;
    @SafeParcelable.Field(id = 3)
    public String zzch;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 11)
    public ArrayList<WalletObjectMessage> zzci;
    @SafeParcelable.Field(id = 12)
    public TimeInterval zzcj;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 13)
    public ArrayList<LatLng> zzck;
    @SafeParcelable.Field(id = 14)
    @Deprecated
    public String zzcl;
    @SafeParcelable.Field(id = 15)
    @Deprecated
    public String zzcm;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 16)
    public ArrayList<LabelValueRow> zzcn;
    @SafeParcelable.Field(id = 17)
    public boolean zzco;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 18)
    public ArrayList<UriData> zzcp;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 19)
    public ArrayList<TextModuleData> zzcq;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 20)
    public ArrayList<UriData> zzcr;

    public final class zza {
        private zza() {
        }

        public final zza zza(String str) {
            CommonWalletObject.this.zzby = str;
            return this;
        }

        public final zza zzb(String str) {
            CommonWalletObject.this.zzch = str;
            return this;
        }

        public final zza zzc(String str) {
            CommonWalletObject.this.name = str;
            return this;
        }

        public final zza zzd(String str) {
            CommonWalletObject.this.zzca = str;
            return this;
        }

        public final zza zze(String str) {
            CommonWalletObject.this.zzcd = str;
            return this;
        }

        public final zza zzf(String str) {
            CommonWalletObject.this.zzce = str;
            return this;
        }

        public final zza zzg(String str) {
            CommonWalletObject.this.zzcf = str;
            return this;
        }

        @Deprecated
        public final zza zzh(String str) {
            CommonWalletObject.this.zzcg = str;
            return this;
        }

        @Deprecated
        public final zza zzi(String str) {
            CommonWalletObject.this.zzcl = str;
            return this;
        }

        @Deprecated
        public final zza zzj(String str) {
            CommonWalletObject.this.zzcm = str;
            return this;
        }

        public final zza zza(int i) {
            CommonWalletObject.this.state = i;
            return this;
        }

        public final zza zzb(Collection<LatLng> collection) {
            CommonWalletObject.this.zzck.addAll(collection);
            return this;
        }

        public final zza zzc(Collection<LabelValueRow> collection) {
            CommonWalletObject.this.zzcn.addAll(collection);
            return this;
        }

        public final zza zzd(Collection<UriData> collection) {
            CommonWalletObject.this.zzcp.addAll(collection);
            return this;
        }

        public final zza zze(Collection<TextModuleData> collection) {
            CommonWalletObject.this.zzcq.addAll(collection);
            return this;
        }

        public final zza zzf(Collection<UriData> collection) {
            CommonWalletObject.this.zzcr.addAll(collection);
            return this;
        }

        public final zza zza(Collection<WalletObjectMessage> collection) {
            CommonWalletObject.this.zzci.addAll(collection);
            return this;
        }

        public final zza zzb(UriData uriData) {
            CommonWalletObject.this.zzcr.add(uriData);
            return this;
        }

        public final CommonWalletObject zzf() {
            return CommonWalletObject.this;
        }

        public final zza zza(WalletObjectMessage walletObjectMessage) {
            CommonWalletObject.this.zzci.add(walletObjectMessage);
            return this;
        }

        public final zza zza(TimeInterval timeInterval) {
            CommonWalletObject.this.zzcj = timeInterval;
            return this;
        }

        public final zza zza(LatLng latLng) {
            CommonWalletObject.this.zzck.add(latLng);
            return this;
        }

        public final zza zza(LabelValueRow labelValueRow) {
            CommonWalletObject.this.zzcn.add(labelValueRow);
            return this;
        }

        public final zza zza(boolean z) {
            CommonWalletObject.this.zzco = z;
            return this;
        }

        public final zza zza(UriData uriData) {
            CommonWalletObject.this.zzcp.add(uriData);
            return this;
        }

        public final zza zza(TextModuleData textModuleData) {
            CommonWalletObject.this.zzcq.add(textModuleData);
            return this;
        }
    }

    @SafeParcelable.Constructor
    public CommonWalletObject(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) String str6, @SafeParcelable.Param(id = 8) String str7, @SafeParcelable.Param(id = 9) String str8, @SafeParcelable.Param(id = 10) int i, @SafeParcelable.Param(id = 11) ArrayList<WalletObjectMessage> arrayList, @SafeParcelable.Param(id = 12) TimeInterval timeInterval, @SafeParcelable.Param(id = 13) ArrayList<LatLng> arrayList2, @SafeParcelable.Param(id = 14) String str9, @SafeParcelable.Param(id = 15) String str10, @SafeParcelable.Param(id = 16) ArrayList<LabelValueRow> arrayList3, @SafeParcelable.Param(id = 17) boolean z, @SafeParcelable.Param(id = 18) ArrayList<UriData> arrayList4, @SafeParcelable.Param(id = 19) ArrayList<TextModuleData> arrayList5, @SafeParcelable.Param(id = 20) ArrayList<UriData> arrayList6) {
        this.zzby = str;
        this.zzch = str2;
        this.name = str3;
        this.zzca = str4;
        this.zzcd = str5;
        this.zzce = str6;
        this.zzcf = str7;
        this.zzcg = str8;
        this.state = i;
        this.zzci = arrayList;
        this.zzcj = timeInterval;
        this.zzck = arrayList2;
        this.zzcl = str9;
        this.zzcm = str10;
        this.zzcn = arrayList3;
        this.zzco = z;
        this.zzcp = arrayList4;
        this.zzcq = arrayList5;
        this.zzcr = arrayList6;
    }

    public static zza zze() {
        return new zza();
    }

    public final String getBarcodeAlternateText() {
        return this.zzcd;
    }

    @Deprecated
    public final String getBarcodeLabel() {
        return this.zzcg;
    }

    public final String getBarcodeType() {
        return this.zzce;
    }

    public final String getBarcodeValue() {
        return this.zzcf;
    }

    public final String getClassId() {
        return this.zzch;
    }

    public final String getId() {
        return this.zzby;
    }

    public final ArrayList<UriData> getImageModuleDataMainImageUris() {
        return this.zzcp;
    }

    @Deprecated
    public final String getInfoModuleDataHexBackgroundColor() {
        return this.zzcm;
    }

    @Deprecated
    public final String getInfoModuleDataHexFontColor() {
        return this.zzcl;
    }

    public final ArrayList<LabelValueRow> getInfoModuleDataLabelValueRows() {
        return this.zzcn;
    }

    public final boolean getInfoModuleDataShowLastUpdateTime() {
        return this.zzco;
    }

    public final String getIssuerName() {
        return this.zzca;
    }

    public final ArrayList<UriData> getLinksModuleDataUris() {
        return this.zzcr;
    }

    public final ArrayList<LatLng> getLocations() {
        return this.zzck;
    }

    public final ArrayList<WalletObjectMessage> getMessages() {
        return this.zzci;
    }

    public final String getName() {
        return this.name;
    }

    public final int getState() {
        return this.state;
    }

    public final ArrayList<TextModuleData> getTextModulesData() {
        return this.zzcq;
    }

    public final TimeInterval getValidTimeInterval() {
        return this.zzcj;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzby, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzch, false);
        SafeParcelWriter.writeString(parcel, 4, this.name, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzca, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzcd, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzce, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzcf, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzcg, false);
        SafeParcelWriter.writeInt(parcel, 10, this.state);
        SafeParcelWriter.writeTypedList(parcel, 11, this.zzci, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzcj, i, false);
        SafeParcelWriter.writeTypedList(parcel, 13, this.zzck, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzcl, false);
        SafeParcelWriter.writeString(parcel, 15, this.zzcm, false);
        SafeParcelWriter.writeTypedList(parcel, 16, this.zzcn, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzco);
        SafeParcelWriter.writeTypedList(parcel, 18, this.zzcp, false);
        SafeParcelWriter.writeTypedList(parcel, 19, this.zzcq, false);
        SafeParcelWriter.writeTypedList(parcel, 20, this.zzcr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public CommonWalletObject() {
        this.zzci = ArrayUtils.newArrayList();
        this.zzck = ArrayUtils.newArrayList();
        this.zzcn = ArrayUtils.newArrayList();
        this.zzcp = ArrayUtils.newArrayList();
        this.zzcq = ArrayUtils.newArrayList();
        this.zzcr = ArrayUtils.newArrayList();
    }
}
