package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "TransactionInfoCreator")
public final class TransactionInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TransactionInfo> CREATOR = new zzai();
    @SafeParcelable.Field(id = 1)
    public int zzdx;
    @SafeParcelable.Field(id = 2)
    public String zzdy;
    @SafeParcelable.Field(id = 3)
    public String zzdz;

    public final class Builder {
        private Builder() {
        }

        public final TransactionInfo build() {
            Preconditions.checkNotEmpty(TransactionInfo.this.zzdz, "currencyCode must be set!");
            TransactionInfo transactionInfo = TransactionInfo.this;
            int i = transactionInfo.zzdx;
            boolean z = true;
            if (!(i == 1 || i == 2 || i == 3)) {
                z = false;
            }
            if (z) {
                if (i == 2) {
                    Preconditions.checkNotEmpty(transactionInfo.zzdy, "An estimated total price must be set if totalPriceStatus is set to WalletConstants.TOTAL_PRICE_STATUS_ESTIMATED!");
                }
                TransactionInfo transactionInfo2 = TransactionInfo.this;
                if (transactionInfo2.zzdx == 3) {
                    Preconditions.checkNotEmpty(transactionInfo2.zzdy, "An final total price must be set if totalPriceStatus is set to WalletConstants.TOTAL_PRICE_STATUS_FINAL!");
                }
                return TransactionInfo.this;
            }
            throw new IllegalArgumentException("totalPriceStatus must be set to one of WalletConstants.TotalPriceStatus!");
        }

        public final Builder setCurrencyCode(@NonNull String str) {
            TransactionInfo.this.zzdz = str;
            return this;
        }

        public final Builder setTotalPrice(@NonNull String str) {
            TransactionInfo.this.zzdy = str;
            return this;
        }

        public final Builder setTotalPriceStatus(int i) {
            TransactionInfo.this.zzdx = i;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public TransactionInfo(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2) {
        this.zzdx = i;
        this.zzdy = str;
        this.zzdz = str2;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final String getCurrencyCode() {
        return this.zzdz;
    }

    @Nullable
    public final String getTotalPrice() {
        return this.zzdy;
    }

    public final int getTotalPriceStatus() {
        return this.zzdx;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzdx);
        SafeParcelWriter.writeString(parcel, 2, this.zzdy, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdz, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private TransactionInfo() {
    }
}
