package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "PaymentMethodTokenCreator")
@SafeParcelable.Reserved({1})
public final class PaymentMethodToken extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PaymentMethodToken> CREATOR = new zzx();
    @SafeParcelable.Field(id = 2)
    private int zzdl;
    @SafeParcelable.Field(id = 3)
    private String zzdm;

    @SafeParcelable.Constructor
    public PaymentMethodToken(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) String str) {
        this.zzdl = i;
        this.zzdm = str;
    }

    public final int getPaymentMethodTokenizationType() {
        return this.zzdl;
    }

    public final String getToken() {
        return this.zzdm;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzdl);
        SafeParcelWriter.writeString(parcel, 3, this.zzdm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private PaymentMethodToken() {
    }
}
