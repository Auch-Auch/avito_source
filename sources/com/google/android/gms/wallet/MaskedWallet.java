package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
@SafeParcelable.Class(creator = "MaskedWalletCreator")
@SafeParcelable.Reserved({1})
public final class MaskedWallet extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MaskedWallet> CREATOR = new zzq();
    @SafeParcelable.Field(id = 2)
    private String zzat;
    @SafeParcelable.Field(id = 3)
    private String zzau;
    @SafeParcelable.Field(id = 5)
    private String zzaw;
    @SafeParcelable.Field(id = 6)
    private zzb zzax;
    @SafeParcelable.Field(id = 7)
    private zzb zzay;
    @SafeParcelable.Field(id = 4)
    private String[] zzaz;
    @SafeParcelable.Field(id = 10)
    private UserAddress zzba;
    @SafeParcelable.Field(id = 11)
    private UserAddress zzbb;
    @SafeParcelable.Field(id = 12)
    private InstrumentInfo[] zzbc;
    @SafeParcelable.Field(id = 8)
    private LoyaltyWalletObject[] zzcu;
    @SafeParcelable.Field(id = 9)
    private OfferWalletObject[] zzcv;

    @SafeParcelable.Constructor
    public MaskedWallet(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String[] strArr, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) zzb zzb, @SafeParcelable.Param(id = 7) zzb zzb2, @SafeParcelable.Param(id = 8) LoyaltyWalletObject[] loyaltyWalletObjectArr, @SafeParcelable.Param(id = 9) OfferWalletObject[] offerWalletObjectArr, @SafeParcelable.Param(id = 10) UserAddress userAddress, @SafeParcelable.Param(id = 11) UserAddress userAddress2, @SafeParcelable.Param(id = 12) InstrumentInfo[] instrumentInfoArr) {
        this.zzat = str;
        this.zzau = str2;
        this.zzaz = strArr;
        this.zzaw = str3;
        this.zzax = zzb;
        this.zzay = zzb2;
        this.zzcu = loyaltyWalletObjectArr;
        this.zzcv = offerWalletObjectArr;
        this.zzba = userAddress;
        this.zzbb = userAddress2;
        this.zzbc = instrumentInfoArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzat, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzau, false);
        SafeParcelWriter.writeStringArray(parcel, 4, this.zzaz, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzaw, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzax, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzay, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzcu, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 9, this.zzcv, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzba, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzbb, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 12, this.zzbc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private MaskedWallet() {
    }
}
