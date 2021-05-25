package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;
import java.util.Collection;
@SafeParcelable.Class(creator = "GiftCardWalletObjectCreator")
@SafeParcelable.Reserved({1})
public final class GiftCardWalletObject extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GiftCardWalletObject> CREATOR = new zzk();
    @SafeParcelable.Field(id = 4)
    public String pin;
    @SafeParcelable.Field(id = 2)
    public CommonWalletObject zzbh = CommonWalletObject.zze().zzf();
    @SafeParcelable.Field(id = 3)
    public String zzbi;
    @SafeParcelable.Field(id = 5)
    @Deprecated
    public String zzbj;
    @SafeParcelable.Field(id = 6)
    public long zzbk;
    @SafeParcelable.Field(id = 7)
    public String zzbl;
    @SafeParcelable.Field(id = 8)
    public long zzbm;
    @SafeParcelable.Field(id = 9)
    public String zzbn;

    public final class Builder {
        private CommonWalletObject.zza zzbo;

        private Builder() {
            this.zzbo = CommonWalletObject.zze();
        }

        public final Builder addImageModuleDataMainImageUri(UriData uriData) {
            this.zzbo.zza(uriData);
            return this;
        }

        public final Builder addImageModuleDataMainImageUris(Collection<UriData> collection) {
            this.zzbo.zzd(collection);
            return this;
        }

        public final Builder addInfoModuleDataLabelValueRow(LabelValueRow labelValueRow) {
            this.zzbo.zza(labelValueRow);
            return this;
        }

        public final Builder addInfoModuleDataLabelValueRows(Collection<LabelValueRow> collection) {
            this.zzbo.zzc(collection);
            return this;
        }

        public final Builder addLinksModuleDataUri(UriData uriData) {
            this.zzbo.zzb(uriData);
            return this;
        }

        public final Builder addLinksModuleDataUris(Collection<UriData> collection) {
            this.zzbo.zzf(collection);
            return this;
        }

        public final Builder addLocation(LatLng latLng) {
            this.zzbo.zza(latLng);
            return this;
        }

        public final Builder addLocations(Collection<LatLng> collection) {
            this.zzbo.zzb(collection);
            return this;
        }

        public final Builder addMessage(WalletObjectMessage walletObjectMessage) {
            this.zzbo.zza(walletObjectMessage);
            return this;
        }

        public final Builder addMessages(Collection<WalletObjectMessage> collection) {
            this.zzbo.zza(collection);
            return this;
        }

        public final Builder addTextModuleData(TextModuleData textModuleData) {
            this.zzbo.zza(textModuleData);
            return this;
        }

        public final Builder addTextModulesData(Collection<TextModuleData> collection) {
            this.zzbo.zze(collection);
            return this;
        }

        public final GiftCardWalletObject build() {
            Preconditions.checkArgument(!TextUtils.isEmpty(GiftCardWalletObject.this.zzbi), "Card number is required.");
            GiftCardWalletObject.this.zzbh = this.zzbo.zzf();
            Preconditions.checkArgument(!TextUtils.isEmpty(GiftCardWalletObject.this.zzbh.getName()), "Card name is required.");
            Preconditions.checkArgument(!TextUtils.isEmpty(GiftCardWalletObject.this.zzbh.getIssuerName()), "Card issuer name is required.");
            return GiftCardWalletObject.this;
        }

        public final Builder setBalanceCurrencyCode(String str) {
            GiftCardWalletObject.this.zzbl = str;
            return this;
        }

        public final Builder setBalanceMicros(long j) {
            GiftCardWalletObject.this.zzbk = j;
            return this;
        }

        public final Builder setBalanceUpdateTime(long j) {
            GiftCardWalletObject.this.zzbm = j;
            return this;
        }

        public final Builder setBarcodeAlternateText(String str) {
            this.zzbo.zze(str);
            return this;
        }

        @Deprecated
        public final Builder setBarcodeLabel(String str) {
            this.zzbo.zzh(str);
            return this;
        }

        public final Builder setBarcodeType(String str) {
            this.zzbo.zzf(str);
            return this;
        }

        public final Builder setBarcodeValue(String str) {
            this.zzbo.zzg(str);
            return this;
        }

        @Deprecated
        public final Builder setCardIdentifier(String str) {
            GiftCardWalletObject.this.zzbj = str;
            return this;
        }

        public final Builder setCardNumber(String str) {
            GiftCardWalletObject.this.zzbi = str;
            return this;
        }

        public final Builder setClassId(String str) {
            this.zzbo.zzb(str);
            return this;
        }

        public final Builder setEventNumber(String str) {
            GiftCardWalletObject.this.zzbn = str;
            return this;
        }

        public final Builder setId(String str) {
            this.zzbo.zza(str);
            return this;
        }

        @Deprecated
        public final Builder setInfoModuleDataHexBackgroundColor(String str) {
            this.zzbo.zzj(str);
            return this;
        }

        @Deprecated
        public final Builder setInfoModuleDataHexFontColor(String str) {
            this.zzbo.zzi(str);
            return this;
        }

        public final Builder setInfoModuleDataShowLastUpdateTime(boolean z) {
            this.zzbo.zza(z);
            return this;
        }

        public final Builder setIssuerName(String str) {
            this.zzbo.zzd(str);
            return this;
        }

        public final Builder setPin(String str) {
            GiftCardWalletObject.this.pin = str;
            return this;
        }

        public final Builder setState(int i) {
            this.zzbo.zza(i);
            return this;
        }

        public final Builder setTitle(String str) {
            this.zzbo.zzc(str);
            return this;
        }

        public final Builder setValidTimeInterval(TimeInterval timeInterval) {
            this.zzbo.zza(timeInterval);
            return this;
        }
    }

    public GiftCardWalletObject() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final String getBalanceCurrencyCode() {
        return this.zzbl;
    }

    public final long getBalanceMicros() {
        return this.zzbk;
    }

    public final long getBalanceUpdateTime() {
        return this.zzbm;
    }

    public final String getBarcodeAlternateText() {
        return this.zzbh.getBarcodeAlternateText();
    }

    @Deprecated
    public final String getBarcodeLabel() {
        return this.zzbh.getBarcodeLabel();
    }

    public final String getBarcodeType() {
        return this.zzbh.getBarcodeType();
    }

    public final String getBarcodeValue() {
        return this.zzbh.getBarcodeValue();
    }

    @Deprecated
    public final String getCardIdentifier() {
        return this.zzbj;
    }

    public final String getCardNumber() {
        return this.zzbi;
    }

    public final String getClassId() {
        return this.zzbh.getClassId();
    }

    public final String getEventNumber() {
        return this.zzbn;
    }

    public final String getId() {
        return this.zzbh.getId();
    }

    public final ArrayList<UriData> getImageModuleDataMainImageUris() {
        return this.zzbh.getImageModuleDataMainImageUris();
    }

    @Deprecated
    public final String getInfoModuleDataHexBackgroundColor() {
        return this.zzbh.getInfoModuleDataHexBackgroundColor();
    }

    @Deprecated
    public final String getInfoModuleDataHexFontColor() {
        return this.zzbh.getInfoModuleDataHexFontColor();
    }

    public final ArrayList<LabelValueRow> getInfoModuleDataLabelValueRows() {
        return this.zzbh.getInfoModuleDataLabelValueRows();
    }

    public final boolean getInfoModuleDataShowLastUpdateTime() {
        return this.zzbh.getInfoModuleDataShowLastUpdateTime();
    }

    public final String getIssuerName() {
        return this.zzbh.getIssuerName();
    }

    public final ArrayList<UriData> getLinksModuleDataUris() {
        return this.zzbh.getLinksModuleDataUris();
    }

    public final ArrayList<LatLng> getLocations() {
        return this.zzbh.getLocations();
    }

    public final ArrayList<WalletObjectMessage> getMessages() {
        return this.zzbh.getMessages();
    }

    public final String getPin() {
        return this.pin;
    }

    public final int getState() {
        return this.zzbh.getState();
    }

    public final ArrayList<TextModuleData> getTextModulesData() {
        return this.zzbh.getTextModulesData();
    }

    public final String getTitle() {
        return this.zzbh.getName();
    }

    public final TimeInterval getValidTimeInterval() {
        return this.zzbh.getValidTimeInterval();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzbh, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbi, false);
        SafeParcelWriter.writeString(parcel, 4, this.pin, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbj, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzbk);
        SafeParcelWriter.writeString(parcel, 7, this.zzbl, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzbm);
        SafeParcelWriter.writeString(parcel, 9, this.zzbn, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public GiftCardWalletObject(@SafeParcelable.Param(id = 2) CommonWalletObject commonWalletObject, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) long j, @SafeParcelable.Param(id = 7) String str4, @SafeParcelable.Param(id = 8) long j2, @SafeParcelable.Param(id = 9) String str5) {
        this.zzbh = commonWalletObject;
        this.zzbi = str;
        this.pin = str2;
        this.zzbk = j;
        this.zzbl = str4;
        this.zzbm = j2;
        this.zzbn = str5;
        this.zzbj = str3;
    }
}
