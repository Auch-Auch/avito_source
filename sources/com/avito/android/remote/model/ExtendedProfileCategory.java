package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.search.map.view.PanelStateKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JJ\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0017J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b\u000e\u0010\u0007R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b\u000f\u0010\u0007R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010\u000bR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b(\u0010\u0004¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfileCategory;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Boolean;", "component3", "Lcom/avito/android/remote/model/ExtendedProfileCategoryAdverts;", "component4", "()Lcom/avito/android/remote/model/ExtendedProfileCategoryAdverts;", "component5", "title", "isCollapsed", "isCollapsible", "items", "loadUri", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/avito/android/remote/model/ExtendedProfileCategoryAdverts;Ljava/lang/String;)Lcom/avito/android/remote/model/ExtendedProfileCategory;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/ExtendedProfileCategoryAdverts;", "getItems", "Ljava/lang/String;", "getTitle", "getLoadUri", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/avito/android/remote/model/ExtendedProfileCategoryAdverts;Ljava/lang/String;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileCategory implements Parcelable {
    public static final Parcelable.Creator<ExtendedProfileCategory> CREATOR = new Creator();
    @SerializedName(PanelStateKt.PANEL_COLLAPSED)
    @Nullable
    private final Boolean isCollapsed;
    @SerializedName("isCollapsible")
    @Nullable
    private final Boolean isCollapsible;
    @SerializedName("items")
    @Nullable
    private final ExtendedProfileCategoryAdverts items;
    @SerializedName("loadUri")
    @Nullable
    private final String loadUri;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ExtendedProfileCategory> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedProfileCategory createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            boolean z = true;
            ExtendedProfileCategoryAdverts extendedProfileCategoryAdverts = null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool2 = Boolean.valueOf(z);
            } else {
                bool2 = null;
            }
            if (parcel.readInt() != 0) {
                extendedProfileCategoryAdverts = ExtendedProfileCategoryAdverts.CREATOR.createFromParcel(parcel);
            }
            return new ExtendedProfileCategory(readString, bool, bool2, extendedProfileCategoryAdverts, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedProfileCategory[] newArray(int i) {
            return new ExtendedProfileCategory[i];
        }
    }

    public ExtendedProfileCategory(@NotNull String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable ExtendedProfileCategoryAdverts extendedProfileCategoryAdverts, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.isCollapsed = bool;
        this.isCollapsible = bool2;
        this.items = extendedProfileCategoryAdverts;
        this.loadUri = str2;
    }

    public static /* synthetic */ ExtendedProfileCategory copy$default(ExtendedProfileCategory extendedProfileCategory, String str, Boolean bool, Boolean bool2, ExtendedProfileCategoryAdverts extendedProfileCategoryAdverts, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = extendedProfileCategory.title;
        }
        if ((i & 2) != 0) {
            bool = extendedProfileCategory.isCollapsed;
        }
        if ((i & 4) != 0) {
            bool2 = extendedProfileCategory.isCollapsible;
        }
        if ((i & 8) != 0) {
            extendedProfileCategoryAdverts = extendedProfileCategory.items;
        }
        if ((i & 16) != 0) {
            str2 = extendedProfileCategory.loadUri;
        }
        return extendedProfileCategory.copy(str, bool, bool2, extendedProfileCategoryAdverts, str2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final Boolean component2() {
        return this.isCollapsed;
    }

    @Nullable
    public final Boolean component3() {
        return this.isCollapsible;
    }

    @Nullable
    public final ExtendedProfileCategoryAdverts component4() {
        return this.items;
    }

    @Nullable
    public final String component5() {
        return this.loadUri;
    }

    @NotNull
    public final ExtendedProfileCategory copy(@NotNull String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable ExtendedProfileCategoryAdverts extendedProfileCategoryAdverts, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new ExtendedProfileCategory(str, bool, bool2, extendedProfileCategoryAdverts, str2);
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
        if (!(obj instanceof ExtendedProfileCategory)) {
            return false;
        }
        ExtendedProfileCategory extendedProfileCategory = (ExtendedProfileCategory) obj;
        return Intrinsics.areEqual(this.title, extendedProfileCategory.title) && Intrinsics.areEqual(this.isCollapsed, extendedProfileCategory.isCollapsed) && Intrinsics.areEqual(this.isCollapsible, extendedProfileCategory.isCollapsible) && Intrinsics.areEqual(this.items, extendedProfileCategory.items) && Intrinsics.areEqual(this.loadUri, extendedProfileCategory.loadUri);
    }

    @Nullable
    public final ExtendedProfileCategoryAdverts getItems() {
        return this.items;
    }

    @Nullable
    public final String getLoadUri() {
        return this.loadUri;
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
        Boolean bool = this.isCollapsed;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isCollapsible;
        int hashCode3 = (hashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        ExtendedProfileCategoryAdverts extendedProfileCategoryAdverts = this.items;
        int hashCode4 = (hashCode3 + (extendedProfileCategoryAdverts != null ? extendedProfileCategoryAdverts.hashCode() : 0)) * 31;
        String str2 = this.loadUri;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    @Nullable
    public final Boolean isCollapsed() {
        return this.isCollapsed;
    }

    @Nullable
    public final Boolean isCollapsible() {
        return this.isCollapsible;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ExtendedProfileCategory(title=");
        L.append(this.title);
        L.append(", isCollapsed=");
        L.append(this.isCollapsed);
        L.append(", isCollapsible=");
        L.append(this.isCollapsible);
        L.append(", items=");
        L.append(this.items);
        L.append(", loadUri=");
        return a.t(L, this.loadUri, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        Boolean bool = this.isCollapsed;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool2 = this.isCollapsible;
        if (bool2 != null) {
            a.G0(parcel, 1, bool2);
        } else {
            parcel.writeInt(0);
        }
        ExtendedProfileCategoryAdverts extendedProfileCategoryAdverts = this.items;
        if (extendedProfileCategoryAdverts != null) {
            parcel.writeInt(1);
            extendedProfileCategoryAdverts.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.loadUri);
    }
}
