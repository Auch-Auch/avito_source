package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "SignInCredentialCreator")
public final class SignInCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInCredential> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getId", id = 1)
    private final String zzbd;
    @Nullable
    @SafeParcelable.Field(getter = "getDisplayName", id = 2)
    private final String zzbe;
    @Nullable
    @SafeParcelable.Field(getter = "getGivenName", id = 3)
    private final String zzbf;
    @Nullable
    @SafeParcelable.Field(getter = "getFamilyName", id = 4)
    private final String zzbg;
    @Nullable
    @SafeParcelable.Field(getter = "getProfilePictureUri", id = 5)
    private final Uri zzbh;
    @Nullable
    @SafeParcelable.Field(getter = "getPassword", id = 6)
    private final String zzbi;
    @Nullable
    @SafeParcelable.Field(getter = "getGoogleIdToken", id = 7)
    private final String zzbj;

    @SafeParcelable.Constructor
    public SignInCredential(@SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) String str3, @Nullable @SafeParcelable.Param(id = 4) String str4, @Nullable @SafeParcelable.Param(id = 5) Uri uri, @Nullable @SafeParcelable.Param(id = 6) String str5, @Nullable @SafeParcelable.Param(id = 7) String str6) {
        this.zzbd = Preconditions.checkNotEmpty(str);
        this.zzbe = str2;
        this.zzbf = str3;
        this.zzbg = str4;
        this.zzbh = uri;
        this.zzbi = str5;
        this.zzbj = str6;
    }

    @Override // java.lang.Object
    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) obj;
        if (!Objects.equal(this.zzbd, signInCredential.zzbd) || !Objects.equal(this.zzbe, signInCredential.zzbe) || !Objects.equal(this.zzbf, signInCredential.zzbf) || !Objects.equal(this.zzbg, signInCredential.zzbg) || !Objects.equal(this.zzbh, signInCredential.zzbh) || !Objects.equal(this.zzbi, signInCredential.zzbi) || !Objects.equal(this.zzbj, signInCredential.zzbj)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzbe;
    }

    @Nullable
    public final String getFamilyName() {
        return this.zzbg;
    }

    @Nullable
    public final String getGivenName() {
        return this.zzbf;
    }

    @Nullable
    public final String getGoogleIdToken() {
        return this.zzbj;
    }

    public final String getId() {
        return this.zzbd;
    }

    @Nullable
    public final String getPassword() {
        return this.zzbi;
    }

    @Nullable
    public final Uri getProfilePictureUri() {
        return this.zzbh;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Objects.hashCode(this.zzbd, this.zzbe, this.zzbf, this.zzbg, this.zzbh, this.zzbi, this.zzbj);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 4, getFamilyName(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getProfilePictureUri(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 7, getGoogleIdToken(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
