package com.avito.android.profile_phones.confirm_phone;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\nR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/PhoneConfirmationArguments;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "component3", "()J", "phone", "codeLength", "timeout", "copy", "(Ljava/lang/String;IJ)Lcom/avito/android/profile_phones/confirm_phone/PhoneConfirmationArguments;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "J", "getTimeout", AuthSource.BOOKING_ORDER, "I", "getCodeLength", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "<init>", "(Ljava/lang/String;IJ)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmationArguments implements Parcelable {
    public static final Parcelable.Creator<PhoneConfirmationArguments> CREATOR = new Creator();
    @NotNull
    public final String a;
    public final int b;
    public final long c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PhoneConfirmationArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneConfirmationArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PhoneConfirmationArguments(parcel.readString(), parcel.readInt(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneConfirmationArguments[] newArray(int i) {
            return new PhoneConfirmationArguments[i];
        }
    }

    public PhoneConfirmationArguments(@NotNull String str, int i, long j) {
        Intrinsics.checkNotNullParameter(str, "phone");
        this.a = str;
        this.b = i;
        this.c = j;
    }

    public static /* synthetic */ PhoneConfirmationArguments copy$default(PhoneConfirmationArguments phoneConfirmationArguments, String str, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = phoneConfirmationArguments.a;
        }
        if ((i2 & 2) != 0) {
            i = phoneConfirmationArguments.b;
        }
        if ((i2 & 4) != 0) {
            j = phoneConfirmationArguments.c;
        }
        return phoneConfirmationArguments.copy(str, i, j);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final long component3() {
        return this.c;
    }

    @NotNull
    public final PhoneConfirmationArguments copy(@NotNull String str, int i, long j) {
        Intrinsics.checkNotNullParameter(str, "phone");
        return new PhoneConfirmationArguments(str, i, j);
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
        if (!(obj instanceof PhoneConfirmationArguments)) {
            return false;
        }
        PhoneConfirmationArguments phoneConfirmationArguments = (PhoneConfirmationArguments) obj;
        return Intrinsics.areEqual(this.a, phoneConfirmationArguments.a) && this.b == phoneConfirmationArguments.b && this.c == phoneConfirmationArguments.c;
    }

    public final int getCodeLength() {
        return this.b;
    }

    @NotNull
    public final String getPhone() {
        return this.a;
    }

    public final long getTimeout() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + c.a(this.c);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PhoneConfirmationArguments(phone=");
        L.append(this.a);
        L.append(", codeLength=");
        L.append(this.b);
        L.append(", timeout=");
        return a.l(L, this.c, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeLong(this.c);
    }
}
