package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "SignInConfigurationCreator")
@SafeParcelable.Reserved({1})
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzx();
    @SafeParcelable.Field(getter = "getConsumerPkgName", id = 2)
    private final String zzcp;
    @SafeParcelable.Field(getter = "getGoogleConfig", id = 5)
    private GoogleSignInOptions zzcq;

    @SafeParcelable.Constructor
    public SignInConfiguration(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 5) GoogleSignInOptions googleSignInOptions) {
        this.zzcp = Preconditions.checkNotEmpty(str);
        this.zzcq = googleSignInOptions;
    }

    @Override // java.lang.Object
    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.zzcp.equals(signInConfiguration.zzcp)) {
            GoogleSignInOptions googleSignInOptions = this.zzcq;
            if (googleSignInOptions == null) {
                if (signInConfiguration.zzcq == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(signInConfiguration.zzcq)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return new HashAccumulator().addObject(this.zzcp).addObject(this.zzcq).hash();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzcp, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzcq, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final GoogleSignInOptions zzp() {
        return this.zzcq;
    }
}
