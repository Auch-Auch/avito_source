package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.preferences.SessionContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B#\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b \u0010!J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ2\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0016\u0010\nJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u001e\u0010\rR\u001c\u0010\u0011\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001f\u0010\r¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/Session;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "component1", "component2", "component3", SessionContract.SESSION, "refreshToken", "pushToken", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/Session;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRefreshToken", "getPushToken", "getSession", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class Session implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Session> CREATOR = Parcels.creator(Session$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Session NULL = new Session("", null, null);
    @SerializedName("phash")
    @Nullable
    private final String pushToken;
    @SerializedName("refreshToken")
    @Nullable
    private final String refreshToken;
    @SerializedName(SessionContract.SESSION)
    @NotNull
    private final String session;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/Session$Companion;", "", "Lcom/avito/android/remote/model/Session;", "NULL", "Lcom/avito/android/remote/model/Session;", "getNULL", "()Lcom/avito/android/remote/model/Session;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Session getNULL() {
            return Session.NULL;
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public Session(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, SessionContract.SESSION);
        this.session = str;
        this.refreshToken = str2;
        this.pushToken = str3;
    }

    public static /* synthetic */ Session copy$default(Session session2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = session2.session;
        }
        if ((i & 2) != 0) {
            str2 = session2.refreshToken;
        }
        if ((i & 4) != 0) {
            str3 = session2.pushToken;
        }
        return session2.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.session;
    }

    @Nullable
    public final String component2() {
        return this.refreshToken;
    }

    @Nullable
    public final String component3() {
        return this.pushToken;
    }

    @NotNull
    public final Session copy(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, SessionContract.SESSION);
        return new Session(str, str2, str3);
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
        if (!(obj instanceof Session)) {
            return false;
        }
        Session session2 = (Session) obj;
        return Intrinsics.areEqual(this.session, session2.session) && Intrinsics.areEqual(this.refreshToken, session2.refreshToken) && Intrinsics.areEqual(this.pushToken, session2.pushToken);
    }

    @Nullable
    public final String getPushToken() {
        return this.pushToken;
    }

    @Nullable
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @NotNull
    public final String getSession() {
        return this.session;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.session;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.refreshToken;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.pushToken;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Session{session='");
        a.m1(L, this.session, "', ", "refreshToken='");
        a.m1(L, this.refreshToken, "', ", "pushToken='");
        return a.t(L, this.pushToken, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.session);
        parcel.writeString(this.refreshToken);
        parcel.writeString(this.pushToken);
    }
}
