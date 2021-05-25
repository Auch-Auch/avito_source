package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.remote.model.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/brandspace/remote/model/MarketplaceTabElement;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Action;", "component2", "()Lcom/avito/android/remote/model/Action;", "component3", "title", "action", "searchUrl", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/lang/String;)Lcom/avito/android/brandspace/remote/model/MarketplaceTabElement;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Action;", "getAction", "Ljava/lang/String;", "getTitle", "getSearchUrl", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceTabElement implements BrandspaceElement {
    public static final Parcelable.Creator<MarketplaceTabElement> CREATOR = new Creator();
    @Nullable
    private final Action action;
    @Nullable
    private final String searchUrl;
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceTabElement> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceTabElement createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MarketplaceTabElement(parcel.readString(), (Action) parcel.readParcelable(MarketplaceTabElement.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceTabElement[] newArray(int i) {
            return new MarketplaceTabElement[i];
        }
    }

    public MarketplaceTabElement(@NotNull String str, @Nullable Action action2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.action = action2;
        this.searchUrl = str2;
    }

    public static /* synthetic */ MarketplaceTabElement copy$default(MarketplaceTabElement marketplaceTabElement, String str, Action action2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = marketplaceTabElement.title;
        }
        if ((i & 2) != 0) {
            action2 = marketplaceTabElement.action;
        }
        if ((i & 4) != 0) {
            str2 = marketplaceTabElement.searchUrl;
        }
        return marketplaceTabElement.copy(str, action2, str2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final Action component2() {
        return this.action;
    }

    @Nullable
    public final String component3() {
        return this.searchUrl;
    }

    @NotNull
    public final MarketplaceTabElement copy(@NotNull String str, @Nullable Action action2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new MarketplaceTabElement(str, action2, str2);
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
        if (!(obj instanceof MarketplaceTabElement)) {
            return false;
        }
        MarketplaceTabElement marketplaceTabElement = (MarketplaceTabElement) obj;
        return Intrinsics.areEqual(this.title, marketplaceTabElement.title) && Intrinsics.areEqual(this.action, marketplaceTabElement.action) && Intrinsics.areEqual(this.searchUrl, marketplaceTabElement.searchUrl);
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getSearchUrl() {
        return this.searchUrl;
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
        Action action2 = this.action;
        int hashCode2 = (hashCode + (action2 != null ? action2.hashCode() : 0)) * 31;
        String str2 = this.searchUrl;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MarketplaceTabElement(title=");
        L.append(this.title);
        L.append(", action=");
        L.append(this.action);
        L.append(", searchUrl=");
        return a.t(L, this.searchUrl, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.action, i);
        parcel.writeString(this.searchUrl);
    }
}
