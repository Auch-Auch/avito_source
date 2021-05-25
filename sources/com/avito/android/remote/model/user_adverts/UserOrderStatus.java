package com.avito.android.remote.model.user_adverts;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import com.google.common.net.HttpHeaders;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001:\u0002()B#\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0007R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010\n¨\u0006*"}, d2 = {"Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Type;", "component1", "()Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Type;", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Link;", "component3", "()Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Link;", "type", "description", "link", "copy", "(Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Type;Ljava/lang/String;Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Link;)Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Type;", "getType", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Link;", "getLink", "<init>", "(Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Type;Ljava/lang/String;Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Link;)V", HttpHeaders.LINK, "Type", "models_release"}, k = 1, mv = {1, 4, 2})
public final class UserOrderStatus implements Parcelable {
    public static final Parcelable.Creator<UserOrderStatus> CREATOR = new Creator();
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("link")
    @Nullable
    private final Link link;
    @SerializedName("type")
    @Nullable
    private final Type type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<UserOrderStatus> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserOrderStatus createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            Link link = null;
            Type type = parcel.readInt() != 0 ? (Type) Enum.valueOf(Type.class, parcel.readString()) : null;
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                link = Link.CREATOR.createFromParcel(parcel);
            }
            return new UserOrderStatus(type, readString, link);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserOrderStatus[] newArray(int i) {
            return new UserOrderStatus[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Link;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", "deepLink", "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Link;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Link implements Parcelable {
        public static final Parcelable.Creator<Link> CREATOR = new Creator();
        @SerializedName(ShareConstants.MEDIA_URI)
        @NotNull
        private final DeepLink deepLink;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Link> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Link createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Link(parcel.readString(), (DeepLink) parcel.readParcelable(Link.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Link[] newArray(int i) {
                return new Link[i];
            }
        }

        public Link(@NotNull String str, @NotNull DeepLink deepLink2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
            this.title = str;
            this.deepLink = deepLink2;
        }

        public static /* synthetic */ Link copy$default(Link link, String str, DeepLink deepLink2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = link.title;
            }
            if ((i & 2) != 0) {
                deepLink2 = link.deepLink;
            }
            return link.copy(str, deepLink2);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final DeepLink component2() {
            return this.deepLink;
        }

        @NotNull
        public final Link copy(@NotNull String str, @NotNull DeepLink deepLink2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
            return new Link(str, deepLink2);
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
            if (!(obj instanceof Link)) {
                return false;
            }
            Link link = (Link) obj;
            return Intrinsics.areEqual(this.title, link.title) && Intrinsics.areEqual(this.deepLink, link.deepLink);
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.deepLink;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            DeepLink deepLink2 = this.deepLink;
            if (deepLink2 != null) {
                i = deepLink2.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Link(title=");
            L.append(this.title);
            L.append(", deepLink=");
            return a.m(L, this.deepLink, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.deepLink, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/user_adverts/UserOrderStatus$Type;", "", "<init>", "(Ljava/lang/String;I)V", "PROCESSING", "DONE", "WARNING", "ERROR", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        PROCESSING,
        DONE,
        WARNING,
        ERROR
    }

    public UserOrderStatus(@Nullable Type type2, @NotNull String str, @Nullable Link link2) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.type = type2;
        this.description = str;
        this.link = link2;
    }

    public static /* synthetic */ UserOrderStatus copy$default(UserOrderStatus userOrderStatus, Type type2, String str, Link link2, int i, Object obj) {
        if ((i & 1) != 0) {
            type2 = userOrderStatus.type;
        }
        if ((i & 2) != 0) {
            str = userOrderStatus.description;
        }
        if ((i & 4) != 0) {
            link2 = userOrderStatus.link;
        }
        return userOrderStatus.copy(type2, str, link2);
    }

    @Nullable
    public final Type component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @Nullable
    public final Link component3() {
        return this.link;
    }

    @NotNull
    public final UserOrderStatus copy(@Nullable Type type2, @NotNull String str, @Nullable Link link2) {
        Intrinsics.checkNotNullParameter(str, "description");
        return new UserOrderStatus(type2, str, link2);
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
        if (!(obj instanceof UserOrderStatus)) {
            return false;
        }
        UserOrderStatus userOrderStatus = (UserOrderStatus) obj;
        return Intrinsics.areEqual(this.type, userOrderStatus.type) && Intrinsics.areEqual(this.description, userOrderStatus.description) && Intrinsics.areEqual(this.link, userOrderStatus.link);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Link getLink() {
        return this.link;
    }

    @Nullable
    public final Type getType() {
        return this.type;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Type type2 = this.type;
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        String str = this.description;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Link link2 = this.link;
        if (link2 != null) {
            i = link2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("UserOrderStatus(type=");
        L.append(this.type);
        L.append(", description=");
        L.append(this.description);
        L.append(", link=");
        L.append(this.link);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Type type2 = this.type;
        if (type2 != null) {
            parcel.writeInt(1);
            parcel.writeString(type2.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.description);
        Link link2 = this.link;
        if (link2 != null) {
            parcel.writeInt(1);
            link2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
