package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
@SafeParcelable.Class(creator = "PaymentDataRequestCreator")
public final class PaymentDataRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PaymentDataRequest> CREATOR = new zzw();
    @SafeParcelable.Field(id = 6)
    public ArrayList<Integer> zzbu;
    @SafeParcelable.Field(id = 10)
    public String zzbw;
    @SafeParcelable.Field(id = 1)
    public boolean zzdc;
    @SafeParcelable.Field(id = 2)
    public boolean zzdd;
    @SafeParcelable.Field(id = 3)
    public CardRequirements zzde;
    @SafeParcelable.Field(id = 4)
    public boolean zzdf;
    @SafeParcelable.Field(id = 5)
    public ShippingAddressRequirements zzdg;
    @SafeParcelable.Field(id = 7)
    public PaymentMethodTokenizationParameters zzdh;
    @SafeParcelable.Field(id = 8)
    public TransactionInfo zzdi;
    @SafeParcelable.Field(defaultValue = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, id = 9)
    public boolean zzdj;

    @Deprecated
    public final class Builder {
        private Builder() {
        }

        public final Builder addAllowedPaymentMethod(int i) {
            PaymentDataRequest paymentDataRequest = PaymentDataRequest.this;
            if (paymentDataRequest.zzbu == null) {
                paymentDataRequest.zzbu = new ArrayList<>();
            }
            PaymentDataRequest.this.zzbu.add(Integer.valueOf(i));
            return this;
        }

        public final Builder addAllowedPaymentMethods(@NonNull Collection<Integer> collection) {
            Preconditions.checkArgument(collection != null && !collection.isEmpty(), "allowedPaymentMethods can't be null or empty!");
            PaymentDataRequest paymentDataRequest = PaymentDataRequest.this;
            if (paymentDataRequest.zzbu == null) {
                paymentDataRequest.zzbu = new ArrayList<>();
            }
            PaymentDataRequest.this.zzbu.addAll(collection);
            return this;
        }

        public final PaymentDataRequest build() {
            PaymentDataRequest paymentDataRequest = PaymentDataRequest.this;
            if (paymentDataRequest.zzbw == null) {
                Preconditions.checkNotNull(paymentDataRequest.zzbu, "Allowed payment methods must be set! You can set it through addAllowedPaymentMethod() or addAllowedPaymentMethods() in the PaymentDataRequest Builder.");
                Preconditions.checkNotNull(PaymentDataRequest.this.zzde, "Card requirements must be set!");
                PaymentDataRequest paymentDataRequest2 = PaymentDataRequest.this;
                if (paymentDataRequest2.zzdh != null) {
                    Preconditions.checkNotNull(paymentDataRequest2.zzdi, "Transaction info must be set if paymentMethodTokenizationParameters is set!");
                }
            }
            return PaymentDataRequest.this;
        }

        public final Builder setCardRequirements(@NonNull CardRequirements cardRequirements) {
            PaymentDataRequest.this.zzde = cardRequirements;
            return this;
        }

        public final Builder setEmailRequired(boolean z) {
            PaymentDataRequest.this.zzdc = z;
            return this;
        }

        public final Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters) {
            PaymentDataRequest.this.zzdh = paymentMethodTokenizationParameters;
            return this;
        }

        public final Builder setPhoneNumberRequired(boolean z) {
            PaymentDataRequest.this.zzdd = z;
            return this;
        }

        public final Builder setShippingAddressRequired(boolean z) {
            PaymentDataRequest.this.zzdf = z;
            return this;
        }

        public final Builder setShippingAddressRequirements(@NonNull ShippingAddressRequirements shippingAddressRequirements) {
            PaymentDataRequest.this.zzdg = shippingAddressRequirements;
            return this;
        }

        public final Builder setTransactionInfo(@NonNull TransactionInfo transactionInfo) {
            PaymentDataRequest.this.zzdi = transactionInfo;
            return this;
        }

        public final Builder setUiRequired(boolean z) {
            PaymentDataRequest.this.zzdj = z;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public PaymentDataRequest(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) boolean z2, @SafeParcelable.Param(id = 3) CardRequirements cardRequirements, @SafeParcelable.Param(id = 4) boolean z3, @SafeParcelable.Param(id = 5) ShippingAddressRequirements shippingAddressRequirements, @SafeParcelable.Param(id = 6) ArrayList<Integer> arrayList, @SafeParcelable.Param(id = 7) PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, @SafeParcelable.Param(id = 8) TransactionInfo transactionInfo, @SafeParcelable.Param(id = 9) boolean z4, @SafeParcelable.Param(id = 10) String str) {
        this.zzdc = z;
        this.zzdd = z2;
        this.zzde = cardRequirements;
        this.zzdf = z3;
        this.zzdg = shippingAddressRequirements;
        this.zzbu = arrayList;
        this.zzdh = paymentMethodTokenizationParameters;
        this.zzdi = transactionInfo;
        this.zzdj = z4;
        this.zzbw = str;
    }

    public static PaymentDataRequest fromJson(String str) {
        Builder newBuilder = newBuilder();
        PaymentDataRequest.this.zzbw = (String) Preconditions.checkNotNull(str, "paymentDataRequestJson cannot be null!");
        return newBuilder.build();
    }

    @Deprecated
    public static Builder newBuilder() {
        return new Builder();
    }

    @Deprecated
    public final ArrayList<Integer> getAllowedPaymentMethods() {
        return this.zzbu;
    }

    @Nullable
    @Deprecated
    public final CardRequirements getCardRequirements() {
        return this.zzde;
    }

    @Deprecated
    public final PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters() {
        return this.zzdh;
    }

    @Nullable
    @Deprecated
    public final ShippingAddressRequirements getShippingAddressRequirements() {
        return this.zzdg;
    }

    @Deprecated
    public final TransactionInfo getTransactionInfo() {
        return this.zzdi;
    }

    @Deprecated
    public final boolean isEmailRequired() {
        return this.zzdc;
    }

    @Deprecated
    public final boolean isPhoneNumberRequired() {
        return this.zzdd;
    }

    @Deprecated
    public final boolean isShippingAddressRequired() {
        return this.zzdf;
    }

    @Deprecated
    public final boolean isUiRequired() {
        return this.zzdj;
    }

    public final String toJson() {
        return this.zzbw;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzdc);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdd);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzde, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzdf);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzdg, i, false);
        SafeParcelWriter.writeIntegerList(parcel, 6, this.zzbu, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzdh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzdi, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzdj);
        SafeParcelWriter.writeString(parcel, 10, this.zzbw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private PaymentDataRequest() {
        this.zzdj = true;
    }
}
