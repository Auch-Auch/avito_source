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
@SafeParcelable.Class(creator = "CardRequirementsCreator")
public final class CardRequirements extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CardRequirements> CREATOR = new zze();
    @SafeParcelable.Field(id = 1)
    public ArrayList<Integer> zzaj;
    @SafeParcelable.Field(defaultValue = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, id = 2)
    public boolean zzak;
    @SafeParcelable.Field(id = 3)
    public boolean zzal;
    @SafeParcelable.Field(id = 4)
    public int zzam;

    public final class Builder {
        private Builder() {
        }

        public final Builder addAllowedCardNetwork(int i) {
            CardRequirements cardRequirements = CardRequirements.this;
            if (cardRequirements.zzaj == null) {
                cardRequirements.zzaj = new ArrayList<>();
            }
            CardRequirements.this.zzaj.add(Integer.valueOf(i));
            return this;
        }

        public final Builder addAllowedCardNetworks(@NonNull Collection<Integer> collection) {
            Preconditions.checkArgument(collection != null && !collection.isEmpty(), "allowedCardNetworks can't be null or empty! You must provide a valid value from WalletConstants.CardNetwork.");
            CardRequirements cardRequirements = CardRequirements.this;
            if (cardRequirements.zzaj == null) {
                cardRequirements.zzaj = new ArrayList<>();
            }
            CardRequirements.this.zzaj.addAll(collection);
            return this;
        }

        public final CardRequirements build() {
            Preconditions.checkNotNull(CardRequirements.this.zzaj, "Allowed card networks must be non-empty! You can set it through addAllowedCardNetwork() or addAllowedCardNetworks() in the CardRequirements Builder.");
            return CardRequirements.this;
        }

        public final Builder setAllowPrepaidCards(boolean z) {
            CardRequirements.this.zzak = z;
            return this;
        }

        public final Builder setBillingAddressFormat(int i) {
            CardRequirements.this.zzam = i;
            return this;
        }

        public final Builder setBillingAddressRequired(boolean z) {
            CardRequirements.this.zzal = z;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public CardRequirements(@SafeParcelable.Param(id = 1) ArrayList<Integer> arrayList, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) int i) {
        this.zzaj = arrayList;
        this.zzak = z;
        this.zzal = z2;
        this.zzam = i;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final boolean allowPrepaidCards() {
        return this.zzak;
    }

    @Nullable
    public final ArrayList<Integer> getAllowedCardNetworks() {
        return this.zzaj;
    }

    public final int getBillingAddressFormat() {
        return this.zzam;
    }

    public final boolean isBillingAddressRequired() {
        return this.zzal;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, this.zzaj, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzak);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzal);
        SafeParcelWriter.writeInt(parcel, 4, this.zzam);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private CardRequirements() {
        this.zzak = true;
    }
}
