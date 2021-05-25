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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJT\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010'R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010$\u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010'R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010$\u001a\u0004\b*\u0010\u0004\"\u0004\b+\u0010'R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010$\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010'R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010$\u001a\u0004\b.\u0010\u0004\"\u0004\b/\u0010'R\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u00100\u001a\u0004\b1\u0010\u000b\"\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/avito/android/remote/model/ItemBrief;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "Lcom/avito/android/remote/model/Navigation;", "component6", "()Lcom/avito/android/remote/model/Navigation;", "id", "categoryId", "version", "title", "description", "navigation", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;)Lcom/avito/android/remote/model/ItemBrief;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "setId", "(Ljava/lang/String;)V", "getCategoryId", "setCategoryId", "getTitle", "setTitle", "getDescription", "setDescription", "getVersion", "setVersion", "Lcom/avito/android/remote/model/Navigation;", "getNavigation", "setNavigation", "(Lcom/avito/android/remote/model/Navigation;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ItemBrief implements Parcelable {
    public static final Parcelable.Creator<ItemBrief> CREATOR = new Creator();
    @SerializedName("categoryId")
    @Nullable
    private String categoryId;
    @SerializedName("description")
    @Nullable
    private String description;
    @SerializedName("id")
    @NotNull
    private String id;
    @SerializedName("navigation")
    @NotNull
    private Navigation navigation;
    @SerializedName("title")
    @Nullable
    private String title;
    @SerializedName("version")
    @Nullable
    private String version;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ItemBrief> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ItemBrief createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ItemBrief(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), Navigation.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ItemBrief[] newArray(int i) {
            return new ItemBrief[i];
        }
    }

    public ItemBrief(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull Navigation navigation2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(navigation2, "navigation");
        this.id = str;
        this.categoryId = str2;
        this.version = str3;
        this.title = str4;
        this.description = str5;
        this.navigation = navigation2;
    }

    public static /* synthetic */ ItemBrief copy$default(ItemBrief itemBrief, String str, String str2, String str3, String str4, String str5, Navigation navigation2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = itemBrief.id;
        }
        if ((i & 2) != 0) {
            str2 = itemBrief.categoryId;
        }
        if ((i & 4) != 0) {
            str3 = itemBrief.version;
        }
        if ((i & 8) != 0) {
            str4 = itemBrief.title;
        }
        if ((i & 16) != 0) {
            str5 = itemBrief.description;
        }
        if ((i & 32) != 0) {
            navigation2 = itemBrief.navigation;
        }
        return itemBrief.copy(str, str2, str3, str4, str5, navigation2);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.categoryId;
    }

    @Nullable
    public final String component3() {
        return this.version;
    }

    @Nullable
    public final String component4() {
        return this.title;
    }

    @Nullable
    public final String component5() {
        return this.description;
    }

    @NotNull
    public final Navigation component6() {
        return this.navigation;
    }

    @NotNull
    public final ItemBrief copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull Navigation navigation2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(navigation2, "navigation");
        return new ItemBrief(str, str2, str3, str4, str5, navigation2);
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
        if (!(obj instanceof ItemBrief)) {
            return false;
        }
        ItemBrief itemBrief = (ItemBrief) obj;
        return Intrinsics.areEqual(this.id, itemBrief.id) && Intrinsics.areEqual(this.categoryId, itemBrief.categoryId) && Intrinsics.areEqual(this.version, itemBrief.version) && Intrinsics.areEqual(this.title, itemBrief.title) && Intrinsics.areEqual(this.description, itemBrief.description) && Intrinsics.areEqual(this.navigation, itemBrief.navigation);
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final Navigation getNavigation() {
        return this.navigation;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.categoryId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.version;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.title;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.description;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Navigation navigation2 = this.navigation;
        if (navigation2 != null) {
            i = navigation2.hashCode();
        }
        return hashCode5 + i;
    }

    public final void setCategoryId(@Nullable String str) {
        this.categoryId = str;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setNavigation(@NotNull Navigation navigation2) {
        Intrinsics.checkNotNullParameter(navigation2, "<set-?>");
        this.navigation = navigation2;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setVersion(@Nullable String str) {
        this.version = str;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ItemBrief(id=");
        L.append(this.id);
        L.append(", categoryId=");
        L.append(this.categoryId);
        L.append(", version=");
        L.append(this.version);
        L.append(", title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", navigation=");
        L.append(this.navigation);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.categoryId);
        parcel.writeString(this.version);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        this.navigation.writeToParcel(parcel, 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemBrief(String str, String str2, String str3, String str4, String str5, Navigation navigation2, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) == 0 ? str5 : null, (i & 32) != 0 ? new Navigation(null, null, null, null, null, null, null, 127, null) : navigation2);
    }
}
