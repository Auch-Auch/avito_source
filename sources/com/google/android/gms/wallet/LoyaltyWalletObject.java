package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;
import java.util.Collection;
@SafeParcelable.Class(creator = "LoyaltyWalletObjectCreator")
@SafeParcelable.Reserved({1})
public final class LoyaltyWalletObject extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new zzp();
    @SafeParcelable.Field(id = 12)
    public int state;
    @SafeParcelable.Field(id = 2)
    public String zzby;
    @SafeParcelable.Field(id = 3)
    public String zzbz;
    @SafeParcelable.Field(id = 4)
    public String zzca;
    @SafeParcelable.Field(id = 5)
    public String zzcb;
    @SafeParcelable.Field(id = 6)
    public String zzcc;
    @SafeParcelable.Field(id = 7)
    public String zzcd;
    @SafeParcelable.Field(id = 8)
    public String zzce;
    @SafeParcelable.Field(id = 9)
    public String zzcf;
    @SafeParcelable.Field(id = 10)
    @Deprecated
    public String zzcg;
    @SafeParcelable.Field(id = 11)
    public String zzch;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 13)
    public ArrayList<WalletObjectMessage> zzci;
    @SafeParcelable.Field(id = 14)
    public TimeInterval zzcj;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 15)
    public ArrayList<LatLng> zzck;
    @SafeParcelable.Field(id = 16)
    @Deprecated
    public String zzcl;
    @SafeParcelable.Field(id = 17)
    @Deprecated
    public String zzcm;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 18)
    public ArrayList<LabelValueRow> zzcn;
    @SafeParcelable.Field(id = 19)
    public boolean zzco;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 20)
    public ArrayList<UriData> zzcp;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 21)
    public ArrayList<TextModuleData> zzcq;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 22)
    public ArrayList<UriData> zzcr;
    @SafeParcelable.Field(id = 23)
    public LoyaltyPoints zzcs;

    public final class Builder {
        private Builder() {
        }

        public final Builder addImageModuleDataMainImageUri(UriData uriData) {
            LoyaltyWalletObject.this.zzcp.add(uriData);
            return this;
        }

        public final Builder addImageModuleDataMainImageUris(Collection<UriData> collection) {
            LoyaltyWalletObject.this.zzcp.addAll(collection);
            return this;
        }

        public final Builder addInfoModuleDataLabeValueRow(LabelValueRow labelValueRow) {
            LoyaltyWalletObject.this.zzcn.add(labelValueRow);
            return this;
        }

        public final Builder addInfoModuleDataLabelValueRows(Collection<LabelValueRow> collection) {
            LoyaltyWalletObject.this.zzcn.addAll(collection);
            return this;
        }

        public final Builder addLinksModuleDataUri(UriData uriData) {
            LoyaltyWalletObject.this.zzcr.add(uriData);
            return this;
        }

        public final Builder addLinksModuleDataUris(Collection<UriData> collection) {
            LoyaltyWalletObject.this.zzcr.addAll(collection);
            return this;
        }

        public final Builder addLocation(LatLng latLng) {
            LoyaltyWalletObject.this.zzck.add(latLng);
            return this;
        }

        public final Builder addLocations(Collection<LatLng> collection) {
            LoyaltyWalletObject.this.zzck.addAll(collection);
            return this;
        }

        public final Builder addMessage(WalletObjectMessage walletObjectMessage) {
            LoyaltyWalletObject.this.zzci.add(walletObjectMessage);
            return this;
        }

        public final Builder addMessages(Collection<WalletObjectMessage> collection) {
            LoyaltyWalletObject.this.zzci.addAll(collection);
            return this;
        }

        public final Builder addTextModuleData(TextModuleData textModuleData) {
            LoyaltyWalletObject.this.zzcq.add(textModuleData);
            return this;
        }

        public final Builder addTextModulesData(Collection<TextModuleData> collection) {
            LoyaltyWalletObject.this.zzcq.addAll(collection);
            return this;
        }

        public final LoyaltyWalletObject build() {
            return LoyaltyWalletObject.this;
        }

        public final Builder setAccountId(String str) {
            LoyaltyWalletObject.this.zzbz = str;
            return this;
        }

        public final Builder setAccountName(String str) {
            LoyaltyWalletObject.this.zzcc = str;
            return this;
        }

        public final Builder setBarcodeAlternateText(String str) {
            LoyaltyWalletObject.this.zzcd = str;
            return this;
        }

        @Deprecated
        public final Builder setBarcodeLabel(String str) {
            LoyaltyWalletObject.this.zzcg = str;
            return this;
        }

        public final Builder setBarcodeType(String str) {
            LoyaltyWalletObject.this.zzce = str;
            return this;
        }

        public final Builder setBarcodeValue(String str) {
            LoyaltyWalletObject.this.zzcf = str;
            return this;
        }

        public final Builder setClassId(String str) {
            LoyaltyWalletObject.this.zzch = str;
            return this;
        }

        public final Builder setId(String str) {
            LoyaltyWalletObject.this.zzby = str;
            return this;
        }

        @Deprecated
        public final Builder setInfoModuleDataHexBackgroundColor(String str) {
            LoyaltyWalletObject.this.zzcm = str;
            return this;
        }

        @Deprecated
        public final Builder setInfoModuleDataHexFontColor(String str) {
            LoyaltyWalletObject.this.zzcl = str;
            return this;
        }

        public final Builder setInfoModuleDataShowLastUpdateTime(boolean z) {
            LoyaltyWalletObject.this.zzco = z;
            return this;
        }

        public final Builder setIssuerName(String str) {
            LoyaltyWalletObject.this.zzca = str;
            return this;
        }

        public final Builder setLoyaltyPoints(LoyaltyPoints loyaltyPoints) {
            LoyaltyWalletObject.this.zzcs = loyaltyPoints;
            return this;
        }

        public final Builder setProgramName(String str) {
            LoyaltyWalletObject.this.zzcb = str;
            return this;
        }

        public final Builder setState(int i) {
            LoyaltyWalletObject.this.state = i;
            return this;
        }

        public final Builder setValidTimeInterval(TimeInterval timeInterval) {
            LoyaltyWalletObject.this.zzcj = timeInterval;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public LoyaltyWalletObject(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) String str6, @SafeParcelable.Param(id = 8) String str7, @SafeParcelable.Param(id = 9) String str8, @SafeParcelable.Param(id = 10) String str9, @SafeParcelable.Param(id = 11) String str10, @SafeParcelable.Param(id = 12) int i, @SafeParcelable.Param(id = 13) ArrayList<WalletObjectMessage> arrayList, @SafeParcelable.Param(id = 14) TimeInterval timeInterval, @SafeParcelable.Param(id = 15) ArrayList<LatLng> arrayList2, @SafeParcelable.Param(id = 16) String str11, @SafeParcelable.Param(id = 17) String str12, @SafeParcelable.Param(id = 18) ArrayList<LabelValueRow> arrayList3, @SafeParcelable.Param(id = 19) boolean z, @SafeParcelable.Param(id = 20) ArrayList<UriData> arrayList4, @SafeParcelable.Param(id = 21) ArrayList<TextModuleData> arrayList5, @SafeParcelable.Param(id = 22) ArrayList<UriData> arrayList6, @SafeParcelable.Param(id = 23) LoyaltyPoints loyaltyPoints) {
        this.zzby = str;
        this.zzbz = str2;
        this.zzca = str3;
        this.zzcb = str4;
        this.zzcc = str5;
        this.zzcd = str6;
        this.zzce = str7;
        this.zzcf = str8;
        this.zzcg = str9;
        this.zzch = str10;
        this.state = i;
        this.zzci = arrayList;
        this.zzcj = timeInterval;
        this.zzck = arrayList2;
        this.zzcl = str11;
        this.zzcm = str12;
        this.zzcn = arrayList3;
        this.zzco = z;
        this.zzcp = arrayList4;
        this.zzcq = arrayList5;
        this.zzcr = arrayList6;
        this.zzcs = loyaltyPoints;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final String getAccountId() {
        return this.zzbz;
    }

    public final String getAccountName() {
        return this.zzcc;
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

    public final LoyaltyPoints getLoyaltyPoints() {
        return this.zzcs;
    }

    public final ArrayList<WalletObjectMessage> getMessages() {
        return this.zzci;
    }

    public final String getProgramName() {
        return this.zzcb;
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
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzby, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbz, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzca, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzcb, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzcc, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzcd, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzce, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzcf, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzcg, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzch, false);
        SafeParcelWriter.writeInt(parcel, 12, this.state);
        SafeParcelWriter.writeTypedList(parcel, 13, this.zzci, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzcj, i, false);
        SafeParcelWriter.writeTypedList(parcel, 15, this.zzck, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzcl, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzcm, false);
        SafeParcelWriter.writeTypedList(parcel, 18, this.zzcn, false);
        SafeParcelWriter.writeBoolean(parcel, 19, this.zzco);
        SafeParcelWriter.writeTypedList(parcel, 20, this.zzcp, false);
        SafeParcelWriter.writeTypedList(parcel, 21, this.zzcq, false);
        SafeParcelWriter.writeTypedList(parcel, 22, this.zzcr, false);
        SafeParcelWriter.writeParcelable(parcel, 23, this.zzcs, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public LoyaltyWalletObject() {
        this.zzci = ArrayUtils.newArrayList();
        this.zzck = ArrayUtils.newArrayList();
        this.zzcn = ArrayUtils.newArrayList();
        this.zzcp = ArrayUtils.newArrayList();
        this.zzcq = ArrayUtils.newArrayList();
        this.zzcr = ArrayUtils.newArrayList();
    }
}
