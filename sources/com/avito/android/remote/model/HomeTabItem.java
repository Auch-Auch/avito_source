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
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001:\u0001-B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0017J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0010\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b%\u0010\u000bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b'\u0010\bR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b*\u0010\u0004¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/HomeTabItem;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/HomeTabItem$Tooltip;", "component3", "()Lcom/avito/android/remote/model/HomeTabItem$Tooltip;", "", "component4", "()Z", "component5", "feedId", "title", "tooltip", "hideSeenBadges", "needsRefresh", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/HomeTabItem$Tooltip;ZZ)Lcom/avito/android/remote/model/HomeTabItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getHideSeenBadges", "getNeedsRefresh", "Lcom/avito/android/remote/model/HomeTabItem$Tooltip;", "getTooltip", "Ljava/lang/String;", "getFeedId", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/HomeTabItem$Tooltip;ZZ)V", "Tooltip", "models_release"}, k = 1, mv = {1, 4, 2})
public final class HomeTabItem implements Parcelable {
    public static final Parcelable.Creator<HomeTabItem> CREATOR = new Creator();
    @SerializedName("feedId")
    @NotNull
    private final String feedId;
    @SerializedName("hideSeenBadges")
    private final boolean hideSeenBadges;
    @SerializedName("needsRefresh")
    private final boolean needsRefresh;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("tooltip")
    @Nullable
    private final Tooltip tooltip;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<HomeTabItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HomeTabItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Tooltip createFromParcel = parcel.readInt() != 0 ? Tooltip.CREATOR.createFromParcel(parcel) : null;
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            return new HomeTabItem(readString, readString2, createFromParcel, z2, z);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HomeTabItem[] newArray(int i) {
            return new HomeTabItem[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/HomeTabItem$Tooltip;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "id", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Tooltip implements Parcelable {
        public static final Parcelable.Creator<Tooltip> CREATOR = new Creator();
        @Nullable
        private final String id;
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Tooltip> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Tooltip createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Tooltip(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Tooltip[] newArray(int i) {
                return new Tooltip[i];
            }
        }

        public Tooltip(@Nullable String str, @Nullable String str2) {
            this.title = str;
            this.id = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.id);
        }
    }

    public HomeTabItem(@NotNull String str, @NotNull String str2, @Nullable Tooltip tooltip2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "feedId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.feedId = str;
        this.title = str2;
        this.tooltip = tooltip2;
        this.hideSeenBadges = z;
        this.needsRefresh = z2;
    }

    public static /* synthetic */ HomeTabItem copy$default(HomeTabItem homeTabItem, String str, String str2, Tooltip tooltip2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = homeTabItem.feedId;
        }
        if ((i & 2) != 0) {
            str2 = homeTabItem.title;
        }
        if ((i & 4) != 0) {
            tooltip2 = homeTabItem.tooltip;
        }
        if ((i & 8) != 0) {
            z = homeTabItem.hideSeenBadges;
        }
        if ((i & 16) != 0) {
            z2 = homeTabItem.needsRefresh;
        }
        return homeTabItem.copy(str, str2, tooltip2, z, z2);
    }

    @NotNull
    public final String component1() {
        return this.feedId;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final Tooltip component3() {
        return this.tooltip;
    }

    public final boolean component4() {
        return this.hideSeenBadges;
    }

    public final boolean component5() {
        return this.needsRefresh;
    }

    @NotNull
    public final HomeTabItem copy(@NotNull String str, @NotNull String str2, @Nullable Tooltip tooltip2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "feedId");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new HomeTabItem(str, str2, tooltip2, z, z2);
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
        if (!(obj instanceof HomeTabItem)) {
            return false;
        }
        HomeTabItem homeTabItem = (HomeTabItem) obj;
        return Intrinsics.areEqual(this.feedId, homeTabItem.feedId) && Intrinsics.areEqual(this.title, homeTabItem.title) && Intrinsics.areEqual(this.tooltip, homeTabItem.tooltip) && this.hideSeenBadges == homeTabItem.hideSeenBadges && this.needsRefresh == homeTabItem.needsRefresh;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public final boolean getHideSeenBadges() {
        return this.hideSeenBadges;
    }

    public final boolean getNeedsRefresh() {
        return this.needsRefresh;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Tooltip getTooltip() {
        return this.tooltip;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.feedId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Tooltip tooltip2 = this.tooltip;
        if (tooltip2 != null) {
            i = tooltip2.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.hideSeenBadges;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (i2 + i4) * 31;
        boolean z2 = this.needsRefresh;
        if (!z2) {
            i3 = z2 ? 1 : 0;
        }
        return i7 + i3;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("HomeTabItem(feedId=");
        L.append(this.feedId);
        L.append(", title=");
        L.append(this.title);
        L.append(", tooltip=");
        L.append(this.tooltip);
        L.append(", hideSeenBadges=");
        L.append(this.hideSeenBadges);
        L.append(", needsRefresh=");
        return a.B(L, this.needsRefresh, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.feedId);
        parcel.writeString(this.title);
        Tooltip tooltip2 = this.tooltip;
        if (tooltip2 != null) {
            parcel.writeInt(1);
            tooltip2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.hideSeenBadges ? 1 : 0);
        parcel.writeInt(this.needsRefresh ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeTabItem(String str, String str2, Tooltip tooltip2, boolean z, boolean z2, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : tooltip2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }
}
