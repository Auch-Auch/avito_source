package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
@SafeParcelable.Class(creator = "IsReadyToPayRequestCreator")
@SafeParcelable.Reserved({1})
public final class IsReadyToPayRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<IsReadyToPayRequest> CREATOR = new zzn();
    @SafeParcelable.Field(id = 2)
    public ArrayList<Integer> zzaj;
    @SafeParcelable.Field(id = 4)
    private String zzbs;
    @SafeParcelable.Field(id = 5)
    private String zzbt;
    @SafeParcelable.Field(id = 6)
    public ArrayList<Integer> zzbu;
    @SafeParcelable.Field(id = 7)
    public boolean zzbv;
    @SafeParcelable.Field(id = 8)
    private String zzbw;

    @Deprecated
    public final class Builder {
        private Builder() {
        }

        public final Builder addAllowedCardNetwork(int i) {
            IsReadyToPayRequest isReadyToPayRequest = IsReadyToPayRequest.this;
            if (isReadyToPayRequest.zzaj == null) {
                isReadyToPayRequest.zzaj = new ArrayList<>();
            }
            IsReadyToPayRequest.this.zzaj.add(Integer.valueOf(i));
            return this;
        }

        public final Builder addAllowedCardNetworks(Collection<Integer> collection) {
            Preconditions.checkArgument(collection != null && !collection.isEmpty(), "allowedCardNetworks can't be null or empty. If you want the defaults, leave it unset.");
            IsReadyToPayRequest isReadyToPayRequest = IsReadyToPayRequest.this;
            if (isReadyToPayRequest.zzaj == null) {
                isReadyToPayRequest.zzaj = new ArrayList<>();
            }
            IsReadyToPayRequest.this.zzaj.addAll(collection);
            return this;
        }

        public final Builder addAllowedPaymentMethod(int i) {
            IsReadyToPayRequest isReadyToPayRequest = IsReadyToPayRequest.this;
            if (isReadyToPayRequest.zzbu == null) {
                isReadyToPayRequest.zzbu = new ArrayList<>();
            }
            IsReadyToPayRequest.this.zzbu.add(Integer.valueOf(i));
            return this;
        }

        public final Builder addAllowedPaymentMethods(Collection<Integer> collection) {
            Preconditions.checkArgument(collection != null && !collection.isEmpty(), "allowedPaymentMethods can't be null or empty. If you want the default, leave it unset.");
            IsReadyToPayRequest isReadyToPayRequest = IsReadyToPayRequest.this;
            if (isReadyToPayRequest.zzbu == null) {
                isReadyToPayRequest.zzbu = new ArrayList<>();
            }
            IsReadyToPayRequest.this.zzbu.addAll(collection);
            return this;
        }

        public final IsReadyToPayRequest build() {
            return IsReadyToPayRequest.this;
        }

        public final Builder setExistingPaymentMethodRequired(boolean z) {
            IsReadyToPayRequest.this.zzbv = z;
            return this;
        }
    }

    public IsReadyToPayRequest() {
    }

    public static IsReadyToPayRequest fromJson(String str) {
        Builder newBuilder = newBuilder();
        IsReadyToPayRequest.this.zzbw = (String) Preconditions.checkNotNull(str, "isReadyToPayRequestJson cannot be null!");
        return newBuilder.build();
    }

    @Deprecated
    public static Builder newBuilder() {
        return new Builder();
    }

    @Deprecated
    public final ArrayList<Integer> getAllowedCardNetworks() {
        return this.zzaj;
    }

    @Deprecated
    public final ArrayList<Integer> getAllowedPaymentMethods() {
        return this.zzbu;
    }

    @Deprecated
    public final boolean isExistingPaymentMethodRequired() {
        return this.zzbv;
    }

    public final String toJson() {
        return this.zzbw;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 2, this.zzaj, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzbs, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbt, false);
        SafeParcelWriter.writeIntegerList(parcel, 6, this.zzbu, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbv);
        SafeParcelWriter.writeString(parcel, 8, this.zzbw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public IsReadyToPayRequest(@SafeParcelable.Param(id = 2) ArrayList<Integer> arrayList, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) ArrayList<Integer> arrayList2, @SafeParcelable.Param(id = 7) boolean z, @SafeParcelable.Param(id = 8) String str3) {
        this.zzaj = arrayList;
        this.zzbs = str;
        this.zzbt = str2;
        this.zzbu = arrayList2;
        this.zzbv = z;
        this.zzbw = str3;
    }
}
