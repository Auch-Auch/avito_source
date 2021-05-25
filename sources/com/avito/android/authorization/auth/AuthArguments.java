package com.avito.android.authorization.auth;

import a2.b.a.a.a;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0013J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0004¨\u0006*"}, d2 = {"Lcom/avito/android/authorization/auth/AuthArguments;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Landroid/content/Intent;", "component2", "()Landroid/content/Intent;", "", "component3", "()Z", "src", "intent", "resultOk", "copy", "(Ljava/lang/String;Landroid/content/Intent;Z)Lcom/avito/android/authorization/auth/AuthArguments;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Z", "getResultOk", AuthSource.BOOKING_ORDER, "Landroid/content/Intent;", "getIntent", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSrc", "<init>", "(Ljava/lang/String;Landroid/content/Intent;Z)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class AuthArguments implements Parcelable {
    public static final Parcelable.Creator<AuthArguments> CREATOR = new Creator();
    @Nullable
    public final String a;
    @Nullable
    public final Intent b;
    public final boolean c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AuthArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AuthArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AuthArguments(parcel.readString(), (Intent) parcel.readParcelable(AuthArguments.class.getClassLoader()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AuthArguments[] newArray(int i) {
            return new AuthArguments[i];
        }
    }

    public AuthArguments(@Nullable String str, @Nullable Intent intent, boolean z) {
        this.a = str;
        this.b = intent;
        this.c = z;
    }

    public static /* synthetic */ AuthArguments copy$default(AuthArguments authArguments, String str, Intent intent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authArguments.a;
        }
        if ((i & 2) != 0) {
            intent = authArguments.b;
        }
        if ((i & 4) != 0) {
            z = authArguments.c;
        }
        return authArguments.copy(str, intent, z);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final Intent component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final AuthArguments copy(@Nullable String str, @Nullable Intent intent, boolean z) {
        return new AuthArguments(str, intent, z);
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
        if (!(obj instanceof AuthArguments)) {
            return false;
        }
        AuthArguments authArguments = (AuthArguments) obj;
        return Intrinsics.areEqual(this.a, authArguments.a) && Intrinsics.areEqual(this.b, authArguments.b) && this.c == authArguments.c;
    }

    @Nullable
    public final Intent getIntent() {
        return this.b;
    }

    public final boolean getResultOk() {
        return this.c;
    }

    @Nullable
    public final String getSrc() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Intent intent = this.b;
        if (intent != null) {
            i = intent.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AuthArguments(src=");
        L.append(this.a);
        L.append(", intent=");
        L.append(this.b);
        L.append(", resultOk=");
        return a.B(L, this.c, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeInt(this.c ? 1 : 0);
    }
}
