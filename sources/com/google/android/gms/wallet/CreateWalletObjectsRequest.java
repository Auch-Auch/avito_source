package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@SafeParcelable.Class(creator = "CreateWalletObjectsRequestCreator")
@SafeParcelable.Reserved({1})
public final class CreateWalletObjectsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CreateWalletObjectsRequest> CREATOR = new zzg();
    public static final int REQUEST_IMMEDIATE_SAVE = 1;
    public static final int SHOW_SAVE_PROMPT = 0;
    @SafeParcelable.Field(id = 2)
    public LoyaltyWalletObject zzao;
    @SafeParcelable.Field(id = 3)
    public OfferWalletObject zzap;
    @SafeParcelable.Field(id = 4)
    public GiftCardWalletObject zzaq;
    @SafeParcelable.Field(id = 5)
    public int zzar;

    public final class Builder {
        private Builder() {
        }

        public final CreateWalletObjectsRequest build() {
            CreateWalletObjectsRequest createWalletObjectsRequest = CreateWalletObjectsRequest.this;
            boolean z = false;
            if ((createWalletObjectsRequest.zzaq == null ? 0 : 1) + (createWalletObjectsRequest.zzao == null ? 0 : 1) + (createWalletObjectsRequest.zzap == null ? 0 : 1) == 1) {
                z = true;
            }
            Preconditions.checkState(z, "CreateWalletObjectsRequest must have exactly one Wallet Object");
            return CreateWalletObjectsRequest.this;
        }

        public final Builder setCreateMode(int i) {
            CreateWalletObjectsRequest.this.zzar = i;
            return this;
        }

        public final Builder setGiftCardWalletObject(GiftCardWalletObject giftCardWalletObject) {
            CreateWalletObjectsRequest.this.zzaq = giftCardWalletObject;
            return this;
        }

        public final Builder setLoyaltyWalletObject(LoyaltyWalletObject loyaltyWalletObject) {
            CreateWalletObjectsRequest.this.zzao = loyaltyWalletObject;
            return this;
        }

        public final Builder setOfferWalletObject(OfferWalletObject offerWalletObject) {
            CreateWalletObjectsRequest.this.zzap = offerWalletObject;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CreateMode {
    }

    @SafeParcelable.Constructor
    public CreateWalletObjectsRequest(@SafeParcelable.Param(id = 2) LoyaltyWalletObject loyaltyWalletObject, @SafeParcelable.Param(id = 3) OfferWalletObject offerWalletObject, @SafeParcelable.Param(id = 4) GiftCardWalletObject giftCardWalletObject, @SafeParcelable.Param(id = 5) int i) {
        this.zzao = loyaltyWalletObject;
        this.zzap = offerWalletObject;
        this.zzaq = giftCardWalletObject;
        this.zzar = i;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final int getCreateMode() {
        return this.zzar;
    }

    public final GiftCardWalletObject getGiftCardWalletObject() {
        return this.zzaq;
    }

    public final LoyaltyWalletObject getLoyaltyWalletObject() {
        return this.zzao;
    }

    public final OfferWalletObject getOfferWalletObject() {
        return this.zzap;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzao, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzap, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzaq, i, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzar);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public CreateWalletObjectsRequest() {
    }

    @Deprecated
    public CreateWalletObjectsRequest(LoyaltyWalletObject loyaltyWalletObject) {
        this.zzao = loyaltyWalletObject;
    }

    @Deprecated
    public CreateWalletObjectsRequest(OfferWalletObject offerWalletObject) {
        this.zzap = offerWalletObject;
    }

    @Deprecated
    public CreateWalletObjectsRequest(GiftCardWalletObject giftCardWalletObject) {
        this.zzaq = giftCardWalletObject;
    }
}
