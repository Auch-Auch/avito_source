package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/VerificationStepType;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/VerificationStepTypeOrientation;", "component3", "()Lcom/avito/android/remote/model/VerificationStepTypeOrientation;", "title", "value", "orientation", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/VerificationStepTypeOrientation;)Lcom/avito/android/remote/model/VerificationStepType;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/VerificationStepTypeOrientation;", "getOrientation", "Ljava/lang/String;", "getValue", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/VerificationStepTypeOrientation;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationStepType implements Parcelable {
    public static final Parcelable.Creator<VerificationStepType> CREATOR = new Creator();
    @SerializedName("orientation")
    @Nullable
    private final VerificationStepTypeOrientation orientation;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("value")
    @NotNull
    private final String value;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VerificationStepType> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerificationStepType createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new VerificationStepType(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (VerificationStepTypeOrientation) Enum.valueOf(VerificationStepTypeOrientation.class, parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerificationStepType[] newArray(int i) {
            return new VerificationStepType[i];
        }
    }

    public VerificationStepType(@NotNull String str, @NotNull String str2, @Nullable VerificationStepTypeOrientation verificationStepTypeOrientation) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.title = str;
        this.value = str2;
        this.orientation = verificationStepTypeOrientation;
    }

    public static /* synthetic */ VerificationStepType copy$default(VerificationStepType verificationStepType, String str, String str2, VerificationStepTypeOrientation verificationStepTypeOrientation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verificationStepType.title;
        }
        if ((i & 2) != 0) {
            str2 = verificationStepType.value;
        }
        if ((i & 4) != 0) {
            verificationStepTypeOrientation = verificationStepType.orientation;
        }
        return verificationStepType.copy(str, str2, verificationStepTypeOrientation);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.value;
    }

    @Nullable
    public final VerificationStepTypeOrientation component3() {
        return this.orientation;
    }

    @NotNull
    public final VerificationStepType copy(@NotNull String str, @NotNull String str2, @Nullable VerificationStepTypeOrientation verificationStepTypeOrientation) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "value");
        return new VerificationStepType(str, str2, verificationStepTypeOrientation);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerificationStepType)) {
            return false;
        }
        VerificationStepType verificationStepType = (VerificationStepType) obj;
        return Intrinsics.areEqual(this.title, verificationStepType.title) && Intrinsics.areEqual(this.value, verificationStepType.value) && Intrinsics.areEqual(this.orientation, verificationStepType.orientation);
    }

    @Nullable
    public final VerificationStepTypeOrientation getOrientation() {
        return this.orientation;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        VerificationStepTypeOrientation verificationStepTypeOrientation = this.orientation;
        if (verificationStepTypeOrientation != null) {
            i = verificationStepTypeOrientation.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("VerificationStepType(title=");
        L.append(this.title);
        L.append(", value=");
        L.append(this.value);
        L.append(", orientation=");
        L.append(this.orientation);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.value);
        VerificationStepTypeOrientation verificationStepTypeOrientation = this.orientation;
        if (verificationStepTypeOrientation != null) {
            parcel.writeInt(1);
            parcel.writeString(verificationStepTypeOrientation.name());
            return;
        }
        parcel.writeInt(0);
    }
}
