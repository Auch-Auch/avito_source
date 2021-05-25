package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
@SafeParcelable.Class(creator = "CardInfoCreator")
public final class CardInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CardInfo> CREATOR = new zzc();
    @SafeParcelable.Field(id = 4)
    private int zzaa;
    @SafeParcelable.Field(id = 5)
    private UserAddress zzab;
    @SafeParcelable.Field(id = 1)
    private String zzx;
    @SafeParcelable.Field(id = 2)
    private String zzy;
    @SafeParcelable.Field(id = 3)
    private String zzz;

    @SafeParcelable.Constructor
    public CardInfo(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) int i, @SafeParcelable.Param(id = 5) UserAddress userAddress) {
        this.zzx = str;
        this.zzy = str2;
        this.zzz = str3;
        this.zzaa = i;
        this.zzab = userAddress;
    }

    @Nullable
    public final UserAddress getBillingAddress() {
        return this.zzab;
    }

    public final int getCardClass() {
        int i = this.zzaa;
        if (i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 0;
    }

    public final String getCardDescription() {
        return this.zzx;
    }

    public final String getCardDetails() {
        return this.zzz;
    }

    public final String getCardNetwork() {
        return this.zzy;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzx, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzy, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzz, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzaa);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzab, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private CardInfo() {
    }
}
