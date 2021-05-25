package com.google.android.gms.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.identity.intents.model.UserAddress;
@SafeParcelable.Class(creator = "PaymentDataCreator")
public final class PaymentData extends AbstractSafeParcelable implements AutoResolvableResult {
    public static final Parcelable.Creator<PaymentData> CREATOR = new zzu();
    @SafeParcelable.Field(id = 5)
    private String zzat;
    @SafeParcelable.Field(id = 1)
    private String zzaw;
    @SafeParcelable.Field(id = 4)
    private PaymentMethodToken zzbd;
    @SafeParcelable.Field(id = 7)
    private String zzbw;
    @SafeParcelable.Field(id = 2)
    private CardInfo zzcy;
    @SafeParcelable.Field(id = 3)
    private UserAddress zzcz;
    @SafeParcelable.Field(id = 6)
    private Bundle zzda;

    public final class zza {
        private zza() {
        }
    }

    @SafeParcelable.Constructor
    public PaymentData(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) CardInfo cardInfo, @SafeParcelable.Param(id = 3) UserAddress userAddress, @SafeParcelable.Param(id = 4) PaymentMethodToken paymentMethodToken, @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) Bundle bundle, @SafeParcelable.Param(id = 7) String str3) {
        this.zzaw = str;
        this.zzcy = cardInfo;
        this.zzcz = userAddress;
        this.zzbd = paymentMethodToken;
        this.zzat = str2;
        this.zzda = bundle;
        this.zzbw = str3;
    }

    public static PaymentData fromJson(String str) {
        PaymentData paymentData = PaymentData.this;
        paymentData.zzbw = (String) Preconditions.checkNotNull(str, "paymentDataJson cannot be null!");
        return paymentData;
    }

    @Nullable
    public static PaymentData getFromIntent(@NonNull Intent intent) {
        return (PaymentData) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.android.gms.wallet.PaymentData", CREATOR);
    }

    @Deprecated
    public final CardInfo getCardInfo() {
        return this.zzcy;
    }

    @Nullable
    @Deprecated
    public final String getEmail() {
        return this.zzaw;
    }

    @Nullable
    @Deprecated
    public final Bundle getExtraData() {
        return this.zzda;
    }

    @Deprecated
    public final String getGoogleTransactionId() {
        return this.zzat;
    }

    @Nullable
    @Deprecated
    public final PaymentMethodToken getPaymentMethodToken() {
        return this.zzbd;
    }

    @Nullable
    @Deprecated
    public final UserAddress getShippingAddress() {
        return this.zzcz;
    }

    @Override // com.google.android.gms.wallet.AutoResolvableResult
    public final void putIntoIntent(@NonNull Intent intent) {
        SafeParcelableSerializer.serializeToIntentExtra(this, intent, "com.google.android.gms.wallet.PaymentData");
    }

    public final String toJson() {
        return this.zzbw;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzaw, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzcy, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzcz, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzat, false);
        SafeParcelWriter.writeBundle(parcel, 6, this.zzda, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzbw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private PaymentData() {
    }
}
