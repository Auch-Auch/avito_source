package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Parcels;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B!\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b#\u0010$J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ0\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0013\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\rR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b\"\u0010\r¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/ShopSearch;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "title", "deepLink", "description", "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)Lcom/avito/android/remote/model/ShopSearch;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "Ljava/lang/String;", "getTitle", "getDescription", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSearch implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShopSearch> CREATOR = Parcels.creator(ShopSearch$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink deepLink;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/ShopSearch$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/ShopSearch;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public ShopSearch(@NotNull String str, @NotNull DeepLink deepLink2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        this.title = str;
        this.deepLink = deepLink2;
        this.description = str2;
    }

    public static /* synthetic */ ShopSearch copy$default(ShopSearch shopSearch, String str, DeepLink deepLink2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopSearch.title;
        }
        if ((i & 2) != 0) {
            deepLink2 = shopSearch.deepLink;
        }
        if ((i & 4) != 0) {
            str2 = shopSearch.description;
        }
        return shopSearch.copy(str, deepLink2, str2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final DeepLink component2() {
        return this.deepLink;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final ShopSearch copy(@NotNull String str, @NotNull DeepLink deepLink2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        return new ShopSearch(str, deepLink2, str2);
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
        if (!(obj instanceof ShopSearch)) {
            return false;
        }
        ShopSearch shopSearch = (ShopSearch) obj;
        return Intrinsics.areEqual(this.title, shopSearch.title) && Intrinsics.areEqual(this.deepLink, shopSearch.deepLink) && Intrinsics.areEqual(this.description, shopSearch.description);
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
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
        int hashCode2 = (hashCode + (deepLink2 != null ? deepLink2.hashCode() : 0)) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShopSearch(title=");
        L.append(this.title);
        L.append(", deepLink=");
        L.append(this.deepLink);
        L.append(", description=");
        return a.t(L, this.description, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.deepLink, i);
        parcel.writeString(this.description);
    }
}
