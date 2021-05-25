package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalColor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\nR\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\rR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b+\u0010\u0007¨\u0006."}, d2 = {"Lcom/avito/android/brandspace/remote/model/MarketplaceCategoryElement;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "Lcom/avito/android/remote/model/Image;", "component1", "()Lcom/avito/android/remote/model/Image;", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Action;", "component3", "()Lcom/avito/android/remote/model/Action;", "Lcom/avito/android/remote/model/UniversalColor;", "component4", "()Lcom/avito/android/remote/model/UniversalColor;", "image", "title", "action", "bgColor", "copy", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/UniversalColor;)Lcom/avito/android/brandspace/remote/model/MarketplaceCategoryElement;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "getImage", "Lcom/avito/android/remote/model/Action;", "getAction", "Lcom/avito/android/remote/model/UniversalColor;", "getBgColor", "Ljava/lang/String;", "getTitle", "<init>", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/UniversalColor;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceCategoryElement implements BrandspaceElement {
    public static final Parcelable.Creator<MarketplaceCategoryElement> CREATOR = new Creator();
    @NotNull
    private final Action action;
    @NotNull
    private final UniversalColor bgColor;
    @NotNull
    private final Image image;
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceCategoryElement> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceCategoryElement createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MarketplaceCategoryElement((Image) parcel.readParcelable(MarketplaceCategoryElement.class.getClassLoader()), parcel.readString(), (Action) parcel.readParcelable(MarketplaceCategoryElement.class.getClassLoader()), (UniversalColor) parcel.readParcelable(MarketplaceCategoryElement.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceCategoryElement[] newArray(int i) {
            return new MarketplaceCategoryElement[i];
        }
    }

    public MarketplaceCategoryElement(@NotNull Image image2, @NotNull String str, @NotNull Action action2, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(universalColor, "bgColor");
        this.image = image2;
        this.title = str;
        this.action = action2;
        this.bgColor = universalColor;
    }

    public static /* synthetic */ MarketplaceCategoryElement copy$default(MarketplaceCategoryElement marketplaceCategoryElement, Image image2, String str, Action action2, UniversalColor universalColor, int i, Object obj) {
        if ((i & 1) != 0) {
            image2 = marketplaceCategoryElement.image;
        }
        if ((i & 2) != 0) {
            str = marketplaceCategoryElement.title;
        }
        if ((i & 4) != 0) {
            action2 = marketplaceCategoryElement.action;
        }
        if ((i & 8) != 0) {
            universalColor = marketplaceCategoryElement.bgColor;
        }
        return marketplaceCategoryElement.copy(image2, str, action2, universalColor);
    }

    @NotNull
    public final Image component1() {
        return this.image;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final Action component3() {
        return this.action;
    }

    @NotNull
    public final UniversalColor component4() {
        return this.bgColor;
    }

    @NotNull
    public final MarketplaceCategoryElement copy(@NotNull Image image2, @NotNull String str, @NotNull Action action2, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(universalColor, "bgColor");
        return new MarketplaceCategoryElement(image2, str, action2, universalColor);
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
        if (!(obj instanceof MarketplaceCategoryElement)) {
            return false;
        }
        MarketplaceCategoryElement marketplaceCategoryElement = (MarketplaceCategoryElement) obj;
        return Intrinsics.areEqual(this.image, marketplaceCategoryElement.image) && Intrinsics.areEqual(this.title, marketplaceCategoryElement.title) && Intrinsics.areEqual(this.action, marketplaceCategoryElement.action) && Intrinsics.areEqual(this.bgColor, marketplaceCategoryElement.bgColor);
    }

    @NotNull
    public final Action getAction() {
        return this.action;
    }

    @NotNull
    public final UniversalColor getBgColor() {
        return this.bgColor;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Image image2 = this.image;
        int i = 0;
        int hashCode = (image2 != null ? image2.hashCode() : 0) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Action action2 = this.action;
        int hashCode3 = (hashCode2 + (action2 != null ? action2.hashCode() : 0)) * 31;
        UniversalColor universalColor = this.bgColor;
        if (universalColor != null) {
            i = universalColor.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MarketplaceCategoryElement(image=");
        L.append(this.image);
        L.append(", title=");
        L.append(this.title);
        L.append(", action=");
        L.append(this.action);
        L.append(", bgColor=");
        L.append(this.bgColor);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.image, i);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.action, i);
        parcel.writeParcelable(this.bgColor, i);
    }
}
