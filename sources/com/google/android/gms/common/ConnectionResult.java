package com.google.android.gms.common;

import a2.b.a.a.a;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.avito.android.payment.SberbankOnlineKt;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "ConnectionResultCreator")
public final class ConnectionResult extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final int API_UNAVAILABLE = 16;
    @RecentlyNonNull
    public static final int CANCELED = 13;
    @RecentlyNonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zza();
    @RecentlyNonNull
    public static final int DEVELOPER_ERROR = 10;
    @RecentlyNonNull
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    @RecentlyNonNull
    public static final int INTERNAL_ERROR = 8;
    @RecentlyNonNull
    public static final int INTERRUPTED = 15;
    @RecentlyNonNull
    public static final int INVALID_ACCOUNT = 5;
    @RecentlyNonNull
    public static final int LICENSE_CHECK_FAILED = 11;
    @RecentlyNonNull
    public static final int NETWORK_ERROR = 7;
    @RecentlyNonNull
    public static final int RESOLUTION_ACTIVITY_NOT_FOUND = 22;
    @RecentlyNonNull
    public static final int RESOLUTION_REQUIRED = 6;
    @RecentlyNonNull
    public static final int RESTRICTED_PROFILE = 20;
    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);
    @RecentlyNonNull
    public static final int SERVICE_DISABLED = 3;
    @RecentlyNonNull
    public static final int SERVICE_INVALID = 9;
    @RecentlyNonNull
    public static final int SERVICE_MISSING = 1;
    @RecentlyNonNull
    public static final int SERVICE_MISSING_PERMISSION = 19;
    @RecentlyNonNull
    public static final int SERVICE_UPDATING = 18;
    @RecentlyNonNull
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    @RecentlyNonNull
    public static final int SIGN_IN_FAILED = 17;
    @RecentlyNonNull
    public static final int SIGN_IN_REQUIRED = 4;
    @RecentlyNonNull
    public static final int SUCCESS = 0;
    @RecentlyNonNull
    public static final int TIMEOUT = 14;
    @RecentlyNonNull
    @KeepForSdk
    public static final int UNKNOWN = -1;
    @SafeParcelable.VersionField(id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getErrorCode", id = 2)
    private final int zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getResolution", id = 3)
    private final PendingIntent zzc;
    @Nullable
    @SafeParcelable.Field(getter = "getErrorMessage", id = 4)
    private final String zzd;

    @SafeParcelable.Constructor
    public ConnectionResult(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @Nullable @SafeParcelable.Param(id = 3) PendingIntent pendingIntent, @Nullable @SafeParcelable.Param(id = 4) String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = pendingIntent;
        this.zzd = str;
    }

    @NonNull
    public static String zza(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return SberbankOnlineKt.RESULT_SUCCESS;
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    default:
                        return a.o2(31, "UNKNOWN_ERROR_CODE(", i, ")");
                }
        }
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.zzb == connectionResult.zzb && Objects.equal(this.zzc, connectionResult.zzc) && Objects.equal(this.zzd, connectionResult.zzd);
    }

    @RecentlyNonNull
    public final int getErrorCode() {
        return this.zzb;
    }

    @RecentlyNullable
    public final String getErrorMessage() {
        return this.zzd;
    }

    @RecentlyNullable
    public final PendingIntent getResolution() {
        return this.zzc;
    }

    @RecentlyNonNull
    public final boolean hasResolution() {
        return (this.zzb == 0 || this.zzc == null) ? false : true;
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    @RecentlyNonNull
    public final boolean isSuccess() {
        return this.zzb == 0;
    }

    public final void startResolutionForResult(@RecentlyNonNull Activity activity, @RecentlyNonNull int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(((PendingIntent) Preconditions.checkNotNull(this.zzc)).getIntentSender(), i, null, 0, 0, 0);
        }
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final String toString() {
        return Objects.toStringHelper(this).add("statusCode", zza(this.zzb)).add("resolution", this.zzc).add("message", this.zzd).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, getErrorCode());
        SafeParcelWriter.writeParcelable(parcel, 3, getResolution(), i, false);
        SafeParcelWriter.writeString(parcel, 4, getErrorMessage(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public ConnectionResult(@RecentlyNonNull int i) {
        this(i, null, null);
    }

    public ConnectionResult(@RecentlyNonNull int i, @Nullable PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(@RecentlyNonNull int i, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this(1, i, pendingIntent, str);
    }
}
