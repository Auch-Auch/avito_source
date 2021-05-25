package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJL\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b'\u0010\u0007R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b(\u0010\u0007R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b)\u0010\u0007R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010\f¨\u0006."}, d2 = {"Lcom/avito/android/brandspace/remote/model/BrandspaceCategoryItemElement;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "Lcom/avito/android/remote/model/Image;", "component1", "()Lcom/avito/android/remote/model/Image;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "Lcom/avito/android/remote/model/Action;", "component5", "()Lcom/avito/android/remote/model/Action;", "image", "title", MessengerShareContentUtility.SUBTITLE, "description", "action", "copy", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)Lcom/avito/android/brandspace/remote/model/BrandspaceCategoryItemElement;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "getImage", "Ljava/lang/String;", "getSubtitle", "getDescription", "getTitle", "Lcom/avito/android/remote/model/Action;", "getAction", "<init>", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceCategoryItemElement implements BrandspaceElement {
    public static final Parcelable.Creator<BrandspaceCategoryItemElement> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("image")
    @Nullable
    private final Image image;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceCategoryItemElement> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceCategoryItemElement createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BrandspaceCategoryItemElement((Image) parcel.readParcelable(BrandspaceCategoryItemElement.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), (Action) parcel.readParcelable(BrandspaceCategoryItemElement.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceCategoryItemElement[] newArray(int i) {
            return new BrandspaceCategoryItemElement[i];
        }
    }

    public BrandspaceCategoryItemElement(@Nullable Image image2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Action action2) {
        this.image = image2;
        this.title = str;
        this.subtitle = str2;
        this.description = str3;
        this.action = action2;
    }

    public static /* synthetic */ BrandspaceCategoryItemElement copy$default(BrandspaceCategoryItemElement brandspaceCategoryItemElement, Image image2, String str, String str2, String str3, Action action2, int i, Object obj) {
        if ((i & 1) != 0) {
            image2 = brandspaceCategoryItemElement.image;
        }
        if ((i & 2) != 0) {
            str = brandspaceCategoryItemElement.title;
        }
        if ((i & 4) != 0) {
            str2 = brandspaceCategoryItemElement.subtitle;
        }
        if ((i & 8) != 0) {
            str3 = brandspaceCategoryItemElement.description;
        }
        if ((i & 16) != 0) {
            action2 = brandspaceCategoryItemElement.action;
        }
        return brandspaceCategoryItemElement.copy(image2, str, str2, str3, action2);
    }

    @Nullable
    public final Image component1() {
        return this.image;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.subtitle;
    }

    @Nullable
    public final String component4() {
        return this.description;
    }

    @Nullable
    public final Action component5() {
        return this.action;
    }

    @NotNull
    public final BrandspaceCategoryItemElement copy(@Nullable Image image2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Action action2) {
        return new BrandspaceCategoryItemElement(image2, str, str2, str3, action2);
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
        if (!(obj instanceof BrandspaceCategoryItemElement)) {
            return false;
        }
        BrandspaceCategoryItemElement brandspaceCategoryItemElement = (BrandspaceCategoryItemElement) obj;
        return Intrinsics.areEqual(this.image, brandspaceCategoryItemElement.image) && Intrinsics.areEqual(this.title, brandspaceCategoryItemElement.title) && Intrinsics.areEqual(this.subtitle, brandspaceCategoryItemElement.subtitle) && Intrinsics.areEqual(this.description, brandspaceCategoryItemElement.description) && Intrinsics.areEqual(this.action, brandspaceCategoryItemElement.action);
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
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
        String str2 = this.subtitle;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Action action2 = this.action;
        if (action2 != null) {
            i = action2.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrandspaceCategoryItemElement(image=");
        L.append(this.image);
        L.append(", title=");
        L.append(this.title);
        L.append(", subtitle=");
        L.append(this.subtitle);
        L.append(", description=");
        L.append(this.description);
        L.append(", action=");
        L.append(this.action);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.image, i);
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.action, i);
    }
}
