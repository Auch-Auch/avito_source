package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "LoyaltyPointsCreator")
@SafeParcelable.Reserved({1, 4})
public final class LoyaltyPoints extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LoyaltyPoints> CREATOR = new zzh();
    @SafeParcelable.Field(id = 2)
    public String label;
    @SafeParcelable.Field(id = 5)
    @Deprecated
    public TimeInterval zzcj;
    @SafeParcelable.Field(id = 3)
    public LoyaltyPointsBalance zzey;

    public final class Builder {
        private Builder() {
        }

        public final LoyaltyPoints build() {
            return LoyaltyPoints.this;
        }

        public final Builder setBalance(LoyaltyPointsBalance loyaltyPointsBalance) {
            LoyaltyPoints.this.zzey = loyaltyPointsBalance;
            return this;
        }

        public final Builder setLabel(String str) {
            LoyaltyPoints.this.label = str;
            return this;
        }

        @Deprecated
        public final Builder setType(String str) {
            return this;
        }

        @Deprecated
        public final Builder setValidTimeInterval(TimeInterval timeInterval) {
            LoyaltyPoints.this.zzcj = timeInterval;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public LoyaltyPoints(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) LoyaltyPointsBalance loyaltyPointsBalance, @SafeParcelable.Param(id = 5) TimeInterval timeInterval) {
        this.label = str;
        this.zzey = loyaltyPointsBalance;
        this.zzcj = timeInterval;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final LoyaltyPointsBalance getBalance() {
        return this.zzey;
    }

    public final String getLabel() {
        return this.label;
    }

    @Deprecated
    public final String getType() {
        return null;
    }

    @Deprecated
    public final TimeInterval getValidTimeInterval() {
        return this.zzcj;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.label, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzey, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzcj, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public LoyaltyPoints() {
    }
}
