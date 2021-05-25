package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "HintRequestCreator")
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new zzj();
    @SafeParcelable.Field(getter = "getAccountTypes", id = 4)
    private final String[] zzab;
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 5)
    private final boolean zzae;
    @Nullable
    @SafeParcelable.Field(getter = "getServerClientId", id = 6)
    private final String zzaf;
    @Nullable
    @SafeParcelable.Field(getter = "getIdTokenNonce", id = 7)
    private final String zzag;
    @SafeParcelable.Field(getter = "getHintPickerConfig", id = 1)
    private final CredentialPickerConfig zzai;
    @SafeParcelable.Field(getter = "isEmailAddressIdentifierSupported", id = 2)
    private final boolean zzaj;
    @SafeParcelable.Field(getter = "isPhoneNumberIdentifierSupported", id = 3)
    private final boolean zzak;
    @SafeParcelable.Field(id = 1000)
    private final int zzv;

    public static final class Builder {
        private String[] zzab;
        private boolean zzae = false;
        @Nullable
        private String zzaf;
        @Nullable
        private String zzag;
        private CredentialPickerConfig zzai = new CredentialPickerConfig.Builder().build();
        private boolean zzaj;
        private boolean zzak;

        public final HintRequest build() {
            if (this.zzab == null) {
                this.zzab = new String[0];
            }
            if (this.zzaj || this.zzak || this.zzab.length != 0) {
                return new HintRequest(this);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public final Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zzab = strArr;
            return this;
        }

        public final Builder setEmailAddressIdentifierSupported(boolean z) {
            this.zzaj = z;
            return this;
        }

        public final Builder setHintPickerConfig(@NonNull CredentialPickerConfig credentialPickerConfig) {
            this.zzai = (CredentialPickerConfig) Preconditions.checkNotNull(credentialPickerConfig);
            return this;
        }

        public final Builder setIdTokenNonce(@Nullable String str) {
            this.zzag = str;
            return this;
        }

        public final Builder setIdTokenRequested(boolean z) {
            this.zzae = z;
            return this;
        }

        public final Builder setPhoneNumberIdentifierSupported(boolean z) {
            this.zzak = z;
            return this;
        }

        public final Builder setServerClientId(@Nullable String str) {
            this.zzaf = str;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public HintRequest(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) String[] strArr, @SafeParcelable.Param(id = 5) boolean z3, @Nullable @SafeParcelable.Param(id = 6) String str, @Nullable @SafeParcelable.Param(id = 7) String str2) {
        this.zzv = i;
        this.zzai = (CredentialPickerConfig) Preconditions.checkNotNull(credentialPickerConfig);
        this.zzaj = z;
        this.zzak = z2;
        this.zzab = (String[]) Preconditions.checkNotNull(strArr);
        if (i < 2) {
            this.zzae = true;
            this.zzaf = null;
            this.zzag = null;
            return;
        }
        this.zzae = z3;
        this.zzaf = str;
        this.zzag = str2;
    }

    @NonNull
    public final String[] getAccountTypes() {
        return this.zzab;
    }

    @NonNull
    public final CredentialPickerConfig getHintPickerConfig() {
        return this.zzai;
    }

    @Nullable
    public final String getIdTokenNonce() {
        return this.zzag;
    }

    @Nullable
    public final String getServerClientId() {
        return this.zzaf;
    }

    public final boolean isEmailAddressIdentifierSupported() {
        return this.zzaj;
    }

    public final boolean isIdTokenRequested() {
        return this.zzae;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getHintPickerConfig(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, isEmailAddressIdentifierSupported());
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzak);
        SafeParcelWriter.writeStringArray(parcel, 4, getAccountTypes(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzv);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private HintRequest(Builder builder) {
        this(2, builder.zzai, builder.zzaj, builder.zzak, builder.zzab, builder.zzae, builder.zzaf, builder.zzag);
    }
}
