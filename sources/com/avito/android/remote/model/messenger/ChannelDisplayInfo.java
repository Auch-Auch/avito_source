package com.avito.android.remote.model.messenger;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JJ\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b&\u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010\nR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b*\u0010\u0007R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b+\u0010\u0004¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/messenger/ChannelDisplayInfo;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Action;", "component3", "()Lcom/avito/android/remote/model/Action;", "component4", "component5", "name", "avatar", "link", "status", ChannelContext.Item.USER_ID, "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Action;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/ChannelDisplayInfo;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUserId", "getName", "Lcom/avito/android/remote/model/Action;", "getLink", "Lcom/avito/android/remote/model/Image;", "getAvatar", "getStatus", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Action;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelDisplayInfo implements Parcelable {
    public static final Parcelable.Creator<ChannelDisplayInfo> CREATOR = new Creator();
    @SerializedName("avatar")
    @Nullable
    private final Image avatar;
    @SerializedName("link")
    @Nullable
    private final Action link;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("status")
    @Nullable
    private final String status;
    @SerializedName(ChannelContext.Item.USER_ID)
    @Nullable
    private final String userId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ChannelDisplayInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ChannelDisplayInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ChannelDisplayInfo(parcel.readString(), (Image) parcel.readParcelable(ChannelDisplayInfo.class.getClassLoader()), (Action) parcel.readParcelable(ChannelDisplayInfo.class.getClassLoader()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ChannelDisplayInfo[] newArray(int i) {
            return new ChannelDisplayInfo[i];
        }
    }

    public ChannelDisplayInfo(@NotNull String str, @Nullable Image image, @Nullable Action action, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.avatar = image;
        this.link = action;
        this.status = str2;
        this.userId = str3;
    }

    public static /* synthetic */ ChannelDisplayInfo copy$default(ChannelDisplayInfo channelDisplayInfo, String str, Image image, Action action, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelDisplayInfo.name;
        }
        if ((i & 2) != 0) {
            image = channelDisplayInfo.avatar;
        }
        if ((i & 4) != 0) {
            action = channelDisplayInfo.link;
        }
        if ((i & 8) != 0) {
            str2 = channelDisplayInfo.status;
        }
        if ((i & 16) != 0) {
            str3 = channelDisplayInfo.userId;
        }
        return channelDisplayInfo.copy(str, image, action, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final Image component2() {
        return this.avatar;
    }

    @Nullable
    public final Action component3() {
        return this.link;
    }

    @Nullable
    public final String component4() {
        return this.status;
    }

    @Nullable
    public final String component5() {
        return this.userId;
    }

    @NotNull
    public final ChannelDisplayInfo copy(@NotNull String str, @Nullable Image image, @Nullable Action action, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new ChannelDisplayInfo(str, image, action, str2, str3);
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
        if (!(obj instanceof ChannelDisplayInfo)) {
            return false;
        }
        ChannelDisplayInfo channelDisplayInfo = (ChannelDisplayInfo) obj;
        return Intrinsics.areEqual(this.name, channelDisplayInfo.name) && Intrinsics.areEqual(this.avatar, channelDisplayInfo.avatar) && Intrinsics.areEqual(this.link, channelDisplayInfo.link) && Intrinsics.areEqual(this.status, channelDisplayInfo.status) && Intrinsics.areEqual(this.userId, channelDisplayInfo.userId);
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final Action getLink() {
        return this.link;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Image image = this.avatar;
        int hashCode2 = (hashCode + (image != null ? image.hashCode() : 0)) * 31;
        Action action = this.link;
        int hashCode3 = (hashCode2 + (action != null ? action.hashCode() : 0)) * 31;
        String str2 = this.status;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.userId;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChannelDisplayInfo(name=");
        L.append(this.name);
        L.append(", avatar=");
        L.append(this.avatar);
        L.append(", link=");
        L.append(this.link);
        L.append(", status=");
        L.append(this.status);
        L.append(", userId=");
        return a.t(L, this.userId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeParcelable(this.avatar, i);
        parcel.writeParcelable(this.link, i);
        parcel.writeString(this.status);
        parcel.writeString(this.userId);
    }
}
