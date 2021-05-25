package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ>\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b'\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b(\u0010\u0004¨\u0006+"}, d2 = {"Lcom/avito/android/brandspace/remote/model/BrandspaceMainBannerElement;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Action;", "component4", "()Lcom/avito/android/remote/model/Action;", "title", "description", "image", "action", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Action;)Lcom/avito/android/brandspace/remote/model/BrandspaceMainBannerElement;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "Lcom/avito/android/remote/model/Image;", "getImage", "Lcom/avito/android/remote/model/Action;", "getAction", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Action;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceMainBannerElement implements BrandspaceElement {
    public static final Parcelable.Creator<BrandspaceMainBannerElement> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("image")
    @NotNull
    private final Image image;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceMainBannerElement> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceMainBannerElement createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BrandspaceMainBannerElement(parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(BrandspaceMainBannerElement.class.getClassLoader()), (Action) parcel.readParcelable(BrandspaceMainBannerElement.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceMainBannerElement[] newArray(int i) {
            return new BrandspaceMainBannerElement[i];
        }
    }

    public BrandspaceMainBannerElement(@Nullable String str, @Nullable String str2, @NotNull Image image2, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(image2, "image");
        this.title = str;
        this.description = str2;
        this.image = image2;
        this.action = action2;
    }

    public static /* synthetic */ BrandspaceMainBannerElement copy$default(BrandspaceMainBannerElement brandspaceMainBannerElement, String str, String str2, Image image2, Action action2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brandspaceMainBannerElement.title;
        }
        if ((i & 2) != 0) {
            str2 = brandspaceMainBannerElement.description;
        }
        if ((i & 4) != 0) {
            image2 = brandspaceMainBannerElement.image;
        }
        if ((i & 8) != 0) {
            action2 = brandspaceMainBannerElement.action;
        }
        return brandspaceMainBannerElement.copy(str, str2, image2, action2);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final Image component3() {
        return this.image;
    }

    @Nullable
    public final Action component4() {
        return this.action;
    }

    @NotNull
    public final BrandspaceMainBannerElement copy(@Nullable String str, @Nullable String str2, @NotNull Image image2, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(image2, "image");
        return new BrandspaceMainBannerElement(str, str2, image2, action2);
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
        if (!(obj instanceof BrandspaceMainBannerElement)) {
            return false;
        }
        BrandspaceMainBannerElement brandspaceMainBannerElement = (BrandspaceMainBannerElement) obj;
        return Intrinsics.areEqual(this.title, brandspaceMainBannerElement.title) && Intrinsics.areEqual(this.description, brandspaceMainBannerElement.description) && Intrinsics.areEqual(this.image, brandspaceMainBannerElement.image) && Intrinsics.areEqual(this.action, brandspaceMainBannerElement.action);
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Image image2 = this.image;
        int hashCode3 = (hashCode2 + (image2 != null ? image2.hashCode() : 0)) * 31;
        Action action2 = this.action;
        if (action2 != null) {
            i = action2.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrandspaceMainBannerElement(title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", image=");
        L.append(this.image);
        L.append(", action=");
        L.append(this.action);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.image, i);
        parcel.writeParcelable(this.action, i);
    }
}
