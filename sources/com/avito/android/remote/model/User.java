package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.messenger.PublicProfile;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJJ\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b)\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b*\u0010\bR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b+\u0010\u0004¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/User;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Long;", "component4", "Lcom/avito/android/remote/model/messenger/PublicProfile;", "component5", "()Lcom/avito/android/remote/model/messenger/PublicProfile;", "id", "name", "lastActionTime", "timeDiff", "publicProfile", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/avito/android/remote/model/messenger/PublicProfile;)Lcom/avito/android/remote/model/User;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Long;", "getLastActionTime", "Lcom/avito/android/remote/model/messenger/PublicProfile;", "getPublicProfile", "Ljava/lang/String;", "getName", "getTimeDiff", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/avito/android/remote/model/messenger/PublicProfile;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class User implements Parcelable {
    public static final Parcelable.Creator<User> CREATOR = new Creator();
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("lastActionTime")
    @Nullable
    private final Long lastActionTime;
    @SerializedName("name")
    @Nullable
    private final String name;
    @SerializedName("publicUserProfile")
    @Nullable
    private final PublicProfile publicProfile;
    @SerializedName("timeDiff")
    @Nullable
    private final Long timeDiff;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<User> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final User createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new User(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, (PublicProfile) parcel.readParcelable(User.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final User[] newArray(int i) {
            return new User[i];
        }
    }

    public User(@NotNull String str, @Nullable String str2, @Nullable Long l, @Nullable Long l2, @Nullable PublicProfile publicProfile2) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.name = str2;
        this.lastActionTime = l;
        this.timeDiff = l2;
        this.publicProfile = publicProfile2;
    }

    public static /* synthetic */ User copy$default(User user, String str, String str2, Long l, Long l2, PublicProfile publicProfile2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = user.id;
        }
        if ((i & 2) != 0) {
            str2 = user.name;
        }
        if ((i & 4) != 0) {
            l = user.lastActionTime;
        }
        if ((i & 8) != 0) {
            l2 = user.timeDiff;
        }
        if ((i & 16) != 0) {
            publicProfile2 = user.publicProfile;
        }
        return user.copy(str, str2, l, l2, publicProfile2);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final Long component3() {
        return this.lastActionTime;
    }

    @Nullable
    public final Long component4() {
        return this.timeDiff;
    }

    @Nullable
    public final PublicProfile component5() {
        return this.publicProfile;
    }

    @NotNull
    public final User copy(@NotNull String str, @Nullable String str2, @Nullable Long l, @Nullable Long l2, @Nullable PublicProfile publicProfile2) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new User(str, str2, l, l2, publicProfile2);
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
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return Intrinsics.areEqual(this.id, user.id) && Intrinsics.areEqual(this.name, user.name) && Intrinsics.areEqual(this.lastActionTime, user.lastActionTime) && Intrinsics.areEqual(this.timeDiff, user.timeDiff) && Intrinsics.areEqual(this.publicProfile, user.publicProfile);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Long getLastActionTime() {
        return this.lastActionTime;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final PublicProfile getPublicProfile() {
        return this.publicProfile;
    }

    @Nullable
    public final Long getTimeDiff() {
        return this.timeDiff;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.lastActionTime;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.timeDiff;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        PublicProfile publicProfile2 = this.publicProfile;
        if (publicProfile2 != null) {
            i = publicProfile2.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("User(id=");
        L.append(this.id);
        L.append(", name=");
        L.append(this.name);
        L.append(", lastActionTime=");
        L.append(this.lastActionTime);
        L.append(", timeDiff=");
        L.append(this.timeDiff);
        L.append(", publicProfile=");
        L.append(this.publicProfile);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        Long l = this.lastActionTime;
        if (l != null) {
            a.I0(parcel, 1, l);
        } else {
            parcel.writeInt(0);
        }
        Long l2 = this.timeDiff;
        if (l2 != null) {
            a.I0(parcel, 1, l2);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.publicProfile, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ User(String str, String str2, Long l, Long l2, PublicProfile publicProfile2, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : publicProfile2);
    }
}
