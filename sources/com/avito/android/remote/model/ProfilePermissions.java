package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB7\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/ProfilePermissions;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "allowMultipleEmails", "Z", "getAllowMultipleEmails", "()Z", "isHiddenStats", "allowHideStats", "getAllowHideStats", "allowHidePhone", "getAllowHidePhone", "isPRO", "allowMultipleNames", "getAllowMultipleNames", "<init>", "(ZZZZZZ)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfilePermissions implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ProfilePermissions> CREATOR = Parcels.creator(ProfilePermissions$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("allowHidePhone")
    private final boolean allowHidePhone;
    @SerializedName("allowHideStats")
    private final boolean allowHideStats;
    @SerializedName("allowMultipleEmails")
    private final boolean allowMultipleEmails;
    @SerializedName("allowMultipleNames")
    private final boolean allowMultipleNames;
    @SerializedName("isHiddenStats")
    private final boolean isHiddenStats;
    @SerializedName("isPRO")
    private final boolean isPRO;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/ProfilePermissions$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/ProfilePermissions;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public ProfilePermissions(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7) {
        this.allowMultipleNames = z;
        this.allowMultipleEmails = z2;
        this.allowHidePhone = z3;
        this.allowHideStats = z4;
        this.isHiddenStats = z5;
        this.isPRO = z7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getAllowHidePhone() {
        return this.allowHidePhone;
    }

    public final boolean getAllowHideStats() {
        return this.allowHideStats;
    }

    public final boolean getAllowMultipleEmails() {
        return this.allowMultipleEmails;
    }

    public final boolean getAllowMultipleNames() {
        return this.allowMultipleNames;
    }

    public final boolean isHiddenStats() {
        return this.isHiddenStats;
    }

    public final boolean isPRO() {
        return this.isPRO;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeBool(parcel, this.allowMultipleNames);
        ParcelsKt.writeBool(parcel, this.allowMultipleEmails);
        ParcelsKt.writeBool(parcel, this.allowHidePhone);
        ParcelsKt.writeBool(parcel, this.allowHideStats);
        ParcelsKt.writeBool(parcel, this.isHiddenStats);
        ParcelsKt.writeBool(parcel, this.isPRO);
    }
}
