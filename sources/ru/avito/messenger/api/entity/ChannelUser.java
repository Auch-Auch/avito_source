package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B=\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0012JJ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010$\u001a\u0004\b%\u0010\u0012R\u001c\u0010\u0017\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u0007R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b)\u0010\u0015R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b*\u0010\u0007R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b+\u0010\u0012¨\u0006/"}, d2 = {"Lru/avito/messenger/api/entity/ChannelUser;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "component2", "", "component3", "()Ljava/lang/Long;", "Lru/avito/messenger/api/entity/PublicProfile;", "component4", "()Lru/avito/messenger/api/entity/PublicProfile;", "component5", "id", "name", "lastActionTime", "publicProfile", "timeDiff", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lru/avito/messenger/api/entity/PublicProfile;Ljava/lang/Long;)Lru/avito/messenger/api/entity/ChannelUser;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getTimeDiff", "Ljava/lang/String;", "getId", "Lru/avito/messenger/api/entity/PublicProfile;", "getPublicProfile", "getName", "getLastActionTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lru/avito/messenger/api/entity/PublicProfile;Ljava/lang/Long;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelUser implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ChannelUser> CREATOR = Parcels.creator(ChannelUser$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lru/avito/messenger/api/entity/ChannelUser$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lru/avito/messenger/api/entity/ChannelUser;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public ChannelUser(@NotNull String str, @Nullable String str2, @Nullable Long l, @Nullable PublicProfile publicProfile2, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.name = str2;
        this.lastActionTime = l;
        this.publicProfile = publicProfile2;
        this.timeDiff = l2;
    }

    public static /* synthetic */ ChannelUser copy$default(ChannelUser channelUser, String str, String str2, Long l, PublicProfile publicProfile2, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelUser.id;
        }
        if ((i & 2) != 0) {
            str2 = channelUser.name;
        }
        if ((i & 4) != 0) {
            l = channelUser.lastActionTime;
        }
        if ((i & 8) != 0) {
            publicProfile2 = channelUser.publicProfile;
        }
        if ((i & 16) != 0) {
            l2 = channelUser.timeDiff;
        }
        return channelUser.copy(str, str2, l, publicProfile2, l2);
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
    public final PublicProfile component4() {
        return this.publicProfile;
    }

    @Nullable
    public final Long component5() {
        return this.timeDiff;
    }

    @NotNull
    public final ChannelUser copy(@NotNull String str, @Nullable String str2, @Nullable Long l, @Nullable PublicProfile publicProfile2, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new ChannelUser(str, str2, l, publicProfile2, l2);
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
        if (!(obj instanceof ChannelUser)) {
            return false;
        }
        ChannelUser channelUser = (ChannelUser) obj;
        return Intrinsics.areEqual(this.id, channelUser.id) && Intrinsics.areEqual(this.name, channelUser.name) && Intrinsics.areEqual(this.lastActionTime, channelUser.lastActionTime) && Intrinsics.areEqual(this.publicProfile, channelUser.publicProfile) && Intrinsics.areEqual(this.timeDiff, channelUser.timeDiff);
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
        PublicProfile publicProfile2 = this.publicProfile;
        int hashCode4 = (hashCode3 + (publicProfile2 != null ? publicProfile2.hashCode() : 0)) * 31;
        Long l2 = this.timeDiff;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChannelUser { id = ");
        L.append(this.id);
        L.append(", name = ");
        L.append(this.name);
        L.append(", timeDiff = ");
        L.append(this.timeDiff);
        L.append(" }");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        ParcelsKt.writeNullableValue(parcel, this.lastActionTime);
        parcel.writeParcelable(this.publicProfile, 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelUser(String str, String str2, Long l, PublicProfile publicProfile2, Long l2, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : publicProfile2, (i & 16) != 0 ? null : l2);
    }
}
