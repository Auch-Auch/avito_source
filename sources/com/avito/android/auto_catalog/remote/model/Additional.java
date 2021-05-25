package com.avito.android.auto_catalog.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b/\u00100J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJX\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0019J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b$\u0010%R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\fR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010*\u001a\u0004\b+\u0010\bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b,\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b-\u0010\fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b.\u0010\b¨\u00061"}, d2 = {"Lcom/avito/android/auto_catalog/remote/model/Additional;", "Landroid/os/Parcelable;", "Lcom/avito/android/auto_catalog/remote/model/PluralString;", "component1", "()Lcom/avito/android/auto_catalog/remote/model/PluralString;", "component2", "", "component3", "()Ljava/lang/String;", "component4", "Lcom/avito/android/deep_linking/links/DeepLink;", "component5", "()Lcom/avito/android/deep_linking/links/DeepLink;", "component6", "showAdvertText", "itemsHeaderText", "noItemsHeaderText", "noItemsButtonText", "searchLink", "fallbackSearchLink", "copy", "(Lcom/avito/android/auto_catalog/remote/model/PluralString;Lcom/avito/android/auto_catalog/remote/model/PluralString;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/auto_catalog/remote/model/Additional;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "getFallbackSearchLink", "Lcom/avito/android/auto_catalog/remote/model/PluralString;", "getItemsHeaderText", "Ljava/lang/String;", "getNoItemsHeaderText", "getShowAdvertText", "getSearchLink", "getNoItemsButtonText", "<init>", "(Lcom/avito/android/auto_catalog/remote/model/PluralString;Lcom/avito/android/auto_catalog/remote/model/PluralString;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/deep_linking/links/DeepLink;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class Additional implements Parcelable {
    public static final Parcelable.Creator<Additional> CREATOR = new Creator();
    @SerializedName("fallbackSearchLink")
    @Nullable
    private final DeepLink fallbackSearchLink;
    @SerializedName("itemsHeaderText")
    @Nullable
    private final PluralString itemsHeaderText;
    @SerializedName("noItemsButtonText")
    @Nullable
    private final String noItemsButtonText;
    @SerializedName("noItemsHeaderText")
    @Nullable
    private final String noItemsHeaderText;
    @SerializedName("searchLink")
    @Nullable
    private final DeepLink searchLink;
    @SerializedName("showAdvertText")
    @Nullable
    private final PluralString showAdvertText;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Additional> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Additional createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Additional(parcel.readInt() != 0 ? PluralString.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? PluralString.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(Additional.class.getClassLoader()), (DeepLink) parcel.readParcelable(Additional.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Additional[] newArray(int i) {
            return new Additional[i];
        }
    }

    public Additional(@Nullable PluralString pluralString, @Nullable PluralString pluralString2, @Nullable String str, @Nullable String str2, @Nullable DeepLink deepLink, @Nullable DeepLink deepLink2) {
        this.showAdvertText = pluralString;
        this.itemsHeaderText = pluralString2;
        this.noItemsHeaderText = str;
        this.noItemsButtonText = str2;
        this.searchLink = deepLink;
        this.fallbackSearchLink = deepLink2;
    }

    public static /* synthetic */ Additional copy$default(Additional additional, PluralString pluralString, PluralString pluralString2, String str, String str2, DeepLink deepLink, DeepLink deepLink2, int i, Object obj) {
        if ((i & 1) != 0) {
            pluralString = additional.showAdvertText;
        }
        if ((i & 2) != 0) {
            pluralString2 = additional.itemsHeaderText;
        }
        if ((i & 4) != 0) {
            str = additional.noItemsHeaderText;
        }
        if ((i & 8) != 0) {
            str2 = additional.noItemsButtonText;
        }
        if ((i & 16) != 0) {
            deepLink = additional.searchLink;
        }
        if ((i & 32) != 0) {
            deepLink2 = additional.fallbackSearchLink;
        }
        return additional.copy(pluralString, pluralString2, str, str2, deepLink, deepLink2);
    }

    @Nullable
    public final PluralString component1() {
        return this.showAdvertText;
    }

    @Nullable
    public final PluralString component2() {
        return this.itemsHeaderText;
    }

    @Nullable
    public final String component3() {
        return this.noItemsHeaderText;
    }

    @Nullable
    public final String component4() {
        return this.noItemsButtonText;
    }

    @Nullable
    public final DeepLink component5() {
        return this.searchLink;
    }

    @Nullable
    public final DeepLink component6() {
        return this.fallbackSearchLink;
    }

    @NotNull
    public final Additional copy(@Nullable PluralString pluralString, @Nullable PluralString pluralString2, @Nullable String str, @Nullable String str2, @Nullable DeepLink deepLink, @Nullable DeepLink deepLink2) {
        return new Additional(pluralString, pluralString2, str, str2, deepLink, deepLink2);
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
        if (!(obj instanceof Additional)) {
            return false;
        }
        Additional additional = (Additional) obj;
        return Intrinsics.areEqual(this.showAdvertText, additional.showAdvertText) && Intrinsics.areEqual(this.itemsHeaderText, additional.itemsHeaderText) && Intrinsics.areEqual(this.noItemsHeaderText, additional.noItemsHeaderText) && Intrinsics.areEqual(this.noItemsButtonText, additional.noItemsButtonText) && Intrinsics.areEqual(this.searchLink, additional.searchLink) && Intrinsics.areEqual(this.fallbackSearchLink, additional.fallbackSearchLink);
    }

    @Nullable
    public final DeepLink getFallbackSearchLink() {
        return this.fallbackSearchLink;
    }

    @Nullable
    public final PluralString getItemsHeaderText() {
        return this.itemsHeaderText;
    }

    @Nullable
    public final String getNoItemsButtonText() {
        return this.noItemsButtonText;
    }

    @Nullable
    public final String getNoItemsHeaderText() {
        return this.noItemsHeaderText;
    }

    @Nullable
    public final DeepLink getSearchLink() {
        return this.searchLink;
    }

    @Nullable
    public final PluralString getShowAdvertText() {
        return this.showAdvertText;
    }

    @Override // java.lang.Object
    public int hashCode() {
        PluralString pluralString = this.showAdvertText;
        int i = 0;
        int hashCode = (pluralString != null ? pluralString.hashCode() : 0) * 31;
        PluralString pluralString2 = this.itemsHeaderText;
        int hashCode2 = (hashCode + (pluralString2 != null ? pluralString2.hashCode() : 0)) * 31;
        String str = this.noItemsHeaderText;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.noItemsButtonText;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        DeepLink deepLink = this.searchLink;
        int hashCode5 = (hashCode4 + (deepLink != null ? deepLink.hashCode() : 0)) * 31;
        DeepLink deepLink2 = this.fallbackSearchLink;
        if (deepLink2 != null) {
            i = deepLink2.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Additional(showAdvertText=");
        L.append(this.showAdvertText);
        L.append(", itemsHeaderText=");
        L.append(this.itemsHeaderText);
        L.append(", noItemsHeaderText=");
        L.append(this.noItemsHeaderText);
        L.append(", noItemsButtonText=");
        L.append(this.noItemsButtonText);
        L.append(", searchLink=");
        L.append(this.searchLink);
        L.append(", fallbackSearchLink=");
        return a.m(L, this.fallbackSearchLink, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        PluralString pluralString = this.showAdvertText;
        if (pluralString != null) {
            parcel.writeInt(1);
            pluralString.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        PluralString pluralString2 = this.itemsHeaderText;
        if (pluralString2 != null) {
            parcel.writeInt(1);
            pluralString2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.noItemsHeaderText);
        parcel.writeString(this.noItemsButtonText);
        parcel.writeParcelable(this.searchLink, i);
        parcel.writeParcelable(this.fallbackSearchLink, i);
    }
}
